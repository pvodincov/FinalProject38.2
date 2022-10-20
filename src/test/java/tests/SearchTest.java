package tests;

import io.appium.java_client.*;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchTest extends CoreTestCase {

    //test is ok
    @Test
    public void testSearch() {

        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_container",
                "Cannot find Search Wikipedia init search input"
        );
        searchInput.click();

        searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Cannot find search input"
        );

        searchInput.sendKeys("wfewfewfwegweg");

        final String actualResult = String.valueOf(mainPO.waitForElementPresent(
                "xpath://*[contains(@text,'No results found')]",
                "Cannot find Search results",
                20

        ));

    }

    /*@Test
    public void FailLogin(){
        String pas = "test";
        MainPageObject mainPO = new MainPageObject(this.driver);
    //найти три точки
        WebElement ThreePoint = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/menu_overflow_button",
                "Cannot find search element"
        );
        ThreePoint.click();

        //поиск поля loginInWik button in menu three points
        WebElement loginInWik =  mainPO.waitForElementPresent(
                "id:org.wikipedia:id/explore_overflow_account_name",
                "cannot find login string"
        );
        loginInWik.click();

        //поиск поля username
        WebElement UserName = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/login_username_text",
                "cannot find UserName element"
        );

        UserName.click();
        UserName.sendKeys("test");


        //поиск поля password

        WebElement password = mainPO.waitForElementPresent(
                "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/TextInputLayout[2]",
                "cannot find Password element"
        );

        WebElement passwordToVisible = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/text_input_password_toggle",
                "cannot find passwordToVisible"
        );
        passwordToVisible.click();

        password.click();
        System.out.println("kak");
        password.sendKeys(pas);
        System.out.println("tit");





        WebElement loginButton = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/login_button",
                "cannot find login button"
        );

        loginButton.click();
    }*/


    //test is ok
    @Test
    public void testLoginPage() {
        String PageName = "Log in to Wikipedia";

        MainPageObject mainPO = new MainPageObject(this.driver);
        //найти три точки
        WebElement ThreePoint = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/menu_overflow_button",
                "Cannot find search element"
        );
        ThreePoint.click();

        WebElement loginInWik = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/explore_overflow_account_name",
                "cannot find login string"
        );
        loginInWik.click();

        WebElement LogInToWik = mainPO.waitForElementPresent(
                "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView",
                "connot find element"
        );
        String PageLogo = LogInToWik.getText();
        assertEquals(PageLogo,PageName);



    }

    //test is ok
    @Test
    public void CraeteAc() {
        String PageName = "Create an account";

        MainPageObject mainPO = new MainPageObject(this.driver);
        //найти три точки
        WebElement ThreePoint = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/menu_overflow_button",
                "Cannot find search element"
        );
        ThreePoint.click();

        WebElement loginInWik = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/explore_overflow_account_name",
                "cannot find login string"
        );
        loginInWik.click();


        WebElement CreateLog = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/login_create_account_link",
                "connot find element CrateUrl"
        );
        CreateLog.click();

        WebElement LogoPage = mainPO.waitForElementPresent(
                "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView",
                "cannot find element logoPage"
        );
        String LogoTextPage = LogoPage.getText();
        assertEquals(LogoTextPage,PageName);

    }

        //this test is ok
    @Test
    public void background () {
            MainPageObject mainPO = new MainPageObject(this.driver);

            driver.runAppInBackground(Duration.ofSeconds(10));
        }
        //this test is ok

        //test is ok
    @Test
    public void Settings(){
            String exampleLogoSettingsText = "Settings";
            MainPageObject mainPO = new MainPageObject(this.driver);

            WebElement ThreePoint = mainPO.waitForElementPresent(
                    "id:org.wikipedia:id/menu_overflow_button",
                    "Cannot find search element"
            );
            ThreePoint.click();

            WebElement Settings = mainPO.waitForElementPresent(
                    "id:org.wikipedia:id/explore_overflow_settings",
                    "connot find settings element",
                    10
            );
            Settings.click();

            WebElement LogoSettings = mainPO.waitForElementPresent(
                    "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView",
                    "cannot find logoSettings element",
                    10
            );
            String equal = LogoSettings.getText();
            assertEquals(equal,exampleLogoSettingsText);

        }

    //test is ok
    @Test
    public void SettingsEditLanguage (){
        String LanguageSet = "DE";
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement ThreePoint = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/menu_overflow_button",
                "Cannot find search element"
        );
        ThreePoint.click();

        WebElement Settings = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/explore_overflow_settings",
                "connot find settings element"
        );
        Settings.click();

        WebElement EditLanguage = mainPO.waitForElementPresent(
                "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout",
                "cannot find WikipediaLanguage element"
        );
        EditLanguage.click();

        WebElement SearchLanguage = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/preference_languages_filter",
                "cannot find Search element"
        );
        SearchLanguage.click();
        SearchLanguage.sendKeys("deu");

        WebElement LanguageDeu = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/language_subtitle",
                "cannot find DE language",
                10
        );
        LanguageDeu.click();


        WebElement backKey = mainPO.waitForElementPresent(
                "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]",
                "cannot find backKey"
        );
        backKey.click();

        WebElement searchInput = mainPO.waitForElementPresent(
                "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]",
                "Cannot find Search Wikipedia init search input"
        );
        searchInput.click();


        WebElement langSearch = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_lang_button",
                "cannot find langSearch element"
        );

        String a = langSearch.getText();
        assertEquals(a,LanguageSet);

    }

    //test is ok
    @Test
    public void SettingsAbout(){
        String SettingsAbout = "About";
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement ThreePoint = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/menu_overflow_button",
                "Cannot find search element"
        );
        ThreePoint.click();

        WebElement Settings = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/explore_overflow_settings",
                "connot find settings element"
        );
        Settings.click();

        WebElement About = mainPO.waitForElementPresent(
        "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.RelativeLayout/android.widget.TextView",
                "cannot find About element"
        );

        About.click();

        WebElement AboutTitel = mainPO.waitForElementPresent(
                "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView",
                "not found AboutTitel",
                10
        );

        String a = AboutTitel.getText();

        assertEquals(a,SettingsAbout);
    }



    /*@Test
    public void hidenBlock(){
        MainPageObject mainPO = new MainPageObject(this.driver);
        WebElement dotThree= mainPO.waitForElementPresent(
                "xpath:(//android.widget.ImageView[@content-desc=\"More options\"])[1]",
                "cannot find threeDot"
        );
        dotThree.click();

        WebElement blockHid = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/title",
                "cannot find hideBlock"
        );
        blockHid.click();

        WebElement News = mainPO.waitForElementPresent(
                "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView",
                "cannot find news block"
        );
    }*/

    //test is ok
    @Test
    public void MyListNull(){

        String MyListNull = "No reading lists yet";
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement MyList = mainPO. waitForElementPresent(
                "xpath://android.widget.FrameLayout[@content-desc=\"My lists\"]/android.widget.ImageView",
                "cannot find element MyList"
        );

        MyList.click();

        WebElement NoReading = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/empty_title",
                "cannot find Text No reading list yet"

        );
        String textMyListNull = NoReading.getText();
        assertEquals(textMyListNull,MyListNull);

    }


    //test is ok
    @Test
    public void historyNull(){
        String EqualsText = "No recently viewed articles";
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement history = mainPO.waitForElementPresent(
                "xpath://android.widget.FrameLayout[@content-desc=\"History\"]/android.widget.ImageView",
                "cannot find historyButton",
                10
        );

        history.click();

        WebElement textHistoryNull = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/history_empty_title",
                "cannot find textHisthory"
        );

        String TextDialog = textHistoryNull.getText();
        assertEquals(TextDialog,EqualsText);

    }
        //test is ok
    @Test
    public void navigate(){
        String equalString = "©  OpenStreetMap contributors";
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement navigateButton = mainPO.waitForElementPresent(
                "xpath://android.widget.FrameLayout[@content-desc=\"Nearby\"]",
                "cannot find button navigate"
        );

        navigateButton.click();

        WebElement licen = mainPO.waitForElementPresent(
            "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.TextView",
                "cannot find license url",
                15
        );
        String licenseText = licen.getText();
        System.out.println(licenseText);
        assertEquals(licenseText,equalString);
    }
    /*@Test
    public void checkVoicePermissionFirstClick() {
        driver.resetApp();
        MainPageObject mainPO = new MainPageObject(this.driver);


        WebElement microphone = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/voice_search_button",
                "connot find element microphone"
        );
        microphone.click();


    }*/
    /*@Test
    public void checkGoogleAudioSearch() {
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement microphone = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/voice_search_button",
                "connot find element microphone"
        );
        microphone.click();

        WebElement AudioSearchDialog = mainPO.waitForElementPresent(
                "id://com.google.android.googlequicksearchbox:id/transcription_intent_api_text",
                "connot find dialog audioSearchDialog"
        );
        String textDialog = driver.getPageSource();

    }*/

    }


