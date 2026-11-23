import java.time.LocalDate;

public class PassiveMember extends Member {

    public PassiveMember(String name, int memberID, LocalDate birthday, String address,
                         String phoneNumber, String email, LocalDate signUpDate, String membershipType) {
        super(name, memberID, birthday, address, phoneNumber, email, signUpDate, membershipType);
    }

    @Override
    public double pay(){
        return calculateFee(LocalDate.now());
    }

    @Override
    public double calculateFee(LocalDate date) {
        return 500.0;
    }

    @Override
    public String getMembershipType() {
        return "PASSIVE";
    }
}