import java.util.*;

public class ProductSearch {

    static int linearSearch(Product[] arr, int targetId) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].productId == targetId) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(Product[] arr, int targetId) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].productId == targetId) {
                return mid;
            } else if (arr[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(203, "Cotton T-Shirt", "Clothing"),
            new Product(150, "Bluetooth Speaker", "Electronics"),
            new Product(310, "Running Shoes", "Footwear"),
            new Product(120, "Coffee Mug", "Home"),
            new Product(275, "Yoga Mat", "Fitness"),
            new Product(190, "Desk Lamp", "Home"),
            new Product(250, "Backpack", "Accessories")
        };

        int searchId = 150;

        long startLinear = System.nanoTime();
        int linearIndex = linearSearch(products, searchId);
        long endLinear = System.nanoTime();

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, (a, b) -> a.productId - b.productId);

        long startBinary = System.nanoTime();
        int binaryIndex = binarySearch(sortedProducts, searchId);
        long endBinary = System.nanoTime();

        if (linearIndex != -1) {
            System.out.println("Linear search found: " + products[linearIndex]);
        } else {
            System.out.println("Linear search: product not found");
        }
        System.out.println("Linear search time: " + (endLinear - startLinear) + " ns");

        if (binaryIndex != -1) {
            System.out.println("Binary search found: " + sortedProducts[binaryIndex]);
        } else {
            System.out.println("Binary search: product not found");
        }
        System.out.println("Binary search time: " + (endBinary - startBinary) + " ns");
    }
}
