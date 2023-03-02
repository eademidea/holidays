package holidays.model.extraction;

import java.util.List;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public interface ExtractorRule {

    public void extract();

    public void extract(String uf);

    public void extract(List<String[]> lines);


}
