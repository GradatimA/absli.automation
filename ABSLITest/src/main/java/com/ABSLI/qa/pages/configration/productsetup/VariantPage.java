package com.ABSLI.qa.pages.configration.productsetup;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ABSLI.qa.base.AbsliParent;

public class VariantPage extends AbsliParent {

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlPlan']")
	WebElement Product;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtProduct']")
	WebElement Variant;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCode']")
	WebElement Code;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtUANNo']")
	WebElement UIN;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEffectiveDate']")
	WebElement UINEffectiveDate;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtStartDate']")
	WebElement VariantStartDate;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEndDate']")
	WebElement VariantEndDate;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMinAge']")
	WebElement VariantMinEntryAge;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMinAgeType-container']")
	WebElement VariantMinEntryAgeYear;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMaxAge']")
	WebElement VariantMaxEntryAge;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMaxAgeType-container']")
	WebElement VariantMaxEntryAgeyear;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtUnderwritingMinimumAge']")
	WebElement UnderwritingMinimumAge;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtUnderwritingMaximumAge']")
	WebElement UnderwitingMaximumAge;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMinTerm']")
	WebElement VariantMinimumTerm;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMinTermType-container']")
	WebElement VariantMinimumTermYear;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMaxTerm']")
	WebElement VariantMaximumTerm;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMaxTermType-container']")
	WebElement VariantMaximumTermyear;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMinSumAssured']")
	WebElement MinimumSumAssured;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMaxSumAssured']")
	WebElement MaximumSumAssured;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtFreelookup']")
	WebElement Freelookup;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstFrequency_0']")
	WebElement FrequencyMonthly;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstFrequency_5']")
	WebElement frequencyAnnual;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstFrequency_1']")
	WebElement frequencySemianuual;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstFrequency_2']")
	WebElement frequencyQuarterly;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstCoEfficient_0']")
	WebElement RiderFactorAge;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstCoEfficient_1']")
	WebElement RiderFactorgender;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstCoEfficient_2']")
	WebElement RiderFactorSumassured;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWaitingPeriodforLoan']")
	WebElement WaitingPeriodforLoan;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtIsEligibleforLoanYes']")
	WebElement EligibleforLoanYes;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtIsEligibleforLoanNo']")
	WebElement EligibleforLoanNo;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNoOfBackDatedForNewApplication']")
	WebElement WindowPeriodforNewBusiness;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNoOfBackDatedForEndorsement']")
	WebElement WindowPeriodforEndorsement;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtUnderWritingYes']")
	WebElement IsUnderWritingApplicableYes;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtUnderWritingNo']")
	WebElement IsUnderWritingApplicableNo;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWaitingPeriodforClaim']")
	WebElement WaitingPeriodforClaim;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkRelationShip_0']")
	WebElement RelationshipAunty;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkRelationShip_1']")
	WebElement RelationshipBrother;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkRelationShip_2']")
	WebElement RelationshipBrotherDaughter;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkNomineeRelationShip_0']")
	WebElement NomineeRelationshipAunty;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkNomineeRelationShip_1']")
	WebElement NomineeRelationshipBrother;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkNomineeRelationShip_2']")
	WebElement NomineeRelationshipBrotherDaughter;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlPlanCategory']")
	WebElement ProductType;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbIsDeletionApplicable_0']")
	WebElement IsEndorsementMemberDeletionApplicableYes;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbIsDeletionApplicable_1']")
	WebElement IsEndorsementMemberDeletionApplicableNo;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbIsSurrenderApplicable_0']")
	WebElement IsSurrenderApplicableYes;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbIsSurrenderApplicable_1']")
	WebElement IsSurrenderApplicableNo;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbIsMPvariantEditable_0']")
	WebElement IsMasterPolicyRenewalVariantEditableyes;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbIsMPvariantEditable_1']")
	WebElement IsMasterPolicyRenewalVariantEditableNo;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtnIsMYRT_0']")
	WebElement IsMultiYearrenewableTermYes;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtnIsMYRT_1']")
	WebElement IsMultiYearrenewableTermNo;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtnpremiumterm_0']")
	WebElement PremiumPaymentTermShortterm;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtnpremiumterm_1']")
	WebElement PremiumPaymentTermLongterm;

	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[@id='page_content_wrapper']/div[@id='ContentPlaceHolder1_uplHeader']/div[@id='ContentPlaceHolder1_twovaluecolumn']/div[contains(@class,'section-tb form_common menuIdentity')]/div[contains(@class,'user-bg-demo-1 user-bgimage-3 add_new_user')]/fieldset/div[contains(@class,'faq-row')]/div[contains(@class,'faq-ans active table-top')]/div[contains(@class,'add_user')]/div[@id='ContentPlaceHolder1_divAgeProofDocs']"
			+ "/div[contains(@class,'add_user')]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement AgeFrom;

	@FindBy(xpath = "//input[contains(@role,'textbox')]")
	WebElement Frominput;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlAgeTo-container']")
	WebElement AgeTo;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstAgeProof_0']")
	WebElement BankersCertificatewithPhotograph;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstAgeProof_1']")
	WebElement PANCard;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstAgeProof_2']")
	WebElement DrivingLicense;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnAgeProofDocumentAdd']")
	WebElement AddDocument;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlCoverage-container']")
	WebElement DropdownBenefitRiders;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkIsBaseCoverage']")
	WebElement IsBaseDeathBenefit;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkIsSelectable']")
	WebElement IsAdditionalRiderCover;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkIsInBuild']")
	WebElement IsInBuilt;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkIsStampDuty']")
	WebElement IsStampDutyApplicable;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWaitingforClaimPeriod']")
	WebElement WaitingforClaimPeriod;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAccidentPeriod']")
	WebElement AccidentPeriodReport;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSurvivalPeriod']")
	WebElement SurvivalPeriod;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPermanencePeriod']")
	WebElement PermanencePeriod;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDeathVerificationPeriod']")
	WebElement DeathVerificationPeriod;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtStampDutyAmount']")
	WebElement StampDutyRate;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEffectFromDate']")
	WebElement EffectFromDate;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEffectToDate']")
	WebElement EffectToDate;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnCoverageAdd']")
	WebElement AddBenefitRiders;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chklstPlanTaxStructure_0']")
	WebElement GoodsandServiceTax;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSave']")
	WebElement SaveButton;

	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkIsSinglePay']")
	WebElement SinglePay;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkIsRegularPay']")
	WebElement RegularPay;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkIsLimitedPay']")
	WebElement LimitedPay;

	public VariantPage() {
		PageFactory.initElements(driver, this);
	}

	public void AddVariant(String product, String variant, String code, String uin, String uineffectdate,
			String varstrdate, String varendate, String varminage, String varmaxage, String undminage, String undmaxage,
			String varminterm, String varmaxterm, String minsumass, String maxsumass, String freelkup, String frequency,
			String ridefac, String eligforln, String waitperloan, String winpernb, String winperendor,
			String underappli, String waitperclm, String producttype, String endomemdelapp, String surrapp,
			String masrenvaredit, String mulyrrenterm, String prepayterm, String agefrm, String ageto,
			String gpsbenifit,String stumprate,String Waitclmper,String accperrep,String surper,String perper,String deaverper,String efffrmdate,String efftodate) throws Throwable {
		Thread.sleep(2000);
		dropdown(Product, product);
		// wait.until(ExpectedConditions.elementToBeClickable(Variant));
		Thread.sleep(2000);
		Variant.sendKeys(variant, Keys.ENTER);
		Thread.sleep(2000);
		Code.sendKeys(code);
		UIN.sendKeys(uin);
		UINEffectiveDate.sendKeys(uineffectdate, Keys.ENTER);	
		VariantStartDate.sendKeys(varstrdate, Keys.ENTER);
		VariantEndDate.sendKeys(varendate, Keys.ENTER);
		VariantMinEntryAge.sendKeys(varminage);
		VariantMaxEntryAge.sendKeys(varmaxage);
		UnderwritingMinimumAge.sendKeys(undminage);
		UnderwitingMaximumAge.sendKeys(undmaxage);
		VariantMinimumTerm.sendKeys(varminterm);
		VariantMaximumTerm.sendKeys(varmaxterm);
		MinimumSumAssured.sendKeys(minsumass);
		MaximumSumAssured.sendKeys(maxsumass);
		Freelookup.sendKeys(freelkup);
		if (frequency.equals("yes")) {
			frequencyAnnual.click();
			frequencyQuarterly.click();
			frequencySemianuual.click();
			FrequencyMonthly.click();
		} else {
			System.out.println("No Frequency");
		}
		Thread.sleep(2000);
		if (ridefac.equals("yes")) {
			RiderFactorAge.click();
			RiderFactorgender.click();
			RiderFactorSumassured.click();
		} else {
			System.out.println("No RiderFactor");
		}
		Thread.sleep(2000);
		if (eligforln.equals("yes")) {
			EligibleforLoanYes.click();
			WaitingPeriodforLoan.sendKeys(waitperloan);
		} else {
			EligibleforLoanNo.click();
		}
		Thread.sleep(2000);
		WindowPeriodforNewBusiness.sendKeys(winpernb);
		WindowPeriodforEndorsement.sendKeys(winperendor);
		if (underappli.equals("yes")) {
			IsUnderWritingApplicableYes.click();
		} else {
			IsUnderWritingApplicableNo.click();
		}
		Thread.sleep(2000);
		WaitingPeriodforClaim.sendKeys(waitperclm);

		RelationshipAunty.click();
		RelationshipBrother.click();
		RelationshipBrotherDaughter.click();
		NomineeRelationshipAunty.click();
		NomineeRelationshipBrother.click();
		NomineeRelationshipBrotherDaughter.click();
		dropdown(ProductType, producttype);
		Thread.sleep(2000);
		if (endomemdelapp.equals("yes")) {
			IsEndorsementMemberDeletionApplicableYes.click();
		} else {
			IsEndorsementMemberDeletionApplicableNo.click();
		}
		Thread.sleep(2000);
		if (surrapp.equals("yes")) {
			IsSurrenderApplicableYes.click();
		} else {

			IsSurrenderApplicableNo.click();
		}
		Thread.sleep(2000);
		if (masrenvaredit.equals("yes")) {
			IsMasterPolicyRenewalVariantEditableyes.click();
		} else {
			IsMasterPolicyRenewalVariantEditableNo.click();
		}
		Thread.sleep(2000);
		if (mulyrrenterm.equals("yes")) {
			IsMultiYearrenewableTermYes.click();
		} else {
			IsMultiYearrenewableTermNo.click();
		}
		Thread.sleep(2000);
		if (prepayterm.equals("Long Term")) {
			PremiumPaymentTermLongterm.click();
		} else {
			PremiumPaymentTermShortterm.click();
		}
		Thread.sleep(2000);
		if (masrenvaredit.equals("yes")) {
			SinglePay.click();
		} else {
			System.out.println(" Is Multi Year renewable Term is Not Required This Variant");
		}
		AgeFrom.click();
		Frominput.sendKeys(agefrm, Keys.ARROW_DOWN, Keys.ENTER);
		AgeTo.click();
		Frominput.sendKeys(ageto, Keys.ARROW_DOWN, Keys.ENTER);
		PANCard.click();
		AddDocument.click();
		Thread.sleep(2000);
		OkButton.click();
		DropdownBenefitRiders.click();
		Frominput.sendKeys(gpsbenifit, Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(2000);
		if (gpsbenifit.equals("GPS Base Benefit")) {
			IsBaseDeathBenefit.click();
			Thread.sleep(2000);
			IsStampDutyApplicable.click();
			Thread.sleep(2000);
			StampDutyRate.sendKeys(stumprate);
		} else {
            System.out.println("This Is not Base Death");
		}
		Thread.sleep(2000);
		if (gpsbenifit.contains("In-Built")) 
		{
		   IsInBuilt.click();
		}
		else 
		{
			IsAdditionalRiderCover.click();
			IsStampDutyApplicable.click();
			Thread.sleep(2000);
			StampDutyRate.sendKeys(stumprate);
		}
		Thread.sleep(2000);
		WaitingforClaimPeriod.sendKeys(Waitclmper);
		AccidentPeriodReport.sendKeys(accperrep);
		SurvivalPeriod.sendKeys(surper);
		PermanencePeriod.sendKeys(perper);
		DeathVerificationPeriod.sendKeys(deaverper);
		EffectFromDate.sendKeys(efffrmdate, Keys.ENTER);
		EffectToDate.sendKeys(efftodate, Keys.ENTER);
		AddBenefitRiders.click();
		OkButton.click();
		Thread.sleep(2000);
		GoodsandServiceTax.click();
		Thread.sleep(2000);
	//	SaveButton.click();
	//	OkButton.click();
		
	}
}
