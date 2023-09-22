import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class UserInterface {
    private Database database;
    private Scanner scanner;

    public UserInterface() {
        database = new Database();
        scanner = new Scanner(System.in);
    }

    public void startProgram() {
        while (true) {
            System.out.println("Velkommen til SUPERHERO UNIVERSET.");
            System.out.println("1. Opret superhelt");
            System.out.println("2. Vis liste over superhelte");
            System.out.println("3. Søg efter superhelt");
            System.out.println("4. Rediger superhelt");
            System.out.println("9. Afslut");
            System.out.print("Vælg en handling: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        createSuperhero();
                        break;
                    case 2:
                        listSuperheroes();
                        break;
                    case 3:
                        searchSuperhero();
                        break;
                    case 4:
                        editSuperhero();
                        break;
                    case 9:
                        System.out.println("Programmet afsluttes.");
                        return;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ugyldigt input. Indtast en gyldig handling (1, 2, 3, 4 eller 9).");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private void createSuperhero() {
        System.out.print("Indtast navn på superhelten: ");
        String name = scanner.nextLine();
        System.out.print("Indtast superheltnavn: ");
        String superheroName = scanner.nextLine();
        // Fortsæt med at indtaste de øvrige oplysninger om superhelten
        System.out.print("Er helten et menneske (ja/nej): ");
        boolean isHuman = scanner.nextLine().equalsIgnoreCase("ja");
        System.out.print("Indtast superkraft: ");
        String superpower = scanner.nextLine();

        int creationYear = 0;
        double strength = 0.0;

        boolean validCreationYear = false;
        while (!validCreationYear) {
            try {
                System.out.print("Indtast skabelsesår: ");
                creationYear = scanner.nextInt();
                validCreationYear = true;
            } catch (InputMismatchException e) {
                System.out.println("Ugyldigt skabelsesår. Indtast et heltal.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        boolean validStrength = false;
        while (!validStrength) {
            try {
                System.out.print("Indtast styrke: ");
                strength = scanner.nextDouble();
                validStrength = true;
            } catch (InputMismatchException e) {
                System.out.println("Ugyldig styrke. Indtast et tal.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        Superhero newSuperhero = new Superhero(name, superheroName, isHuman, superpower, creationYear, strength);
        database.addSuperhero(newSuperhero);
        System.out.println("Superhelten er blevet oprettet.");
    }

    private void listSuperheroes() {
        database.listSuperheroes();
    }

    private void searchSuperhero() {
        System.out.print("Indtast søgekriterium (superheltnavn eller del af navnet): ");
        String searchCriteria = scanner.nextLine();
        List<Superhero> searchResults = database.searchSuperhero(searchCriteria);

        if (!searchResults.isEmpty()) {
            System.out.println("Fundne superhelte:");
            for (Superhero superhero : searchResults) {
                displaySuperheroInfo(superhero);
            }
        } else {
            System.out.println("Ingen superhelte fundet med søgekriteriet: " + searchCriteria);
        }
    }

    private void editSuperhero() {
        System.out.print("Indtast superheltnavn eller en unik identifikator for superhelten, du vil redigere: ");
        String searchCriteria = scanner.nextLine();

        Superhero superheroToEdit = database.findSuperhero(searchCriteria);

        if (superheroToEdit != null) {
            displaySuperheroInfo(superheroToEdit);

            System.out.print("Indtast nyt navn: ");
            String newName = scanner.nextLine();
            superheroToEdit.setName(newName);

            System.out.print("Indtast nyt superheltnavn: ");
            String newSuperheroName = scanner.nextLine();
            superheroToEdit.setSuperheroName(newSuperheroName);

            System.out.print("Er helten stadig et menneske (ja/nej): ");
            boolean isHuman = scanner.nextLine().equalsIgnoreCase("ja");
            superheroToEdit.setHuman(isHuman);

            System.out.print("Indtast ny superkraft: ");
            String newSuperpower = scanner.nextLine();
            superheroToEdit.setSuperpower(newSuperpower);

            boolean validCreationYear = false;
            while (!validCreationYear) {
                try {
                    System.out.print("Indtast nyt skabelsesår: ");
                    int newCreationYear = scanner.nextInt();
                    superheroToEdit.setCreationYear(newCreationYear);
                    validCreationYear = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ugyldigt skabelsesår. Indtast et heltal.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }

            boolean validStrength = false;
            while (!validStrength) {
                try {
                    System.out.print("Indtast ny styrke: ");
                    double newStrength = scanner.nextDouble();
                    superheroToEdit.setStrength(newStrength);
                    validStrength = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ugyldig styrke. Indtast et tal.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }

            System.out.println("Superhelten er blevet opdateret.");
        } else {
            System.out.println("Superhelten blev ikke fundet i databasen.");
        }
    }

    private void displaySuperheroInfo(Superhero superhero) {
        System.out.println("Detaljer for superhelten:");
        System.out.println("Navn: " + superhero.getName());
        System.out.println("Superheltenavn: " + superhero.getSuperheroName());
        System.out.println("Er helten et menneske: " + (superhero.isHuman() ? "Ja" : "Nej"));
        System.out.println("Superkraft: " + superhero.getSuperpower());
        System.out.println("Skabelsesår: " + superhero.getCreationYear());
        System.out.println("Styrke: " + superhero.getStrength());
    }
}