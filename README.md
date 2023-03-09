# Holidays

Tecnologias usadas:

Java
Maven
jUnit
ChromeDrive

Propósito do software:

Buscar todos feriados, nacionais e municipais do site febraban: https://feriadosbancarios.febraban.org.br/ e gravar em um CSV.

Gerar o "Jar":
maven package

Executar o programa:

java -jar nome_do_arquivo_gerado.jar

Opções de extração do feriado:

Todos os feriados municipais: nesta modalidade você pode extrair todos os feriados de todos municipios da "UF" digitada.

Todos feriados nacionais: nesta modalidade você pode extrair todos os feriados nacionais.

Feriados por unidade: você pode extrair todos feriados nacionais e municipais de uma unidade de negócio.

Exemplo: uma empresa tem duas unidades de negócio em municipios diferentes. Será possível extrair os feriados do municipio da unidade e feriados nacionais.

Observação:
O resultado sempre será um arquivo CSV.
