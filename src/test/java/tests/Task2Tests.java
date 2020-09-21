package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task2Tests extends BaseTest {
    public static final String YOUR_STORY_TEST_TEXT = "HABEREhibereHABEREhibereHOP!";
    public static final String NAME_FIELD_TEST_TEXT = "Test user";
    public static final String HOW_TO_SHARE_URL = "https://www.bbc.com/news/10725415";

    @Test
    public void submitCoronavirusStoryWithoutTermsAcceptance()
    {
        getMainPage().clickNewsInMenu();
        getMainPage().waitForElementVisibility(30, getMainPage().signInPopupLocator());
        getMainPage().closeSignInPopup();
        getBasePage().implicitlyWait(5);
        getNewsPage().clickCoronavirusTab();
        getBasePage().implicitlyWait(5);
        getCoronavirusPage().clickYourCoronavirusStoriesTab();
        getBasePage().implicitlyWait(5);
        getHaveYouSayPage().clickHowToShareWithBBC();
        getBasePage().implicitlyWait(5);
        getHowToSharePage().typeToTellUsYourStoryField(YOUR_STORY_TEST_TEXT);
        getHowToSharePage().typeToNameInput(NAME_FIELD_TEST_TEXT);
        getHowToSharePage().checkIAmOver16Checkbox();
        getHowToSharePage().clickSubmitButton();
        assertEquals(getHowToSharePage().getUrl(), HOW_TO_SHARE_URL,
                "Expected result: The same page is displayed. " +
                "Actual result: Another page is displayed after invalid submission. ");
        assertTrue(getHowToSharePage().isCheckboxErrorMessageDisplayed(), "Expected result: Error message is displayed" +
                "Actual result: Error message is not displayed");
    }

    @Test
    public void submitCoronavirusStoryWithNameFieldEmpty()
    {
        getMainPage().clickNewsInMenu();
        getMainPage().waitForElementVisibility(30, getMainPage().signInPopupLocator());
        getMainPage().closeSignInPopup();
        getBasePage().implicitlyWait(5);
        getNewsPage().clickCoronavirusTab();
        getBasePage().implicitlyWait(5);
        getCoronavirusPage().clickYourCoronavirusStoriesTab();
        getBasePage().implicitlyWait(5);
        getHaveYouSayPage().clickHowToShareWithBBC();
        getBasePage().implicitlyWait(5);
        getHowToSharePage().typeToTellUsYourStoryField(YOUR_STORY_TEST_TEXT);
        getHowToSharePage().checkIAmOver16Checkbox();
        getHowToSharePage().checkTermsAgreementCheckbox();
        getHowToSharePage().clickSubmitButton();
        assertEquals(getHowToSharePage().getUrl(), HOW_TO_SHARE_URL,
                "Expected result: The same page is displayed. " +
                        "Actual result: Another page is displayed after invalid submission. ");
        assertTrue(getHowToSharePage().isNameCantBeBlankMessageDisplayed(), "Expected result: Error message is displayed" +
                "Actual result: Error message is not displayed");
    }
    @Test
    public void submitCoronavirusStoryWithStoryFieldEmpty()
    {
        getMainPage().clickNewsInMenu();
        getMainPage().waitForElementVisibility(30, getMainPage().signInPopupLocator());
        getMainPage().closeSignInPopup();
        getBasePage().implicitlyWait(5);
        getNewsPage().clickCoronavirusTab();
        getBasePage().implicitlyWait(5);
        getCoronavirusPage().clickYourCoronavirusStoriesTab();
        getBasePage().implicitlyWait(5);
        getHaveYouSayPage().clickHowToShareWithBBC();
        getBasePage().implicitlyWait(5);
        getHowToSharePage().typeToNameInput(NAME_FIELD_TEST_TEXT);
        getHowToSharePage().checkIAmOver16Checkbox();
        getHowToSharePage().checkTermsAgreementCheckbox();
        getHowToSharePage().clickSubmitButton();
        assertEquals(getHowToSharePage().getUrl(), HOW_TO_SHARE_URL,
                "Expected result: The same page is displayed. " +
                        "Actual result: Another page is displayed after invalid submission. ");
        assertTrue(getHowToSharePage().isStoryCantBeBlankMessageDisplayed(), "Expected result: Error message is displayed" +
                "Actual result: Error message is not displayed");
    }
}
