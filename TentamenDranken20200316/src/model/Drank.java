package model;

//Eerst gewoon het tentamen hermaken

import java.time.LocalDate;

//Stap 5 a. Aanpassen Class: toevoegen implements Comparable<Drank> (de Array)
public abstract class Drank implements Comparable<Drank> {

    //Variabelen declareren
    private String naam;
    private LocalDate brouwDatum;
    private double prijs;

    //constructur met alle drie de variabelen:
    Drank(String naam, LocalDate brouwDatum, double prijs) {
        this.naam = naam;
        this.brouwDatum = brouwDatum;
        this.prijs = prijs;
    }

    //getter methode om de brouwdatum terug te geven
    public LocalDate getBrouwDatum() {
        return brouwDatum;
    }

    //getter-methode om de prijs per fles terug te geven
    public double getPrijs() {
        return prijs;
    }

    //methode om de houdbaarheidsdatum te bepalen
    public abstract LocalDate bepaalHoudbaarTot();

    //methode om de houdbaarheidsdatum te bepalen en weer te geven in de terminal.
    //Dit moet middels een toString die naam, prijs en houdbaarheidsdatum weergeeft zoals in voorbeeld beschreven
    //Door de toString moet je dus de methoden overriden met @Override
    @Override
    public String toString() {
        return naam + ": " + prijs + "euro per fles\nHoudbaar tot: " + bepaalHoudbaarTot();
    }

    //Hieronder bij stap 5 interface met compareTo()-methode maken.
    //Stap 5 b. Override met compareTo()
    @Override
    public int compareTo(Drank andereDrank) {
        return naam.compareTo(andereDrank.naam);
    }

}
