package Learning.Specific.C.Programming.ClassAndAbstract.Abastract;

public class Modem extends AbstractProduct {

    public Modem(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public void processOrder() {
        System.out.println("Processing order for Modem: " + super.name);
    }
}

class BusinessBroadband extends AbstractProduct {
    public BusinessBroadband(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public void processOrder() {
        System.out.println("Processing order for Business Broadband: " + super.name);
        // Specific logic for provisioning a broadband service
    }


}

class Fiber extends AbstractProduct {
    public Fiber(String productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public void processOrder() {
        System.out.println("Processing order for Fiber: " + super.name);
        // Specific logic for fiber installation and provisioning
    }
}