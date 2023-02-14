package holidays;

import holidays.model.Holiday;
import holidays.model.WeekDays;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static holidays.HolidayCrowler.getNationalHolidays;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.2
 */
public class HolidayCrowlerTest {


    @Before
    public void init() {
    }


    @Test
    public void doCrawlWithChrome() throws InterruptedException {
        List<Holiday> holidayList = getNationalHolidays();
        for (Holiday holiday : holidayList) {
            System.out.println(holiday.toString());
        }
    }


    @Test
    public void test() {
        System.out.println(WeekDays.dayExists("teste"));
        System.out.println(WeekDays.dayExists("terça-feira"));
    }

    @Test
    public void teste2() throws IOException, InterruptedException {
        new CsvMaker().toCsv();
    }

}
