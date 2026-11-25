import java.time.LocalDate;

public abstract class Result {
    private double time; // Tid i sekunder (eller format efter eget valg)
    private LocalDate date;
    private Discipline discipline;

    public Result(double time, LocalDate date, Discipline discipline) {
        this.time = time;
        this.date = date;
        this.discipline = discipline;
    }

    public double getTime() { return time; }
    public LocalDate getDate() { return date; }
    public Discipline getDiscipline() { return discipline; }

    public abstract int toCsv();
}