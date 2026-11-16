import java.time.LocalDate;
import java.time.Period;

public class ActiveMember extends Member {
    private boolean isJunior; // eller beregnet ud fra alder

    public ActiveMember(String name, int memberID, LocalDate birthday, String address,
                        String phoneNumber, String email, LocalDate signUpDate) {
        super(name, memberID, birthday, address, phoneNumber, email, signUpDate);
    }

    public double calculateFee(LocalDate date) {
        int age = Period.between(getBirthday(), date).getYears();

        // Kontingentregler fra casen:
        // Under 18 år: 1000 kr.
        // 18 år og derover: 1600 kr.
        // Over 60 år: 25% rabat af seniortaksten (1600 * 0.75 = 1200 kr.)
        if (age < 18) {
            return 1000.0;
        } else if (age >= 60) {
            return 1600.0 * 0.75; // 1200 kr.
        } else {
            return 1600.0;
        }
    }
}