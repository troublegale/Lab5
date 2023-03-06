import org.apache.commons.codec.binary.StringUtils;
import worker_related.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) {
        Worker worker1 = new Worker(1, "Валентин", new Coordinates(34.9, 85.32),
                java.time.LocalDate.now(), 8000, java.time.LocalDate.now(), Position.DEVELOPER,
                Status.REGULAR, new Organization("Могилевлифтмаш", 450000, 143L,
                new Address("Малочаевская", "67852")));
        System.out.println(worker1);
    }
}
