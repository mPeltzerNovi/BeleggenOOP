package model;

import java.time.LocalDate;

public class Bier extends Drank {

    //variabelen definieren
    private final static double ALCOHOLPERCENTAGE_GRENS = 5.0;
    private final static int HOUDBAARHEID_GIST = 16;
    private final static int HOUDBAARHEID_LAAG_PERCENTAGE = 9;
    private final static int HOUDBAARHEID_HOOG_PERCENTAGE = 30;
    private final static boolean DEFAULT_GIST_IN_FLES = false;
    private final double alcoholPercentage;

    private boolean gistInFles;

    //constructor 1 volgens klassendiagram
    public Bier(String naam, LocalDate brouwDatum, double prijs, double alcoholPercentage, boolean gistInFles) {
        super(naam, brouwDatum, prijs);
        this.alcoholPercentage = alcoholPercentage;
        this.gistInFles = gistInFles;
    }

    //constructor 2 volgens klassendiagram.
    public Bier(String naam, LocalDate brouwdatum, double prijs, double alcoholPercentage) {
        this(naam, brouwdatum, prijs, alcoholPercentage, DEFAULT_GIST_IN_FLES);
    }

    //beperktHoudbaarTot() methode maken met @Override-->Datum uitrekenen!
    @Override
    public LocalDate bepaalHoudbaarTot() {
        if(gistInFles) {
            return getBrouwDatum().plusYears(HOUDBAARHEID_GIST);
        } else if (alcoholPercentage <= ALCOHOLPERCENTAGE_GRENS) {
            return getBrouwDatum().plusMonths(HOUDBAARHEID_LAAG_PERCENTAGE);
        } else {
            return getBrouwDatum().plusMonths(HOUDBAARHEID_HOOG_PERCENTAGE);
        }
    }

    //Met toString de bootschap printen:
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString()); //super gebruiken!
        builder.append("\nAlcoholpercentage: ").append(alcoholPercentage);
        builder.append("%\nGist in fles: ");
        if(gistInFles) {
            builder.append("Ja");
        } else {
            builder.append("Nee");
        }

        return builder.toString();
    }



}
