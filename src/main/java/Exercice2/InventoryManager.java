package Exercice2;

    import java.util.HashMap;
import java.util.Map;

    public class InventoryManager {
        private Map<String, Integer> inventory;

        public InventoryManager() {
            this.inventory = new HashMap<>();
        }

        /**
         * Ajout du nom d'un produit et de sa quantité
         * @param product
         * @param quantity
         */
        public void addProduct(String product, int quantity) {
            if (inventory.containsKey(product)) {
                int currentQuantity = inventory.get(product);
                inventory.put(product, currentQuantity + quantity);
            } else {
                inventory.put(product, quantity);
            }
        }

        /**
         * Supprime un produit en focntion de son nom et de la quantité que l'on veux supprimer
         * @param product
         * @param quantity
         */
        public void removeProduct(String product, int quantity) {
            if (!inventory.containsKey(product)) {
                throw new IllegalArgumentException("Produit non présent dans l'inventaire : " + product);
            }

            int currentQuantity = inventory.get(product);
            if (quantity > currentQuantity) {
                throw new IllegalArgumentException("Quantité insuffisante pour retirer du produit : " + product);
            }

            inventory.put(product, currentQuantity - quantity);
        }

        /**
         * Récupère le stock disponible d'un produit
         * @param product
         * @return
         */
        public int getAvailableStock(String product) {
            return inventory.getOrDefault(product, 0);
        }
    }

