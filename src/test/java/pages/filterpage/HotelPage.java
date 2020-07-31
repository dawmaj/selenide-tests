package pages.filterpage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;

public class HotelPage extends FiltersInPage{
    public HotelPage(){
        super();
    }
    public void getNameofHotelandScreenshot(int index){
        $(".name__copytext",index).click();
        screenshot("Hotel_" + (index+1));
        System.out.println($(".name__copytext", index).getText());
    }
}
