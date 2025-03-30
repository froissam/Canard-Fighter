import canard.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Canard> canardList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {

            System.out.println("Bienvenue dans Canard Fighter Simulator !");

            System.out.println("1. Créer un canard");
            System.out.println("2. Lancer une bataille");
            System.out.println("3. Quitter");

            System.out.print("Choisissez une option : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Création d'un canard");
                    CreerCanard();
                    break;
                case 2:
                    System.out.println("Lancement de la bataille");
                    if (canardList.size() < 2) {
                        System.out.println("Vous devez d'abord créer au moins 2 canards pour pouvoir lancer une bataille ");
                    } else {
                        Bataille();
                    }
                    break;
                case 3:
                    System.out.println("Merci d'avoir joué");
                    break;
            }
        }

        scanner.close();
    }

    public static void CreerCanard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("veuillez remplir les informations suivantes : ");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        int pv = 0;
        while (pv <= 0) {
            System.out.print("Pv (nombre supérieur à 0) : ");
            pv = scanner.nextInt();
        }

        int attaque = 0;
        while (attaque <= 0) {
            System.out.print("Attaque (nombre supérieur à 0) : ");
            attaque = scanner.nextInt();
        }

        int type = 0;
        while (type <= 0 || type > 4) {
            System.out.println("Type : ");
            System.out.println("1. Eau");
            System.out.println("2. Feu");
            System.out.println("3. Glace");
            System.out.println("4. Vent");
            type = scanner.nextInt();
        }

        switch (type) {
            case 1:
                CanardEau canardEau = new CanardEau(nom, pv, attaque);
                canardList.add(canardEau);
                break;
            case 2:
                CanardFeu canardFeu = new CanardFeu(nom, pv, attaque);
                canardList.add(canardFeu);
                break;
            case 3:
                CanardGlace canardGlace = new CanardGlace(nom, pv, attaque);
                canardList.add(canardGlace);
                break;
            case 4:
                CanardVent canardVent = new CanardVent(nom, pv, attaque);
                canardList.add(canardVent);
                break;
        }
    }

    public static void Bataille() {
        Scanner scanner = new Scanner(System.in);
        int indexCanard1 = -1;
        int indexCanard2 = -1;
        while (indexCanard1 == -1 || indexCanard2 == -1) {
            System.out.println("Veuillez sélectionner 2 canards pour la bataille : ");

            for (int i = 0; i < canardList.size(); i++) {
                if (indexCanard1 != i) {
                    System.out.println(i + ". " + canardList.get(i).getNom());
                }
            }

            int choice = scanner.nextInt();
            if(choice >= 0 && choice < canardList.size()) {
                if (indexCanard1 == -1) {
                    indexCanard1 = choice;
                } else {
                    indexCanard2 = choice;
                }
            }
        }

        Canard canard1 = canardList.get(indexCanard1);
        Canard canard2 = canardList.get(indexCanard2);

        System.out.println("Les 2 canards sélectionnés pour la bataille sont : ");
        System.out.println(canard1.getNom() + " et " + canard2.getNom());
    }
}