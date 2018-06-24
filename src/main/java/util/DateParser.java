package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

public class DateParser {
    public static Optional<LocalDate> parseDate(String date) {
        if(Objects.nonNull(date)) {
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
            return Optional.of(localDate);
        }
        return Optional.empty();
    }
}
