import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileSaver {

    private String delimiter = ", ";

    public void saveMembers(List<Member> members, String memberInfo) throws IOException {
        Path path = Path.of(memberInfo);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(member.getName() + delimiter
                        + member.getMemberID() + delimiter
                        + member.getBirthday() + delimiter
                        + member.getAdress() + delimiter
                        + member.getPhoneNumber() + delimiter
                        + member.getEmail() + delimiter
                        + member.getSignUpDate());
                        + member.getMembershipType());
                writer.newLine();
            }
        }
    }
}
