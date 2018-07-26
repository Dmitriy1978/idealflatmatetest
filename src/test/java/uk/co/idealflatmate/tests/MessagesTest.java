package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.MessageHelper;

import static com.codeborne.selenide.Selenide.$;



public class MessagesTest extends TestBase {

   public final MessageHelper messageHelper = new MessageHelper();

    @Test (priority = 1)
    public void readMessageByLandlordWithoutSubscription() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.Landlord101@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        getMessageHelper().chooseMessageTab("Test Message to Landlord without subscription");
        verificationHelper.verifyUpgradeButton();
        authorizationHelper.logoutFromApp();
    }
    @Test (priority = 1)
    public void sendMessageByLandlordWithoutSubscriptionToFM() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.Landlord101@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        homePageHelper.clickFM();
        getMessageHelper().clickUpgradeToMessage();
        verificationHelper.paymentPage();
    }

    @Test (priority = 1)
    public void sendMessageByLandlordWithSubscriptionToFM() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.AgencyPaid@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        homePageHelper.clickFM();
        getMessageHelper().clickFMPageMessage();
        verificationHelper.chatPage();
    }

    @Test (priority = 1)
    public void answerMessageFmWithoutSubscriptionToFM() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen.FHMatching@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        messageHelper.chooseMessageTab("FM can answer to FM");
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("FM can answer to FM");
        verificationHelper.verifyTextMessage("FM can answer to FM");
        authorizationHelper.logoutFromApp();
    }

    @Test (priority = 2)
    public void answerMessageLandlordToPremiumFHWithoutSubscription() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen.Landlord101@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        messageHelper.chooseMessageTab("Landlord Answer to Prem FM");
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Landlord Answer to Prem FM");
        verificationHelper.verifyTextMessage("Landlord Answer to Prem FM");
        authorizationHelper.logoutFromApp();
    }

    @Test (priority = 1)
    public void sendMessagePremiumFmToLandlordWithoutSubscriptionWithListingFromSearch() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen.Premium@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        searchHelper.searchProperty("PO30");
        messageHelper.clickCardMessageLogged();
        //messageHelper.clickPropertyPageMessage();
        verificationHelper.noTextUpgradeToFasterReply();
        verificationHelper.messageGroup("# 0012947 Newport PO30 2DN, UK");
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Landlord Answer to Prem FM");
        verificationHelper.verifyTextMessage("Landlord Answer to Prem FM");
        authorizationHelper.logoutFromApp();
    }
    @Test (priority = 1)
    public void sendMessageFmWithoutSubscriptionToLandlordWithoutSubscriptionWithListingFromListing() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        searchHelper.searchProperty("PO30");
        //messageHelper.clickCardMessageLogged();
        messageHelper.clickPropertyCardPagelogged();
        messageHelper.clickPropertyPageMessage();
        verificationHelper.upgradeToFasterReply();
        verificationHelper.messageGroup("# 0012947 Newport PO30 2DN, UK");
        messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }

    @Test (priority = 1)
    public void sendMessageFmWithoutSubscriptionToLandlordWithoutSubscriptionWithListingFromFMpage() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        searchHelper.searchProperty("PO30");
        //messageHelper.clickCardMessageLogged();
        messageHelper.clickPropertyCardFMnamePagelogged();
        messageHelper.clickFMPageMessage();
        verificationHelper.upgradeToFasterReply();
        verificationHelper.messageGroup("No property");
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }



}
