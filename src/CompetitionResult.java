import java.time.LocalDate;

public class CompetitionResult extends Result {
    private int placement;
    private String competitionName;

    public CompetitionResult(double time, LocalDate date, Discipline discipline, int placement, String competitionName, CompetitiveSwimmer swimmer) {
        super(time, date, discipline, swimmer);
        this.placement = placement;
        this.competitionName = competitionName;
    }

    public int getPlacement() { return placement; }
    public String getCompetitionName() { return competitionName; }
}