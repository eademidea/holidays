package holidays.model;


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

    private String state;

    private String holidayType;


    public String[] getHolidayObject() {
        return new String[]{getState().getLabel(), getUf(), getCounty(), getFormatedDate(), getDayWeek(), getHoliday(), getHolidayType()};
    }


    public MunicipalHoliday(String date, String uf, String county, String holidayType) {
        this.date = date;
        this.uf = uf;
        this.county = county;
        this.holidayType = holidayType;
    }

    public UF getState() {
        return UF.getState(getUf());
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
        var formatedDate = date.split(" ")[0].split("/");
        return formatedDate[2] + "-" + formatedDate[1] + "-" + formatedDate[0];
    }

}
