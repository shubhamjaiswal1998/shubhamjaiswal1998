package core_jdbc1;

class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat meows");
    }
}

class Cow extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cow mooes");
    }
}

public class java_testQ1 {

	public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.makeSound(); 

        Animal animal2 = new Cat();
        animal2.makeSound(); 

        Animal animal3 = new Cow();
        animal3.makeSound(); 
    }
	
}
