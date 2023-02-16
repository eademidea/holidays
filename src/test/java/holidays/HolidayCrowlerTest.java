package holidays;

import holidays.csv.CsvMaker;
import holidays.model.MunicipalHoliday;
import holidays.model.NationalHoliday;
import holidays.model.WeekDays;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static holidays.crawler.HolidayCrowler.getMunicipalHolidays;
import static holidays.crawler.HolidayCrowler.getNationalHolidays;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class HolidayCrowlerTest {


    @Before
    public void init() {
    }


    @Test
    public void testNationalHolidays() throws InterruptedException {
        List<NationalHoliday> holidayList = getNationalHolidays();
        for (NationalHoliday holiday : holidayList) {
            System.out.println(holiday.toString());
        }
    }

    @Test
    public void testMunicipalHolidays() throws InterruptedException {
        List<MunicipalHoliday> holidayList = getMunicipalHolidays();
        for (MunicipalHoliday holiday : holidayList) {
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
