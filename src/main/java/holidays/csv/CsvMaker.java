package holidays.csv;

import com.opencsv.CSVWriter;
import holidays.crawler.HolidayCrowler;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class CsvMaker {

    public static void toCsv(List<String[]> holidays, String directory) throws IOException {
        Writer writer = Files.newBufferedWriter(Paths.get(directory));
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeAll(holidays);

        csvWriter.flush();
        writer.close();
    }

}
