package model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Voorraad {

    private ArrayList<Drank> dranken;

    //default constructor voor Voorraad
    public Voorraad() {
        dranken = new ArrayList<>();
    }

    //Methode om dranken toe te voegen --> steeds in de array stoppen.
    public void voegDrankToe(Drank drank) {
        dranken.add(drank);
    }

    //Later maken:
    //Methode voor printBewaarWijnen()
    //Stap 6: Implementeer de methode printBewaarwijnen
    public void printBewaarWijnen() {
        for (Drank drank : dranken) {
            if (drank instanceof Wijn) {
                Wijn wijn = (Wijn)drank;
                if (wijn.isBewaarWijn()) {
                    System.out.println(wijn.toString());
                    System.out.println();
                }
            }
        }
    }

    //Stap 7Methode voor printBedorvenDranken() met File maken in "resources"
    //met een try catch blok
    public void printBedorvenDranken() {
        try {
            File drankbestand = new File("resources/bedorvendrank.txt");
            PrintWriter printWriter = new PrintWriter(drankbestand);
            for (Drank drank : dranken) {
                if (drank.bepaalHoudbaarTot().isBefore(LocalDate.now())) {
                    printWriter.println(drank);
                    printWriter.println();
                }
            }
            printWriter.close();
        } catch (IOException schrijffout) { //hier word "new Printwriter" ok
            System.out.println("Schrijven niet gelukt");

        }
    }


    //toString voor een uitdraai van de voorraad; alfabetisch gesorteerd.
    //Stap 5 c. toString die de dranken output op alfabetische volgorde
    public String toString() {
        Collections.sort(dranken);

        StringBuilder builder = new StringBuilder();
        for (Drank drank : dranken) {
            builder.append(drank.toString()); //(hier gaat die info  uit de Drank-Constructor erin
            builder.append("\n\n");
        }

        return builder.toString();
    }

}
