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
    final String membershipType;


    public Member(String name, int memberID, LocalDate birthday, String adress,
                  String phoneNumber, String email, LocalDate signUpDate, String membershipType) {

        this.name = name;
        this.memberID = memberID;
        this.birthday = birthday;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.signUpDate = signUpDate;
        this.membershipType = membershipType;
    }

    public double pay(){
        return 0.0;
    }

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
                
                """, name, memberID, birthday, adress, phoneNumber, email, signUpDate, membershipType);
    }


    public abstract double calculateFee();

    public abstract String getMembershipType();

    public int calculateAge(LocalDate date){
        return Period.between(getBirthday(), date).getYears();
    }

}
