public class Superhero {
    private String name;
    private String superheroName;
    private boolean human;
    private String superpower;
    private int creationYear;
    private double strength;

    public Superhero(String name, String superheroName, boolean human, String superpower, int creationYear, double strength) {
        this.name = name;
        this.superheroName = superheroName;
        this.human = human;
        this.superpower = superpower;
        this.creationYear = creationYear;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
}