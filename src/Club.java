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

    public double calculateTotalFee() {

        double total = 0;

        for (Member member : members) {
            total += member.calculateFee();
        }

        return total;
    }

    public void addResult(Result result) {
        results.add(result);
    }

    public List<Result> getResults() {
        return results;
    }
}