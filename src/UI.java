public class UI {
    public void run() {

        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Vælg et nummer fra hovedmenuen: "));
            switch (choice) {
                case 1 -> adminMenu();
                case 2 -> memberMenu();
                case 3 -> running = false;

                default -> IO.println("Ugyldigt valg, indtast gyldigt tal.");
            }
        }

        IO.println("Tak fordi du brugte Svømmeklubben Delfinen!");
    }

    // HOVEDMENU
    private void showMenu() {
        IO.println("Velkommen til Svømmeklubben Delfinen");
        IO.println();
        IO.println("1. Administrator");
        IO.println("2. Kunde");
        IO.println("3. Slut programmet");
        IO.println();
    }

    // ADMINISTRATORMENU
    private void adminMenu() {

        boolean running = true;
        while (running) {
            IO.println("Administrator-menu");
            IO.println();
            IO.println("1. Medlemskab");
            IO.println("2. Data og information");
            IO.println("0. Tilbage");
            IO.println();

            int choice = Integer.parseInt(IO.readln("Vælg et nummer fra menuen: "));
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
            IO.println("Medlemskab - Administrator");
            IO.println();
            IO.println("1. Se alle medlemmer");
            IO.println("2. Opret medlem");
            IO.println("3. Ændre medlemskab");
            IO.println("0. Tilbage");
            IO.println();

            int choice = Integer.parseInt(IO.readln("Vælg et nummer: "));
            switch (choice) {
                case 1 -> allMemberInfo();
                case 2 -> {
                    // Opret medlem
                }
                case 3 -> {
                    // Ændre medlemskab
                }
                case 0 -> running = false;

                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    // ADMINISTRATOR: DATA OG INFORMATION
    private void adminInformation() {

        boolean running = true;
        while (running) {
            IO.println("Data og information");
            IO.println();
            IO.println("1. Hold og træning");
            IO.println("2. Kontaktinformation");
            IO.println("3. Resultater");
            IO.println("0. Tilbage");
            IO.println();

            int choice = Integer.parseInt(IO.readln("Vælg et nummer: "));
            switch (choice) {
                case 1 -> information();
                case 2 -> {
                    // Kontaktinformation
                }
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
            IO.println("Velkommen medlem af Delfinen");
            IO.println();
            IO.println("1. Se dine oplysninger");
            IO.println("2. Se dine hold");
            IO.println("3. Se dine resultater");
            IO.println("4. Se dit medlemskab");
            IO.println("0. Tilbage");
            IO.println();

            int choice = Integer.parseInt(IO.readln("Vælg et nummer: "));
            switch (choice) {
                case 1 -> membership();
                case 2 -> information();
                case 3 -> results();
                case 4 -> membership();
                case 0 -> running = false;

                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    // VIS ALLE MEDLEMMERS INFORMATION
    private void allMemberInfo() {// Her vises alle medlemmers info og status.
    }

    // VIS INFORMATION OM HOLD OG TRÆNING
    private void information() {
        // Information om hold, træning og kontakt.
    }

    // VIS RESULTATER
    private void results() {// Her kan man vælge stævner eller træningsresultater.
    }

    // VIS EGET MEDLEMSKAB OG INFORMATION
    private void membership() {// Her vises eget medlemskab, info og status.
    }
}
