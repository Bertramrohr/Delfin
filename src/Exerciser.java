import java.time.LocalDate;
import java.util.ArrayList;

public class Exerciser extends ActiveMember {


    public Exerciser(String name, int memberID, LocalDate birthday, String address,
                              String phoneNumber, String email, LocalDate signUpDate) {
        super(name, memberID, birthday, address, phoneNumber, email, signUpDate);

    }

    @Override
    public String getMembershipType() {
        return "EXERCISER";
    }

}
