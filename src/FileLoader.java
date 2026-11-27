import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
    public List<Result> loadResultsByMemberId(String swimmingResults, int targetMemberId) throws IOException {
        List<Result> memberResults = new ArrayList<>();
        Path path = Path.of(swimmingResults);

        if (!Files.exists(path)) {
            return memberResults;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.isBlank()) {
                    continue;
                }

                // Spring evt. header-linje over, hvis filen har en
                if (lineNumber == 1 && line.toLowerCase().contains("memberid")) {
                    continue;
                }

                String[] fields = line.split(";", -1);
                if (fields.length < 5) {
                    IO.println("Ugyldigt antal felter i results på linje " + lineNumber);
                    continue;
                }

                try {
                    int memberId = Integer.parseInt(fields[0].trim());
                    if (memberId != targetMemberId) {
                        continue;
                    }

                    String type = fields[1].trim().toUpperCase(); // "TRAINING" eller "COMPETITION"
                    Discipline discipline = new Discipline(fields[2].trim());
                    double time = Double.parseDouble(fields[3].trim().replace(",", "."));
                    LocalDate date = LocalDate.parse(fields[4].trim());

                    if ("COMPETITION".equals(type) && fields.length >= 7) {
                        int placement = Integer.parseInt(fields[5].trim());
                        String competitionName = fields[6].trim();
                        memberResults.add(new CompetitionResult(memberId ,time, date, discipline, placement, competitionName));
                    } else {
                        memberResults.add(new TrainingResult(memberId,time, date, discipline));
                    }

                } catch (NumberFormatException | java.time.DateTimeException e) {
                    IO.println("Ugyldige resultatdata på linje " + lineNumber + ". Linjen springes over.");
                }
            }
        }

        // Valgfrit: sortér efter hurtigste tid (laveste double først)
        memberResults.sort(Comparator.comparingDouble(Result::getTime));
        return memberResults;
    }



    public List<Result> loadResults(String swimmingResults) throws IOException {
        List<Result> results = new ArrayList<>();

        Path path = Path.of(swimmingResults);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            // Spring CSV-headeren over
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",", -1);

                int memberId = Integer.parseInt(fields[0].trim());
                String type = fields[1].trim();
                double time = Double.parseDouble(fields[2].trim());
                LocalDate date = LocalDate.parse(fields[3].trim());
                String disciplineName = fields[4].trim();

                Discipline discipline = new Discipline(disciplineName);

                if (type.equals("TRAINING")) {
                    results.add(new TrainingResult(
                            memberId, time, date, discipline));
                }

                else if (type.equals("COMPETITION")) {
                    int placement = Integer.parseInt(fields[5].trim());
                    String competitionName = fields[6].trim();

                    results.add(new CompetitionResult(
                            memberId, time, date, discipline,
                            placement, competitionName));
                }
            }
        }

        return results;
    }
}