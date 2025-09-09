<<<<<<<< HEAD:src/Preparation/Specific/Canva/Programming/ClassAndAbstract/Interface/InterfaceExample.java
package Preparation.Specific.Canva.Programming.ClassAndAbstract.Interface;
========
package Learning.Specific.C.Programming.ClassAndAbstract.Interface;
>>>>>>>> origin/master:src/Learning/Specific/C/Programming/ClassAndAbstract/Interface/InterfaceExample.java



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
