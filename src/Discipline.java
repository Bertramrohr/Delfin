public class Discipline {
    private String name; // F.eks. "Crawl", "Butterfly", etc.

    public Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}