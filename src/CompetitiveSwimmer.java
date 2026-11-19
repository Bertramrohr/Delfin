import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitiveSwimmer extends ActiveMember {

    private String team;
    private List<String> disciplines;

    public CompetitiveSwimmer(String name, int memberID, LocalDate birthday, String address,
                              String phoneNumber, String email, LocalDate signUpDate, String team, String membershipType) {
        super(name, memberID, birthday, address, phoneNumber, email, signUpDate, membershipType);
        this.team = team;
        this.disciplines = new ArrayList<>();
    }

    @Override
    public String getMembershipType() {
        return "COMPETITIVE";
    }

    public String getTeam() {
        return team;
    }

    public List<String> getDisciplines() {
        return disciplines;
    }

    public void addDiscipline(String discipline) {
        disciplines.add(discipline);
    }
}