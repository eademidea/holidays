package holidays.model;


import holidays.crawler.NationalHolidays;
import holidays.extract.*;

import static holidays.extract.All.extractAll;
import static holidays.extract.AllUf.extractAllUf;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public enum TypeExtraction implements ExtractorRule {

    NATIONAL(1, "Feriados Nacionais") {
        @Override
        public void extract(String val) {
            try {
                var holidays = NationalHolidays.getHolidaysList();
                National.extractNational();
            } catch (Exception e) {

            }


        }
    }, ESPECIFIC_UF(2, "UF Específica") {
        @Override
        public void extract(String val) {
            EspecificUf.extractEspecificUf(val);
        }
    }, ALL_UF(3, "Todas UF's") {
        @Override
        public void extract(String val) {
            extractAllUf();
        }
    }, ALL(4, "Todas") {
        @Override
        public void extract(String val) {
            extractAll();
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
