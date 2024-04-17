import java.util.ArrayList;
import java.util.List;

public class MyStream<T> {
    private List<T> list = new ArrayList<>();

    public void fill(int count, MySupplier<T> supplier) {
        for (int i = 0; i < count; i++) {
            list.add(supplier.get());
        }
    }

    public void print() {
        System.out.println(list);
    }

    public void map(MyUnaryOperator<T> unaryOperator) {
        list.replaceAll(unaryOperator::apply);
    }

    public void delete(MyPredicate<T> predicate) {
        for (int i = 0; i < list.size(); i++) {
            if (predicate.test(list.get(i))) {
                list.remove(i);
                i--;
            }
        }
    }
}
