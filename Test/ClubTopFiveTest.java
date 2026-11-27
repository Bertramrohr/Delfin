import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClubTopFiveTest {

    private final LocalDate date = LocalDate.of(2026, 11, 27);

    private CompetitiveSwimmer createSwimmer(
            String name, int id, int age) {

        return new CompetitiveSwimmer(
                name,
                id,
                date.minusYears(age),
                "Testvej 1",
                "12345678",
                "test@mail.dk",
                date
        );
    }

    @Test
    void returnsFiveFastestInCorrectOrder() {
        Club club = new Club();
        Discipline crawl = new Discipline("Crawl");

        for (int i = 1; i <= 6; i++) {
            CompetitiveSwimmer swimmer =
                    createSwimmer("Swimmer " + i, i, 16);

            club.addResult(new TrainingResult(
                    40 - i, date, crawl, swimmer));
        }

        List<Result> topFive =
                club.getTopFive("Crawl", true, date);

        assertEquals(5, topFive.size());

        for (int i = 0; i < 5; i++) {
            assertEquals(6 - i,
                    topFive.get(i).getSwimmer().getMemberID());

            assertEquals(34.0 + i,
                    topFive.get(i).getTime(), 0.001);
        }
    }

    @Test
    void separatesJuniorAndSeniorAtAgeEighteen() {
        Club club = new Club();
        Discipline crawl = new Discipline("Crawl");

        CompetitiveSwimmer junior =
                createSwimmer("Junior", 1, 17);

        CompetitiveSwimmer senior =
                createSwimmer("Senior", 2, 18);

        club.addResult(new TrainingResult(
                30, date, crawl, junior));

        club.addResult(new TrainingResult(
                28, date, crawl, senior));

        List<Result> juniors =
                club.getTopFive("Crawl", true, date);

        List<Result> seniors =
                club.getTopFive("Crawl", false, date);

        assertEquals(1, juniors.size());
        assertEquals(1, seniors.size());

        assertSame(junior, juniors.get(0).getSwimmer());
        assertSame(senior, seniors.get(0).getSwimmer());
    }

    @Test
    void returnsAvailableSwimmersWhenFewerThanFive() {
        Club club = new Club();
        Discipline crawl = new Discipline("Crawl");

        CompetitiveSwimmer swimmer =
                createSwimmer("Anna", 1, 16);

        club.addResult(new TrainingResult(
                29, date, crawl, swimmer));

        List<Result> topFive =
                club.getTopFive("Crawl", true, date);

        assertEquals(1, topFive.size());
        assertSame(swimmer, topFive.get(0).getSwimmer());
    }

    @Test
    void onlyUsesBestTimePerSwimmerAndChosenDiscipline() {
        Club club = new Club();

        CompetitiveSwimmer swimmer =
                createSwimmer("Anna", 1, 16);

        club.addResult(new TrainingResult(
                30, date, new Discipline("Crawl"), swimmer));

        club.addResult(new TrainingResult(
                28, date, new Discipline("Crawl"), swimmer));

        club.addResult(new TrainingResult(
                20, date, new Discipline("Butterfly"), swimmer));

        List<Result> topFive =
                club.getTopFive("Crawl", true, date);

        assertEquals(1, topFive.size());
        assertEquals(28.0, topFive.get(0).getTime(), 0.001);
    }

    @Test
    void returnsEmptyListWhenNoResultsExist() {
        Club club = new Club();

        List<Result> topFive =
                club.getTopFive("Crawl", true, date);

        assertTrue(topFive.isEmpty());
    }
}
