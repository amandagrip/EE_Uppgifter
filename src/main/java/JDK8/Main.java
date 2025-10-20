package JDK8;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");//.of introducerades senare och fungerar inte i java8

        int day = 3;
        String result = switch (day) { //fungerar endast i java14+
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Unknown";
        };

        System.out.println(result);
    }
}

