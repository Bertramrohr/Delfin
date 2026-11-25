import java.time.LocalDate;

public class CompetitionResult extends Result {
    private int placement;
    private String competitionName;

    public CompetitionResult(int memberId, double time, LocalDate date,
                             Discipline discipline, int placement, String competitionName) {
        super(memberId, time, date, discipline);
        this.placement = placement;
        this.competitionName = competitionName;
    }

    public int getPlacement() { return placement; }
    public String getCompetitionName() { return competitionName; }

    @Override
    public String toCsv() {
        return "0";
    }
}