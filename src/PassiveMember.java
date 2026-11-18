import java.time.LocalDate;

public class PassiveMember extends Member {

    public PassiveMember(String name, int memberID, LocalDate birthday, String address,
                         String phoneNumber, String email, LocalDate signUpDate) {
        super(name, memberID, birthday, address, phoneNumber, email, signUpDate);
    }

    public double calculateFee(LocalDate date) {
        // Kontingent for passivt medlemskab er 500 kr. årligt
        return 500.0;
    }
}
