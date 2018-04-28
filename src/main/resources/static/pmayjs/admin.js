mainApp
		.controller(
				'adminController',
				function($scope, $http, $window, $rootScope, Excel, $timeout,$compile,PagerService) {
					$http.defaults.headers.post["Content-Type"] = "application/json";
					$scope.curPage = 0;
					$scope.pageSize = 20;
					$scope.disabledOtherReligion = true;
					$scope.locationDetailsPicDis = true;
					$scope.landRecordPicDis = true;
					$scope.disabledOtherBank = true;
					$scope.rationCardPicDis = true;
					$scope.bplPictureDis = true;
					$scope.bplNoDis = true;
					$scope.rationCardNoDis = true;
					$scope.slumLocationDetailsPicDis = true;
					$scope.disabledOtherSlumReligion = true;
					
					
					/*************************************************Code For High Chart for Survey Report ********************************************/
					   Highcharts.setOptions({
						    colors: ['#FF4210', '#004586']
					   });
					   
					   $scope.getTodaySurveyReport = function getTodaySurveyReport() {
						   var getTodayUrl = 'getTodayUlbSurveyReportForSlumNonSlum/'
						   if(!$scope.packageULB) $scope.packageULB = 'ALL';
						  /*
						   if ($scope.packageULB === 'ALL') {
							   getTodayUrl = 'getTodaySurveyReportForSlumNonSlum/';
						   } else {
							   getTodayUrl = 'getTodayUlbSurveyReportForSlumNonSlum/';
						   }
						   */
						   getTodayUrl = 'getTodayUlbSurveyReportForSlumNonSlum/';
						   
						   $scope.packageCity = $("#selectULB option:selected").html();
						   $scope.surveyDate = $("#surveyDate").val();
						   
						   //$http.get(baseUrl+'getTodaySurveyReportForSlumNonSlum/').success(function (data) {
						   $http.get(baseUrl+getTodayUrl, {params: {ulbNo: $scope.packageULB,surveyDate:$scope.surveyDate}}).success(function (data) {
							   $scope.surveyDate = $("#surveyDate").val();
							   $scope.todaySurveyReport = data;
							   Highcharts.chart('todaySurveyReport', {
								    chart: {
								        plotBackgroundColor: null,
								        plotBorderWidth: null,
								        plotShadow: false,
								        type: 'pie'
								    },
								    title: {
								        text: "Survey Report for Dt. " + $scope.surveyDate
								    },
								    tooltip: {
								        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
								    },
								    plotOptions: {
								        pie: {
								            allowPointSelect: true,
								            cursor: 'pointer',
								            dataLabels: {
								                enabled: true,
								                format: '<b>{point.name}</b>: {point.y} ',
								                style: {
								                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
								                }
								            }
								        }
								    },
								    series: [{
								        name: 'Beneficiary',
								        colorByPoint: true,
								        data: [{
								            name: 'Non-Slum',
								            y: $scope.todaySurveyReport.noOfNonSlumSurvey,
								        }, {
								            name: 'Slum',
								            y: $scope.todaySurveyReport.noOfSlumSurvey
								        }]
								    }]
								});
							   
						   })
					   }
					   
					   
					   $scope.getTotalSurveyReport = function getTotalSurveyReport() {
						   var getTotalUrl = 'getUlbSurveyReportForSlumNonSlum/';
						   if(!$scope.packageULB) $scope.packageULB = 'ALL';
						   if ($scope.packageULB === 'ALL') {
							   getTotalUrl = 'getTotalSurveyReportForSlumNonSlum/';
						   } else {
							   getTotalUrl = 'getUlbSurveyReportForSlumNonSlum/';
						   }
						   //$http.get(baseUrl+'getTotalSurveyReportForSlumNonSlum/').success(function (data) {
						   $http.get(baseUrl+getTotalUrl, {params: {ulbNo: $scope.packageULB}}).success(function (data) {
						   
							   $scope.totalSurveyReport = data;
							   Highcharts.chart('totalSurveyReport', {
								    chart: {
								        plotBackgroundColor: null,
								        plotBorderWidth: null,
								        plotShadow: false,
								        type: 'pie'
								    },
								    title: {
								        text: "Total Survey Report "
								    },
								    tooltip: {
								        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
								    },
								    plotOptions: {
								        pie: {
								            allowPointSelect: true,
								            cursor: 'pointer',
								            dataLabels: {
								                enabled: true,
								                format: '<b>{point.name}</b>: {point.y} ',
								                style: {
								                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
								                }
								            }
								        }
								    },
								    series: [{
								        name: 'Beneficiary',
								        colorByPoint: true,
								        data: [{
								            name: 'Non-Slum',
								            y: data.noOfNonSlumSurvey,
								        }, {
								            name: 'Slum',
								            y: data.noOfSlumSurvey
								        }]
								    }]
								});
							   
						   })
					   }
					   
					   

					
					$scope.slumAadhaarFieldBlank = function(){
						if($scope.val==true){
							$scope.addSlumSurvey.slumAdharNo = "";
						};
					}
					
					$scope.aadhaarFieldBlank = function(){
						if($scope.nonSlumVal==true){
							$scope.addSurvey.adharNo = "";
						};
					}

					$scope.checkSession = function checkSession() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						$http
								.get(baseUrl + 'checkSession/')
								.success(
										function(data) {
											if (data.success == 'true') {
												$(".pmay-loader").css({
													"display" : "none"
												});
												if (data.data.roleId == '2') {
													$scope.loginUserName = data.data.firstName;
													$rootScope.userRole = data.data.roleName;
													$rootScope.userUrl = "/admin";
													$rootScope.userId = data.data.userId;
												} else {
													location.href = "/";
												}
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
					$scope.getSurveyReports = function getSurveyReports() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						
						$http.get(baseUrl + 'getAdminsSurveyReports/').success(
								function(data) {
									$(".pmay-loader").css({
										"display" : "none"
									});
									admin.adminSurveyReport = data;
									$scope.tempSurveyData = data;
									admin.setReportPage(1);
								});
					}
					$scope.getAllPendingUsers = function getAllPendingUsers() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						$http.get(baseUrl + 'getAllPendingUsers/').success(
								function(data) {
									$(".pmay-loader").css({
										"display" : "none"
									});
									if (data == "") {
										/*$('#pendingTable').hide();
										$('#noPending').show();*/
									} else {
										admin.pendingUsers = data;
										admin.setPendingUserReportPage(1);
									}
								});
					}
					$scope.approveUser = function approveUser(userData) {
						$(".pmay-loader").css({
							"display" : "block"
						});
						$http.post(baseUrl + 'approveUser/', userData).success(
								function(data) {
									$(".pmay-loader").css({
										"display" : "none"
									});
									if (data != true) {
										swal({
											position : 'top',
											text : "Something went wrong",
											type : 'error',
											animation : false,
											customClass : 'animated tada',
											showConfirmButton : false,
											timer : 3000,
										})
									} else {
										$scope.getAllPendingUsers();
									}

								});
					}
					
					/***************De-activate user START****************/
					$scope.deactivateUser = function deactivateUser(userData) {
						$(".pmay-loader").css({
							"display" : "block"
						});
						$http.post(baseUrl + 'updateUserStatus/', userData).success(
								function(data) {
									$(".pmay-loader").css({
										"display" : "none"
									});
									if (data != true) {
										swal({
											position : 'top',
											text : "Something went wrong",
											type : 'error',
											animation : false,
											customClass : 'animated tada',
											showConfirmButton : true,
											timer : 3000,
										})
									} else {
										swal({
											position : 'top',
											text : "User Status Changed successfully",
											type : 'success',
											animation : false,
											customClass : 'animated tada',
											showConfirmButton : true,
											timer : 3000,
										})
										$scope.getAllPendingUsers();
									}
							});
						
					}
					/**************De-activate user END****************/
					
					/** Deny Request Start **/
					$scope.denyUser = function denyUser(userData) {
						$(".pmay-loader").css({
							"display" : "block"
						});
						var confirmDeny = confirm("Are you sure to Deny the request? This will delete the record for that user.");
						if(confirmDeny == true)
							{
								$http.post(baseUrl + 'denyUser/', userData).success(
								function(data) {
									$(".pmay-loader").css({
										"display" : "none"
									});
									if (data != true) {
										swal({
											position : 'top',
											text : "Something went wrong",
											type : 'error',
											animation : false,
											customClass : 'animated tada',
											showConfirmButton : true,
											timer : 3000,
										})
									} else {
										$scope.getAllPendingUsers();
									}
							});

						}
						else if(confirmDeny == false)
						{
								$(".pmay-loader").css({
									"display" : "none"
								});
							return;
						}
					}
					/** Deny Request End **/
					
					$scope.removeSurvey = function removeSurvey(userSurveyId) {
						swal({
							  title: 'Are you sure?',
							  text: "You won't be able to revert this!",
							  type: 'warning',
							  showCancelButton: true,
							  confirmButtonColor: '#3085d6',
							  cancelButtonColor: '#d33',
							  confirmButtonText: 'Yes, delete it!',
							  cancelButtonText: 'No, cancel!',
							  confirmButtonClass: 'btn btn-success',
							  cancelButtonClass: 'btn btn-danger',
							  buttonsStyling: false,
							  reverseButtons: true
							}).then((result) => {
							  if (result.value) {
								  $http.post(baseUrl + 'removeSurvey/', userSurveyId)
									.success(function(data) {
										$scope.getSurveyReports();
										$scope.deletedSurveyReports();

									});
							    swal(
							      'Deleted!',
							      'Your file has been deleted.',
							      'success'
							    )
							  } else if (
							    // Read more about handling dismissals
							    result.dismiss === swal.DismissReason.cancel
							  ) {
							    swal(
							      'Cancelled',
							      'Your imaginary file is safe :)',
							      'error'
							    )
							  }
							})
					}
					$scope.getDropDownData = function getDropDownData() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						$http
								.get(baseUrl + 'addsurveydropdowndata/')
								.success(
										function(data) {
											$scope.idData = data.listIdData;
											$scope.religionData = data.listReligionData;
											$scope.casteData = data.listCasteData;
											$scope.maritalData = data.listMaritalData;
											$scope.genderData = data.listGenderData;
											$scope.roofData = data.listHouseRoofData;
											$scope.ownershipData = data.listOwnershipData;
											$scope.wallData = data.listHouseWallData;
											$scope.requirementData = data.listRequirementData;
											$scope.employmentData = data.listEmploymentData;
											$scope.hfaAsstData = data.listHfaAsstData;
											/*$scope.vehicleData = data.listVehicleData;*/
											$scope.memberRelationshipData = data.listRelationshipData;
											$scope.wardData = data.listWardData;
											$scope.cityList = data.listCityData;
											$scope.houseCategoryData = data.listHouseCategoryData;
											$scope.banksList = data.listBanks;
											$scope.presentInCityInYears = data.listNoOfYearsPresent;
											$scope.ulbList = data.listUlbData;
											$(".pmay-loader").css({
												"display" : "none"
											});
										});

					}

					$scope.selectAllSurveyReportData = function selectAllSurveyReportData() {
						if ($scope.selectedAll) {
							$scope.selectedAll = true;
						} else {
							$scope.selectedAll = false;
						}

						angular
								.forEach(
										$scope.adminReport.selectedId,
										function(item, key) {
											$scope.adminReport.selectedId[key] = $scope.selectedAll;
										});
					}

					$scope.adminReport = {}
					$scope.getReportDetailsForDownload = function getReportDetailsForDownload() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						var adminReportDataForDownload = [];
						angular.forEach($scope.adminReport.selectedId,
								function(item, key) {
									if (item == true) {
										adminReportDataForDownload.push(key);
									}
								});

						var rowColumnName = {
							"mobileNo" : $scope.mobileNo,
							"uniqueId" : $scope.uniqueId,
							"aadharNo" : $scope.aadharNo,
							"name" : $scope.userName,
							"fatherName" : $scope.userFatherName,
							"sex" : $scope.gender,
							"dob" : $scope.dob,
							"slumNonSlum" : $scope.slumNonSlum,
							"ulbName" : $scope.ulbName,
							"wardNo" : $scope.wardNo,
							"missionComponent" : $scope.missionComponent,
							"eligibleStatus" : $scope.eligibleStatus,
							"longLat" : $scope.longLat,
							"selectedsurveyId" : adminReportDataForDownload
						}

						$http
								.post(
										baseUrl
												+ '/storeFilteredRowColumnDetailsForAdmins',
										rowColumnName).success(function(data) {
									$(".pmay-loader").css({
										"display" : "none"
									});
									if (data === "true") {
										location.href = "/adminReportExcel";
									} else {
										swal({
											position : 'top',
											text : data,
											type : 'info',
											animation : false,
											customClass : 'animated tada',
											showConfirmButton : false,
											timer : 3000,
										})
									}
								});
					}
					
					$scope.getAdminsDesiredReport = function getAdminsDesiredReport() {
						$(".pmay-loader").css({
							"display" : "block"
						});

						$http
								.get(baseUrl + '/getDesiredDataForAdminDownload')
								.success(
										function(downloadData) {
											$(".pmay-loader").css({
												"display" : "none"
											});
											$scope.filteredAdminReportData = downloadData.listAdminsData;
											$scope.mobileNo = downloadData.columnData.mobileNo;
											$scope.uniqueId = downloadData.columnData.uniqueId;
											$scope.aadharNo = downloadData.columnData.aadharNo;
											$scope.name = downloadData.columnData.name;
											$scope.fatherName = downloadData.columnData.fatherName;
											$scope.sex = downloadData.columnData.sex;
											$scope.dob = downloadData.columnData.dob;
											$scope.slumNonSlum = downloadData.columnData.slumNonSlum;
											$scope.ulbName = downloadData.columnData.ulbName;
											$scope.wardNo = downloadData.columnData.wardNo;
											$scope.missionComponent = downloadData.columnData.missionComponent;
											$scope.eligibleStatus = downloadData.columnData.eligibleStatus;
											$scope.longLat = downloadData.columnData.longLat;
										});
					}
					

					$scope.resetAll = function resetAll() {
						$scope.searchData = {};
						admin.adminSurveyReport = $scope.tempSurveyData;
						admin.setReportPage(1);
					}

					$scope.getReportFilteredDataForAdmin = function getReportFilteredDataForAdmin() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						var searchData = {
							"searchName" : $scope.searchData.adminReportName,
							"aadharOrIdNumber" : $scope.searchData.adminReportAadharNo,
							"ulbName" : $scope.searchData.adminReportUlbName,
							"fatherSpouseName" : $scope.searchData.adminReportFatherSpouseName,
							"bankAccountNo" : $scope.searchData.adminReportBankAc,
							"searchScopeName" : $scope.searchData.adminReportScopeName,
							"searchScopeValue" : $scope.searchData.adminReportScopeValue
						}

						$http
								.post(baseUrl + '/getFilteredReportBySearch',
										searchData)
								.success(
										function(surveyReport) {
											$(".pmay-loader").css({
												"display" : "none"
											});
											if (surveyReport != "") {
												admin.adminSurveyReport = surveyReport;
												admin.setReportPage(1);
											} else {
												swal({
													position : 'top',
													text : "No Result Found",
													type : 'info',
													animation : false,
													customClass : 'animated tada',
													showConfirmButton : false,
													timer : 3000,
												})
												admin.adminSurveyReport = $scope.tempSurveyData;
												admin.setReportPage(1);
											}

										});
					}

					$scope.getSurveyedFilteredDataForAdmin = function getSurveyedFilteredDataForAdmin() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						var searchData = {
								"searchName" : $scope.searchData.adminSurveyName,
								"aadharOrIdNumber" : $scope.searchData.adminSurveyAadharNo,
								"ulbName" : $scope.searchData.adminSurveyUlbName,
								"fatherSpouseName" : $scope.searchData.adminSurveyFatherSpouseName,
								"bankAccountNo" : $scope.searchData.adminSurveyBankAc,
								"searchScopeName" : $scope.searchData.adminSurveyScopeName,
								"searchScopeValue" : $scope.searchData.adminSurveyScopeValue
						}

						$http.post(baseUrl + '/getFilteredReportBySearch',
								searchData).success(function(surveyReport) {
							$(".pmay-loader").css({
								"display" : "none"
							});

							if (surveyReport != "") {
								$scope.adminSurveyData = surveyReport;
							} else {
								swal({
									position : 'top',
									text : "No Result Found",
									type : 'info',
									animation : false,
									customClass : 'animated tada',
									showConfirmButton : false,
									timer : 3000,
								})
								$scope.adminSurveyData = $scope.tempSurveyData;
							}
						});
					}

					$scope.excelReport = function excelReport(tableId) {
						var exportHref = Excel.tableToExcel(tableId,
								'WireWorkbenchDataExport');
						$timeout(function() {
							location.href = exportHref;
						}, 100);
					}
					
/*****************************************************************Function for addSlumData****************************************************************/
					
					$scope.saveSlumSurvey = function saveSlumSurvey(addSlumSurvey,clickButton) {
						if($("#adharErrorForSlum").text()=='' && $("#idProofErrorForSlum").text()==''){
						$(".pmay-loader").css({
							"display" : "block"
						});
 
						
						var isSubmittedFlag = "N";

						if (clickButton === "submit") {
							isSubmittedFlag = "Y";
							if(addSlumSurvey.slumIdPhoto == null || addSlumSurvey.slumIdPhoto == ""){
								$scope.slumIdImageError=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.slumIdImageError=false;
							}
							if(addSlumSurvey.slumApplicantSignature == null ||addSlumSurvey.slumApplicantSignature == ""){
								$scope.slumApplicantSignatureError=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.slumApplicantSignatureError=false;
							}
							
							/*************************new validations***************************/
							if(addSlumSurvey.slumOwnsRadio=="Y"){
							if(addSlumSurvey.slumLocationDetailsPic == null ||addSlumSurvey.slumLocationDetailsPic == ""){
								$scope.slumLocationDetailsPicError=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.slumLocationDetailsPicError=false;
							}
							if(addSlumSurvey.slumLandAddress == null ||addSlumSurvey.slumLandAddress == ""){
								$scope.slumLocationAddressError=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.slumLocationAddressError=false;
							}
							if(addSlumSurvey.slumLandinSqm == null ||addSlumSurvey.slumLandinSqm == ""){
								$scope.slumExtentLandError=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.slumExtentLandError=false;
							}
						}
							/*************************new validations end***************************/
						}

						if (addSlumSurvey.slumIsSameAsPresentAdd == false) {
							addSlumSurvey.slumIsSameAsPresentAdd = "N";
						} else {
							addSlumSurvey.slumIsSameAsPresentAdd = "Y";
						}
						if (addSlumSurvey.chckSlumRadio == 'S') {
							addSlumSurvey.validationPendingStatus = "N";
						} else {
							addSlumSurvey.validationPendingStatus = "Y";
						}
						if (addSlumSurvey.slumEligibleStatus == false) {
							addSlumSurvey.slumEligibleStatus = "N";
						} else {
							addSlumSurvey.slumEligibleStatus = "Y";
						}
						
						var slumPresentTown = 'N';
						if(addSlumSurvey.slumPresentTown === true){
							slumPresentTown = 'Y';
							
						} 
						
						var slumPermanentTown = 'N';
						if(addSlumSurvey.slumPermanentTown === true){
							slumPermanentTown = 'Y';
						}
						
						var familyMemberName = [];
						var familyMemberRelation = [];
						var familyMemberGender = [];
						var familyMemberAge = [];
						var familyMemberIdCardNo = [];
						$("tr.item").each(function() {
						
						familyMemberName.push($(this).find("input.slumName").val());
						
						familyMemberRelation.push($(this).find("select.slumMemberrelationship option:selected").val());
					    
						familyMemberGender.push($(this).find("select.slumMembergender option:selected").val());
						
						familyMemberAge.push($(this).find("input.slumAge").val());
						
						familyMemberIdCardNo.push($(this).find("input.slumIdcardno").val());
						});

						var surveyData = {
							
							"surveyId":addSlumSurvey.slumSurveyId,
							"userId":$rootScope.userId,
							"chckSlumRadio": "S",
							"slumFamilyHeadName":addSlumSurvey.slumFamilyHeadName,
							"slumFatherHusbandName":addSlumSurvey.slumFatherHusbandName,
							"slumAdharNo":addSlumSurvey.slumAdharNo,
							"slumAdharReason":addSlumSurvey.slumAdharReason,
							"slumIdProof" : addSlumSurvey.slumIdProof,
							"slumIdProofNo" : addSlumSurvey.slumIdProofNo,
							"genderValue":addSlumSurvey.slumGenderRadio,
							"maritalStatus" : addSlumSurvey.maritalStatus,
							"idType" : addSlumSurvey.slumIdProof,
							"idNo" : addSlumSurvey.slumIdProofNo,

							"slumPresentTown":slumPresentTown,
							"slumPresentHouseNo":addSlumSurvey.slumPresentHouseNo,
							"slumPresentStreetName":addSlumSurvey.slumPresentStreetName,
							"slumPresentCity":addSlumSurvey.slumPresentCity,
							"presentMobileNo":addSlumSurvey.slumPresentMobileNo,
							"slumIsSameAsPresentAdd":addSlumSurvey.slumIsSameAsPresentAdd,
							"slumPermanentTown":slumPermanentTown,
							"slumPermanentHouseNo":addSlumSurvey.slumPermanentHouseNo,
							"slumPermanentStreetName":addSlumSurvey.slumPermanentStreetName,
							"slumPermanentCity":addSlumSurvey.slumPermanentCity,
							"slumPermanentMobileNo":addSlumSurvey.slumPermanentMobileNo,

							"familyMemberName":familyMemberName.toString(),
							"familyMemberRelation":familyMemberRelation.toString(),
							"familyMemberGender":familyMemberGender.toString(),
							"familyMemberAge":familyMemberAge.toString(),
							"familyMemberIdCardNo":familyMemberIdCardNo.toString(),
							
							"slumReligion":addSlumSurvey.slumReligion,
							"religionIfOther" :addSlumSurvey.religionIfOther,
							"dob" : addSlumSurvey.dob,
							"slumCaste":addSlumSurvey.slumCaste,
							"slumOwnsRadio":addSlumSurvey.slumOwnsRadio,
							"slumLandAddress":addSlumSurvey.slumLandAddress,
							"slumLandinSqm":addSlumSurvey.slumLandinSqm,
							
							"isSubmittedFlag":isSubmittedFlag,
							"nonEligibleReason" : addSlumSurvey.slumNonEligibleReason,
							"eligibleStatus" : addSlumSurvey.slumEligibleStatus,
							"slumWardDetails" : addSlumSurvey.slumWardName,
							"slumUlbNameId" : addSlumSurvey.slumUlbDetails,
							"geoLongitude": addSlumSurvey.geoLongitude,
							"geoLatitude": addSlumSurvey.geoLatitude
						};
						
						var allImageFiles = new FormData();
						allImageFiles.append('applicantSignature',addSlumSurvey.slumApplicantSignature);
						allImageFiles.append('locationDetailsPic',addSlumSurvey.slumLocationDetailsPic);
						allImageFiles.append('slumIdImage',addSlumSurvey.slumIdPhoto);
						allImageFiles.append('surveyData', angular.toJson(surveyData, true));
						allImageFiles.append('slumBiometricDetails','');//blank for slum biometric details
						allImageFiles.append('applicantPhoto',addSlumSurvey.applicantImageFile);
						$http.post(baseUrl + 'addSlumSurvey/', allImageFiles, {
							transformRequest : angular.identity,
							headers : {
								'Content-Type' : undefined
							}
						}).success(function(data) {
							$(".pmay-loader").css({
								"display" : "none"
							});
							$scope.addSlumSurvey = {};
							$scope.val=false;
							swal({
								position : 'top',
								text : "Successfully Saved",
								type : 'success',
								animation : false,
								customClass : 'animated tada',
								showConfirmButton : false,
								timer : 3000,
							})
							location.reload();
							/*$scope.getSurveyReports();
							$('.nav-tabs a[href="#' + "surrpt" + '"]').tab('show');*/
							
						});
					}else{
						return false;
					}
					}

					$scope.copySlumPresentAddress = function() {
						if ($('#slumSameData').is(':checked')) {
							$scope.addSlumSurvey.slumPermanentTown = angular.copy($scope.addSlumSurvey.slumPresentTown);
							$scope.addSlumSurvey.slumPermanentHouseNo = angular.copy($scope.addSlumSurvey.slumPresentHouseNo);
							$scope.addSlumSurvey.slumPermanentStreetName = angular.copy($scope.addSlumSurvey.slumPresentStreetName);
							$scope.addSlumSurvey.slumPermanentCity = angular.copy($scope.addSlumSurvey.slumPresentCity);
							$scope.addSlumSurvey.slumPermanentMobileNo = angular.copy($scope.addSlumSurvey.slumPresentMobileNo);
						} else {
							$scope.addSlumSurvey.slumPermanentTown = '';
							$scope.addSlumSurvey.slumPermanentHouseNo = '';
							$scope.addSlumSurvey.slumPermanentStreetName = '';
							$scope.addSlumSurvey.slumPermanentCity = '';
							$scope.addSlumSurvey.slumPermanentMobileNo = '';
						}

					}
					
					$scope.addSlumFamilyTextbox = function() {
						var addFamilyRow = "<tr class='item'><td><input type='text' class='slumName' placeholder='' /></td>"
								+ "<td><select class='slumMemberrelationship'>"
								+ "<option value=''>----select----</option>"
								+ "<option ng-repeat='relation in memberRelationshipData' value='{{relation.relationshipId}}'>{{relation.relationshipName}}</option>"
								+ "</select></td>"
								+ "<td><select class='slumMembergender'>"
								+ "<option value=''>select</option>"
								+ "<option ng-repeat='gender in genderData' value='{{gender.genderId}}'>{{gender.genderName}}</option>"
								+ "</select></td>"
								+ "<td><input type='text' class='slumAge' placeholder='' /></td>"
								+ "<td><input type='text' class='slumIdcardno' placeholder='' /></td>"
								+ "<td><div class='rsm-r'>"
								+ "<button name='delRow' class='b-row-add' type='button'><span class='fa fa-minus'></span></button>"
								+ "</div></td></tr>"
						var element = $compile(addFamilyRow)($scope);
						$(".slumMemberAdd").append(element);
						$("button[name = 'delRow']").click(function() {
							$(this).parent().parent().parent().remove();
						});
					}
					
/*****************************************************************End of function for addSlumData**********************************************************/
					
					$scope.saveSurvey = function saveSurvey(addSurvey,
							clickButton) {
						if($("#adharErrorForNonSlum").text()=='' && $("#idProofErrorForNonSlum").text()==''){
						$(".pmay-loader").css({
							"display" : "block"
						});
                         
						var isSubmittedFlag = "N";

						if (clickButton === "submit") {
							isSubmittedFlag = "Y";
							if(addSurvey.applicantImageFile == null || addSurvey.applicantImageFile == ""){
								$scope.applicantImageFileError=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.applicantImageFileError=false;
							}
							if(addSurvey.idImage == null || addSurvey.idImage == ""){
								$scope.idImageError=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.idImageError=false;
							}
							if(addSurvey.presentInfrontHousePic == null || addSurvey.presentInfrontHousePic == ""){
								$scope.presentInfrontHousePicError=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.presentInfrontHousePicError=false;
							}
				/****************************Non slum new validation****************************/			
							if(addSurvey.ownsRadio=="Y"){
								if(addSurvey.landRecordPic == null ||addSurvey.landRecordPic == ""){
									$scope.landRecordPicError=true;
									$(".pmay-loader").css({
										"display" : "none"
									});
									return false;
								}else{
									$scope.landRecordPicError=false;
								}
								if(addSurvey.landAddress == null ||addSurvey.landAddress == ""){
									$scope.locationAddressError=true;
									$(".pmay-loader").css({
										"display" : "none"
									});
									return false;
								}else{
									$scope.locationAddressError=false;
								}
								if(addSurvey.landinSqm == null ||addSurvey.landinSqm == ""){
									$scope.extentLandError=true;
									$(".pmay-loader").css({
										"display" : "none"
									});
									return false;
								}else{
									$scope.extentLandError=false;
								}
							}
							
							if(addSurvey.houseRequirementRadio== "2"){
								if(addSurvey.requirement == null ||addSurvey.requirement == ""){
									$scope.requirementError=true;
									$(".pmay-loader").css({
										"display" : "none"
									});
									return false;
								}else{
									$scope.requirementError=false;
								}
							}
							
							if(addSurvey.bplRadio== "Y"){
								if(addSurvey.bplNo == null ||addSurvey.bplNo == ""){
									$scope.bplError=true;
									$(".pmay-loader").css({
										"display" : "none"
									});
									return false;
								}else{
									$scope.bplError=false;
								}
								if(addSurvey.bplPicture == null ||addSurvey.bplPicture == ""){
									$scope.bplPicError=true;
									$(".pmay-loader").css({
										"display" : "none"
									});
									return false;
								}else{
									$scope.bplPicError=false;
								}
							}
							
							if(addSurvey.rationRadio== "Y"){
								if(addSurvey.rationCardNo == null ||addSurvey.rationCardNo == ""){
									$scope.rationError=true;
									$(".pmay-loader").css({
										"display" : "none"
									});
									return false;
								}else{
									$scope.rationError=false;
								}
								if(addSurvey.rationCardPic == null ||addSurvey.rationCardPic == ""){
									$scope.rationPicError=true;
									$(".pmay-loader").css({
										"display" : "none"
									});
									return false;
								}else{
									$scope.rationPicError=false;
								}
							}
							
							if($scope.disabledOtherBank== false){
								if(addSurvey.otherBankName == null ||addSurvey.otherBankName == ""){
									$scope.bankError=true;
									$(".pmay-loader").css({
										"display" : "none"
									});
									return false;
								}else{
									$scope.bankError=false;
								}
							}
				/**************************End Non slum new validation****************************/			
							
							if(addSurvey.landPhoto1 == null || addSurvey.landPhoto1 == ""){
								$scope.landPhoto1Error=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.landPhoto1Error=false;
							}
							if(addSurvey.landPhoto2 == null || addSurvey.landPhoto2 == ""){
								$scope.landPhoto2Error=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.landPhoto2Error=false;
							}
							if(addSurvey.incomeProofPhoto == null || addSurvey.incomeProofPhoto == ""){
								$scope.incomeProofPhotoError=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.incomeProofPhotoError=false;
							}
							if(addSurvey.applicantSignature == null || addSurvey.applicantSignature == ""){
								$scope.applicantSignatureError=true;
								$(".pmay-loader").css({
									"display" : "none"
								});
								return false;
							}else{
								$scope.applicantSignatureError=false;
							}
						}

						if (addSurvey.eligibleStatus == false) {
							addSurvey.eligibleStatus = "N";
						} else {
							addSurvey.eligibleStatus = "Y";
						}
						if (addSurvey.isSameAsPresentAdd == false) {
							addSurvey.isSameAsPresentAdd = "N";
						} else {
							addSurvey.isSameAsPresentAdd = "Y";
						}
						if (addSurvey.chckSlumRadio == 'S') {
							addSurvey.validationPendingStatus = "N";
						} else {
							addSurvey.validationPendingStatus = "Y";
						}
						
						
						var presentTown = 'N';
						if(addSurvey.presentYearsInCity === true){
							presentTown = 'Y';
						}
						
						var permanentTown = 'N';
						if(addSurvey.permanentYearsInCity === true){
							permanentTown = 'Y';
						}
						
						var familyMemberName = [];
						var familyMemberRelation = [];
						var familyMemberGender = [];
						var familyMemberAge = [];
						var familyMemberIdCardNo = [];
						$("tr.familyMemberRow")
								.each(
										function() {
											familyMemberName.push($(this).find(
													"input.name").val());
											familyMemberRelation
													.push($(this)
															.find(
																	"select.memberrelationship option:selected")
															.val());
											familyMemberGender
													.push($(this)
															.find(
																	"select.membergender option:selected")
															.val());
											familyMemberAge.push($(this).find(
													"input.age").val());
											familyMemberIdCardNo.push($(this)
													.find("input.idcardno")
													.val());
										});

						var surveyData = {
							
							"surveyId" : addSurvey.surveyId,
							"userId" : $rootScope.userId,
							"slumRadio" : "N",
							"validationPendingStatus" : addSurvey.validationPendingStatus,
							"familyHeadName" : addSurvey.familyHeadName,
							"fatherHusbandName" : addSurvey.fatherHusbandName,
							"adharNo" : addSurvey.adharNo,
							"adharReason" : addSurvey.adharReason,
							"maritalStatus" : addSurvey.maritalRadio,
							"eligibleStatus" : addSurvey.eligibleStatus,
							"nonEligibleReason" : addSurvey.nonEligibleReason,
							"genderId" : addSurvey.genderRadio,
							"idType" : addSurvey.idProof,
							"idNo" : addSurvey.idProofNo,
							"dob" : addSurvey.dob,
							"religion" : addSurvey.religion,
							"religionIfOther" : addSurvey.religionIfOther,
							"caste" : addSurvey.caste,

							"presentTown" : presentTown,
							"presentHouseNo" : addSurvey.presentHouseNo,
							"presentStreetName" : addSurvey.presentStreetName,
							"presentCity" : addSurvey.presentCity,
							"presentMobileNo" : addSurvey.presentMobileNo,
							"isSameAsPresentAdd" : addSurvey.isSameAsPresentAdd,
							"permanentTown" : permanentTown,
							"permanentHouseNo" : addSurvey.permanentHouseNo,
							"permanentStreetName" : addSurvey.permanentStreetName,
							"permanentCity" : addSurvey.permanentCity,
							"permanentMobileNo" : addSurvey.permanentMobileNo,

							"houseRoofType" : addSurvey.houseRoofType,
							"ownsRadio" : addSurvey.ownsRadio,
							"landAddress" : addSurvey.landAddress,
							"landinSqm" : addSurvey.landinSqm,
							"ownershipHouse" : addSurvey.ownershipHouse,
							"houseWallType" : addSurvey.houseWallType,
							"dwellinUnitRoom" : addSurvey.dwellinUnitRoom,
							"sizeExistingDwelling" : addSurvey.sizeExistingDwelling,
							"houseRequirementRadio" : addSurvey.houseRequirementRadio,
							"requirement" : addSurvey.requirement,

							"pattadarName" : addSurvey.pattadarName,
							"dagNo" : addSurvey.dagNo,
							"pattaNo" : addSurvey.pattaNo,
							"landAreaPatta" : addSurvey.landAreaPatta,
							"landLength" : addSurvey.landLength,
							"landBreadth" : addSurvey.landBreadth,
							"employmentStatus" : addSurvey.employmentStatus,
							"employmentStatusName" : addSurvey.employmentStatusName,
							"averageIncome" : addSurvey.averageIncome,
							"incomeProof" : addSurvey.incomeProof,
							"bplRadio" : addSurvey.bplRadio,
							"bplNo" : addSurvey.bplNo,
							"rationRadio" : addSurvey.rationRadio,
							"rationCardNo" : addSurvey.rationCardNo,
							"preferredAssistanceHfa" : addSurvey.preferredAssistanceHfa,
							"wardDetails" : $scope.slumNonWardDetails,
							"ulbNameId" : $scope.slumNonUlbDetails,
							/*"vehicleCategoryId" : addSurvey.vehicleCategory,
							"vehicleRegdNo" : addSurvey.vehicleRegdNo,*/
							"bankAccNo" : addSurvey.bankAccNo,
							"bankId" : addSurvey.bankName,
							"bankName" : addSurvey.otherBankName,
							"bankBranchName" : addSurvey.bankBranchName,
							"bankIfscCode" : addSurvey.bankIfscCode,
							"familyMemberName" : familyMemberName.toString(),
							"familyMemberRelation" : familyMemberRelation
									.toString(),
							"familyMemberGender" : familyMemberGender
									.toString(),
							"familyMemberAge" : familyMemberAge.toString(),
							"familyMemberIdCardNo" : familyMemberIdCardNo
									.toString(),
							"isSubmitted" : isSubmittedFlag,
							"geoLongitude": addSurvey.geoLongitude,
							"geoLatitude": addSurvey.geoLatitude
						};
						var allImageFiles = new FormData();
						allImageFiles.append('applicantPhoto',
								addSurvey.applicantImageFile);
						allImageFiles.append('idPhoto', addSurvey.idImage);
						allImageFiles.append('presentInfrontHousePic',
								addSurvey.presentInfrontHousePic);
						/*allImageFiles.append('locationDetailsPic',
								addSurvey.locationDetailsPic);*/
						allImageFiles.append('landRecordPic',
								addSurvey.landRecordPic);
						allImageFiles
								.append('landPhoto1', addSurvey.landPhoto1);
						allImageFiles
								.append('landPhoto2', addSurvey.landPhoto2);
						allImageFiles
								.append('bplPicture', addSurvey.bplPicture);
						allImageFiles.append('rationCardPic',
								addSurvey.rationCardPic);
						/*allImageFiles.append('vehiclePhoto',
								addSurvey.vehiclePhoto);*/
						allImageFiles.append('applicantSignature',
								addSurvey.applicantSignature);
						allImageFiles.append('incomeProofPhoto',
								addSurvey.incomeProofPhoto);
						allImageFiles.append('surveyData', angular.toJson(
								surveyData, true));
						allImageFiles.append('biometricDetails',
								'');
						$http.post(baseUrl + 'addSurvey/', allImageFiles, {
							transformRequest : angular.identity,
							headers : {
								'Content-Type' : undefined
							}
						}).success(function(data) {
							$(".pmay-loader").css({
								"display" : "none"
							});
							$scope.addSurvey = {};
							$scope.nonSlumVal=false;
							swal({
								position : 'top',
								text : "Successfully Saved",
								type : 'success',
								animation : false,
								customClass : 'animated tada',
								showConfirmButton : false,
								timer : 3000,
							})
							location.reload();
							/*$scope.getSurveyReports();
							$('.nav-tabs a[href="#' + "surrpt" + '"]').tab('show');*/
						});
					}else{
						return false;
					}
					}

					$scope.copyPresentAddress = function() {
						if ($('#sameData').is(':checked')) {
							$scope.addSurvey.permanentYearsInCity = $scope.addSurvey.presentYearsInCity; 
							
							$scope.addSurvey.permanentHouseNo = angular
									.copy($scope.addSurvey.presentHouseNo);
							$scope.addSurvey.permanentStreetName = angular
									.copy($scope.addSurvey.presentStreetName);
							$scope.addSurvey.permanentCity = angular
									.copy($scope.addSurvey.presentCity);
							$scope.addSurvey.permanentMobileNo = angular
									.copy($scope.addSurvey.presentMobileNo);
						} else {
							$scope.addSurvey.permanentYearsInCity = '';
							$scope.addSurvey.permanentHouseNo = '';
							$scope.addSurvey.permanentStreetName = '';
							$scope.addSurvey.permanentCity = '';
							$scope.addSurvey.permanentMobileNo = '';
						}

					}
					
					$scope.editSurvryReport = function editSurvryReport(surveyReport) {
						if(surveyReport.submittedData == 'Y'){
							swal({
								position : 'top',
								text : "Data is already submitted, You can't edit your data",
								type : 'info',
								animation : false,
								customClass : 'animated tada',
								showConfirmButton : false,
								timer : 3000,
							})
						}else{
						$("input[type='file']").val(null);
						$("#adharErrorForSlum").text("");
						$("#adharErrorForNonSlum").text("");
						$("#idProofErrorForSlum").text("");
						$("#idProofErrorForNonSlum").text("");
						$('.nav-tabs a[href="#' + "mngrbe" + '"]').tab('show');
						
						if(surveyReport.slumNonSlum == "S"){
							$('.nav-tabs a[href="#' + "slum" + '"]').tab('show');
							$("#slumedit").css({"display" : "block"});
							$("#nonslumedit").css({"display" : "none"});
							$scope.addSlumSurvey ={};
							$scope.slumApplicantImageShow = true;
							$scope.slumApplicantSignatureShow = true;
							$scope.slumLocationDetailsPicShow = true;
							$scope.idImageShow = true;
							$scope.slumPhotoAttachmentName = surveyReport.photoAttachmentName;
							$scope.idAttachmentName=surveyReport.idAttachmentName;
							$scope.signatureOfApplicant = surveyReport.signatureOfApplicant;
							$scope.indiaLocationDetailsAttachment = surveyReport.landAttachmentName;
							
							if (surveyReport.eligibilityForScheme == "N") {
								surveyReport.eligibilityForScheme = false ;
							} else {
								surveyReport.eligibilityForScheme = true;
							}
							
							if (surveyReport.permanentSameAsPresent == "N") {
								surveyReport.permanentSameAsPresent = false ;
							} else {
								surveyReport.permanentSameAsPresent = true;
							}
							
							$scope.val = false;
							if(surveyReport.aadharCardNumber == "" || surveyReport.aadharCardNumber == undefined ){
								$scope.val = true;
							}
							if(surveyReport.familyOwnHouseInIndia == 'Y'){
								$scope.slumLocationDetailsPicDis = false;
								$scope.slumLandAdd = false;
								$scope.slumLandInSqrMtr = false;
							}else{
								$scope.slumLocationDetailsPicDis = true;
								$scope.slumLandAdd = true;
								$scope.slumLandInSqrMtr = true;
							}
							if(surveyReport.religionId == '8'){
								$scope.disabledOtherSlumReligion = false;
							}else{
								$scope.disabledOtherSlumReligion = true;
							}
							
							$scope.addSlumSurvey.slumWardName = surveyReport.wardId;
							$scope.addSlumSurvey.slumUlbDetails =  surveyReport.ulbNameId;
							$scope.addSlumSurvey.slumSurveyId = surveyReport.userSurveyId;
							$scope.addSurvey.chckSlumRadio=surveyReport.slumNonSlum;
							$scope.addSlumSurvey.slumFamilyHeadName = surveyReport.familyHead;
							$scope.addSlumSurvey.slumFatherHusbandName=surveyReport.fatherOrHusbandName;
							$scope.addSlumSurvey.slumAdharNo=surveyReport.aadharCardNumber;
							$scope.addSlumSurvey.hiddenSlumAdharNo=surveyReport.aadharCardNumber;
							$scope.addSlumSurvey.slumAdharReason=surveyReport.reasonforAAdharNotAvailable;
							$scope.addSlumSurvey.slumIdProof=surveyReport.idTypeId;
							$scope.addSlumSurvey.slumIdProofNo=surveyReport.idNumber;
							$scope.addSlumSurvey.hiddenSlumIdProofNo=surveyReport.idNumber;
							
							$scope.addSlumSurvey.slumGenderRadio=surveyReport.genderId;
							$scope.addSlumSurvey.maritalStatus = surveyReport.maritalStatusId;
							$scope.addSlumSurvey.dob=surveyReport.dob;
							
							var presentYearInTown = false;
							if(surveyReport.noOfYearsOfStayPresent === 'Y'){
								presentYearInTown = true;
							}
							$scope.addSlumSurvey.slumPresentTown=presentYearInTown;
							$scope.addSlumSurvey.slumPresentHouseNo=surveyReport.presentHouseFlatNo;
							$scope.addSlumSurvey.slumPresentStreetName=surveyReport.presentNameOfStreet;
							$scope.addSlumSurvey.slumPresentCity=surveyReport.presentCityId;
							$scope.addSlumSurvey.slumPresentMobileNo=surveyReport.presentMobNo;
							$scope.addSlumSurvey.slumIsSameAsPresentAdd=surveyReport.permanentSameAsPresent;
							
							var permanentYearInTown = false;
							if(surveyReport.noOfYearsOfStayPermanent === 'Y'){
								permanentYearInTown = true;
							}
							$scope.addSlumSurvey.slumPermanentTown=permanentYearInTown;
							$scope.addSlumSurvey.slumPermanentHouseNo=surveyReport.permanentHouseFlatNo;
							$scope.addSlumSurvey.slumPermanentStreetName=surveyReport.permanentNameOfStreet;
							$scope.addSlumSurvey.slumPermanentCity=surveyReport.permanentCityId;
							$scope.addSlumSurvey.slumPermanentMobileNo=surveyReport.permanentMobileNo;
							
							$scope.addSlumSurvey.slumReligion=surveyReport.religionId;
							$scope.addSlumSurvey.religionIfOther = surveyReport.religionIfOther;
							$scope.addSlumSurvey.geoLongitude=surveyReport.geoLongitude;
							$scope.addSlumSurvey.geoLatitude = surveyReport.geoLatitude;
							
							$scope.addSlumSurvey.slumCaste=surveyReport.casteId;
							$scope.addSlumSurvey.slumOwnsRadio=surveyReport.familyOwnHouseInIndia;
							$scope.addSlumSurvey.slumLandAddress=surveyReport.landAddress;
							$scope.addSlumSurvey.slumLandinSqm=surveyReport.indiaLandInSquareMeter;
							$scope.addSlumSurvey.nonEligibleReason=surveyReport.reasonForNonEligibility;
							$scope.addSlumSurvey.slumEligibleStatus = surveyReport.eligibilityForScheme;
							$(".slumMemberAdd tr").slice(2).remove();
							var slumNameOfFamilyMember = surveyReport.nameOfFamilyMember.split(","); 
							var slumRelationshipId = surveyReport.relationshipId.split(",");
							var slumRelationshipName = surveyReport.relationshipName.split(",");
							var slumFamilyGenderId = surveyReport.familyGenderId.split(",");
							var slumFamilyGenderName = surveyReport.familyGenderName.split(",");
							var slumAgeOfFamilyMember = surveyReport.ageOfFamilyMember.split(",");
							var slumFamilyMemberIdCardNumber = surveyReport.familyMemberIdCardNumber.split(",");
							$scope.addSlumSurvey.slumFamilyMemberName = slumNameOfFamilyMember[0];
							$scope.addSlumSurvey.slumFamilyRelationship = slumRelationshipId[0];
							$scope.addSlumSurvey.slumFamilyMemberGender = slumFamilyGenderId[0];
							$scope.addSlumSurvey.slumFamilyMemberAge = slumAgeOfFamilyMember[0];
							$scope.addSlumSurvey.slumFamilyMemberIdCardNo = slumFamilyMemberIdCardNumber[0];
							for (var i = 1; i < slumNameOfFamilyMember.length; i++) {var addFamilyRow = "<tr class='item'><td><input type='text' class='slumName' placeholder='' value='"+slumNameOfFamilyMember[i]+"' /></td>"
								+ "<td><select class='slumMemberrelationship'>"
								+"<option value='"+slumRelationshipId[i]+"' selected='selected'>"+slumRelationshipName[i]+"</option>"
								+ "<option ng-repeat='relation in memberRelationshipData' value='{{relation.relationshipId}}'>{{relation.relationshipName}}</option>"
								+ "</select></td>"
								+ "<td><select class='slumMembergender'>"
								+ "<option value='"+slumFamilyGenderId[i]+"' seleted='selected'>"+slumFamilyGenderName[i]+"</option>"
								+ "<option ng-repeat='gender in genderData' value='{{gender.genderId}}'>{{gender.genderName}}</option>"
								+ "</select></td>"
								+ "<td><input type='text' class='slumAge' placeholder='' value='"+slumAgeOfFamilyMember[i]+"' /></td>"
								+ "<td><input type='text' class='slumIdcardno' placeholder='' value='"+slumFamilyMemberIdCardNumber[i]+"' /></td>"
								+ "<td><div class='rsm-r'>"
								+ "<button name='delRow' class='b-row-add' type='button'><span class='fa fa-minus'></span></button>"
								+ "</div></td></tr>"
						var element = $compile(addFamilyRow)($scope);
						$(".slumMemberAdd").append(element);
						$("button[name = 'delRow']").click(function() {
							$(this).parent().parent().parent().remove();
						});
						}
							
						}else{
							$('.nav-tabs a[href="#' + "nonslum" + '"]').tab('show');
							$("#nonslumedit").css({"display" : "block"});
							$("#slumedit").css({"display" : "none"});
							
						$scope.validationPendingStatusNonSlum();
						
						$scope.applicantImageShow = true;
						$scope.idImageShow = true;
						$scope.presentInfrontHousePicShow = true;
						$scope.locationDetailsPicShow = true;
						$scope.landRecordPicShow = true;
						$scope.landPhoto1Show = true;
						$scope.landPhoto2Show = true;
						$scope.incomeProofPhotoShow = true;
						$scope.bplPictureShow = true;
						$scope.rationCardPicShow = true;
						$scope.applicantSignatureShow = true;
						
						if(surveyReport.familyOwnHouseInIndia == 'Y'){
							$scope.locationDetailsPicDis = false;
							$scope.landRecordPicDis = false;
						}else{
							$scope.locationDetailsPicDis = true;
							$scope.landRecordPicDis = true;
						}
						if(surveyReport.religionId == '8'){
							$scope.disabledOtherReligion = false;
						}else{
							$scope.disabledOtherReligion = true;
						}
						if(surveyReport.bankId == '47'){
							$scope.disabledOtherBank = false;
						}else{
							$scope.disabledOtherBank = true;
						}
						if(surveyReport.familyHaveBplCard == 'Y'){
							$scope.bplPictureDis = false;
							$scope.bplNoDis = false;
						}else{
							$scope.bplPictureDis = true;
							$scope.bplNoDis = true;
						}
						if(surveyReport.familyHaveRationCard == 'Y'){
							$scope.rationCardPicDis = false;
							$scope.rationCardNoDis = false;
						}else{
							$scope.rationCardPicDis = true;
							$scope.rationCardNoDis = true;
						}
						
						$scope.showSubmitButton = false;
						$scope.showSaveButton = false;
						$scope.showUpdateButton = true;
						/*var parsedData = $scope.superAdminSurveyReport;*/
						if (surveyReport.permanentSameAsPresent == "N") {
							surveyReport.permanentSameAsPresent = false ;
						} else {
							surveyReport.permanentSameAsPresent = true;
						}
						if (surveyReport.eligibilityForScheme == "N") {
							surveyReport.eligibilityForScheme = false ;
						} else {
							surveyReport.eligibilityForScheme = true;
						}
						
						$scope.nonSlumVal = false;
						if(surveyReport.aadharCardNumber == "" || surveyReport.aadharCardNumber == undefined){
							$scope.nonSlumVal = true;
						}
						
						
						$scope.addSurvey = {};
						$scope.addSurvey.formNo ="demo";
						$scope.addSurvey.surveyCity="demo";
						
						$scope.nonSlumPhotoAttachmentName = surveyReport.photoAttachmentName;
						$scope.nonSlumIdAttachmentName = surveyReport.idAttachmentName;
						$scope.nonSlumPhotoAttachmentInFrontOfHouse = surveyReport.photoAttachmentInFrontOfHouse;
						$scope.nonSlumIndiaLocationDetailsAttachment = surveyReport.landAttachmentName;
						$scope.nonSlumLandAttachment1 = surveyReport.landAttachment1;
						$scope.nonSlumLandAttachment2 = surveyReport.landAttachment2;
						$scope.nonSlumIncomeProofAttachment = surveyReport.incomeProofAttachment;
						$scope.nonSlumBplCardAttachment = surveyReport.bplCardAttachment;
						$scope.nonSlumRationCardAttachment = surveyReport.rationCardAttachment;
						$scope.nonSlumSignatureOfApplicant = surveyReport.signatureOfApplicant;
						
						$scope.slumNonWardDetails = surveyReport.wardId;
						$scope.slumNonUlbDetails =  surveyReport.ulbNameId;
						$scope.addSurvey.eligibleStatus = surveyReport.eligibilityForScheme;	
						$scope.addSurvey.surveyId = surveyReport.userSurveyId;
						$scope.addSurvey.chckSlumRadio=surveyReport.slumNonSlum
						$scope.addSurvey.familyHeadName = surveyReport.familyHead;
						$scope.addSurvey.fatherHusbandName=surveyReport.fatherOrHusbandName;
						$scope.addSurvey.adharNo=surveyReport.aadharCardNumber;
						$scope.addSurvey.hiddenNonSlumAdharNo=surveyReport.aadharCardNumber;
						// $scope. adhar check box
						$scope.addSurvey.adharReason=surveyReport.reasonforAAdharNotAvailable;
						$scope.addSurvey.maritalRadio=surveyReport.maritalStatusId;
						// $scope. Eligibility
						$scope.addSurvey.nonEligibleReason=surveyReport.reasonForNonEligibility;
						$scope.addSurvey.genderRadio=surveyReport.genderId;
						// $scope. image file model
						$scope.addSurvey.idProof=surveyReport.idTypeId;
						$scope.addSurvey.idProofNo=surveyReport.idNumber;
						$scope.addSurvey.hiddenNonSlumIdProofNo=surveyReport.idNumber;
						// $scope. image file model
						$scope.addSurvey.dob=surveyReport.dob;
						$scope.addSurvey.religion=surveyReport.religionId;
						$scope.addSurvey.religionIfOther = surveyReport.religionIfOther;
						$scope.addSurvey.caste=surveyReport.casteId;
						
						var presentInCity = false;
						if(surveyReport.noOfYearsOfStayPresent === 'Y'){
							presentInCity = true;
						}
						$scope.addSurvey.presentYearsInCity=presentInCity;
						$scope.addSurvey.presentHouseNo=surveyReport.presentHouseFlatNo;
						$scope.addSurvey.presentStreetName=surveyReport.presentNameOfStreet;
						$scope.addSurvey.presentCity=surveyReport.presentCityId;
						$scope.addSurvey.presentMobileNo=surveyReport.presentMobNo;
						$scope.addSurvey.isSameAsPresentAdd=surveyReport.permanentSameAsPresent;
						
						var permanentInCity = false;
						if(surveyReport.noOfYearsOfStayPermanent === 'Y'){
							permanentInCity = true;
						}
						$scope.addSurvey.permanentYearsInCity=permanentInCity;
						$scope.addSurvey.permanentHouseNo=surveyReport.permanentHouseFlatNo;
						$scope.addSurvey.permanentStreetName=surveyReport.permanentNameOfStreet;
						$scope.addSurvey.permanentCity=surveyReport.permanentCityId;
						$scope.addSurvey.permanentMobileNo=surveyReport.permanentMobileNo;
						
						// $scope. image
						$scope.addSurvey.houseRoofType=surveyReport.houseTypeRoofId;
						$scope.addSurvey.dwellinUnitRoom=surveyReport.houseTypeWallId;
						$scope.addSurvey.ownsRadio=surveyReport.familyOwnHouseInIndia;
						$scope.addSurvey.landAddress=surveyReport.landAddress;
						// $scope. image
						$scope.addSurvey.landinSqm=surveyReport.indiaLandInSquareMeter;
						$scope.addSurvey.ownershipHouse=surveyReport.houseOwnershipId;
						$scope.addSurvey.houseWallType=surveyReport.houseTypeWallId;
						$scope.addSurvey.sizeExistingDwelling=surveyReport.sizeOfDwellUnitCarpetArea;
						// $scope. image
						$scope.addSurvey.houseRequirementRadio=surveyReport.housingCategoryId; 
						$scope.addSurvey.requirement=surveyReport.houseRequirementName;
						
						$scope.addSurvey.pattadarName=surveyReport.nameOfPattadars;
						$scope.addSurvey.dagNo=surveyReport.dagNumber;
						$scope.addSurvey.pattaNo=surveyReport.pattaNumber;
						$scope.addSurvey.landAreaPatta=surveyReport.landAreaAsInPatta;
						$scope.addSurvey.landLength=surveyReport.dimentionOfLandLength;
						$scope.addSurvey.landBreadth=surveyReport.dimensionOfLandbreadth;
						// $scope.addSurvey.permanentStreetName
						// $scope.addSurvey.permanentCity
						$scope.addSurvey.employmentStatus=surveyReport.employementCategoryId;
						// $scope.addSurvey.averageIncome=surveyReport.houseRequirementId;
						// no columns
						// $scope.addSurvey.employmentStatusName=surveyReport.houseRequirementId;
						// no columns
						$scope.addSurvey.incomeProof=surveyReport.incomeProofDocName;
						// $scope.addSurvey.presentMobileNo
						$scope.addSurvey.bplRadio=surveyReport.familyHaveBplCard;
						$scope.addSurvey.bplNo=surveyReport.bplCardNumber;
						// $scope.addSurvey.permanentHouseNo
						$scope.addSurvey.rationRadio=surveyReport.familyHaveRationCard;
						$scope.addSurvey.rationCardNo=surveyReport.rationCardNumber;
						// $scope.addSurvey
						$scope.addSurvey.geoLongitude=surveyReport.geoLongitude;
						$scope.addSurvey.geoLatitude = surveyReport.geoLatitude;
						$scope.addSurvey.preferredAssistanceHfa=surveyReport.hfaCategoryId;
						/*$scope.addSurvey.vehicleCategory=surveyReport.vehicleCategoryId;
						$scope.addSurvey.vehicleRegdNo=surveyReport.vehicleRegistrationNumber;*/
						// $scope.addSurvey.
						$scope.addSurvey.bankAccNo=surveyReport.bankAccountNo;
						$scope.addSurvey.bankName=surveyReport.bankId;
						$scope.addSurvey.otherBankName=surveyReport.otherBankName;
						$scope.addSurvey.bankBranchName=surveyReport.branchName;
						$scope.addSurvey.bankIfscCode=surveyReport.branchIfscCode;
						// $scope.addSurvey
						$(".memberAdd tr").slice(2).remove();
						var nameOfFamilyMember = surveyReport.nameOfFamilyMember.split(","); 
						var relationshipId = surveyReport.relationshipId.split(",");
						var relationshipName = surveyReport.relationshipName.split(",");
						var familyGenderId = surveyReport.familyGenderId.split(",");
						var familyGenderName = surveyReport.familyGenderName.split(",");
						var ageOfFamilyMember = surveyReport.ageOfFamilyMember.split(",");
						var familyMemberIdCardNumber = surveyReport.familyMemberIdCardNumber.split(",");
						$scope.addSurvey.familyMemberName = nameOfFamilyMember[0];
						$scope.addSurvey.familyRelationship = relationshipId[0];
						$scope.addSurvey.familyMemberGender = familyGenderId[0];
						$scope.addSurvey.familyMemberAge = ageOfFamilyMember[0];
						$scope.addSurvey.familyMemberIdCardNo = familyMemberIdCardNumber[0];
						for (var i = 1; i < nameOfFamilyMember.length; i++) {var addFamilyRow = "<tr class='familyMemberRow'><td><input type='text' class='name' placeholder='' value='"+nameOfFamilyMember[i]+"' /></td>"
							+ "<td><select class='memberrelationship'>"
							+"<option value='"+relationshipId[i]+"' selected='selected'>"+relationshipName[i]+"</option>"
							+ "<option ng-repeat='relation in memberRelationshipData' value='{{relation.relationshipId}}'>{{relation.relationshipName}}</option>"
							+ "</select></td>"
							+ "<td><select class='membergender'>"
							+ "<option value='"+familyGenderId[i]+"' seleted='selected'>"+familyGenderName[i]+"</option>"
							+ "<option ng-repeat='gender in genderData' value='{{gender.genderId}}'>{{gender.genderName}}</option>"
							+ "</select></td>"
							+ "<td><input type='text' class='age' placeholder='' value='"+ageOfFamilyMember[i]+"' /></td>"
							+ "<td><input type='text' class='idcardno' placeholder='' value='"+familyMemberIdCardNumber[i]+"' /></td>"
							+ "<td><div class='rsm-r'>"
							+ "<button name='delRow' class='b-row-add' type='button'><span class='fa fa-minus'></span></button>"
							+ "</div></td></tr>"
					var element = $compile(addFamilyRow)($scope);
					$(".memberAdd").append(element);
					$("button[name = 'delRow']").click(function() {
						$(this).parent().parent().parent().remove();
					});
					}
					}	
					}
					}
					
					$scope.addFamilyTextbox = function() {
						var addFamilyRow = "<tr class='familyMemberRow'><td><input type='text' class='name' placeholder='' /></td>"
								+ "<td><select class='memberrelationship'>"
								+ "<option value=''>----select----</option>"
								+ "<option ng-repeat='relation in memberRelationshipData' value='{{relation.relationshipId}}'>{{relation.relationshipName}}</option>"
								+ "</select></td>"
								+ "<td><select class='membergender'>"
								+ "<option value=''>select</option>"
								+ "<option ng-repeat='gender in genderData' value='{{gender.genderId}}'>{{gender.genderName}}</option>"
								+ "</select></td>"
								+ "<td><input type='text' class='age' placeholder='' /></td>"
								+ "<td><input type='text' class='idcardno' placeholder='' /></td>"
								+ "<td><div class='rsm-r'>"
								+ "<button name='delRow' class='b-row-add' type='button'><span class='fa fa-minus'></span></button>"
								+ "</div></td></tr>"
						var element = $compile(addFamilyRow)($scope);
						$(".memberAdd").append(element);
						$("button[name = 'delRow']").click(function() {
							$(this).parent().parent().parent().remove();
						});
					}
					
					
/**********************fuction to hide error message********************/
					
					/*$('[name=familyHeadName]').click(function(){
						 $('#fmlyHdNmErr').hide();
					 });*/
					
					/*$('[name=idProofNo]').click(function(){
						 $('#fthrHusbNmErr').hide();
					 });*/
					
					$scope.idVerify = function idVerify(id)
					{
						$scope.idtype = id;
						if(id == 1)
							{
							$scope.message ="Your Adhar format should be 0000-0000-0000" ;
							}else if(id == 3)
								{
								$scope.message ="Your PAN format should be AAAAA-0000-A" ;
								}else if(id == 4){
									$scope.message ="Your DL format should be AA-00-0000-0000000" ;
								}
					}
					
					/**********************End of fuction to hide error message********************/
					
/************************functions for some validation**************************/
					
					$scope.validationPendingStatusSlum = function validationPendingStatusSlum(){
						$scope.validationPendingStatus = false;
					}
					
					$scope.validationPendingStatusNonSlum = function validationPendingStatusNonSlum(){
						$scope.validationPendingStatus = true;
					}
					
					$scope.ownsRadioFunction = function ownsRadioFunction() {
						$scope.locationDetailsPicDis = false;
						$scope.landRecordPicDis = false;
						$scope.landAdd = false;
						$scope.landInSqrMtr = false;
					}
					
					$scope.ownsRadioNoFunction = function ownsRadioNoFunction() {
						$scope.locationDetailsPicDis = true;
						$scope.landRecordPicDis = true;
						$scope.landAdd = true;
						$scope.landInSqrMtr = true;
					}
					
					$scope.enableOtherReligion = function enableOtherReligion(){
						if($scope.addSurvey.religion == '8'){
							$scope.disabledOtherReligion = false;
						}
						else{
							$scope.disabledOtherReligion = true;
							$scope.addSurvey.religionIfOther="";
						}
					}
					
					$scope.enableOtherBank = function enableOtherBank(){
						if($scope.addSurvey.bankName == '47'){
							$scope.disabledOtherBank = false;
						}
						else{
							$scope.disabledOtherBank = true;
							$scope.addSurvey.otherBankName = "";
						}
					}
					$scope.bplRadioFunction = function bplRadioFunction(){
						$scope.bplPictureDis = false;
						$scope.bplNoDis = false;
						
					}
					$scope.bplRadioNoFunction = function bplRadioNoFunction(){
						$scope.bplPictureDis = true;
						$scope.bplNoDis = true;
						$scope.addSurvey.bplNo = "";
					}
					$scope.rationRadioFunction = function rationRadioFunction(){
						$scope.rationCardPicDis = false;
						$scope.rationCardNoDis = false;
					}
					$scope.rationRadioNoFunction = function rationRadioNoFunction(){
						$scope.rationCardPicDis = true;
						$scope.rationCardNoDis = true;
						$scope.addSurvey.rationCardNo = "";
					}
					$scope.slumOwnsRadioFunction = function slumOwnsRadioFunction() {
						$scope.slumLocationDetailsPicDis = false;
						$scope.slumLandAdd = false;
						$scope.slumLandInSqrMtr = false;
					}
					
					$scope.slumOwnsRadioNoFunction = function slumOwnsRadioNoFunction() {
						$scope.slumLocationDetailsPicDis = true;
						$scope.slumLandAdd = true;
						$scope.slumLandInSqrMtr = true;
					}
					
					$scope.idProofValidation = function idProofValidation(){
						$scope.IfMatch = false;
						var re="";
						if($scope.addSlumSurvey.slumIdProof == '2'){
								re = /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/
						}else if($scope.addSlumSurvey.slumIdProof == '3'){
							re = /^[A-Z]{2}[0-9]{13}$/
					     }
						
						$scope.idProofCheck = function idProofCheck(){
							if(re.test($scope.addSlumSurvey.slumIdProofNo)==false){
								$scope.IfMatch = true;
						}else{
							$scope.IfMatch = false;
						}
					  }
					}
					
					$scope.idNonSlumProofValidation = function idNonSlumProofValidation(){
						$scope.nIfMatch = false;
						var re="";
						if($scope.addSurvey.idProof == '2'){
								re = /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/
						}else if($scope.addSurvey.idProof == '3'){
							re = /^[A-Z]{2}[0-9]{13}$/
					     }
						
						$scope.idNonSlumProofCheck = function idNonSlumProofCheck(){
							if(re.test($scope.addSurvey.idProofNo)==false){
								$scope.nIfMatch = true;
						}else{
							$scope.nIfMatch = false;
						}
					  }
					}
					
					/************************End of functions for validation**************************/
					$scope.checkAdharForSlum=function checkAdharForSlum(adharNo){
						var data={"adharNo" : adharNo};
						$http.post(baseUrl + 'checkAdharIsExist/',data).success(function(data) {
							if(data==true){
							if($scope.addSlumSurvey.hiddenSlumAdharNo=='0'){
								$("#adharErrorForSlum").text("Adhar card already exists");
							}else{
								if($scope.addSlumSurvey.hiddenSlumAdharNo!=adharNo){
									$("#adharErrorForSlum").text("Adhar card already exists");
								}else{
									$("#adharErrorForSlum").text("");
								}
							}
							}else{
								$("#adharErrorForSlum").text("");
							}
						});
					}
					$scope.checkAdharForNonSlum=function checkAdharForNonSlum(adharNo){
						var data={"adharNo" : adharNo};
						$http.post(baseUrl + 'checkAdharIsExist/',data).success(function(data) {
							if(data==true){
								if($scope.addSurvey.hiddenNonSlumAdharNo=='0'){
									$("#adharErrorForNonSlum").text("Adhar card already exists");
								}else{
									if($scope.addSurvey.hiddenNonSlumAdharNo!=adharNo){
										$("#adharErrorForNonSlum").text("Adhar card already exists");
									}else{
										$("#adharErrorForNonSlum").text("");
									}
								}
							}else{
								$("#adharErrorForNonSlum").text("");
							}
						});
					}
					$scope.downloadSurveyPhotos=function downloadSurveyPhotos(surveyReport){
		
						var data={"surveyId":surveyReport.userSurveyId,"applicantPhotoName" : surveyReport.photoAttachmentName,"bplPhotoName" : surveyReport.bplCardAttachment,"idPhotoName" : surveyReport.idAttachmentName,"incomeProofPhotoName" : surveyReport.incomeProofAttachment, "landPhoto1Name" : surveyReport.landAttachment1,"landPhoto2Name" : surveyReport.landAttachment2,"landRecordPhotoName" : surveyReport.landAttachmentName,"presentInfrontHousePhotoName" : surveyReport.photoAttachmentInFrontOfHouse,"rationCardPhotoName" : surveyReport.rationCardAttachment,"applicantSignatureName" : surveyReport.signatureOfApplicant}
					
						$http({
						    url: baseUrl + 'downLoadFilesInZip',
						    method: "POST",
						    data: data, // this is your json data string
						    headers: {
						       'Content-type': 'application/json'
						    },
						    responseType: 'blob'
						}).success(function (data, status, headers, config) {
						    var blob = new Blob([data], {type: "application/zip"});
							saveAs(blob, surveyReport.userSurveyId+'_images.zip');
						}).error(function (data, status, headers, config) {
						    alert("Error occured while downloading survey images!!");
						});
					}
					$scope.checkIdProofForSlum=function checkIdProofForSlum(slumIdProofNo,slumIdProof){
						$scope.IfMatch = false;
						var data={"IdProofId" : slumIdProof,"IdProofNo" : slumIdProofNo};
						$http.post(baseUrl + 'checkIdProofNoIsExist/',data).success(function(data) {
							if(data==true){
								if($scope.addSlumSurvey.hiddenSlumIdProofNo=='0'){
									$("#idProofErrorForSlum").text("Id card already exists");
								}else{
									if($scope.addSlumSurvey.hiddenSlumIdProofNo!=slumIdProofNo){
										$("#idProofErrorForSlum").text("Id card already exists");
									}else{
										$("#idProofErrorForSlum").text("");
									}
								}
							}else{
								$("#idProofErrorForSlum").text("");
							}
						});
					}
					$scope.checkIdProofForNonSlum=function checkIdProofForNonSlum(nonSlumIdProofNo,nonSlumIdProof){
						$scope.nIfMatch = false;
						var data={"IdProofId" : nonSlumIdProof,"IdProofNo" : nonSlumIdProofNo};
						$http.post(baseUrl + 'checkIdProofNoIsExist/',data).success(function(data) {
							if(data==true){
								if($scope.addSurvey.hiddenNonSlumIdProofNo=='0'){
									$("#idProofErrorForNonSlum").text("Id card already exists");
								}else{
									if($scope.addSurvey.hiddenNonSlumIdProofNo!=nonSlumIdProofNo){
										$("#idProofErrorForNonSlum").text("Id card already exists");
									}else{
										$("#idProofErrorForNonSlum").text("");
									}
								}
							}else{
								$("#idProofErrorForNonSlum").text("");
							}
						});
					}
					$scope.enableOtherReligionForSlum = function enableOtherReligionForSlum(){
						if($scope.addSlumSurvey.slumReligion == '8'){
							$scope.disabledOtherSlumReligion = false;
						}
						else{
							$scope.disabledOtherSlumReligion = true;
							$scope.addSlumSurvey.religionIfOther="";
						}
					}
					
					$scope.getUserDetails = function getUserDetails(){
						$(".pmay-loader").css({
							"display" : "block"
						});
						$http.get(baseUrl + 'getUserDetails/').success(function(data) {
							admin.userDetailsReport = data;
							admin.setUserReportPage(1);
					        $(".pmay-loader").css({
						    "display" : "none"
						    });
						});
					}
					
					$scope.resetUserPaswrd = function resetUserPaswrd(mobileNo){
						var mobileNumber = {"mobileNo" : mobileNo}
						$(".pmay-loader").css({
							"display" : "block"
						});
						$http.post(baseUrl + 'generatePassword/',mobileNumber).success(function(data) {
							$(".pmay-loader").css({
							    "display" : "none"
							});
							swal({
								position : 'top',
								text : "Password Reset Successfully",
								type : 'success',
								animation : false,
								customClass : 'animated tada',
								showConfirmButton : false,
								timer : 2000,
							})
							
						});
					}
					
					$scope.getAdminFilterForUlbDetails = function getAdminFilterForUlbDetails(adminReportParam){
						$(".pmay-loader").css({
							"display" : "block"
						});
						$("#noUlbrecords").hide();
						var data = {"searchData" : adminReportParam}
						   $http.post(baseUrl +'/getAdminUlbWardDetails', data).success(function(data) {
							   $(".pmay-loader").css({
									"display" : "none"
								});
										console.log(data)
										if (data != "") {
											admin.adminUserUlbWardsData = data;
											admin.setUlbDetailsPage(1);
										} else {
											admin.setUlbDetailsPage(-1);
											$("#noUlbrecords").show();
										}
									});
					}
/***********************************************************Pagination ******** *************************************************/
					var admin = this;
					/********************Pagination for Survey Report**********************/				    
				    //used for survey report
					admin.reportPager = {};
					admin.setReportPage = setReportPage;
					$scope.getSurveyReports();
					function setReportPage(page) {
						$(".pmay-loader").css({
							"display" : "block"
						});
				        if (page < 1 || page > admin.reportPager.totalPages) {
				        	$(".pmay-loader").css({
								"display" : "none"
							});
				            return;
				        }
				        admin.reportPager = PagerService.GetPager(admin.adminSurveyReport.length, page );
				        admin.adminSurveyData = admin.adminSurveyReport.slice(admin.reportPager.startIndex, admin.reportPager.endIndex + 1);
				        $(".pmay-loader").css({
							"display" : "none"
						});
				    }
					/******************** End Pagination for Survey Report**********************/
					/********************Pagination for manager Surveyor Report**********************/				    
				    //used for survey report
					admin.pendingUserPager = {};
					admin.setPendingUserReportPage = setPendingUserReportPage;
					$scope.getAllPendingUsers();
					function setPendingUserReportPage(page) {
						$(".pmay-loader").css({
							"display" : "block"
						});
				        if (page < 1 || page > admin.pendingUserPager.totalPages) {
				        	$(".pmay-loader").css({
								"display" : "none"
							});
				            return;
				        }
				        admin.pendingUserPager = PagerService.GetPager(admin.pendingUsers.length, page );
				        admin.pendingUsersData = admin.pendingUsers.slice(admin.pendingUserPager.startIndex, admin.pendingUserPager.endIndex + 1);
				        $(".pmay-loader").css({
							"display" : "none"
						});
				    }
					/******************** End Pagination for  manager Surveyor Report**********************/
					/********************Pagination for manager Profile Report**********************/				    
				    //used for survey report
					admin.userPager = {};
					admin.setUserReportPage = setUserReportPage;
					$scope.getUserDetails();
					function setUserReportPage(page) {
						$(".pmay-loader").css({
							"display" : "block"
						});
				        if (page < 1 || page > admin.userPager.totalPages) {
				        	$(".pmay-loader").css({
								"display" : "none"
							});
				            return;
				        }
				        admin.userPager = PagerService.GetPager(admin.userDetailsReport.length, page );
				        admin.userDetailsReportData = admin.userDetailsReport.slice(admin.userPager.startIndex, admin.userPager.endIndex + 1);
				        $(".pmay-loader").css({
							"display" : "none"
						});
				    }
					/******************** End Pagination for manager Profile Report**********************/
					/********************Pagination for  Ulb Details**********************/				    
				    //used for survey report
					var searchData= "savedSurvey";
					var pageSizeForUlb = 5;
					admin.ulbPager = {};
					admin.setUlbDetailsPage = setUlbDetailsPage;
					$scope.getAdminFilterForUlbDetails(searchData);
					function setUlbDetailsPage(page) {
						$(".pmay-loader").css({
							"display" : "block"
						});
						if(page===-1){
							admin.ulbWardsData="";
							admin.ulbPager.pages.length=0;
							$(".pmay-loader").css({
								"display" : "none"
							});
							return;
						}
				        if (page < 1 || page > admin.ulbPager.totalPages) {
				        	$(".pmay-loader").css({
								"display" : "none"
							});
				            return;
				        }
				        admin.ulbPager = PagerService.GetPager(admin.adminUserUlbWardsData.length, page ,pageSizeForUlb);
				        admin.ulbWardsData = admin.adminUserUlbWardsData.slice(admin.ulbPager.startIndex, admin.ulbPager.endIndex + 1);
				        $(".pmay-loader").css({
							"display" : "none"
						});
				    }
					/******************** End Pagination for  Ulb Details**********************/
					
/****************************************************End Pagination ***************** *************************************************/
					
					$scope.deleteMultipleRecord = function deleteMultipleRecord() {
						var deletedSurveyIds = [];
						angular.forEach($scope.adminReport.selectedId,
								function(item, key) {
									if (item == true) {
										deletedSurveyIds.push(key);
									}
								});
						
						var data = {"markedSurveyIds" : deletedSurveyIds};
						
						swal({
							  title: 'Are you sure?',
							  text: "You won't be able to revert this!",
							  type: 'warning',
							  showCancelButton: true,
							  confirmButtonColor: '#3085d6',
							  cancelButtonColor: '#d33',
							  confirmButtonText: 'Yes, delete it!',
							  cancelButtonText: 'No, cancel!',
							  confirmButtonClass: 'btn btn-success',
							  cancelButtonClass: 'btn btn-danger',
							  buttonsStyling: false,
							  reverseButtons: true
							}).then((result) => {
							  if (result.value) {
								  $http.post(baseUrl + 'deleteMultipleRecord/', data)
									.success(function(data) {
										$scope.getSurveyReports();
										$scope.deletedSurveyReports();

									});
							    swal(
							      'Deleted!',
							      'Your file has been deleted.',
							      'success'
							    )
							  } else if (
							    // Read more about handling dismissals
							    result.dismiss === swal.DismissReason.cancel
							  ) {
							    swal(
							      'Cancelled',
							      'Your imaginary file is safe :)',
							      'error'
							    )
							  }
							})
					}
					
					$scope.getLoggedInDetails = function getLoggedInDetails(){
						$(".pmay-loader").css({
							"display" : "block"
						});
						$http.get(baseUrl + 'getLoggedInDetails/').success(function(data) {
							admin.userLoggedinDetails = data;
							admin.setUserReportPage(1);
					        $(".pmay-loader").css({
						    "display" : "none"
						    });
						});
					}
				});