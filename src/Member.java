
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
    private boolean paid;

    public Member(String name, int memberID, LocalDate birthday, String adress,
                  String phoneNumber, String email, LocalDate signUpDate) {

        this.name = name;
        this.memberID = memberID;
        this.birthday = birthday;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.signUpDate = signUpDate;
        this.paid = false;
    }

    // Medlemsalder på en bestemt dato
    public int calculateAge(LocalDate date) {
        return Period.between(getBirthday(), date).getYears();
    }

    // Medlemsalder ud fra dags dato
    public int calculateAge() {
        return calculateAge(LocalDate.now());
    }

    // Kontingentberegning
    public abstract double calculateFee(int age);

    // Beregner kontingent ud fra medlemmets nuværende alder
    public double calculateFee() {
        return calculateFee(calculateAge());
    }

    // Beregner restance på en bestemt dato
    public double getArrears(LocalDate date) {
        if (paid) {
            return 0.0;
        }

        return calculateFee(calculateAge(date));
    }

    // Beregner restance ud fra dags dato
    public double getArrears() {
        return getArrears(LocalDate.now());
    }

    // Betalingsstatus
    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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

    // ToString
    @Override
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
                Betalt: %s

                """, name, memberID, birthday, adress, phoneNumber,
                email, signUpDate, getMembershipType(), paid);
    }
}
