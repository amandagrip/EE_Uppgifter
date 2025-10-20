package com.amanda.lektion1.Uppgift9;

public class AnimalUtil {

    public void checkAnimal(IAnimal animal) {
        if (animal instanceof IMammal) {
            System.out.println("Mammal");
        } else if (animal instanceof IReptile) {
            System.out.println("Reptile");
        }
    }
}
