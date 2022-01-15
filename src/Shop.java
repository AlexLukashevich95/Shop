public class Shop {

    private Long id;
    private String name;
    private Long[] products;


    public Shop(Long id, String name) {
        this.id = id;
        this.name = name;
        this.products = new Long[0];
    }

    public void addProduct(Product product) {
        Long[] newProducts = new Long[products.length + 1];
        for (int i = 0; i < products.length; i++){
            newProducts[i] = products[i];
        }
        Long productId = product.getId();
        newProducts[products.length] = productId;
        products = newProducts;
    }

    public void showProducts() {
        System.out.print("[ ");
        for (Long product : products) {
            System.out.print(product + " ");
        }
        System.out.println("]");
    }

    public void deleteProduct(Long productIdRemove) {
        if (products.length != 0) {
            Long[] newProducts = new Long[products.length - 1];
            for (int i = 0, k = 0; i < products.length; i++) {
                if (products[i].equals(productIdRemove)) {
                    System.out.println("This product were removed successfully");
                    continue;
                }
                newProducts[k++] = products[i];
            }
            products = newProducts;
        }
        else{
            System.out.println("No items found");
        }

    }

    public void sortProducts() {
        Long[] newProducts = new Long[products.length];
        for (int i = 0;i<products.length;i++){
            newProducts[i] = products[i];
        }
        System.out.print("[ ");
        for (int i = 0; i < newProducts.length; i++) {
            Long min = newProducts[i];
            int minId = i;
            for (int j = i + 1; j < newProducts.length; j++) {
                if (newProducts[j] < min) {
                    min = newProducts[j];
                    minId = j;
                }
            }
            Long newProduct = newProducts[i];
            newProducts[i] = newProducts[minId];
            newProducts[minId] = newProduct;
            System.out.print(newProducts[i]+" ");
        }
        System.out.println("]");
    }
}

