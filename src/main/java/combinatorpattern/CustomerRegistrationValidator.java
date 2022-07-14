package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult>
{
    static CustomerRegistrationValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.SUCCEES :
                ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator  isPhoneNumberValid(){
        return customer -> customer.getPhoneNumber().contains("+9") ?
                ValidationResult.SUCCEES :
                ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 1 ?
                ValidationResult.SUCCEES :
                ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCEES) ? other.apply(customer) : result;
        };
    }
}
enum ValidationResult{
    SUCCEES,
    PHONE_NUMBER_NOT_VALID,
    EMAIL_NOT_VALID,
    IS_NOT_AN_ADULT
}
