package holidays.model.extraction;


import holidays.crawler.MunicipalHolidays;
import holidays.crawler.NationalHolidays;

import java.util.ArrayList;
import java.util.List;

import static holidays.csv.CsvMaker.toCsv;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public enum TypeExtraction implements ExtractorRule {

    NATIONAL(1, "Feriados Nacionais") {
        @Override
        public void extract() {
            try {
                var nationalHolidays = NationalHolidays.getNationalHolidays();
                List<String[]> holidays = new ArrayList<>();
                nationalHolidays.forEach(holiday -> {
                    holidays.add(holiday.getHolidayObject());
                });
                toCsv(holidays, "feriados-nacionais.csv");
            } catch (Exception e) {

            }
        }

        @Override
        public void extract(String uf) {

        }

        @Override
        public void extract(List<String[]> lines) {

        }
    }, ESPECIFIC_UF(2, "UF Específica") {
        @Override
        public void extract() {

        }

        @Override
        public void extract(String uf) {

        }

        @Override
        public void extract(List<String[]> lines) {
            try {
                var municipalHolidays = MunicipalHolidays.getMunicipalHolidays(lines);
                List<String[]> holidays = new ArrayList<>();
                municipalHolidays.forEach(holiday -> {
                    holidays.add(holiday.getHolidayObject());
                });
                toCsv(holidays, "estado-holidays.csv");
            } catch (Exception e) {

            }
        }
    }, ALL_UF(3, "Todas UF's") {
        @Override
        public void extract() {
            try {
                var nationalHolidays = NationalHolidays.getNationalHolidays();
                List<String[]> holidays = new ArrayList<>();
                nationalHolidays.forEach(holiday -> {
                    holidays.add(holiday.getHolidayObject());
                });
                toCsv(holidays, "feriados-nacionais.csv");
            } catch (Exception e) {

            }
        }

        @Override
        public void extract(String uf) {
            
        }

        @Override
        public void extract(List<String[]> lines) {

        }
    }, UNITY(5, "Por Unidade") {
        @Override
        public void extract() {

        }

        @Override
        public void extract(String uf) {

        }

        @Override
        public void extract(List<String[]> lines) {
            try {
                var municipalHolidays = MunicipalHolidays.getMunicipalHolidays(lines);
                List<String[]> holidays = new ArrayList<>();
                municipalHolidays.forEach(holiday -> {
                    holidays.add(holiday.getHolidayObject());
                });
                toCsv(holidays, "municipal-holidays.csv");
            } catch (Exception e) {

            }
        }
    };

    public String getLabel() {
        return label;
    }


    private String label;

    private Integer option;

    TypeExtraction(Integer option, String label) {
        this.label = label;
        this.option = option;
    }

    public Integer getOption() {
        return option;
    }
}
