import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterWithStream {
    static class Employee {
        private String firstName;
        private String lastName;
        private Integer salary;

        public Employee(String firstName, String lastName, Integer salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        public  Integer getSalary() {
            return this.salary;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("emp1","emp1 last name", 200),
                new Employee("emp2","emp2 last name", 100),
                new Employee("emp3","emp3 last name", 300),
                new Employee("N/A","emp3 last name", 500)
        );
        List<Employee> collect = employees.stream()
                .filter(e ->!( "N/A".equals(e.getFirstName())))
                .filter(e -> !(e.getSalary() > 400))
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
