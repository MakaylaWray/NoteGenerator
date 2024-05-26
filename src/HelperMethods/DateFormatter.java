package HelperMethods;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DateFormatter {
    public static String formattedDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
