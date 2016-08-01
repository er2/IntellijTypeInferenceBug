import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collectinator<LocalDate, ?, Optional<LocalDate>> lastDate =
                new Collectinator<>(Collectors.maxBy(LocalDate::compareTo));
    }
}
