import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Shop shop = new Shop(1L, "ABC");
        Scanner sc = new Scanner(System.in);
        Long productId = 1L;
        while(true){
            System.out.println("Add product - 1; Remove product - 2; Show all products - 3; Sort - 4; Edit - 5; End - 0");
            int endPointValue = sc.nextInt();
            switch(endPointValue) {
                case 0:
                    return;
                case 1:
                    System.out.print("Add product name:  ");
                    String productName = sc.next();
                    System.out.print("Add product price:  ");
                    Long productPrice = sc.nextLong();
                    System.out.print("Add product rating:  ");
                    Long productRating = sc.nextLong();
                    Product product = new Product(productId, productName, productPrice, productRating);
                    shop.addProduct(product);
                    productId++;
                    break;
                case 2:
                    System.out.println("Which product by name do you want to remove?");
                    sc.nextLine();
                    String productNameRemove = sc.nextLine();
                    shop.deleteProduct(productNameRemove);
                    break;
                case 3:
                    shop.showProducts();
                    break;
                case 4:
                    shop.sortProducts();
                    break;
                case 5:
                    System.out.println("Which product by id do you want to edit?");
                    Long productIdEdit = sc.nextLong();
                    System.out.println("Edit id - 1; Edit name - 2; Edit price - 3; Edit rating - 4");
                    int editPoint = sc.nextInt();
                    switch (editPoint){
                        case 1:
                            shop.editProductName(productIdEdit);
                            break;
                        case 2:
                            shop.editProductPrice(productIdEdit);
                            break;
                        case 3:
                            shop.editProductRating(productIdEdit);
                            break;
                        default:
                            System.out.println("Any condition were not chosen");
                    }
                    break;
                default:
                    System.out.println("Any condition were not chosen");
            }
        }
    }
}

