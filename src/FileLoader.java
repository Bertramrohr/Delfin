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
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Member member = new Member(
                        fields[0].trim(),
                        Integer.parseInt(fields[1].trim()),
                        LocalDate.parse(fields[2].trim()),
                        fields[3].trim(),
                        fields[4].trim(),
                        fields[5].trim(),
                        LocalDate.parse(fields[6].trim()));
                members.add(member);
            }
        }
        return members;
    }
}
