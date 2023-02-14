package holidays;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvMaker {

    public void toCsv() throws IOException, InterruptedException {

        var nationalHolidays = HolidayCrowler.getNationalHolidays();

        List<String[]> holidays = new ArrayList<>();

        nationalHolidays.forEach(holiday -> {
            holidays.add(holiday.getHolidayObject());
        });

        Writer writer = Files.newBufferedWriter(Paths.get("feriados-nacionais.csv"));
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeAll(holidays);

        csvWriter.flush();
        writer.close();

    }

}
