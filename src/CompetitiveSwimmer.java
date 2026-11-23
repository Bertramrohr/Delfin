import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitiveSwimmer extends ActiveMember {

    private List<String> disciplines;

    public CompetitiveSwimmer(String name, int memberID, LocalDate birthday, String address,
                              String phoneNumber, String email, LocalDate signUpDate, String membershipType) {
        super(name, memberID, birthday, address, phoneNumber, email, signUpDate, membershipType);

        this.disciplines = new ArrayList<>();
    }

    @Override
    public String getMembershipType() {
        return "COMPETITIVE";
    }

    public List<String> getDisciplines() {
        return disciplines;
    }

    public void addDiscipline(String discipline) {
        disciplines.add(discipline);
    }
}