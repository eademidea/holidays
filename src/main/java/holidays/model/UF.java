package holidays.model;

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
