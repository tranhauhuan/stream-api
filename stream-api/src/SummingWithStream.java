import java.util.List;
import java.util.stream.IntStream;

public class SummingWithStream {
    static class Employee {
        private String firstName;
        private String lastName;
        private Integer salary;

        public Employee(String firstName, String lastName,Integer salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }

        public Integer getSalary() {
            return this.salary * 2;
        }
    }
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("emp1","emp1 last name", 100),
                new Employee("emp2","emp2 last name", 200),
                new Employee("emp3","emp3 last name", 300)
        );
        IntStream intStream = employees.stream()
                .mapToInt(Employee::getSalary);
        System.out.println(intStream.sum());
        System.out.println(intStream.max());

        /*
        * Khi bạn sử dụng Stream API trong Java, mỗi Stream chỉ có thể được sử dụng một lần duy nhất.
        * Sau khi thực hiện một toán tử kết thúc (terminal operation) như sum(), max(), forEach(), v.v.,
        * Stream đó sẽ bị đóng và không thể tái sử dụng cho các thao tác tiếp theo.
        * Nếu bạn cố gắng thực hiện một toán tử kết thúc khác trên cùng một Stream đã bị đóng,
        * Java sẽ ném ra một ngoại lệ IllegalStateException.

        Lý do tại sao bạn gặp lỗi
        Dựa trên câu hỏi của bạn, có vẻ như bạn đang thực hiện các toán tử kết thúc sum() và max() trên cùng một IntStream.
        * */
    }
}
