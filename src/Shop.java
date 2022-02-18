import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Shop {

    private Long id;
    private String name;
    private ArrayList<Product> products = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Comparator<Product> prodId = Comparator.comparingLong(Product::getId);


    public Shop(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addProduct(Product product) {

        Long productId = product.getId();
        String productName = product.getName();
        Long productPrice = product.getPrice();
        Long productRating = product.getRating();
        products.add(new Product(productId,productName,productPrice,productRating));

    }

    public void showProducts() {
        for(Product product: products)
        System.out.println("id - "+product.getId()+"  ||  Name - "+ product.getName() + "  ||  Price - " + product.getPrice() + "  ||  Rating - " + product.getRating());
        System.out.println(" ");
    }

    public void deleteProduct(String productNameRemove) {
        if (products != null) {
            products.removeIf(product -> product.getName().equals(productNameRemove));
        }
        else{
            System.out.println("No items found");
        }
    }

   public void sortProducts() {
       ArrayList<Product> newProducts = new ArrayList<>(products);
       newProducts.sort(prodId);
       for(Product product: newProducts)
           System.out.println("id - "+product.getId()+"  ||  Name - "+ product.getName() + "  ||  Price - " + product.getPrice() + "  ||  Rating - " + product.getRating());
       System.out.println(" ");
   }

    public void editProductName(Long productId){
        for(Product product: products)
            if (product.getId().equals(productId)) {
                System.out.print ("New name : ");
                String productNewName = sc.nextLine();
                product.setName(productNewName);
            }
            else{
                System.out.println("No items found");
            }
    }

    public void editProductPrice(Long productId){
        for(Product product: products)
            if (product.getId().equals(productId)) {
                System.out.print ("New price : ");
                Long productNewPrice = sc.nextLong();
                product.setPrice(productNewPrice);
            }
            else{
                System.out.println("No items found");
            }
    }

    public void editProductRating(Long productId){
        for(Product product: products)
            if (product.getId().equals(productId)) {
                System.out.print ("New rating : ");
                Long productNewRating = sc.nextLong();
                product.setRating(productNewRating);
            }
            else{
                System.out.println("No items found");
            }
    }

}

