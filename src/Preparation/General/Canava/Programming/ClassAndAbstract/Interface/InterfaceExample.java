package Preparation.General.Canava.Programming.ClassAndAbstract.Interface;



    interface Flyable {
        void fly();
        default void glide() {
            System.out.println("Gliding through the air.");
        }
    }
    // Class implementing the interface
    class Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("Bird is flying.");
        }
    }

    // Main class to demonstrate
    public class InterfaceExample {
        public static void main(String[] args) {
            Bird myBird = new Bird();
            myBird.fly();
            myBird.glide();
        }
    }
