package Preparation.Specific.Canava.AIAssistantedRound;

import java.util.*;

/***
 *

 Use AI assistance to write a function that:
 Accepts this array.
 Returns the top 5 products sorted by sales volume (highest first).
 Explain how you prompted the AI and refined its output.
 Discuss how you would test this function.
 *
 */
class Product {
    String name;
    int salesVolume;

    public Product(String name, int salesVolume) {
        this.name = name;
        this.salesVolume = salesVolume;
    }
}

public class ProductFilter {
    public List<Product> topFiveBySales(List<Product> products) {
        PriorityQueue<Product> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.salesVolume));
        for (Product p : products) {
            pq.offer(p);
            if (pq.size() > 5) {
                pq.poll();
            }
        }
        List<Product> result = new ArrayList<>(pq);
        result.sort((a, b) -> Integer.compare(b.salesVolume, a.salesVolume));
        return result;
    }

    public static void main(String[] args) {
        ProductFilter test = new ProductFilter();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Widget A", 120));
        products.add(new Product("Widget B", 300));
        products.add(new Product("Widget C", 150));
        products.add(new Product("Widget D", 90));
        products.add(new Product("Widget E", 200));
        products.add(new Product("Widget F", 250));
        List<Product> topProducts = test.topFiveBySales(products);
        for (Product p : topProducts) {
            System.out.println(p.name + ": " + p.salesVolume);
        }
        System.out.println("Case 1: Fewer than 5 products");
        List<Product> case1 = Arrays.asList(new Product("A", 10), new Product("B", 20));
        printProducts(test.topFiveBySales(case1));

        // 2. Exactly 5 products
        System.out.println("\nCase 2: Exactly 5 products");
        List<Product> case2 =Arrays.asList(
                new Product("A", 10), new Product("B", 20),
                new Product("C", 30), new Product("D", 40), new Product("E", 50)
        );
        printProducts(test.topFiveBySales(case2));

        // 3. Duplicate sales volumes
        System.out.println("\nCase 3: Duplicate sales volumes");
        List<Product> case3 = Arrays.asList(
                new Product("A", 100), new Product("B", 100),
                new Product("C", 50), new Product("D", 50), new Product("E", 200), new Product("F", 200)
        );
        printProducts(test.topFiveBySales(case3));

        // 4. All products have the same sales volume
        System.out.println("\nCase 4: All products have the same sales volume");
        List<Product> case4 = Arrays.asList(
                new Product("A", 42), new Product("B", 42),
                new Product("C", 42), new Product("D", 42), new Product("E", 42), new Product("F", 42)
        );
        printProducts(test.topFiveBySales(case4));

        // 5. Negative or zero sales volumes
        System.out.println("\nCase 5: Negative or zero sales volumes");
        List<Product> case5 = Arrays.asList(
                new Product("A", 0), new Product("B", -10),
                new Product("C", 5), new Product("D", -20), new Product("E", 15)
        );
        printProducts(test.topFiveBySales(case5));

        // 6. Very large sales volumes
        System.out.println("\nCase 6: Very large sales volumes");
        List<Product> case6 = Arrays.asList(
                new Product("A", Integer.MAX_VALUE), new Product("B", Integer.MAX_VALUE - 1),
                new Product("C", 999999999), new Product("D", 888888888), new Product("E", 777777777)
        );
        printProducts(test.topFiveBySales(case6));

        // 7. Empty list
        System.out.println("\nCase 7: Empty list");
        List<Product> case7 = Arrays.asList();
        printProducts(test.topFiveBySales(case7));
    }
    private static void printProducts(List<Product> products) {
        for (Product p : products) {
            System.out.println(p.name + ": " + p.salesVolume);
        }
    }
}