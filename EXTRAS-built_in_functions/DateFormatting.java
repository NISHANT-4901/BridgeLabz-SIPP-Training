import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();

        // Format 1: dd/MM/yyyy
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Format 2: yyyy-MM-dd
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Format 3: EEE, MMM dd, yyyy
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        System.out.println("Format 1: " + currentDate.format(format1));
        System.out.println("Format 2: " + currentDate.format(format2));
        System.out.println("Format 3: " + currentDate.format(format3));
    }
}
