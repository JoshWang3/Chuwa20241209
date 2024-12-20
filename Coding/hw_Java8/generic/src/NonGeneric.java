public class NonGeneric {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5,
                NonGenericInner.maximum(3, 4, 5));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
                NonGenericInner.maximum(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
                NonGenericInner.maximum("pear", "apple", "orange"));
    }

    class NonGenericInner {

        public static int maximum(int a, int b, int c) {
            return Math.max(a, Math.max(b, c));
        }

        public static double maximum(double a, double b, double c) {
            double max = Math.max(a, b);
            max = Math.max(max, c);

            return max;
        }

        public static String maximum(String a, String b, String c) {
            String max = a;
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
