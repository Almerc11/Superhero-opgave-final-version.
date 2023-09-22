import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Superhero> superheroes;

    public Database() {
        superheroes = new ArrayList<>();
    }

    // Tilføj en superhelt til databasen
    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
    }

    // Søg efter en superhelt baseret på superheltnavn eller del af navnet
    public List<Superhero> searchSuperhero(String searchCriteria) {
        List<Superhero> searchResults = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            // Sammenlign superheltnavnet (du kan ændre dette til at søge i andre attributter)
            if (superhero.getSuperheroName().toLowerCase().contains(searchCriteria.toLowerCase())) {
                searchResults.add(superhero);
            }
        }
        return searchResults;
    }

    // Find en superhelt baseret på unik identifikator (f.eks. navn)
    public Superhero findSuperhero(String searchCriteria) {
        for (Superhero superhero : superheroes) {
            // Sammenlign unik identifikator (f.eks. navn)
            if (superhero.getSuperheroName().equalsIgnoreCase(searchCriteria)) {
                return superhero;
            }
        }
        return null; // Returner null, hvis superhelten ikke blev fundet
    }

    // Vis en liste over alle superhelte i databasen
    public void listSuperheroes() {
        System.out.println("Liste over superhelte:");
        for (Superhero superhero : superheroes) {
            System.out.println(superhero.getName() + " (" + superhero.getSuperheroName() + ")");
        }
    }
}