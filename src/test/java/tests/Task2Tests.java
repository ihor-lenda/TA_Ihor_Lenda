package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task2Tests extends BaseTest {
    public static final String YOUR_STORY_TEST_TEXT = "HABEREhibereHABEREhibereHOP!";
    public static final String NAME_FIELD_TEST_TEXT = "Test user";
    public static final String HOW_TO_SHARE_URL = "https://www.bbc.com/news/10725415";
    Dictionary<String, String> FIELD_VALUES = new Hashtable<String, String>();


    @Test
    public void submitCoronavirusStoryWithoutTermsAcceptance() {
        FIELD_VALUES.put("Tell us your story. ", YOUR_STORY_TEST_TEXT);
        FIELD_VALUES.put("Name", NAME_FIELD_TEST_TEXT);
        String URL = getMainPage().clickNewsInMenu()
                .closeSignInPopup()
                .clickCoronavirusTab()
                .clickYourCoronavirusStoriesTab()
                .clickHowToShareWithBBC()
                .typeToTellUsYourStoryField(YOUR_STORY_TEST_TEXT)
                .typeToNameInput(NAME_FIELD_TEST_TEXT)
                .checkIAmOver16Checkbox()
                .clickSubmitButton()
                .getUrl();
        assertEquals(URL, HOW_TO_SHARE_URL,
                "Expected result: The same page is displayed. " +
                        "Actual result: Another page is displayed after invalid submission. ");
        assertTrue(getHowToSharePage().isCheckboxErrorMessageDisplayed(), "Expected result: Error message is displayed" +
                "Actual result: Error message is not displayed");
    }

    @Test
    public void submitCoronavirusStoryWithNameFieldEmpty() {
        String URL = getMainPage().clickNewsInMenu()
                .closeSignInPopup()
                .clickCoronavirusTab()
                .clickYourCoronavirusStoriesTab()
                .clickHowToShareWithBBC()
                .typeToTellUsYourStoryField(YOUR_STORY_TEST_TEXT)
                .checkIAmOver16Checkbox()
                .checkTermsAgreementCheckbox()
                .clickSubmitButton()
                .getUrl();
        assertEquals(URL, HOW_TO_SHARE_URL,
                "Expected result: The same page is displayed. " +
                        "Actual result: Another page is displayed after invalid submission. ");
        assertTrue(getHowToSharePage().isNameCantBeBlankMessageDisplayed(), "Expected result: Error message is displayed" +
                "Actual result: Error message is not displayed");
    }

    @Test
    public void submitCoronavirusStoryWithStoryFieldEmpty() {
        String URL = getMainPage().clickNewsInMenu()
                .closeSignInPopup()
                .clickCoronavirusTab()
                .clickYourCoronavirusStoriesTab()
                .clickHowToShareWithBBC()
                .typeToTellUsYourStoryField(YOUR_STORY_TEST_TEXT)
                .checkIAmOver16Checkbox()
                .checkTermsAgreementCheckbox()
                .clickSubmitButton()
                .getUrl();
        assertEquals(URL, HOW_TO_SHARE_URL,
                "Expected result: The same page is displayed. " +
                        "Actual result: Another page is displayed after invalid submission. ");
        assertTrue(getHowToSharePage().isStoryCantBeBlankMessageDisplayed(), "Expected result: Error message is displayed" +
                "Actual result: Error message is not displayed");
    }
}
