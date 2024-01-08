package learn.java.abstraction;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Wolf", "big", 100));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Shark", "large", 1500));
        animals.add(new Dog("Pug", "small", 20));

        for(Animal animal : animals){
            doAnimalStuff(animal);
            if(animal instanceof Dog currDog){
                currDog.shredHair();
            }
            System.out.println("-------------------");
        }
    }

    private static void doAnimalStuff(Animal animal){
        animal.makeNoise();
        animal.move("slow");
    }
}
