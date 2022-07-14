package imperative;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Konur",Gender.MALE),
                new Person("Alp",Gender.MALE),
                new Person("Konuralp",Gender.MALE),
                new Person("Derya",Gender.FEMALE),
                new Person("Deniz",Gender.FEMALE)
        );

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        people.stream()
              .filter(personPredicate)
              .forEach(System.out::println);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){

            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender
    {
        MALE,FEMALE
    }
}
