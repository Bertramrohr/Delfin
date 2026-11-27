import java.time.LocalDate;

public class TrainingResult extends Result {

    public TrainingResult(double time, LocalDate date, Discipline discipline, CompetitiveSwimmer swimmer) {
        super(time, date, discipline, swimmer);
    }
}