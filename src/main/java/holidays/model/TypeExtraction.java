package holidays.model;


/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public enum TypeExtraction {

    NATIONAL("Feriados Nacionais"), ESPECIFIC_UF("UF Específica"), ALL_UF("Todas UF's"), ALL("Todas");

    public String getLabel() {
        return label;
    }

    private String label;

    TypeExtraction(String label) {
        this.label = label;
    }
}
