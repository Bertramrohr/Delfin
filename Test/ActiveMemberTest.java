import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ActiveMemberTest {
    @Test
    void testJuniorFee() {
        //Arrange
        ActiveMember member = new ActiveMember(
                "Emma Jensen",
                112,
                LocalDate.of(2012, 5, 10),
                "København",
                "12345678",
                "emma@gmail.com",
                LocalDate.of(2026, 9, 17),
                "ACTIIVE");
        //Act
        double fee = member.calculateFee(LocalDate.now());

        //Assert
        assertEquals(1000.0, fee);
    }

    @Test
    void testAdultFee() {
        //Arrange
        ActiveMember member = new ActiveMember(
                "Rasmus Hansen",
                111,
                LocalDate.of(2001, 2, 15),
                "Albertslund",
                "53648391",
                "rasmus@gmail.com",
                LocalDate.of(2026, 9, 17),
                "ACTIVE");

        //ACt
        double fee = member.calculateFee(LocalDate.now());

        //Assert
        assertEquals(1600.0, fee);

    }

    @Test
    void testSeniorFee() {
        //Arrange
        ActiveMember member = new ActiveMember(
                "Peter Nielsen",
                113,
                LocalDate.of(1960, 3, 20),
                "Roskilde",
                "87654321",
                "peter@gmail.com",
                LocalDate.of(2026, 9, 17),
                "ACTIVE");
        //ACT
        double fee = member.calculateFee(LocalDate.now());

        //Assert
        assertEquals(1200.0, fee);

    }

    @Test
    void testSenior60() {
        //Arrange
        ActiveMember member = new ActiveMember(
                "Peter Nielsen",
                113,
                LocalDate.of(1966, 10, 16),
                "Roskilde",
                "87654321",
                "peter@gmail.com",
                LocalDate.of(2026, 9, 17),
                "ACTIVE");
        //ACT
        double fee = member.calculateFee(LocalDate.now());

        //Assert
        assertEquals(1200.0, fee);

    }


}
