package holidays.crawler;

import holidays.model.MunicipalHoliday;
import holidays.model.NationalHoliday;

import java.util.List;


/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class HolidayCrowler {

    public static List<NationalHoliday> getNationalHolidays() throws InterruptedException {
        return NationalHolidays.getNationalHolidays();
    }

    public static List<MunicipalHoliday> getMunicipalHolidays() throws InterruptedException {
        return MunicipalHolidays.getMunicipalHolidays();
    }

}
