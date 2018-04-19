mainApp
		.controller(
				'userController',
				function($scope, $http, $window, $rootScope) {
					$http.defaults.headers.post["Content-Type"] = "application/json";
					$scope.forgetpassword = function forgetpassword() {
						var data = {
								"mobileNo" : $scope.userId
						}
						$http.post(baseUrl + 'forgetpassword/', data)
								.success(function(data) {
									if (data == 'otp sent successfully.') {
										$(".login-panel").hide();
										$(".login-panel1").fadeIn();
									} else {
										$('#errorlogin').text(data);
									}
								});

					}
					$scope.validateOtp = function validateOtp() {
						var data = {
							"mobileNo" : $scope.userId,
							"otp" : $scope.otp
						}
						$http.post(baseUrl + 'validateOtp/', data).success(
								function(data) {
									if (data == 'valid Otp.') {
										$(".login-panel1").hide();
										$(".login-panel").hide();
										$(".login-panel2").fadeIn();
									} else {
										$('#errorOtp').text(data);
									}
								});

					}
					$scope.generatePassword = function generatePassword() {
						var data = {
								"mobileNo" : $scope.userId
							}
						$http
								.post(baseUrl + 'generatePassword/',data).success(function(data) {
									
									//var path = "/login";
								     //location.href = path;
									setTimeout(function(){ location.href = "/"; }, 2000); 
								});

					}
					$scope.login = function login() {
						var data = {
							"userId" : $scope.userId,
							"password" : $scope.password
						}
						var successCallBack = function(response) {
							if ((response.data.success) === "true") {
								/*var path = "/index";
								location.href = path;*/
								$scope.checkSession();
							}
							if ((response.data.success) === "pError") {
								$('#errorlogin').text("Invalid Password !");
								return false;
							}
							if ((response.data.success) === "appError") {
								$('#errorlogin')
										.text(
												" Once admin will approve, password will be sent to your registered eMail ID/mobile number ");
								return false;
							}
							if ((response.data.success) === "aiError") {
								$('#errorlogin')
										.text(
												" Your Service has been temporarily deactivated,Please contact your Admin for your status.");
								return false;
							}
							if ((response.data.success) === "false") {
								$('#errorlogin')
										.text(
												"you are not register yet...please register to login.");
								return false;
							}

						};
						var errorCallBack = function(response) {
							$("#errorLogin").append("").text("");
							$('#errorlogin')
									.text(
											"you are not register yet...please register to login.");
						};
						$http.post(baseUrl + 'login/', data).then(
								successCallBack, errorCallBack);

					}
					$scope.checkSession = function checkSession() {
						$http
								.get(baseUrl + 'checkSession/')
								.success(
										function(data) {
											$scope.loginUserName = data.data.ulbName;
											if (data.success == 'true') {
												
												if (data.data.roleId == '1') {
													$rootScope.userRole = data.data.roleName;
													$rootScope.userUrl = "/super-admin";
												}
												if (data.data.roleId == '2') {
													$rootScope.userRole = data.data.roleName;
													$rootScope.userUrl = "/admin";
												}
												if (data.data.roleId == '3') {
													$rootScope.userRole = data.data.roleName;
													$rootScope.userUrl = "/superuser";
												}
												if (data.data.roleId == '4') {
													$rootScope.userRole = data.data.roleName;
													$rootScope.userUrl = "/surveyuser";
												}
												location.href = $rootScope.userUrl;
												
											} else {
												location.href = "/";
											}
										});
					}
					
					
					$scope.logout = function logout() {
						$http.get(baseUrl + 'logout/').success(function(data) {
							location.href = "/"
						});
					}
					$scope.register = function register() {

						var data = {
							"userId" : "10",
							"firstName" : "Smruti Rekha",
							"middleName" : "",
							"lastName" : "Nayak",
							"emailId" : "smrutirekha@gmail.com",
							"mobileNo" : "7381284404"
						}
						var successCallBack = function(response) {
							if ((response.data.success) === "true") {
								alert("register successfully.");
							}
							if ((response.data.success) === "false") {
								alert("user already exist.");
								return false;
							}
							if ((response.data.success) === "error") {
								alert("Something went wrong !");
								return false;
							}
						};
						var errorCallBack = function(response) {
							$(".errorLogin").append("").text("");
							alert("Something went wrong !");
						};
						$http.post(baseUrl + 'register/', data).then(
								successCallBack, errorCallBack);

					}
				});