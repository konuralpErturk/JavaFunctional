package combinatorpattern;

import java.time.LocalDate;
import java.time.Month;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("konuralp",
                "konuralp.erturk01@gmail.com",
                "+905555555555",
                LocalDate.of(1994, Month.FEBRUARY,17));

        System.out.println(new CustomerValidatorService().isValid(customer));

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCEES)
            throw new IllegalStateException(result.name());

    }
}
