import java.time.LocalDate;
import java.time.Period;


public abstract class Member {
    final String name;
    final int memberID;
    final LocalDate birthday;
    final String adress;
    final String phoneNumber;
    final String email;
    final LocalDate signUpDate;

    public Member(String name, int memberID, LocalDate birthday, String adress,
                  String phoneNumber, String email, LocalDate signUpDate) {

        this.name = name;
        this.memberID = memberID;
        this.birthday = birthday;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.signUpDate = signUpDate;
    }

    // til kontingent beregning
    public abstract double calculateFee(LocalDate date);

    // Betaling med dags dato
    public double pay() {
        return calculateFee(LocalDate.now());
    }

    // Medlemsalder
    public int calculateAge(LocalDate date) {
        return Period.between(getBirthday(), date).getYears();
    }

    // Medlemstype
    public abstract String getMembershipType();

    // Getters
    public String getName() {
        return name;
    }

    public int getMemberID() {
        return memberID;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getSignUpDate() {
        return signUpDate;
    }

    //To-String
    public String toString() {
        return String.format("""
                Navn: %s
                Medlemsnummer: %s
                Fødselsdag: %s
                Adresse: %s
                Tlf: %s
                Email: %s
                Oprettelses Dato: %s
                Status: %s
                
                """, name, memberID, birthday, adress, phoneNumber, email, signUpDate, getMembershipType());
    }
}
