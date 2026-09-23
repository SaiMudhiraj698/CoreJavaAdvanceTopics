package Covariant;
// MODERN JAVA (With Covariance)
class Animal {
    Animal giveBirth() {
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    Dog giveBirth() { // Covariant Return Type: 'Dog' is a subtype of 'Animal'
        return new Dog();
//        we must return Animal type but we are returning Dog but after java-5 covariant return type is can be
//        parent type or subclass of parent
    }

    void bark() {
        System.out.println("Woof!");
    }
}

public class WithCovariant {
    public static void main(String[] args) {
        Dog myDog = new Dog();

// Clean and safe! No (Dog) cast required.
        Dog puppy = myDog.giveBirth();
        puppy.bark(); // Prints: Woof!

    }
}
