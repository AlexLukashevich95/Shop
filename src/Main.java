import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Shop shop = new Shop(1L, "ABC");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Add product - 1; Remove product - 2; Show all products - 3; Sort - 4; End - 0");
            int endPointValue = sc.nextInt();
            switch(endPointValue) {
                case 0:
                    return;
                case 1:
                    System.out.print("Add product id:  ");
                    Long productId = sc.nextLong();
                    System.out.print("Add product name:  ");
                    String productName = sc.next();
                    System.out.print("Add product price:  ");
                    Long productPrice = sc.nextLong();
                    System.out.print("Add product rating:  ");
                    Long productRating = sc.nextLong();
                    Product product = new Product(productId, productName, productPrice, productRating);
                    shop.addProduct(product);
                    break;
                case 2:
                    System.out.println("Which product do you want to remove?");
                    Long productIdRemove = sc.nextLong();
                    shop.deleteProduct(productIdRemove);
                    break;
                case 3:
                    shop.showProducts();
                    break;
                case 4:
                    shop.sortProducts();
                    break;
                default:
                    System.out.println("Any condition were not chosen");
            }
        }
    }
}

