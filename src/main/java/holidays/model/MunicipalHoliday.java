package holidays.model;


import java.time.LocalDate;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class MunicipalHoliday {

    private String date;

    private String uf;

    private String dayWeek;

    private String holiday;

    private String county;

    private String holidayType;


    public String[] getHolidayObject() {
        return new String[]{getFormatedDate(), getDate(), getDayWeek(), getHoliday()};
    }


    public MunicipalHoliday(String date, String uf, String county, String holidayType) {
        this.date = date;
        this.uf = uf;
        this.county = county;
        this.holidayType = holidayType;
    }

    public String getDate() {
        return date;
    }


    public String getDayWeek() {
        return date.split(" ")[1];
    }


    public String getHoliday() {
        return holiday;
    }


    public String getCounty() {
        return county;
    }

    public String getHolidayType() {
        return holidayType;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return "MunicipalHoliday{" +
                "date='" + date + '\'' +
                ", uf='" + uf + '\'' +
                ", dayWeek='" + dayWeek + '\'' +
                ", holiday='" + holiday + '\'' +
                ", county='" + county + '\'' +
                ", holidayType='" + holidayType + '\'' +
                '}';
    }

    public String getFormatedDate() {
        return date.split(" ")[0];
    }

}