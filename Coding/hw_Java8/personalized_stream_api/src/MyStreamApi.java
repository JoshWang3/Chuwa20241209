import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamApi<T> {

    private final List<T> list;

    public MyStreamApi(List<T> list) {
        this.list = list;
    }

    public MyStreamApi<T> filter(Predicate<T> predicate) {
        List<T> res = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                res.add(t);
            }
        }

        return new MyStreamApi<>(res);
    }

    public MyStreamApi<T> map(Function<T, T> function) {
        List<T> res = new ArrayList<>();
        for (T t : list) {
            res.add(function.apply(t));
        }

        return new MyStreamApi<>(res);
    }

    public MyStreamApi<T> sort(Comparator<T> comparator) {
        List<T> res = new ArrayList<>(list);
        res.sort(comparator);
        return new MyStreamApi<>(res);
    }

    public List<T> toList() {
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evens = new MyStreamApi<>(numbers).filter(n -> n % 2 == 0).sort((a, b) -> b - a).toList();
        System.out.println(evens);

        List<Integer> odds = new MyStreamApi<>(numbers).filter(n -> n % 2 != 1).toList();
        System.out.println(odds);
    }
}
