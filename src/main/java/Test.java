import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        System.out.println(map.replace(1, null, 14));
        System.out.println(map.get(1));
    }
}
