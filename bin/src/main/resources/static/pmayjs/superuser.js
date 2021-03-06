mainApp
		.controller(
				'SuperUserController',
				function($scope, $http, $rootScope, Excel, $timeout,$compile, PagerService) {
					$http.defaults.headers.post["Content-Type"] = "application/json";
					$scope.curPage = 0;
					$scope.pageSize = 20;
					$scope.disabledOtherSlumReligion = true;
					/*document.getElementById("locationDetailsPicId").disabled = true;
					document.getElementById("landRecordPicId").disabled = true;
					$scope.disabledOtherReligion = true;*/

/***********************************************************Pagination ******** *************************************************/
					var superUser = this;
					var searchData= "slum";
					var pageSizeForUlb = 5;
				    
					//used for ulb details
					superUser.ulbPager = {};
				    superUser.setUlbDetailsPage = setUlbDetailsPage;
				    
				    //used for survey report
				    superUser.reportPager = {};
				    superUser.setReportPage = setReportPage;

				    activate(searchData);
				    getSuperUserSurveyReport();

				    /*****************Pagination For Ulb Details ********/
				    function activate(searchData) {
				    	getUlbWardDetails(searchData);
				    }

				    function setUlbDetailsPage(page) {
				        if (page < 1 || page > superUser.ulbPager.totalPages) {
				            return;
				        }

				        // get ulbPager object from service
				        superUser.ulbPager = PagerService.GetPager(superUser.superUserUlbWardsData.length, page ,pageSizeForUlb );

				        // get current page of items
				        superUser.ulbWardsData = superUser.superUserUlbWardsData.slice(superUser.ulbPager.startIndex, superUser.ulbPager.endIndex + 1);
				    }
					
					
					$scope.getFilterForUlbDetails = function getFilterForUlbDetails (searchData) {
						activate(searchData);
					}
					
					
					/********************End Pagination for Ulb Details**********************/
					
					/********************Pagination for Survey Report**********************/
					function setReportPage(page) {
				        if (page < 1 || page > superUser.reportPager.totalPages) {
				            return;
				        }

				        // get ulbPager object from service
				        superUser.reportPager = PagerService.GetPager(superUser.superUserSurveyData.length, page );

				        // get current page of items
				        superUser.surveyReportData = superUser.superUserSurveyData.slice(superUser.reportPager.startIndex, superUser.reportPager.endIndex + 1);
				    }
					
					/******************** End Pagination for Survey Report**********************/
					
					
					
/****************************************************End Pagination ***************** *************************************************/									
					
					
					
					
					
					
					
					$scope.getDropDownData = function() {
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
											$scope.memberRelationshipData = data.listRelationshipData;
											$scope.wardData = data.listWardData;
											$scope.cityList = data.listCityData;
											$scope.houseCategoryData = data.listHouseCategoryData;
											$scope.banksList = data.listBanks;
											$scope.ulbList = data.listUlbData;
											$scope.presentInCityInYears = data.listNoOfYearsPresent;
											$(".pmay-loader").css({
												"display" : "none"
											});
										});

					}

					function getSuperUserSurveyReport() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						$http
								.get(baseUrl + '/getAdminsSurveyReports')
								.success(
										function(surveyReportData) {
											$(".pmay-loader").css({
												"display" : "none"
											});
											$scope.superUserReportData = surveyReportData;
											superUser.superUserSurveyData = surveyReportData;
											
											$scope.tempSurveyData = surveyReportData;
											superUser.setReportPage(1);
										});
					}
					
					$scope.logout = function logout() {
						$http.get(baseUrl + 'logout/').success(function(data) {
							location.href = "/"
						});
					}

					$scope.numberOfSuperUserSurveyDataPages = function numberOfSuperUserSurveyDataPages() {
						if ($scope.superUserSurveyData != null) {
							return Math.ceil($scope.superUserSurveyData.length
									/ $scope.pageSize);
						}
					}

					$scope.numberOfSuperUserReportPages = function numberOfSuperUserReportPages() {
						if ($scope.superUserReportData != null) {
							return Math.ceil($scope.superUserReportData.length
									/ $scope.pageSize);
						}
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
												if (data.data.roleId == '3') {
													
													$scope.loginUserName = data.data.firstName;
													$rootScope.userRole = data.data.roleName;
													$rootScope.userUrl = "/superuser";
													$rootScope.userId = data.data.userId;
												} else {
													location.href = "/";
												}
											} else {
												location.href = "/";
											}
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
										$scope.superUserReport.selectedId,
										function(item, key) {
											$scope.superUserReport.selectedId[key] = $scope.selectedAll;
										});
					}

					$scope.superUserReport = {}
					$scope.getReportDetailsForDownload = function getReportDetailsForDownload() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						var superUserReportDataForDownload = [];
						angular.forEach($scope.superUserReport.selectedId,
								function(item, key) {
									if (item == true) {
										superUserReportDataForDownload
												.push(key);
									}
								});

						var rowColumnName = {
							"name" : $scope.userName,
							"fatherName" : $scope.userFatherName,
							"gender" : $scope.gender,
							"age" : $scope.age,
							"maritiaStatus" : $scope.maritalStatus,
							"religion" : $scope.religion,
							"caste" : $scope.caste,
							"aadharNumber" : $scope.aadharNo,
							"idType" : $scope.idType,
							"idNumber" : $scope.idNumber,
							"selectedsurveyId" : superUserReportDataForDownload
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
										location.href = "/userReportExcel";
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

					$scope.getSuperUserDesiredReport = function getSuperUserDesiredReport() {
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
											$scope.filteredSuperUserReportData = downloadData.listAdminsData;
											$scope.name = downloadData.columnData.name;
											$scope.fatherName = downloadData.columnData.fatherName;
											$scope.gender = downloadData.columnData.gender;
											$scope.age = downloadData.columnData.age;
											$scope.maritiaStatus = downloadData.columnData.maritiaStatus;
											$scope.religion = downloadData.columnData.religion;
											$scope.caste = downloadData.columnData.caste;
											$scope.aadharNumber = downloadData.columnData.aadharNumber;
											$scope.idType = downloadData.columnData.idType;
											$scope.idNumber = downloadData.columnData.idNumber;
										});
					}

					$scope.resetAll = function resetAll() {
						$scope.searchData = {};
						superUser.superUserSurveyData = $scope.tempSurveyData;
						superUser.setReportPage(1);
					}

					$scope.customizeSearchReport = function customizeSearchReport() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						
						var searchData = {
								"searchName" : $scope.searchData.superUserReportName,
								"aadharOrIdNumber" : $scope.searchData.superUserReportAadharNo,
								"ulbName" : $scope.searchData.superUserReportUlbName,
								"fatherSpouseName" : $scope.searchData.superUserReportFatherSpouseName,
								"bankAccountNo" : $scope.searchData.superUserReportBankAc,
								"searchScopeName" : $scope.searchData.superUserReportScopeName,
								"searchScopeValue" : $scope.searchData.superUserReportScopeValue
						}

						$http
								.post(
										baseUrl
												+ '/getFilteredReportBySearch',
										searchData)
								.success(
										function(surveyReport) {
											$(".pmay-loader").css({
												"display" : "none"
											});
											if (surveyReport != "") {
												superUser.superUserSurveyData = surveyReport;
												superUser.setReportPage(1);
												
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
												superUser.superUserSurveyData = $scope.tempSurveyData;
												superUser.setReportPage(1);
											}
										});

					}

					$scope.customizeSearchSurveyData = function customizeSearchSurveyData() {
						$(".pmay-loader").css({
							"display" : "block"
						});
						
						var searchData = {
								"searchName" : $scope.searchData.superUserSurveyedName,
								"aadharOrIdNumber" : $scope.searchData.superUserSurveyedAadharNo,
								"ulbName" : $scope.searchData.superUserSurveyedUlbName,
								"fatherSpouseName" : $scope.searchData.superUserSurveyedFatherSpouseName,
								"bankAccountNo" : $scope.searchData.superUserSurveyedBankAc,
								"searchScopeName" : $scope.searchData.superUserSurveyedScopeName,
								"searchScopeValue" : $scope.searchData.superUserSurveyedScopeValue
						}

						$http
								.post(
										baseUrl
												+ '/getFilteredReportBySearch',
										searchData)
								.success(
										function(surveyReport) {
											$(".pmay-loader").css({
												"display" : "none"
											});
											if (surveyReport != "") {
												$scope.superUserSurveyData = surveyReport;
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
												$scope.superUserSurveyData = $scope.tempSurveyData;
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

					/*$scope.saveSurvey = function saveSurvey( addSurvey, clickButton) {
						$(".pmay-loader").css({
							"display" : "block"
						});

						var isSubmittedFlag = "N";

						if (clickButton === "submit") {
							isSubmittedFlag = "Y";
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
						var familyMemberName = [];
						var familyMemberRelation = [];
						var familyMemberGender = [];
						var familyMemberAge = [];
						var familyMemberIdCardNo = [];
						$("tr.item")
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
						var maritalValue = addSurvey.maritalRadio;
						if (maritalValue == undefined) {
							maritalValue = 0;
						}

						var genderValue = addSurvey.genderRadio;
						if (genderValue == undefined) {
							genderValue = 0;
						}

						var surveyData = {
								
								"surveyId" : addSurvey.surveyId,
								"userId" : $rootScope.userId,
							"slumRadio" : addSurvey.chckSlumRadio,
							"validationPendingStatus" : addSurvey.validationPendingStatus,
							"familyHeadName" : addSurvey.familyHeadName,
							"fatherHusbandName" : addSurvey.fatherHusbandName,
							"adharNo" : addSurvey.adharNo,
							"adharReason" : addSurvey.adharReason,
							"contactNo" : addSurvey.contactNo,
							"maritalStatus" : maritalValue,
							"eligibleStatus" : addSurvey.eligibleStatus,
							"nonEligibleReason" : addSurvey.nonEligibleReason,
							"genderId" : genderValue,
							"idType" : addSurvey.idProof,
							"idNo" : addSurvey.idProofNo,
							"dob" : addSurvey.dob,
							"religion" : addSurvey.religion,
							"religionIfOther" : addSurvey.religionIfOther,
							"caste" : addSurvey.caste,

							"presentTown" : addSurvey.presentYearsInCity,
							"presentHouseNo" : addSurvey.presentHouseNo,
							"presentStreetName" : addSurvey.presentStreetName,
							"presentCity" : addSurvey.presentCity,
							"presentMobileNo" : addSurvey.presentMobileNo,
							"isSameAsPresentAdd" : addSurvey.isSameAsPresentAdd,
							"permanentTown" : addSurvey.permanentYearsInCity,
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
							"wardDetails" : addSurvey.wardDetails,
							"vehicleCategoryId" : addSurvey.vehicleCategory,
							"vehicleRegdNo" : addSurvey.vehicleRegdNo,
							"bankAccNo" : addSurvey.bankAccNo,
							"bankName" : addSurvey.bankName,
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
							"isSubmitted" : isSubmittedFlag
						};
						var allImageFiles = new FormData();
						allImageFiles.append('applicantPhoto',
								addSurvey.applicantImageFile);
						allImageFiles.append('idPhoto', addSurvey.idImage);
						allImageFiles.append('presentInfrontHousePic',
								addSurvey.presentInfrontHousePic);
						allImageFiles.append('locationDetailsPic',
								addSurvey.locationDetailsPic);
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
						allImageFiles.append('vehiclePhoto',
								addSurvey.vehiclePhoto);
						allImageFiles.append('applicantSignature',
								addSurvey.applicantSignature);
						allImageFiles.append('incomeProofPhoto',
								addSurvey.incomeProofPhoto);
						allImageFiles.append('surveyData', angular.toJson(
								surveyData, true));
						$http.post(baseUrl + 'addSurvey/', allImageFiles, {
							transformRequest : angular.identity,
							headers : {
								'Content-Type' : undefined
							}
						}).success(function(data) {
							$(".pmay-loader").css({
								"display" : "none"
							});
							alert("success")
						});

					}*/
					
					
					
					/*$scope.addFamilyTextbox = function() {
						var addFamilyRow = "<tr class='item'><td><input type='text' class='name' placeholder='' /></td>"
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
					}*/
					
					/*$scope.copyPresentAddress = function() {
						if ($('#sameData').is(':checked')) {
							$scope.addSurvey.permanentYearsInCity = angular
									.copy($scope.addSurvey.presentYearsInCity);
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

					}*/
					
/**********************fuction to hide error message********************/
					
					/*$('[name=familyHeadName]').click(function(){
						 $('#fmlyHdNmErr').hide();
					 });*/
					
					/*$('[name=idProofNo]').click(function(){
						 $('#fthrHusbNmErr').hide();
					 });*/
					
					/*$scope.idVerify = function idVerify(id)
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
					}*/
					
					/**********************End of fuction to hide error message********************/
					
/************************functions for some validation**************************/
					
					$scope.validationPendingStatusSlum = function validationPendingStatusSlum(){
						$scope.validationPendingStatus = false;
						$(".slum-tbl").css({"display" : "block"});
						$(".nonslum-tbl").css({"display" : "none"});
					}
					
					$scope.validationPendingStatusNonSlum = function validationPendingStatusNonSlum(){
						$scope.validationPendingStatus = true;
						$(".slum-tbl").css({"display" : "none"});
						$(".nonslum-tbl").css({"display" : "block"});
					}
					
					$scope.enableRequirement = function enableRequirement(addSurvey){
						var status= addSurvey.houseRequirementRadio;
						if(status === '2'){
						 $scope.requirement = false;
						}else{
							$scope.requirement = true;
						}
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
					/************************End of functions for validation**************************/
					$scope.editSurvryReport = function editSurvryReport(surveyReport) {
						$("input[type='file']").val(null);
						$("#adharErrorForSlum").text("");
						$("#adharErrorForNonSlum").text("");
						$("#updateSurTab").css({"display" : "block"});
						$('.nav-tabs a[href="#' + "adsur" + '"]').tab('show');
						$scope.slumNonWardDetails=surveyReport.wardId;
						$scope.slumNonUlbDetails = surveyReport.ulbNameId;
							if(surveyReport.slumNonSlum == "S"){
								$(".slum-tbl").css({"display" : "block"});
								$(".nonslum-tbl").css({"display" : "none"});
								
								$scope.slumApplicantSignatureShow = true;
								$scope.slumLocationDetailsPicShow = true;
								$scope.idImageShow = true;
								$scope.idAttachmentName=surveyReport.idAttachmentName;
								$scope.signatureOfApplicant = surveyReport.signatureOfApplicant;
								$scope.indiaLocationDetailsAttachment = surveyReport.indiaLocationDetailsAttachment;
								
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
								
								if(surveyReport.aadharCardNumber == "" || surveyReport.aadharCardNumber == undefined ){
									$scope.val = true;
								}
								
								$scope.addSlumSurvey.slumSurveyId = surveyReport.userSurveyId;
								$scope.addSurvey.chckSlumRadio=surveyReport.slumNonSlum;
								$scope.addSlumSurvey.slumFamilyHeadName = surveyReport.familyHead;
								$scope.addSlumSurvey.slumFatherHusbandName=surveyReport.fatherOrHusbandName;
								$scope.addSlumSurvey.slumAdharNo=surveyReport.aadharCardNumber;
								$scope.addSlumSurvey.hiddenSlumAdharNo=surveyReport.aadharCardNumber;
								$scope.addSlumSurvey.slumAdharReason=surveyReport.reasonforAAdharNotAvailable;
								$scope.addSlumSurvey.slumGenderRadio=surveyReport.genderId;
								$scope.addSlumSurvey.maritalStatus = surveyReport.maritalStatusId;
								$scope.addSlumSurvey.dob=surveyReport.dob;
								$scope.addSlumSurvey.slumIdProof=surveyReport.idTypeId;
								$scope.addSlumSurvey.slumIdProofNo=surveyReport.idNumber;
								
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
								$scope.addSlumSurvey.slumPermanentTown=permanentYearInTown ;
								$scope.addSlumSurvey.slumPermanentHouseNo=surveyReport.permanentHouseFlatNo;
								$scope.addSlumSurvey.slumPermanentStreetName=surveyReport.permanentNameOfStreet;
								$scope.addSlumSurvey.slumPermanentCity=surveyReport.permanentCityId;
								$scope.addSlumSurvey.slumPermanentMobileNo=surveyReport.permanentMobileNo;
								
								$scope.addSlumSurvey.slumReligion=surveyReport.religionId;
								$scope.addSlumSurvey.religionIfOther = surveyReport.religionIfOther;
								$scope.addSlumSurvey.slumCaste=surveyReport.casteId;
								$scope.addSlumSurvey.slumOwnsRadio=surveyReport.familyOwnHouseInIndia;
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
								$(".slum-tbl").css({"display" : "none"});
								$(".nonslum-tbl").css({"display" : "block"});
							
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
							}else{
								$scope.bplPictureDis = true;
							}
							if(surveyReport.familyHaveRationCard == 'Y'){
								$scope.rationCardPicDis = false;
							}else{
								$scope.rationCardPicDis = true;
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
							
							if(surveyReport.aadharCardNumber == "" || surveyReport.aadharCardNumber == undefined){
								$scope.nonSlumVal = true;
							}
							
							
							$scope.addSurvey = {};
							$scope.addSurvey.formNo ="demo"
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
							// $scope. image
							$scope.addSurvey.landinSqm=surveyReport.indiaLandInSquareMeter;
							$scope.addSurvey.ownershipHouse=surveyReport.houseOwnershipId;
							$scope.addSurvey.houseWallType=surveyReport.houseTypeWallId;
							$scope.addSurvey.sizeExistingDwelling=surveyReport.sizeOfDwellUnitCarpetArea;
							// $scope. image
							$scope.addSurvey.houseRequirementRadio=surveyReport.housingCategoryId; 
							$scope.addSurvey.requirement=surveyReport.houseRequirementId;
							
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
					   $scope.enableOtherReligionForSlum = function enableOtherReligionForSlum(){
							if($scope.addSlumSurvey.slumReligion == '8'){
								$scope.disabledOtherSlumReligion = false;
							}
							else{
								$scope.disabledOtherSlumReligion = true;
								$scope.addSlumSurvey.religionIfOther="";
							}
						}
					   
					   
/*************************************************Code For High Chart for Survey Report ********************************************/
					   
					   $scope.getTodaySurveyReport = function getTodaySurveyReport() {
						   $http.get(baseUrl+'getTodaySurveyReportForSlumNonSlum/').success(function (data) {
							   console.log(data)
							   $scope.todaySurveyReport = data;
							   Highcharts.chart('todaySurveyReport', {
								    chart: {
								        plotBackgroundColor: null,
								        plotBorderWidth: null,
								        plotShadow: false,
								        type: 'pie'
								    },
								    title: {
								        text: "Survey Report for Dt. " + new Date().toLocaleDateString('en-GB')
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
								            name: 'Slum',
								            y: $scope.todaySurveyReport.noOfNonSlumSurvey,
								        }, {
								            name: 'Non-Slum',
								            y: $scope.todaySurveyReport.noOfSlumSurvey
								        }]
								    }]
								});
							   
						   })
					   }
					   
					   
					   $scope.getTotalSurveyReport = function getTotalSurveyReport() {
						   $http.get(baseUrl+'getTotalSurveyReportForSlumNonSlum/').success(function (data) {
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
								            name: 'Slum',
								            y: data.noOfNonSlumSurvey,
								        }, {
								            name: 'Non-Slum',
								            y: data.noOfSlumSurvey
								        }]
								    }]
								});
							   
						   })
					   }
					   
					   
					   
					   
/******************************************************End for Survey Report ********************************************/
					   function getUlbWardDetails(searchData) {
						   var data = {"searchData" : searchData}
						   $http.post(baseUrl +'/getUlbWardDetails', data)
								.success(function(ulbReport) {
										console.log(ulbReport)
										if (ulbReport != "") {
											superUser.superUserUlbWardsData = ulbReport;
											superUser.setUlbDetailsPage(1);
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
										}
									});

					   }
					   
					   
					   
					   
				});