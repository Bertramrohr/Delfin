import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberCalculatefeeTest {

    @Test
    void testCalculateTotalFeeForDifferentMemberTypes() {

        // Arrange
        Club club = new Club();

        // Act
        double totalFee = club.calculateTotalFee(
                LocalDate.of(2026, 11, 19));

        // Assert
        assertEquals(3100.0, totalFee);
    }
}
