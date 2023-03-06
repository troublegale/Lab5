import worker_related.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Worker worker1 = new Worker(1, "Валентин", new Coordinates(34.9, 85.32),
                java.time.LocalDate.now(), 16000, java.time.LocalDate.now(), Position.DEVELOPER,
                Status.RECOMMENDED_FOR_PROMOTION,
                new Organization("Могилевлифтмаш", 450000, 143L,
                new Address("Малочаевская ул.", "67852")));
        Worker worker2 = new Worker(2, "Николай", new Coordinates(34.9, 85.32),
                java.time.LocalDate.now(), 8000, java.time.LocalDate.now(), Position.MANAGER_OF_CLEANING,
                Status.RECOMMENDED_FOR_PROMOTION,
                new Organization("Могилевлифтмаш", 450000, 143L,
                new Address("Малочаевская ул.", "67852")));
        Worker worker3 = new Worker(3, "Сергей", new Coordinates(34.9, 85.32),
                java.time.LocalDate.now(), 16000, java.time.LocalDate.now(), Position.HEAD_OF_DEPARTMENT,
                Status.REGULAR,
                new Organization("Могилевлифтмаш", 450000, 143L,
                new Address("Малочаевская ул.", "67852")));
        Map<Integer, Worker> workerMap = new HashMap<>();
        workerMap.put(1, worker1);
        workerMap.put(2, worker2);
        workerMap.put(3, worker3);
        for (Worker w : workerMap.values()) {
            System.out.println(w);
        }
        System.out.println("А самый крутой из них это:");
        System.out.println(Collections.max(new ArrayList<>(workerMap.values())));
    }
}
