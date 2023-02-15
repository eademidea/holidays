package holidays.model;

import static java.util.Arrays.asList;


/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public enum WeekDays {

    MONDAY("segunda-feira")
    ,TUESDAY("terça-feira")
    ,WEDNESDAY("quarta-feira")
    ,THURSDAY("quinta-feira")
    ,FRIDAY("sexta-feira")
    ,SATURDAY("sábado")
    ,SUNDAY("domingo");

    public static Boolean dayExists(String desc) {
        boolean exists = false;
        for (WeekDays day: asList(values())) {
            if (day.getLabel().equals(desc)) {
                exists = true;
            }
        }
        return exists;
    }

    WeekDays(String label) {
        this.label = label;
    }

    private String label;

    public String getLabel() {
        return label;
    }


}
