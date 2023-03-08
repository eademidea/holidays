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

    NATIONAL(1, "Todos feriados nacionais") {
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
                throw new RuntimeException(e);
            }
        }

        @Override
        public void extract(String uf) {
        }

        @Override
        public void extract(List<String[]> lines) {
        }
    },ALL_UF(1, "Todos feriados municipais") {
        @Override
        public void extract() {
            try {
                var nationalHolidays = MunicipalHolidays.getAllUfHolidays();
                List<String[]> holidays = new ArrayList<>();
                nationalHolidays.forEach(holiday -> {
                    holidays.add(holiday.getHolidayObject());
                });
                toCsv(holidays, "feriados-nacionais.csv");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void extract(String uf) {
        }

        @Override
        public void extract(List<String[]> lines) {
        }
    }
    , UNITY(5, "Por Unidade") {
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
                throw new RuntimeException(e);
            }
        }

        @Override
        public void extract() {
            // Não será necessário a sua implementação até o momento.
        }

        @Override
        public void extract(String uf) {
            // Não será necessário a sua implementação até o momento.
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
