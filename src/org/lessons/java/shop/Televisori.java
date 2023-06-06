package org.lessons.java.shop;

public class Televisori extends Prodotto {
    private int dimensioni;
    private boolean smart;

    public Televisori(String nome, String descrizione, double prezzo, double iva, int dimensioni, boolean smart) {
        super(nome, descrizione, prezzo, iva);
        this.dimensioni = dimensioni;
        this.smart = smart;
    }

    public int getDimensioni() {
        return dimensioni;
    }

    public boolean isSmart() {
        return smart;
    }

    public void setDimensioni(int dimensioni) {
        this.dimensioni = dimensioni;
    }

    public void setSmart(boolean smart) {
        this.smart = smart;
    }

    @Override
    public String toString() {
        String smartString = smart ? "Smart" : "Non Smart";
        return super.toString() + "\nDimensioni: " + dimensioni + " pollici\nSmart: " + smartString;
    }
}