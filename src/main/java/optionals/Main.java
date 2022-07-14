package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null).orElseGet(()->"default value");
        System.out.println(value);
        /*
        Supplier<IllegalArgumentException> exception = ()-> new IllegalArgumentException();
        Optional.ofNullable(null).orElseThrow(exception);
        */
        Optional.ofNullable("konuralp.erturk01@gmail.com")
                .ifPresentOrElse(
                        email-> System.out.println("Sending email to "+ email),
                        ()-> System.out.println("Email not found"));
    }
}
