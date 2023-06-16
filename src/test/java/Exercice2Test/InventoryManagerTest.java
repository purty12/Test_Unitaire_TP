package Exercice2Test;

import Exercice2.InventoryManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryManagerTest {
    private InventoryManager inventoryManager;

    @BeforeEach
    public void setUp() {
        inventoryManager = new InventoryManager();
    }

    @Test
    public void testAddProduct() {
        inventoryManager.addProduct("Product 1", 100);
        int stockAvailability = inventoryManager.getAvailableStock("Product 1");
        Assertions.assertEquals(100, stockAvailability);
    }

    @Test
    public void testRemoveProductSufficientStock() {
        inventoryManager.addProduct("Product 2", 51);
        inventoryManager.removeProduct("Product 2", 20);
        int stockAvailability = inventoryManager.getAvailableStock("Product 2");
        Assertions.assertEquals(30, stockAvailability);
    }

    @Test
    public void testRemoveProductInsufficientStock() {
        inventoryManager.addProduct("Product 3", 11);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inventoryManager.removeProduct("Product 3", 10));
    }

    @Test
    public void testRemoveProductOutOfStock() {
        inventoryManager.addProduct("Product 4", 0);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inventoryManager.removeProduct("Product 4", 1));
    }

    @Test
    public void testRemoveProductNonExistingProduct() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inventoryManager.removeProduct("Produit non existant", 1));
    }
}

