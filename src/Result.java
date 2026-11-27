import java.time.LocalDate;

public abstract class Result {
    private int memberId;
    private double time; // Tid i sekunder (eller format efter eget valg)
    private LocalDate date;
    private Discipline discipline;


    public Result(int memberId, double time, LocalDate date, Discipline discipline) {
        this.memberId = memberId;
        this.time = time;
        this.date = date;
        this.discipline = discipline;

    }

    public double getTime() {
        return time;
    }



    public LocalDate getDate() {
        return date;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public int getMemberId() {
        return memberId;
    }


    public abstract String toCsv();}