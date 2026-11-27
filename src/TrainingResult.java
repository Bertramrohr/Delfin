import java.time.LocalDate;

public class TrainingResult extends Result {
    public TrainingResult(int memberId, double time, LocalDate date, Discipline discipline) {
        super(memberId, time, date, discipline);
    }

    @Override
    public String toCsv() {
        return getMemberId() + "," +
                "TRAINING" + "," +
                getTime() + "," +
                getDate() + "," +
                getDiscipline().getName() + "," +
                "," +
                "";
    }
}


