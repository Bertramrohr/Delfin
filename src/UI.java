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
                case 1 -> adminMenu();
                case 2 -> memberMenu();
                case 3 -> running = false;
                default -> IO.println("Ugyldigt valg, indtast gyldigt tal.");
            }
        }
        IO.println("Tak for at besøge Svømmeklubben Delfinen!");
    }

    // HOVEDMENU
    private void showMenu() {
        IO.println("\n=== Velkommen til Svømmeklubben Delfinen ===");
        IO.println("1. Administrator");
        IO.println("2. Kunde / Medlem");
        IO.println("3. Slut programmet");
    }

    // ADMINISTRATORMENU
    private void adminMenu() {
        boolean running = true;
        while (running) {
            IO.println("\n--- Administrator-menu ---");
            IO.println("1. Medlemskab");
            IO.println("2. Data og information");
            IO.println("0. Tilbage");

            int choice = readInt("Vælg et nummer fra menuen: ");
            switch (choice) {
                case 1 -> adminMembership();
                case 2 -> adminInformation();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    // ADMINISTRATOR: MEDLEMSKAB
    private void adminMembership() {
        boolean running = true;
        while (running) {
            IO.println("\n--- Medlemskab - Administrator ---");
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

    // ADMINISTRATOR: DATA OG INFORMATION
    private void adminInformation() {
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
    private void memberMenu() {
        boolean running = true;
        while (running) {
            IO.println("\n--- Medlemsmenu ---");
            IO.println("1. Søg i medlemmer (via medlemsnummer)");
            IO.println("2. Se hold");
            IO.println("3. Se resultater");
            IO.println("0. Tilbage");

            int choice = readInt("Vælg et nummer: ");
            switch (choice) {
                case 1 -> searchMemberById();
                case 2 -> information();
                case 3 -> results();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    // VIS ALLE MEDLEMMER
    private void allMemberInfo() {
        IO.println("\n--- OVERSIGT OVER MEDLEMMER ---");
        if (club.getMembers().isEmpty()) {
            IO.println("Ingen medlemmer registreret.");
            return;
        }
        for (Member m : club.getMembers()) {
            IO.println(m.toString());
        }
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

    private void information() {
        IO.println("\n[Information om hold og træning vises her]");
    }

    private void results() {
        IO.println("\n[Resultater og stævner vises her]");
    }

    // ROBUST HJÆLPEMETODE TIL AT LÆSE TAL
    private int readInt(String prompt) {
        while (true) {
            try {
                String input = IO.readln(prompt);
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                IO.println("Ugyldigt input! Indtast venligst et heltal.");
            }
        }
    }
}