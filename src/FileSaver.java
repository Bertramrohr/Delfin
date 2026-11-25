import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileSaver {

    private String delimiter = "; ";

    public void saveMembers(List<Member> members, String memberInfo) throws IOException {
        Path path = Path.of(memberInfo);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                String disciplines = "";
                if (member instanceof CompetitiveSwimmer swimmer) {
                    disciplines = String.join(
                            ",",
                            swimmer.getDisciplines()
                    );
                }
                writer.write(member.getName() + delimiter
                        + member.getMemberID() + delimiter
                        + member.getBirthday() + delimiter
                        + member.getAdress() + delimiter
                        + member.getPhoneNumber() + delimiter
                        + member.getEmail() + delimiter
                        + member.getSignUpDate() + delimiter
                        + member.getMembershipType() + delimiter
                        + disciplines
                );

                writer.newLine();
            }
        }
    }


    public void createResultsCsv(List<Result> results, String swimmingResults) throws IOException {
        Path path = Path.of(swimmingResults);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("medlemsId,type,time,date,placement,event");
            writer.newLine();
            for (Result result : results) {
                writer.write(result.toCsv());
                writer.newLine();
            }
        }
    }



}
