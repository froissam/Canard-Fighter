import java.util.Scanner;

public class Main {
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
                    break;
                case 2:
                    System.out.println("Lancement de la bataille");
                    break;
                case 3:
                    System.out.println("Merci d'avoir joué");
                    break;
            }
        }

        scanner.close();
    }
}