import java.time.LocalDate;

public class PassiveMember extends Member {

    public PassiveMember(String name, int memberID, LocalDate birthday, String address,
                         String phoneNumber, String email, LocalDate signUpDate) {
        super(name, memberID, birthday, address, phoneNumber, email, signUpDate);
    }

    @Override
    public double calculateFee(int age) {
        return 500.0;
    }

    @Override
    public String getMembershipType() {
        return "PASSIVE";
    }
}