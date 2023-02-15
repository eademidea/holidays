package holidays.crawler;

import holidays.model.Holiday;
import holidays.model.WeekDays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MunicipalHolidays extends HolidaysUtils {

    private static Logger log = Logger.getLogger(HolidayCrowler.class.getName());
    public static List<Holiday> getMunicipalHolidays() throws InterruptedException {
        List<Holiday> holidays = new ArrayList<>();
        driver.get(FEBRABAN_URL.concat("Municipais/Listar"));
        var element = driver.findElement(By.id("Uf"));
        Select select = new Select(element);
        select.selectByValue("AL");
        new Thread().sleep(1000);
        driver.findElement(By.className("botao")).click();
        List<WebElement> weekDays = driver.findElements(By.tagName("tr"));
        weekDays.forEach(day -> {
            String[] weekDay = getWeekDay(day);
            if (WeekDays.dayExists(weekDay[1])) {
                holidays.add(new Holiday(weekDay[0], weekDay[1], weekDay[2]));
            }
        });
        if (holidays.isEmpty()) {
            log.info("Lista de feriados indisponível no momento.");
        }
        driver.close();
        return holidays;
    }


}
