package holidays.crawler;

import holidays.model.NationalHoliday;
import holidays.model.WeekDays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class NationalHolidays {


    private static final String FEBRABAN_URL = "https://feriadosbancarios.febraban.org.br/";

    private static Logger log = Logger.getLogger(NationalHolidays.class.getName());

    static WebDriver driver = new ChromeDriver();

    public static String[] getWeekDay(WebElement element) {
        return element.getAttribute("innerText").split("\t");
    }

    public static List<NationalHoliday> getNationalHolidays() throws InterruptedException {
        List<NationalHoliday> holidays = new ArrayList<>();
        driver.get(FEBRABAN_URL);
        new Thread().sleep(1000);
        List<WebElement> weekDays = driver.findElements(By.tagName("tr"));
        weekDays.forEach(day -> {
            String[] weekDay = getWeekDay(day);
            if (WeekDays.dayExists(weekDay[1])) {
                holidays.add(new NationalHoliday(weekDay[0], weekDay[1], weekDay[2]));
            }
        });
        if (holidays.isEmpty()) {
            log.info("Lista de feriados indisponível no momento.");
        }
        driver.close();
        return holidays;
    }

}
