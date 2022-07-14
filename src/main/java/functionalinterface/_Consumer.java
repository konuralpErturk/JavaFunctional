package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer konuralp = new Customer("Konuralp","+90555 555 55 55");
        //Normal Java
        greetCustomer(konuralp);

        //Consumer Functional Interface
        greetConsumer.accept(konuralp);

        greetConsumer2.accept(konuralp,false);

        greetConsumer2.accept(konuralp,true);
    }

    static Consumer<Customer> greetConsumer = customer -> System.out.println("Hello "+customer.name+ ", thanks for registering phone number "+customer.customerPhoneNumber);

    static BiConsumer<Customer,Boolean> greetConsumer2 =
            (customer,showNumber)
                    -> System.out.println("Hello "+customer.name+ ", thanks for registering phone number " + (showNumber ? customer.customerPhoneNumber : "**********"));

    static void greetCustomer(Customer customer){
        System.out.println("Hello "+customer.name+ ", thanks for registering phone number "+customer.customerPhoneNumber);
    }

    static class Customer{
        private final String name;
        private final String customerPhoneNumber;

        public Customer(String name, String customerPhoneNumber) {
            this.name = name;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customer='" + name + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }
}
