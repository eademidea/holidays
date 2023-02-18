package holidays.model;

import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.stripAccents;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public enum UF {

    RONDONIA(11,	"Rondônia",	"RO")
    ,ACRE(12,	"Acre"	,"AC")
    ,AMAZONAS(13,	"Amazonas",	"AM")
    ,RORAIMA(14,	"Roraima",	"RR")
    ,PARA(15,	"Pará",	"PA")
    ,AMAPA(16,	"Amapá",	"AP")
    ,TOCANTINS(17,	"Tocantins",	"TO")
    ,MARANHAO(21,	"Maranhão",	"MA")
    ,PIAUI(22,	"Piauí",	"PI")
    ,CEARA(23,	"Ceará",	"CE")
    ,RIO_GRANDE_NORTE(24,	"Rio Grande do Norte",	"RN")
    ,PARAIBA(25,	"Paraíba",	"PB")
    ,PERNAMBUCO(26,	"Pernambuco",	"PE")
    ,ALAGOAS(27,	"Alagoas",	"AL")
    ,SERGIPE(28,	"Sergipe",	"SE")
    ,BAHIA(29,	"Bahia",	"BA")
    ,MINAS_GERAIS(31,	"Minas Gerais",	"MG")
    ,ESPIRITO_SANTO(32,	"Espírito Santo",	"ES")
    ,RIO_DE_JANEIRO(33,	"Rio de Janeiro",	"RJ")
    ,SAO_PAULO(35,	"São Paulo",	"SP")
    ,PARANA(41,	"Paraná",	"PR")
    ,SANTA_CATARINA(42,	"Paraná",	"SC")
    ,RIO_GRANDE_SUL(43,	"Rio Grande do Sul",	"RS")
    ,MATO_GROSSO_SUL(50,	"Mato Grosso do Sul",	"MS")
    ,MATO_GROSSO(51,	"Mato Grosso",	"MT")
    ,GOIAS(52,	"Goiás",	"GO")
    ,DISTRITO_FEDERAL(53,	"Distrito Federal",	"DF");

    public static String getFormatedUf(String uf) {
        return stripAccents(uf).toUpperCase().trim();
    }

    public static UF getState(String uf) {
        if (uf != null) {
            var ufs= Arrays.asList(UF.values());
            for (UF estado:ufs) {
                if (estado.getSigla().equals(getFormatedUf(uf))) {
                    return estado;
                }
            }
        }
        return null;
    }

    public static boolean ufExists(String uf) {
        if (uf == null) {
            return false;
        }
        var ufs= Arrays.asList(UF.values());
        for (UF estado:ufs) {
            if (estado.getSigla().equals(getFormatedUf(uf))) {
                return true;
            }
        }
        return false;
    }



    UF(Integer codUf, String label, String sigla) {
        this.codUf = codUf;
        this.label = label;
        this.sigla = sigla;
    }

    private Integer codUf;

    private String label;

    private String sigla;

    public Integer getCodUf() {
        return codUf;
    }

    public String getLabel() {
        return label;
    }

    public String getSigla() {
        return sigla;
    }
}
