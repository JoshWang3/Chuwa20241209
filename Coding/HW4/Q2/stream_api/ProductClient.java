//package Chuwa20241209.Coding.HW4.Q2.stream_api;
//
//import org.junit.Test;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class ProductClient {
//    static List<Product> productList = Arrays.asList(
//            new Product(1, "Product 1", "Electronics", 1.99, 2),
//            new Product(2, "Product 2", "Electronics", 2.99, 1),
//            new Product(3, "Product 3", "Electronics", 3.99, 5),
//            new Product(4, "Product 4", "Clothing", 4.99, 13),
//            new Product(5, "Product 5", "Clothing", 5.99, 42),
//            new Product(6, "Product 6", "Clothing", 6.99, 61),
//            new Product(7, "Product 7", "Kitchen", 7.99, 8),
//            new Product(8, "Product 8", "Kitchen", 8.99, 2),
//            new Product(9, "Product 9", "Kitchen", 9.99, 55)
//    );
//
//    @Test
//    public void toList() {
//        // Create a new list containing only the products with a stock greater than 10
//        List<Product> filteredProducts = productList.stream()
//                .filter(product -> product.getStock() > 10)
//                .collect(Collectors.toList());
//        System.out.println(filteredProducts);
//    }
//
//    @Test
//    public void toSet() {
//        // Create a new set containing the unique category from the list of products
//        Set<String> uniqueCategories = productList.stream()
//                .map(Product::getCategory)
//                .collect(Collectors.toSet());
//        System.out.println(uniqueCategories);
//    }
//
//    @Test
//    public void joining() {
//        // Concatenate all product names into a single string, separated by commas
//        String allProductNames = productList.stream()
//                .map(Product::getName)
//                .collect(Collectors.joining(", "));
//        System.out.println(allProductNames);
//        // Concatenate all product names into a string, separated by a newline character
//        String allProductNamesNewLine = productList.stream()
//                .map(Product::getName)
//                .collect(Collectors.joining("\n"));
//        System.out.println(allProductNamesNewLine);
//    }
//
//    @Test
//    public void counting() {
//        // Count the number of products in each category
//        Map<String, Long> categoryCounts = productList.stream()
//                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
//        System.out.println(categoryCounts);
//    }
//
//    @Test
//    public void summingInt() {
//        // Calculate the total stock of all products
//        int totalStock = productList.stream()
//                .collect(Collectors.summingInt(Product::getStock));
//        System.out.println(totalStock);
//    }
//
//    @Test
//    public void groupingBy() {
//        // Group the products by category and calculate the total stock for each category
//        Map<String, Integer> categoryStock = productList.stream()
//                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getStock)));
//        System.out.println(categoryStock);
//        // Group the products by category and calculate the average price for each category
//        Map<String, Double> categoryAveragePrice = productList.stream()
//                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
//        System.out.println(categoryAveragePrice);
//    }
//
//    @Test
//    public void maxBy() {
//        // maxBy() on price
//        Optional<Product> maxPriceProduct = productList.stream()
//                .collect(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)));
//        System.out.println(maxPriceProduct);
//    }
//
//    @Test
//    public void partitioningBy() {
//        // partitioningBy() over 100
//        Map<Boolean, List<Product>> partitionedProducts = productList.stream()
//                .collect(Collectors.partitioningBy(p -> p.getPrice() > 100));
//        System.out.println(partitionedProducts);
//    }
//
//    @Test
//    public void mapping() {
//        Set<String> upperCaseNames = productList.stream()
//                .map(Product::getName)
//                .map(String::toUpperCase)
//                .collect(Collectors.toSet());
//        System.out.println(upperCaseNames);
//    }
//
//    @Test
//    public void match() {
//        boolean isAnyProductExpensive = productList.stream()
//                .anyMatch(product -> product.getPrice() > 250);
//        System.out.println("Is there any expensive product? " + isAnyProductExpensive);
//
//        // allMatch example
//        boolean areAllProductsInStock = productList.stream()
//                .allMatch(product -> product.getStock() > 0);
//        System.out.println("Are all products in stock? " + areAllProductsInStock);
//
//        // noneMatch example
//        boolean areNoProductsFree = productList.stream()
//                .noneMatch(product -> product.getPrice() == 0);
//        System.out.println("Are there no free products? " + areNoProductsFree);
//    }
//
//    @Test
//    public void findFirst() {
//        // findFirst example
//        Optional<Product> firstExpensiveProduct = productList.stream()
//                .filter(product -> product.getPrice() > 100)
//                .findFirst();
//        firstExpensiveProduct.ifPresent(product -> System.out.println("First expensive product > 100: " + product.getName()));
//    }
//
//    @Test
//    public void findAny() {
//
//        // findAny example
//        Optional<Product> anyLowStockProduct = productList.stream()
//                .filter(product -> product.getStock() < 10)
//                .findAny();
//        anyLowStockProduct.ifPresent(product -> System.out.println("Any low stock product < 10 count: " + product.getName()));
//    }
//}
