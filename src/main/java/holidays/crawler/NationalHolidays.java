package holidays.crawler;

import holidays.model.Holiday;
import holidays.model.WeekDays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class NationalHolidays extends HolidaysUtils {

    private static Logger log = Logger.getLogger(HolidayCrowler.class.getName());

    public static List<Holiday> getNationalHolidays() throws InterruptedException {
        List<Holiday> holidays = new ArrayList<>();
        driver.get(FEBRABAN_URL);
        new Thread().sleep(1000);
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
