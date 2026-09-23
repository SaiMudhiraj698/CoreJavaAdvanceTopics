class Animal {
    Animal giveBirth() {
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    Dog giveBirth() { // Covariant Return Type: 'Dog' is a subtype of 'Animal'
        return new Dog();
    }

    void bark() {
        System.out.println("Woof!");
    }
}

////---------------------------------------
//// BEFORE JAVA 5 (No Covariance)
//class Animal {
//    Animal giveBirth() { return new Animal(); }
//}
//
//class Dog extends Animal {
//    @Override
//    Animal giveBirth() { return new Dog(); } // Must return "Animal" reference
//
//    void bark() { System.out.println("Woof!"); }
//}

public class Covariant {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        Dog puppy = myDog.giveBirth();
        puppy.bark(); // Prints: Woof!

//        Dog myDog = new Dog();
//
//// The method returns an 'Animal' reference, so you MUST cast it manually to 'Dog'
//        Dog puppy = (Dog) myDog.giveBirth();
//        puppy.bark();

    }
}
