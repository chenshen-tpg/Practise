package CompanyPreparation.Canava.ProgrammingQuestions.ClassAndAbstract.Abastract;


    abstract class Animal {

        public abstract void makeSound();
        public void sleep() {
            System.out.println("Zzz...");
        }
    }

    class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Woof woof!");
        }
    }


    public class AbstractClassExample {
        public static void main(String[] args) {
            Dog myDog = new Dog();
            myDog.makeSound();
            myDog.sleep();
        }
    }
