package Preparation.Specific.Canva.Programming.ClassAndAbstract.Abastract;

public abstract class AbstractProduct {

        private String productId;
        public String name;
        private double price;

        public AbstractProduct(String productId, String name, double price) {
            this.productId = productId;
            this.name = name;
            this.price = price;
        }


        public void displayDetails() {
            System.out.println("Product ID: " + productId);
            System.out.println("Name: " + name);
            System.out.println("Price: $" + price);
        }
        public abstract void processOrder();

        public void test() {

        }

}
