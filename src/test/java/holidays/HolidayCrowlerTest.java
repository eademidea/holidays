package holidays;

import holidays.model.WeekDays;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 */
public class HolidayCrowlerTest {


    @Before
    public void init() {
    }


    @Test
    public void test() {
        System.out.println(WeekDays.dayExists("teste"));
        System.out.println(WeekDays.dayExists("terça-feira"));
    }


}
