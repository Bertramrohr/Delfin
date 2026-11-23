import java.time.LocalDate;
import java.time.Period;

public class ActiveMember extends Member {
    private boolean isJunior; // eller beregnet ud fra alder

    public ActiveMember(String name, int memberID, LocalDate birthday, String address,
                        String phoneNumber, String email, LocalDate signUpDate, String membershipType) {
        super(name, memberID, birthday, address, phoneNumber, email, signUpDate, membershipType);
    }


    @Override
    public double pay(){
        return calculateFee(LocalDate.now());
    }

    public double calculateFee(LocalDate date) {
        int age = Period.between(getBirthday(), date).getYears();

        if (age < 18) {
            return 1000.0;
        } else if (age >= 60) {
            return 1600.0 * 0.75; // 1200 kr.
        } else {
            return 1600.0;
        }
    }
        @Override
        public String getMembershipType() {
            return "ACTIVE";
    }
}