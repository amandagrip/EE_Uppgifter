package com.amanda.lektion1.Uppgift9;

public class Main {
    public static void main(String[] args) {

        IAnimal lizard = new Lizard(); // Lizard implementerar IReptile

        AnimalUtil util = new AnimalUtil();

        util.checkAnimal(lizard);
    }
}

