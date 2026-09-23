package Covariant;
class Animal {
    // Parent method returns a generic Animal
    Animal getAnimal() {
        return new Animal();
    }
}

class Dog extends Animal {
    // Must return "Animal" reference
    @Override
    Animal getAnimal() {
        return new Dog();
//        we must return Animal type but we are returning Dog so later we need to type cast before java-5
    }

    void bark() {
        System.out.println("Woof!");
    }
}
public class WithoutCovariant {
    public static void main(String[] args) {
        Dog myDog = new Dog();
// before java 5 we must typecast
// The method returns an 'Animal' reference, so you MUST cast it manually to 'Dog'
        Dog puppy = (Dog)myDog.getAnimal();
        puppy.bark();
    }
}
