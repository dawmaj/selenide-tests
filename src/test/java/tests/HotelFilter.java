package tests;

import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import pages.filterpage.*;
import pages.homepage.MainSearch;


import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class HotelFilter {
    @Test
    public void getHotels() {
        MainSearch page = new MainSearch();
        page.browserSetUp();
        page.searchPlace("Zakopane");
        page.getFirstRecomenndedSuggestion();
        page.nextMonth();
        page.getCalendarDay(5,2);
        page.getCalendarDay(5,5);
        page.addToSearch(0);
        page.addToSearch(2);
        page.applySearch();
        page.clickSearchOnPage().rateGuests(0);
        //$(By.className("item__flex-column")).shouldBe(visible);
        //new page

        new FiltersInPage().sortBy(4);
        /* additional filter
        filter.additionalFilter();
        filter.clickFieldInExtraFilter();
        filter.applyFilter(); */

        HotelPage hotel = new HotelPage();
        hotel.getNameofHotelandScreenshot(0);
        hotel.getNameofHotelandScreenshot(1);
        hotel.getNameofHotelandScreenshot(2);
    }
    @After
    public void close(){
        closeWebDriver();
    }
}
