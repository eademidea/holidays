package holidays.crawler;

import holidays.model.MunicipalHoliday;
import holidays.model.NationalHoliday;
import holidays.model.WeekDays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class MunicipalHolidays  {

    private static final String FEBRABAN_URL = "https://feriadosbancarios.febraban.org.br/";

    private static Logger log = Logger.getLogger(MunicipalHolidays.class.getName());

    static WebDriver driver = new ChromeDriver();

    public static String[] getWeekDay(WebElement element) {
        return element.getAttribute("innerText").split("\t");
    }



    public static List<MunicipalHoliday> getMunicipalHolidays() throws InterruptedException {
        List<MunicipalHoliday> holidays = new ArrayList<>();
        driver.get(FEBRABAN_URL.concat("Municipais/Listar"));
        var element = driver.findElement(By.id("Uf"));
        Select select = new Select(element);

        //TO:DO refatorar aqui...
        select.selectByValue("AL");



        new Thread().sleep(1000);
        driver.findElement(By.className("botao")).click();
        List<WebElement> weekDays = driver.findElements(By.tagName("tr"));
        weekDays.forEach(day -> {
            String[] weekDay = getWeekDay(day);
            if (!weekDay[0].equals("Data")) {
                holidays.add(new MunicipalHoliday(weekDay[0], weekDay[1], weekDay[2],weekDay[3]));
            }
        });
        if (holidays.isEmpty()) {
            log.info("Lista de feriados indisponível no momento.");
        }
        driver.close();
        return holidays;
    }


}
