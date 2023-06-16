package Exercice2Test;

import Exercice2.InventoryManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InventoryManagerTest {
    private InventoryManager inventoryManager;

    public InventoryManagerTest() {
        inventoryManager = new InventoryManager();
    }

    @ParameterizedTest
    @CsvSource({"Product 1, 100"})
    public void testAddProduct(String product, int quantity) {
        inventoryManager.addProduct(product, quantity);
        int stockAvailability = inventoryManager.getAvailableStock(product);
        Assertions.assertEquals(quantity, stockAvailability);
    }

    @ParameterizedTest
    @CsvSource({"Product 2, 50, 20"})
    public void testRemoveProductSufficientStock(String product, int initialQuantity, int quantityToRemove) {
        int expectedAvailability = initialQuantity - quantityToRemove;

        inventoryManager.addProduct(product, initialQuantity);
        inventoryManager.removeProduct(product, quantityToRemove);
        int stockAvailability = inventoryManager.getAvailableStock(product);

        Assertions.assertEquals(expectedAvailability, stockAvailability);
    }

    @ParameterizedTest
    @CsvSource({"Product 3, 7, 10"})
    public void testRemoveProductInsufficientStock(String product, int initialQuantity, int quantityToRemove) {
        inventoryManager.addProduct(product, initialQuantity);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inventoryManager.removeProduct(product, quantityToRemove));
    }

    @ParameterizedTest
    @CsvSource({"Product 4, 0, 1"})
    public void testRemoveProductOutOfStock(String product, int initialQuantity, int quantityToRemove) {
        inventoryManager.addProduct(product, initialQuantity);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inventoryManager.removeProduct(product, quantityToRemove));
    }

    @ParameterizedTest
    @CsvSource({"Produit non existant, 1"})
    public void testRemoveProductNonExistingProduct(String product, int quantityToRemove) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inventoryManager.removeProduct(product, quantityToRemove));
    }
}
