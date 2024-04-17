import java.util.List;

public class Person {
    private String name;
    private List<String> products;

    public Person(String name, List<String> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public List<String> getProducts() {
        return products;
    }
}
