package pages.homepage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.filterpage.FiltersInPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.*;

public class MainSearch {
    SelenideElement searchField = $(By.id("querytext"));
    SelenideElement suggestionInfo = $(".ssg-suggestion__info");
    SelenideElement firstSuggestion = $(".ssg-suggest").$("li").$(".ssg-suggestion__info",0);
    SelenideElement applySearch = $(By.className("btn--apply-config"));
    SelenideElement nextMonthButton = $(".cal-btn-next");
    SelenideElement searchButton = $(By.className("search-button"));

    public void browserSetUp() {
        startMaximized = true;
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\ChromeDriver\\chromedriver.exe");
        System.setProperty("selenide.browser","Chrome");
        open("https://www.trivago.pl/");
    }

    public void searchPlace(String place) {
        this.searchField.val(place);
        this.suggestionInfo.should(Condition.visible);
    }

    public void getFirstRecomenndedSuggestion() {
        this.firstSuggestion.click();
    }

    public void nextMonth() {
        this.nextMonthButton.click();
    }
    public void getCalendarDay(int week, int day) {
        $("tr",week).$(".cal-day",day).click();
    }

    public void addToSearch(int selector) {
        $(".room-filters",selector).$(".circle-btn--plus").click();
    }

    public void applySearch(){
        this.applySearch.click();
    }

    public FiltersInPage clickSearchOnPage(){
        this.searchButton.click();
        return new FiltersInPage();
    }
}
