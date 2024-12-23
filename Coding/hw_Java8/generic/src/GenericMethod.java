public class GenericMethod {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5,
                GenericMaxTest.maxSelf(3, 4, 5));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
                GenericMaxTest.maxParent(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
                GenericMaxTest.maxSelf("pear", "apple", "orange"));
    }

    class GenericMaxTest {
        /**
         * <T extends Comparable<T>> limit the class itself has implemented Comparable
         * @param a
         * @param b
         * @param c
         * @return
         * @param <T>
         */
        public static <T extends Comparable<T>> T maxSelf(T a, T b, T c) {
            T max = a;
            if (b.compareTo(max) > 0) {
                max = b;
            }
            if (c.compareTo(max) > 0) {
                max = c;
            }

            return max;
        }

        /**
         * <T extends Comparable<? super T>> limit if child or father has implement Comparable
         * @param a
         * @param b
         * @param c
         * @return
         * @param <T>
         */
        public static <T extends Comparable<? super T>> T maxParent(T a, T b, T c) {
            T max = a;
            if (b.compareTo(max) > 0) {
                max = b;
            }
            if (c.compareTo(max) > 0) {
                max = c;
            }

            return max;
        }
    }
}
