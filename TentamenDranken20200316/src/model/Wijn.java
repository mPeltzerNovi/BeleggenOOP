package model;

import java.time.LocalDate;

public class Wijn extends Drank {

    //variabelen declareren
    private final static double PRIJS_GRENS = 35.0;
    private final static int GOEDKOOP_BEWAARWIJN_JAREN = 10;
    private final static int GOEDKOOP_GEEN_BEWAARWIJN_JAREN = 2;
    private final static int DUUR_BEWAARWIJN_JAREN = 100;
    private final static int DUUR_GEEN_BEWAARWIJN_JAREN = 10;

    private boolean bewaarWijn;

    //constructor
    public Wijn(String naam, LocalDate brouwDatum, double prijs, boolean bewaarwijn) {
        super(naam, brouwDatum, prijs);
        this.bewaarWijn = bewaarWijn;
    }

    //hergebruik "bepaalHoudbaarTot()
    @Override
    public LocalDate bepaalHoudbaarTot() {
        if (getPrijs() < PRIJS_GRENS) {
            if (bewaarWijn) {
                return getBrouwDatum().plusYears(GOEDKOOP_BEWAARWIJN_JAREN);
            } else {
                return getBrouwDatum().plusYears(GOEDKOOP_GEEN_BEWAARWIJN_JAREN);
            }
        } else {
            if (bewaarWijn) {
                return getBrouwDatum().plusYears(DUUR_BEWAARWIJN_JAREN);
            } else {
                return getBrouwDatum().plusYears(DUUR_GEEN_BEWAARWIJN_JAREN);
            }
        }

    }
    //Methode voor vaststellen "is bewaarwijn
    public boolean isBewaarWijn() {
        return bewaarWijn;
    }

    //Printen gevraagde output met een toString
    @Override
    public String toString() {
        if(bewaarWijn) {
            return super.toString() + "\nBewaarwijn: ja";
        } else {
            return super.toString() + "\nBewaarwijn: Nee";
        }
    }
}
