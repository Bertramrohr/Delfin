import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private List<Member> members;
    private List<Result> results;

    public Club() {
        members = new ArrayList<>();
        results = new ArrayList<>();

        FileLoader fileLoader = new FileLoader();

        try {
            members = fileLoader.loadMembers("memberInfo.csv");
        } catch (IOException e) {
            IO.println("Kunne ikke indlæse medlemmer: " + e.getMessage());
        }

        results = new ArrayList<>();

        try {
            results = fileLoader.loadResults("swimmingResults.csv");
        } catch (IOException e) {
            IO.println("Kunne ikke indlæse resultater: " + e.getMessage());
        }
    }


    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        if (member != null) {
            members.add(member);
        }
    }


    public Member findMemberById(int id) {

        for (Member member : members) {
            if (member.getMemberID() == id) {
                return member;
            }
        }

        return null;
    }

    // Samlet forventet årlig indkomst fra alle medlemmer
    public double calculateTotalFee() {
        double total = 0;

        for (Member member : members) {
            total += member.calculateFee();
        }

        return total;
    }

    // Tilføjer et resultat til klubbens resultatliste.
    public void addResult(Result result) {
        if (result != null) {
            results.add(result);
        }
    }

    // Finder højst fem svømmere i den valgte aldersgruppe.
    public List<Result> getTopFive(String disciplineName, boolean junior,
                                   LocalDate date) {
        List<Result> bestResults = new ArrayList<>();

        for (Result result : results) {
            CompetitiveSwimmer swimmer = result.getSwimmer();

            boolean correctDiscipline = result.getDiscipline()
                    .getName().equalsIgnoreCase(disciplineName);

            boolean swimmerIsJunior = swimmer.calculateAge(date) < 18;

            if (correctDiscipline && swimmerIsJunior == junior) {
                int existingIndex = -1;

                // Find ud af, om svømmeren allerede er med.
                for (int i = 0; i < bestResults.size(); i++) {
                    if (bestResults.get(i).getSwimmer().getMemberID()
                            == swimmer.getMemberID()) {
                        existingIndex = i;
                        break;
                    }
                }

                if (existingIndex == -1) {
                    bestResults.add(result);
                } else if (result.getTime()
                        < bestResults.get(existingIndex).getTime()) {
                    // Behold kun svømmerens hurtigste tid.
                    bestResults.set(existingIndex, result);
                }
            }
        }

        // Sortér med den hurtigste tid først.
        bestResults.sort(new ResultTimeComparator());

        List<Result> topFive = new ArrayList<>();

        // Tag højst fem resultater fra den sorterede liste.
        for (int i = 0; i < bestResults.size() && i < 5; i++) {
            topFive.add(bestResults.get(i));
        }

        return topFive;
    // Samlet faktisk indbetalt kontingent
    public double calculateCollectedIncome() {
        double total = 0;

        for (Member member : members) {
            if (member.isPaid()) {
                total += member.calculateFee();
            }
        }

        return total;
    }

    // Samlet restanceværdi
    public double calculateTotalArrears() {
        double total = 0;

        for (Member member : members) {
            total += member.getArrears();
        }

        return total;
    }

    // Find alle medlemmer, der ikke har betalt
    public List<Member> getMembersInArrears() {
        List<Member> membersInArrears = new ArrayList<>();

        for (Member member : members) {
            if (!member.isPaid()) {
                membersInArrears.add(member);
            }
        }

        return membersInArrears;
    }

    public void addResult(Result result) {
        results.add(result);
    }

    public List<Result> getResults() {
        return results;
    }
}