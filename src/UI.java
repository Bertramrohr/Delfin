
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UI {

    private final Club club;

    public UI(Club club) {
        this.club = club;
    }

    public void run() throws IOException {

        boolean running = true;

        while (running) {
            showMenu();
            int choice = readInt("Vælg et nummer fra hovedmenuen: ");

            switch (choice) {
                case 1 -> chairmanMenu();
                case 2 -> cashierMenu();
                case 3 -> trainerMenu();
                case 4 -> running = false;
                default -> IO.println("Ugyldigt valg, indtast gyldigt tal.");
            }
        }

        IO.println("Tak for at besøge Svømmeklubben Delfinen!");
    }

    // HOVEDMENU
    private void showMenu() {
        IO.println("Velkommen til Svømmeklubben Delfinen");
        IO.println();
        IO.println("1. Formand");
        IO.println("2. Kasserer");
        IO.println("3. Træner");
        IO.println("4. Slut programmet");
        IO.println();
    }

    // ADMINISTRATORMENU
    private void chairmanMenu() throws IOException {

        boolean running = true;

        while (running) {
            IO.println("Menu for formand");
            IO.println();
            IO.println("1. Medlemskab");
            IO.println("0. Tilbage");

            int choice = readInt("Vælg et nummer fra menuen: ");

            switch (choice) {
                case 1 -> chairmanMembership();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    private void chairmanMembership() throws IOException {

        boolean running = true;

        while (running) {
            IO.println("Medlemskabsmenu");
            IO.println();
            IO.println("1. Se alle medlemmer");
            IO.println("2. Opret medlem");
            IO.println("3. Ændre medlemskab");
            IO.println("0. Tilbage");

            int choice = readInt("Vælg et nummer: ");

            switch (choice) {
                case 1 -> allMemberInfo();
                case 2 -> createMember();
                case 3 -> changeMembershipType();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    // KASSERERMENU
    private void cashierMenu() throws IOException {

        boolean running = true;

        while (running) {
            IO.println("Menu for kasserer");
            IO.println();
            IO.println("1. Ændre medlemskab");
            IO.println("2. Medlemmer i restance");
            IO.println("3. Data og information");
            IO.println("4. Økonomisk overblik");
            IO.println("0. Tilbage");
            IO.println();

            int choice = readInt("Vælg et nummer fra menuen: ");

            switch (choice) {
                case 1 -> changeMembershipType();
                case 2 -> showMembersInArrears();
                case 3 -> memberInformation();
                case 4 -> showFinancialOverview();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    // ØKONOMISK OVERBLIK
    private void showFinancialOverview() {

        IO.println("\n--- Økonomisk overblik ---");

        IO.println("Forventet årlig indkomst: "
                + club.calculateTotalFee() + " kr.");

        IO.println("Faktisk indbetalt: "
                + club.calculateCollectedIncome() + " kr.");

        IO.println("Samlet restance: "
                + club.calculateTotalArrears() + " kr.");
    }

    // VIS MEDLEMMER I RESTANCE
    private void showMembersInArrears() {

        IO.println("\n--- Medlemmer i restance ---");

        List<Member> membersInArrears =
                club.getMembersInArrears();

        if (membersInArrears.isEmpty()) {
            IO.println("Ingen medlemmer er i restance.");
            return;
        }

        for (Member member : membersInArrears) {

            IO.println("Navn: " + member.getName());
            IO.println("Medlemsnummer: " + member.getMemberID());
            IO.println("Skyldigt beløb: "
                    + member.getArrears() + " kr.");
            IO.println("-------------------------");
        }
    }

    // ADMINISTRATOR: DATA OG INFORMATION
    private void memberInformation() throws IOException {

        boolean running = true;

        while (running) {
            IO.println("\n--- Data og information ---");
            IO.println("1. Hold og træning");
            IO.println("2. Kontaktinformation");
            IO.println("3. Resultater");
            IO.println("0. Tilbage");

            int choice = readInt("Vælg et nummer: ");

            switch (choice) {
                case 1 -> information();
                case 2 -> allMemberInfo();
                case 3 -> seeAllResults();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    // TRÆNERMENU
    private void trainerMenu() throws IOException {

        boolean running = true;

        while (running) {
            IO.println("Menu for træner");
            IO.println("1. Søg i medlemmer (via medlemsnummer)");
            IO.println("2. Søg i hold");
            IO.println("3. Opret resultater");
            IO.println("4. Se alle resultater");
            IO.println("0. Tilbage");

            int choice = readInt("Vælg et nummer: ");

            switch (choice) {
                case 1 -> searchMemberById();
                case 2 -> information();
                case 3 -> createResults();
                case 4 -> seeAllResults();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }


    // VIS ALLE MEDLEMMERS INFORMATION
    private void allMemberInfo() throws IOException {

        FileLoader loader = new FileLoader();
        List<Member> loadMembers =
                loader.loadMembers("memberInfo.csv");

        for (Member member : loadMembers) {
            IO.println(
                    "Medlems navn: " + member.getName()
                            + "\nTlf: " + member.getPhoneNumber()
                            + "\nMedlems nummer: " + member.getMemberID()
                            + "\n"
            );
        }
    }

    // OPRET NYT MEDLEM
    private void createMember() throws IOException {

        IO.println("\n--- Opret nyt medlem ---");

        String name = IO.readln("Indtast navn: ");
        int id = readInt("Indtast medlemsnummer: ");
        LocalDate birthday =
                readDate("Indtast fødselsdato (yyyy-mm-dd): ");

        String address = IO.readln("Indtast din adresse: ");
        String phoneNumber = IO.readln("Indtast dit telefonnummer: ");
        String email = IO.readln("Indtast din Email: ");

        LocalDate signUpDate = LocalDate.now();

        IO.println("Vælg medlemstypen");
        IO.println("1. Aktivt medlem");
        IO.println("2. Passivt medlem");
        IO.println("3. Konkurrencesvømmer");
        IO.println("4. Motionist");

        int choice = readInt("Vælg medlemstype: ");

        Member member = null;

        switch (choice) {

            case 1 -> member = new ActiveMember(
                    name, id, birthday, address,
                    phoneNumber, email, signUpDate
            );

            case 2 -> member = new PassiveMember(
                    name, id, birthday, address,
                    phoneNumber, email, signUpDate
            );

            case 3 -> {

                CompetitiveSwimmer swimmer =
                        new CompetitiveSwimmer(
                                name, id, birthday, address,
                                phoneNumber, email, signUpDate
                        );

                String disciplines = IO.readln(
                        "Indtast discipliner (adskilt med komma): "
                );

                for (String discipline : disciplines.split(",")) {
                    if (!discipline.trim().isEmpty()) {
                        swimmer.addDiscipline(discipline.trim());
                    }
                }

                member = swimmer;
            }
            case 4 -> {
                member = new Exerciser(
                        name,
                        id,
                        birthday,
                        address,
                        phoneNumber,
                        email,
                        signUpDate);
            }


            default -> {
                IO.println("Ugyldigt valg, medlemmet blev ikke oprettet.");
                return;
            }
        }

        club.addMember(member);

        FileSaver saver = new FileSaver();
        saver.saveMembers(club.getMembers(), "memberInfo.csv");

        IO.println("Medlem oprettet!");
    }

    // ÆNDRE MEDLEMSKABSTYPE
    private void changeMembershipType() throws IOException {

        IO.println("\nÆndre medlemskabstypen");

        int id = readInt("Indtast medlemsnummeret: ");

        Member oldMemberInfo = club.findMemberById(id);

        if (oldMemberInfo == null) {
            IO.println("Medlemsnummer eksisterer ikke.");
            return;
        }

        IO.println("Nuværende medlemstype: "
                + oldMemberInfo.getMembershipType());

        IO.println("Vælg den nye medlemstype:");
        IO.println("1. Aktiv");
        IO.println("2. Passiv");
        IO.println("3. Konkurrencesvømmer");
        IO.println("4. Motionist");

        int newMembershipType =
                readInt("Vælg medlemstype (tal): ");

        Member newMembershipInfo;

        switch (newMembershipType) {

            case 1 -> newMembershipInfo = new ActiveMember(
                    oldMemberInfo.getName(),
                    oldMemberInfo.getMemberID(),
                    oldMemberInfo.getBirthday(),
                    oldMemberInfo.getAdress(),
                    oldMemberInfo.getPhoneNumber(),
                    oldMemberInfo.getEmail(),
                    oldMemberInfo.getSignUpDate()
            );

            case 2 -> newMembershipInfo = new PassiveMember(
                    oldMemberInfo.getName(),
                    oldMemberInfo.getMemberID(),
                    oldMemberInfo.getBirthday(),
                    oldMemberInfo.getAdress(),
                    oldMemberInfo.getPhoneNumber(),
                    oldMemberInfo.getEmail(),
                    oldMemberInfo.getSignUpDate()
            );

            case 3 -> newMembershipInfo = new CompetitiveSwimmer(
                    oldMemberInfo.getName(),
                    oldMemberInfo.getMemberID(),
                    oldMemberInfo.getBirthday(),
                    oldMemberInfo.getAdress(),
                    oldMemberInfo.getPhoneNumber(),
                    oldMemberInfo.getEmail(),
                    oldMemberInfo.getSignUpDate()
            );

            case 4 -> newMembershipInfo = new Exerciser(
                    oldMemberInfo.getName(),
                    oldMemberInfo.getMemberID(),
                    oldMemberInfo.getBirthday(),
                    oldMemberInfo.getAdress(),
                    oldMemberInfo.getPhoneNumber(),
                    oldMemberInfo.getEmail(),
                    oldMemberInfo.getSignUpDate()
            );

            default -> {
                IO.println("Ugyldigt valg.");
                return;
            }
        }

        // Behold den eksisterende betalingsstatus
        newMembershipInfo.setPaid(oldMemberInfo.isPaid());

        int index = club.getMembers().indexOf(oldMemberInfo);

        club.getMembers().set(index, newMembershipInfo);

        FileSaver saver = new FileSaver();
        saver.saveMembers(club.getMembers(), "memberInfo.csv");

        IO.println("Den nye medlemstype er ændret.");
    }

    // SØG MEDLEM EFTER ID
    private void searchMemberById() {

        int id = readInt("Indtast medlemsnummer der søges efter: ");

        Member member = club.findMemberById(id);

        if (member != null) {
            IO.println("\nMedlem fundet:");
            IO.println(member);
        } else {
            IO.println("Fandt intet medlem med medlemsnummer: " + id);
        }
    }

    // VIS RESULTATER
    private void seeAllResults() throws IOException {

        FileLoader loader = new FileLoader();

        List<Result> loadResults =
                loader.loadResults("swimmingResults.csv");

        for (Result result : loadResults) {
            IO.println(
                    "\nMedlems ID: " + result.getMemberId()
                            + "\nDisciplin: " + result.getDiscipline()
                            + "\nTid: " + result.getTime()
                            + "\n"
            );
        }
    }

    // OPRET RESULTATER
    private void createResults() throws IOException {

        IO.println("Opret resultater for svømmeren");
        IO.println("1. Opret træningsresultat");
        IO.println("2. Opret konkurrenceresultat");

        int resultChoice = readInt("Vælg resultattypen: ");

        int id = readInt("Indtast svømmerens medlemsnummer: ");

        Member member = club.findMemberById(id);

        if (member == null) {
            IO.println("Medlemmet findes ikke.");
            return;
        }

        IO.println("Medlemmet hvis tid du opretter: "
                + member.getName());

        String disciplineName =
                IO.readln("Indtast disciplinen: ");

        Discipline discipline = new Discipline(disciplineName);

        double resultTime = Double.parseDouble(
                IO.readln("Indtast tiden i sekunder: ")
        );

        LocalDate resultDate =
                readDate("Indtast datoen (yyyy-mm-dd): ");

        Result result;

        switch (resultChoice) {

            case 1 -> result = new TrainingResult(
                    id, resultTime, resultDate, discipline
            );

            case 2 -> {

                int placement = readInt("Indtast placering: ");
                String event = IO.readln("Indtast stævnet: ");

                result = new CompetitionResult(
                        id, resultTime, resultDate, discipline,
                        placement, event
                );
            }

            default -> {
                IO.println("Ugyldigt valg.");
                return;
            }
        }

        club.addResult(result);

        FileSaver saver = new FileSaver();
        saver.createResultsCsv(
                club.getResults(), "swimmingResults.csv"
        );

        IO.println("Resultatet for "
                + member.getName() + " er oprettet!");
        FileLoader loader = new FileLoader();
        List<Result> loadResults = loader.loadResults("swimmingResults.csv");
        for (Result result : loadResults) {
            IO.println("\n Medlems ID: " + result.getMemberId() + "\n" + "Disciplin: " + result.getDiscipline() + "\n" + "Tid: " + result.getTime() + "\n");
        }
    }


    private void createResults() throws IOException {

        IO.println("Opret resultater for svømmeren");
        IO.println("1. Opret træningsresultat");
        IO.println("2. Opret konkurrenceresultat");

        int resultChoice = readInt("Vælg resultattypen: ");

        // Find svømmeren
        int id = readInt("Indtast svømmerens medlemsnummer: ");


        Member member = club.findMemberById(id);

        IO.println("Medlemmet hvis tid du opretter: " + member.getName());

        if (member == null) {
            IO.println("Medlemmet findes ikke.");
            return;
        }

        // Fælles oplysninger
        String disciplineName = IO.readln("Indtast disciplinen: ");
        Discipline discipline = new Discipline(disciplineName);

        double resultTime = Double.parseDouble(
                IO.readln("Indtast tiden i sekunder: ")
        );

        LocalDate resultDate = readDate(
                "Indtast datoen (yyyy-mm-dd): "
        );

        Result result = null;

        switch (resultChoice) {

            case 1 -> {
                result = new TrainingResult(
                        id,
                        resultTime,
                        resultDate,
                        discipline
                );
            }

            case 2 -> {
                int placement = readInt("Indtast placering: ");
                String event = IO.readln("Indtast stævnet: ");

                result = new CompetitionResult(
                        id,
                        resultTime,
                        resultDate,
                        discipline,
                        placement,
                        event
                );
            }

            default -> {
                IO.println("Ugyldigt valg.");
                return;
            }
        }

        club.addResult(result);

        FileSaver saver = new FileSaver();
        saver.createResultsCsv(club.getResults(), "swimmingResults.csv");

        IO.println("Resultatet for " + member.getName() + " er oprettet!");
    }


    // VIS EGET MEDLEMSKAB OG INFORMATION
    private void membership() {
        // Her vises eget medlemskab, info og status.
    }

    // LÆS ET HELTAL FRA BRUGEREN
    private int readInt(String prompt) {

        while (true) {
            try {
                String input = IO.readln(prompt).trim();
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {
                IO.println("Ugyldig indtastning. Indtast et helt tal.");
            }
        }
    }

    private void information() {
    }

    // LÆS EN DATO
    private LocalDate readDate(String prompt) {

        while (true) {
            try {
                String input = IO.readln(prompt).trim();
                return LocalDate.parse(input);

            } catch (java.time.format.DateTimeParseException e) {
                IO.println("Ugyldig dato. Brug formatet yyyy-mm-dd.");
            }
        }
    }
}
