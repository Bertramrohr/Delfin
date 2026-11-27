import java.time.LocalDate;

public abstract class Result {
    private double time; // Tid i sekunder (eller format efter eget valg)
    private LocalDate date;
    private Discipline discipline;
    private CompetitiveSwimmer swimmer;

    public Result(double time, LocalDate date, Discipline discipline, CompetitiveSwimmer swimmer) {

        this.time = time;
        this.date = date;
        this.discipline = discipline;
        this.swimmer = swimmer;

    }

    public double getTime() { return time; }
    public LocalDate getDate() { return date; }
    public Discipline getDiscipline() { return discipline; }
    public CompetitiveSwimmer getSwimmer() {
        return swimmer;
    }
}