package pages.filterpage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.logging.Filter;

import static com.codeborne.selenide.Selenide.$;

public class FiltersInPage {
    SelenideElement filterElements = $(".filter-item--select",1);
    SelenideElement additionalExtras = $(".filter-item--select",3);
    SelenideElement sortByField = $(By.id("mf-select-sortby"));
    SelenideElement extraField = $(".details",1).$("li");
    SelenideElement additionalField = $(".details",2).$("li",2);
    SelenideElement applyFilter = $(By.id("filter-popover-done-button"));
    //rate of guests are from 8,5+ (index - 0) to all (5)
    public void rateGuests(int rate){
        this.filterElements.click();
        $(".range__button",rate).click();
    }

    public void additionalFilter(){
        this.additionalExtras.click();
    }

    public void clickFieldInExtraFilter(){
        this.extraField.click();
        this.additionalField.click();
    }

    public void applyFilter() {
        this.applyFilter.click();
    }
    public void sortBy(int option){
        this.sortByField.selectOption(option);
    }
}
