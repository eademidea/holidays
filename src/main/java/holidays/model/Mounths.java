package holidays.model;

import java.util.Arrays;

public enum Mounths {
    JANEIRO(1, "janeiro")
    ,FEVEREIRO(2, "fevereiro")
    ,MARCO(3, "marco")
    ,ABRIL(4, "abril")
    ,MAIO(5, "maio")
    ,JUNHO(6, "junho")
    ,JULHO(7, "julho")
    ,AGOSTO(8, "agosto")
    ,SETEMBRO(9, "setembro")
    ,OUTUBRO(10, "outubro")
    ,NOVEMBRO(11, "novembro")
    ,DEZEMBRO(12, "dezembro");

    private String label;
    private Integer mounthNumber;

    Mounths(Integer mounthNumber,String label) {
        this.label = label;
        this.mounthNumber = mounthNumber;
    }

    public static Integer getMounthNumber(String mounthLabel) {
        for (Mounths value: Arrays.asList(Mounths.values())) {
            if (value.getLabel().equals(mounthLabel)) {
                return value.mounthNumber;
            }
        }
        return 0;
    }

    public String getLabel() {
        return label;
    }

    public Integer getMounthNumber() {
        return mounthNumber;
    }
}
