package JDK21;

public class Main {
    public static void main(String[] args) {
        RecordClass recordClass = new RecordClass("Matte");
        //finns ej setters då en record är final

        System.out.println(recordClass.name());

        int day = 2;
        String dayName = switch (day) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            default -> "Unknown";
        };
        System.out.println(dayName);
    }
}
