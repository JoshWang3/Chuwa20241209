import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {
    private final List<T> data;

    // Constructor
    private MyStream(List<T> data) {
        this.data = data;
    }

    // Factory method to create a MyStream instance
    public static <T> MyStream<T> of(List<T> data) {
        return new MyStream<>(data);
    }

    // Implementing filter method
    public MyStream<T> filter(Predicate<? super T> predicate) {
        List<T> filteredData = new ArrayList<>();
        for (T element : data) {
            if (predicate.test(element)) {
                filteredData.add(element);
            }
        }
        return new MyStream<>(filteredData);
    }

    // Implementing map method
    public <R> MyStream<R> map(Function<? super T, ? extends R> mapper) {
        List<R> mappedData = new ArrayList<>();
        for (T element : data) {
            mappedData.add(mapper.apply(element));
        }
        return new MyStream<>(mappedData);
    }

    // Terminal operation to collect results into a List
    public List<T> collect() {
        return new ArrayList<>(data);
    }

    // For debugging: Print elements
    public void forEach() {
        data.forEach(System.out::println);
    }
}

