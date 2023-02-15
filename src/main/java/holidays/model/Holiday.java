package holidays.model;


import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

import static holidays.model.Mounths.getMounthNumber;
import static org.apache.commons.lang3.StringUtils.stripAccents;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class Holiday {

    private String date;

    private String dayWeek;

    private String holiday;

    private String month;

    public Holiday(String date, String dayWeek, String holiday) {
        this.date = date;
        this.dayWeek = dayWeek;
        this.holiday = holiday;
    }

    public String getDate() {
        return date;
    }


    public String getDayWeek() {
        return dayWeek;
    }


    public String getHoliday() {
        return holiday;
    }


    @Override
    public String toString() {
        return "Holiday{" +
                "date=" + date +
                ", dayWeek='" + dayWeek + '\'' +
                ", holiday='" + holiday + '\'' +
                '}';
    }

    public String[] getHolidayObject() {
        return new String[]{getFormatedDate(), getDate(), getDayWeek(), getHoliday()};
    }

    public String getMonth() {
        return date != null ? getMounthNumber(stripAccents(date.split(" ")[2]).trim()).toString() : "inexistente";
    }

    public String getFormatedDate() {
        return LocalDate.now().getYear() + "-" + getMonth() + "-" + date.split(" ")[0];
    }
}
