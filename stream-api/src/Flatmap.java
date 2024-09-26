import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* Trong Java Stream API, flatMap() được sử dụng để
*  biến đổi từng phần tử của stream thành một stream khác,
*  sau đó gộp tất cả các stream con lại thành một stream duy nhất
* */
public class Flatmap {
    static class Order{
        private List<String> products;

        public Order(List<String> products) {
            this.products = products;
        }

        public List<String> getProducts() {
            return products;
        }

        public void setProducts(List<String> products) {
            this.products = products;
        }
    }
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Java", "Spring"),
                Arrays.asList("Stream", "API"),
                Arrays.asList("FlatMap", "Stream")
        );
        listOfLists.stream()
                .flatMap((l->l.stream()))
                .distinct()
                .forEach(System.out::println);

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(Arrays.asList("product1", "product2", "product3")));
        orderList.add(new Order(Arrays.asList("product4", "product5", "product6")));
        orderList.add(new Order(Arrays.asList("product7", "product8", "product9")));
        List<String> collect = orderList.stream()
                .map(o -> o.getProducts())//Stream<List<String>>
                .flatMap(s -> s.stream())
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
