import edu.hibernatexmpl.Application;
import edu.hibernatexmpl.enums.SeasonType;
import edu.hibernatexmpl.model.Car;
import edu.hibernatexmpl.model.Engine;
import edu.hibernatexmpl.model.Tyre;
import edu.hibernatexmpl.model.Wheel;
import edu.hibernatexmpl.service.CarService;
import edu.hibernatexmpl.service.EngineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)

public class AppTest {
    @Autowired
    private CarService carService;
    @Autowired
    private EngineService engineService;

    @Test
    public void carTest() {

        Engine engine = new Engine("CSD123ZX", 100);
        Tyre tyre = new Tyre(SeasonType.WINTER);
        List<Wheel> wheels = new ArrayList<>();
        IntStream.range(1, 4).forEach(element -> {
            wheels.add(new Wheel("Nokian", 14, tyre));
        });
        Car car = new Car("Dodge", wheels, engine);
        System.out.println(car.toString());
        carService.save(car);
        System.out.println(carService.findById(1).toString());


    }
}
