import java.util.Arrays;

public class CreatingStream {
    public static void main(String[] args) {
        String[] names = {"Tran", "Hau", "Huan"};
        Arrays.stream(names)
                .map(s -> s.concat("_"))
                .forEach(System.out::print);
    }
}
