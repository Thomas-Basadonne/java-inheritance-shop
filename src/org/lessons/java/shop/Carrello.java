package org.lessons.java.shop;

import java.util.Scanner;

public class Carrello {
    private Prodotto[] prodotti;
    private int numeroProdotti;

    public Carrello(int capacita) {
        prodotti = new Prodotto[capacita];
        numeroProdotti = 0;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        if (numeroProdotti < prodotti.length) {
            prodotti[numeroProdotti] = prodotto;
            numeroProdotti++;
            System.out.println("Prodotto aggiunto al carrello.");
        } else {
            System.out.println("Il carrello è pieno. Impossibile aggiungere ulteriori prodotti.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrello:\n");
        for (int i = 0; i < numeroProdotti; i++) {
            sb.append(prodotti[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci la capacità del carrello: ");
        int capacita = scanner.nextInt();
        scanner.nextLine();

        Carrello carrello = new Carrello(capacita);

        while (true) {
            System.out.print("Che tipo di prodotto vuoi inserire (Smartphone/Televisori/Cuffie) o 'Fine' per terminare: ");
            String tipoProdotto = scanner.nextLine();

            if (tipoProdotto.equalsIgnoreCase("Fine")) {
                break;
            }

            // Richiesta delle informazioni comuni a tutti i tipi di prodotto
            System.out.print("Inserisci il nome del prodotto: ");
            String nome = scanner.nextLine();

            System.out.print("Inserisci la descrizione del prodotto: ");
            String descrizione = scanner.nextLine();

            System.out.print("Inserisci il prezzo del prodotto: ");
            double prezzo = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Inserisci l'IVA del prodotto: ");
            double iva = scanner.nextDouble();
            scanner.nextLine();

            // Richiesta delle informazioni specifiche x gli smartphone
            if (tipoProdotto.equalsIgnoreCase("Smartphone")) {
                System.out.print("Inserisci il codice IMEI dello Smartphone: ");
                String imei = scanner.nextLine();

                System.out.print("Inserisci la quantità di memoria dello Smartphone: ");
                int memoria = scanner.nextInt();
                scanner.nextLine();

                Smartphone smartphone = new Smartphone(nome, descrizione, prezzo, iva, imei, memoria);
                carrello.aggiungiProdotto(smartphone);
                // Richiesta delle informazioni specifiche x i televisori
            } else if (tipoProdotto.equalsIgnoreCase("Televisori")) {
                System.out.print("Inserisci le dimensioni del televisore: ");
                int dimensioni = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Il televisore è smart (Sì/No)? ");
                boolean smart = scanner.nextLine().equalsIgnoreCase("Sì");

                Televisori televisore = new Televisori(nome, descrizione, prezzo, iva, dimensioni, smart);
                carrello.aggiungiProdotto(televisore);
                // Richiesta delle informazioni specifiche x i cuffie
            } else if (tipoProdotto.equalsIgnoreCase("Cuffie")) {
                System.out.print("Inserisci il colore delle cuffie: ");
                String colore = scanner.nextLine();

                System.out.print("Le cuffie sono wireless (Sì/No)? ");
                boolean wireless = scanner.nextLine().equalsIgnoreCase("Sì");

                Cuffie cuffie = new Cuffie(nome, descrizione, prezzo, iva, colore, wireless);
                carrello.aggiungiProdotto(cuffie);
            } else {
                System.out.println("Tipo di prodotto non valido. Riprova.");
            }
        }

        System.out.println("\nRiepilogo del carrello:\n");
        System.out.println(carrello);

        System.out.println("Grazie per aver utilizzato il nostro servizio di carrello. Arrivederci!");
    }
}
