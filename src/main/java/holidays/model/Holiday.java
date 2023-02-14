package holidays.model;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.2
 */
public class Holiday {

    private String date;

    private String dayWeek;

    private String holiday;

    public Holiday(String date, String dayWeek, String holiday) {
        this.date = date;
        this.dayWeek = dayWeek;
        this.holiday = holiday;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
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
        return new String[]{getDate(), getDayWeek(), getHoliday()};
    }
}
