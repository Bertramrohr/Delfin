import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public List<Member> loadMembers(String memberInfo) throws IOException {
        List<Member> members = new ArrayList<>();
        Path path = Path.of(memberInfo);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.isBlank()) {
                    continue;
                }


                try {
                    String[] fields = line.split(";", -1);

                    if (fields.length != 8 && fields.length != 9) {
                        IO.println("Ugyldigt antal felter på linje " + lineNumber);
                        continue;
                    }

                    String name = fields[0].trim();
                    int memberID = Integer.parseInt(fields[1].trim());
                    LocalDate birthday = LocalDate.parse(fields[2].trim());
                    String address = fields[3].trim();
                    String phoneNumber = fields[4].trim();
                    String email = fields[5].trim();
                    LocalDate signUpDate = LocalDate.parse(fields[6].trim());
                    String membershipType = fields[7].trim().toUpperCase();

                    Member member;

                    switch (membershipType) {
                        case "PASSIVE" -> member = new PassiveMember(
                                name, memberID, birthday, address,
                                phoneNumber, email, signUpDate);

                        case "ACTIVE" -> member = new ActiveMember(
                                name, memberID, birthday, address,
                                phoneNumber, email, signUpDate);

                        case "COMPETITIVE" -> member = new CompetitiveSwimmer(
                                name, memberID, birthday, address,
                                phoneNumber, email, signUpDate);

                        case "EXERCISER" -> member = new Exerciser(
                                name, memberID, birthday, address,
                                phoneNumber, email, signUpDate);

                        default -> {
                            IO.println("Ukendt medlemstype på linje "
                                    + lineNumber + ": " + membershipType);
                            continue;
                        }
                    }

                    members.add(member);

                } catch (NumberFormatException | java.time.DateTimeException e) {
                    System.out.println("Ugyldige medlemsdata på linje " + lineNumber
                            + ". Linjen springes over.");
                }
            }
        }

        return members;
    }
}