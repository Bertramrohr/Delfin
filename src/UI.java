
public class UI {

    private final Club club;

    public UI(Club club) {
        this.club = club;
    }


    public void run() {

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
    private void chairmanMenu() {

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

    private void chairmanMembership() {

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
                case 3 -> IO.println("Funktion til at ændre medlemskab kommer snart.");
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    private void cashierMenu() {

        boolean running = true;
        while (running) {
            IO.println("Menu for kasserer");
            IO.println();
            IO.println("1. Medlemskab");
            IO.println("2. Medlemmer i restance");
            IO.println("3. Data og information");
            IO.println("0. Tilbage");
            IO.println();

            int choice = readInt("Vælg et nummer fra menuen: ");

            switch (choice) {
                case 1 -> {
                    // Kunne finde medlemmet kontingent og info
                }
                case 2 -> {
                    // Kunne finde liste over medlemmer i restance
                }
                case 3 -> memberInformation();
                case 0 -> running = false;

                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    // ADMINISTRATOR: DATA OG INFORMATION
    private void memberInformation() {

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
                case 2 -> allMemberInfo(); // Genbruger evt. til kontaktinfo
                case 3 -> results();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    // KUNDE / MEDLEMSMENU
    private void trainerMenu() {

        boolean running = true;
        while (running) {
            IO.println("Menu for træner");
            IO.println("1. Søg i medlemmer (via medlemsnummer)");
            IO.println("2. Søg i hold");
            IO.println("3. Søg i resultater");
            IO.println("0. Tilbage");

            int choice = readInt("Vælg et nummer: ");
            switch (choice) {
                case 1 -> membership();
                case 2 -> information();
                case 3 -> results();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    // VIS ALLE MEDLEMMERS INFORMATION
    private void allMemberInfo() {
        // Her vises alle medlemmers info og status.
    }

    // OPRET NYT MEDLEM (Eksempel)
    private void createMember() {
        IO.println("\n--- Opret nyt medlem ---");
        String name = IO.readln("Indtast navn: ");
        int id = readInt("Indtast medlemsnummer: ");
        // Her kan man udbygge med indtastning af fødselsdato, adresse osv.
        IO.println("Medlem oprettet (eksempel).");
    }

    // SØG MEDLEM EFTER ID (Til kundemenuen)
    private void searchMemberById() {
        int id = readInt("Indtast medlemsnummer der søges efter: ");
        Member m = club.findMemberById(id);
        if (m != null) {
            IO.println("\nMedlem fundet:");
            IO.println(m.toString());
        } else {
            IO.println("Fandt intet medlem med medlemsnummer: " + id);
        }
    }

    // VIS RESULTATER
    private void results() {
        // Her kan man vælge stævner eller træningsresultater.
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

}
