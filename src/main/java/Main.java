import canard.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Canard> canardList = new ArrayList<>();

    public static void main(String[] args) {

        /* Liste de canards créés par défaut pour pouvoir lancer des combats plus vite */
        canardList.add(new CanardEau("Canardo", 100, 20, 110));
        canardList.add(new CanardFeu("Confit", 80, 30, 130));
        canardList.add(new CanardGlace("Glaglanard", 90, 25, 100));
        canardList.add(new CanardVent("Tornard", 90, 20, 120));
        canardList.add(new CanardElectrique("Elecanard", 100, 20, 120));

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {

            System.out.println("\nBienvenue dans Canard Fighter Simulator !");

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
                    System.out.println("Merci d'avoir joué !");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Demande les différents attributs d'un canard (nom, pv, attaque, vitesse, type)
     * crée un canard correspondant à ces attributs et l'ajoute à la liste de canards
     * pour qu'il soit sélectionnable dans les combats.
     */
    private static void CreerCanard() {
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

        int vitesse = 0;
        while (vitesse <= 0) {
            System.out.print("Vitesse (nombre supérieur à 0) : ");
            vitesse = scanner.nextInt();
        }

        int type = 0;
        while (type <= 0 || type > 5) {
            System.out.println("Type : ");
            System.out.println("1. Eau");
            System.out.println("2. Feu");
            System.out.println("3. Glace");
            System.out.println("4. Vent");
            System.out.println("5. Electrique");
            type = scanner.nextInt();
        }

        switch (type) {
            case 1:
                CanardEau canardEau = new CanardEau(nom, pv, attaque, vitesse);
                canardList.add(canardEau);
                break;
            case 2:
                CanardFeu canardFeu = new CanardFeu(nom, pv, attaque, vitesse);
                canardList.add(canardFeu);
                break;
            case 3:
                CanardGlace canardGlace = new CanardGlace(nom, pv, attaque, vitesse);
                canardList.add(canardGlace);
                break;
            case 4:
                CanardVent canardVent = new CanardVent(nom, pv, attaque, vitesse);
                canardList.add(canardVent);
                break;
            case 5:
                CanardElectrique canardElectrique = new CanardElectrique(nom, pv, attaque, vitesse);
                canardList.add(canardElectrique);
                break;
        }
    }

    /**
     * Affiche la liste de canards et demande d'en sélectionner 2 pour faire une bataille
     * Une fois les canards sélectionnés, lance une bataille en demandant les actions à effectuer
     * pour chaques canards et execute ces actions (en fonction de la vitesse, des status et des PP restant des canards)
     * Quand les points de vie d'un canard tombent à 0, le combat est fini et son adversaire remporte la bataille
     * A la fin du combat, réinitialise les canards pour qu'ils puissent être re-sélectionnés pour d'autres combats
     */
    private static void Bataille() {
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

        System.out.println("Début de la bataille : ");
        while (!canard1.estKo() && !canard2.estKo()) {

            int actionCanard1 = 0;
            while (actionCanard1 <= 0 || actionCanard1 > 2) {
                System.out.println("Sélectionnez l'action de " + canard1.getNom());
                System.out.println("1. Attaquer");
                System.out.println("2. Utiliser la capacité spéciale");
                actionCanard1 = scanner.nextInt();
            }

            int actionCanard2 = 0;
            while (actionCanard2 <= 0 || actionCanard2 > 2) {
                System.out.println("Sélectionnez l'action de " + canard2.getNom());
                System.out.println("1. Attaquer");
                System.out.println("2. Utiliser la capacité spéciale");
                actionCanard2 = scanner.nextInt();
            }

            Canard premier, second;
            int actionPremier, actionSecond;

            if (canard1.getVitesse() >= canard2.getVitesse()) {
                premier = canard1;
                second = canard2;
                actionPremier = actionCanard1;
                actionSecond = actionCanard2;
            } else {
                premier = canard2;
                second = canard1;
                actionPremier = actionCanard2;
                actionSecond = actionCanard1;
            }

            executerAction(premier, second, actionPremier);
            afficherEtat(canard1, canard2);

            if (second.estKo()) {
                break;
            }

            executerAction(second, premier, actionSecond);
            afficherEtat(canard1, canard2);
        }

        if (canard1.estKo()) {
            System.out.println(canard1.getNom() + " est KO");
            System.out.println(canard2.getNom() + " remporte la bataille !");
        } else {
            System.out.println(canard2.getNom() + " est KO");
            System.out.println(canard1.getNom() + " remporte la bataille !");
        }

        canard1.reinitialisation();
        canard2.reinitialisation();
    }

    /**
     * Vérifie le statut du canard attaquant et en fonction execute
     * l'action choisie et/ou applique les effets du statut
     * @param attaquant le canard attaquant
     * @param cible le canard adverse
     * @param action l'action à éxecuter (1 : attaque, 2 : capacité spéciale)
     */
    private static void executerAction(Canard attaquant, Canard cible, int action) {
        boolean actionOk = true;
        int dureeStatut = attaquant.getDureeStatut();
        switch (attaquant.getStatut()) {
            case GEL:
                if (dureeStatut == 0) {
                    System.out.println(attaquant.getNom() + " n'est plus gelé");
                    attaquant.appliquerEffet(attaquant, Statut.AUCUN);
                } else {
                    actionOk = false;
                    attaquant.setDureeStatut(dureeStatut - 1);
                    System.out.println(attaquant.getNom() + " est gelé, il n'a pas pu attaquer");
                }
                break;
            case BRULURE:
                if (dureeStatut == 0) {
                    System.out.println(attaquant.getNom() + " n'est plus brulé");
                    attaquant.appliquerEffet(attaquant, Statut.AUCUN);
                } else {
                    attaquant.setDureeStatut(dureeStatut - 1);
                    attaquant.subirDegats(10);
                    System.out.println(attaquant.getNom() + " souffre de brûlure");
                }
                break;
            case PARALYSIE:
                if (dureeStatut == 0) {
                    System.out.println(attaquant.getNom() + " n'est plus paralysé");
                    attaquant.appliquerEffet(attaquant, Statut.AUCUN);
                } else {
                    attaquant.setDureeStatut(dureeStatut - 1);
                    if (Math.random() < 0.5) {
                        actionOk = false;
                        System.out.println(attaquant.getNom() + " est paralysé, il n'a pas pu attaquer");
                    }
                }
                break;
            case AUCUN:
                break;
        }

        if (actionOk) {
            if (action == 1) {
                int degats = attaquant.attaquer(cible);
                System.out.println(attaquant.getNom() + " attaque " + cible.getNom());
                if (Math.random() < 0.1) {
                    degats *= 2;
                    System.out.println("Coup critique !");
                }
                cible.subirDegats(degats);
            } else if (action == 2) {
                System.out.println(attaquant.getNom() + " utilise sa capacité spéciale");
                attaquant.capaciteSpeciale(cible);
            }
        }
    }

    /**
     * Affiche l'état actuel des canards pour savoir où en est le combat
     * @param canard1 le premier canard
     * @param canard2 le second canard
     */
    private static void afficherEtat(Canard canard1, Canard canard2) {
        System.out.println("\nEtat des canards :");
        System.out.println(canard1.getNom() + " - PV: " + canard1.getPv() + ", Attaque : " + canard1.getPpAttaque()
                + " PP, Capacité spéciale : " + canard1.getPpCapacite() + " PP.");
        System.out.println(canard2.getNom() + " - PV: " + canard2.getPv() + ", Attaque : " + canard2.getPpAttaque()
                + " PP, Capacité spéciale : " + canard2.getPpCapacite() + " PP.");
        System.out.println("--------------------------");
    }
}