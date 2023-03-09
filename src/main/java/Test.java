import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(2, 43);
        map.put(3, 300);
        System.out.println(map.remove(5));
    }
}
