import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private List<Member> members;

    public Club() {
        members = new ArrayList<>();
        // Indsæt evt. lidt startdata (eksempeldata)
        loadInitialData();
    }

    private void loadInitialData() {
        members.add(new PassiveMember("Hans Jensen", 1, LocalDate.of(1985, 4, 12), "Strandvejen 14", "12345678", "hans@mail.com", LocalDate.of(2023, 1, 15)));
        members.add(new ActiveMember("Anna Hansen", 2, LocalDate.of(2008, 9, 22), "Bygaden 5", "87654321", "anna@mail.com", LocalDate.of(2022, 5, 10)));
        members.add(new CompetitiveSwimmer("Peter Nielsen", 3, LocalDate.of(2005, 11, 3), "Parkvej 8", "11223344", "peter@mail.com", LocalDate.of(2021, 8, 20), "Junior"));
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
    public double calculateTotalFee(LocalDate date) {
        double totalFee = 0;

        for (Member member : members) {
            totalFee += member.calculateFee(date);
        }

        return totalFee;
    }
}