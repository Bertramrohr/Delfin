import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private List<Member> members;
    private List<Result> results;

    public Club() {
        members = new ArrayList<>();
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
        members.add(member);
    }

    public Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getMemberID() == id) {
                return m;
            }
        }
        return null;
    }

    public double calculateTotalFee() {
        double totalFee = 0;

        for (Member member : members) {
            totalFee += member.calculateFee();
        }

        return totalFee;
    }
}