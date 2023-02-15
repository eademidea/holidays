package holidays.crawler;

import holidays.model.Holiday;

import java.util.List;


/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class HolidayCrowler {

    public static List<Holiday> getNationalHolidays() throws InterruptedException {
        return NationalHolidays.getNationalHolidays();
    }

    public static List<Holiday> getMunicipalHolidays() throws InterruptedException {
        return MunicipalHolidays.getMunicipalHolidays();
    }

}
