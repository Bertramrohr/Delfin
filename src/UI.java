public class UI {

    public void run() {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast dit valg: "));
            switch (choice) {
                case 1 -> logInMenu();
                case 2 -> membership();
                case 3 -> allMemberInfo();
                case 4 -> results();
                case 5 -> information();
                case 6 -> adminMenu();

                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg, indtast gyldigt tal.");

            }

        }
    }

    //her rettes fejl.
    private void adminMenu() {
    }

    //Information over hold, kontakt mm.
    private void information() {
    }

    // her kan du se ALLES medlemmers info og status.
    private void allMemberInfo() {
    }
    // så kan du efterfølgene vælge stævne eller træningsresultater
    private void results() {
    }
    // her kan du se DIT medlemskab og din egen info og status.
    private void membership() {
    }
    // log in for at se om du er adminstrator og derefter kan se alle muligheder eller kun ens egen info hvis medlem.
    private void logInMenu() {
    }

    private void showMenu() {

    }


}

/*
void main() {

    boolean masterMenuIsRunning = true;
    while (masterMenuIsRunning) {

        IO.println("Velkommen til Svømmeklubben Delfinen");
        IO.println();
        IO.println("1. Administrator");
        IO.println("2. Kunde");
        IO.println("3. Slut programmet");
        IO.println();

        int masterMenuChoice = Integer.parseInt(IO.readln("Vælg et nummer fra hovedmenuen: "));
        IO.println();
        if (masterMenuChoice == 1) { //det er admin der er bruger
            //Vis admin-menu
            boolean adminMenuIsRunning = true;
            while (adminMenuIsRunning) {

                IO.println("Administrator-menu");
                IO.println();
                IO.println("1. Medlemskab"); //Alle medlemmer, Opret medlem og skift medlemskab
                IO.println("2. Data og information"); //Alle eksempeldata, Arbejdsplaner,
                IO.println("3. Tilbage");
                IO.println();

                int adminMenuChoice = Integer.parseInt(IO.readln("Vælg et nummer fra menuen: "));
                IO.println();
                if (adminMenuChoice == 1) { //admin vil se filmprogrammet

                    //Switch case for menu


                    }
                }

                if (adminMenuChoice == 2) { //admin se data og information

                    }
                    int movieChoice = Integer.parseInt(IO.readln("Skriv nummeret på den film du vil erstatte: "));
                    IO.println("Du har valgt at erstatte " + movieProgram[movieChoice - 1]);
                    String newMovie = IO.readln("Skriv titlen på den nye film: ");
                    movieProgram[movieChoice - 1] = newMovie;
                    IO.println("Det nye filmprogram ser sådan ud:");

                    //Udskriv filmprogram
                    IO.println("Filmprogram");
                    for (int i = 1; i <= movieProgram.length; i++) {
                        IO.println(i + ". " + movieProgram[i - 1]);
                    }
                    //vil brugeren tilbage?
                    String back = IO.readln("Vil du tilbage til menuen? skriv 'j' for ja, eller enter for at komme tilbage til hovedmenuen: ");
                    if (!back.equals("j")) {
                        adminMenuIsRunning = false;
                    }
                }
                if (adminMenuChoice == 3) { //tilbage til hovedmenu
                    adminMenuIsRunning = false;
                }
            }

        }
        if (masterMenuChoice == 2) { //det er kunden der er bruger
            //vis kundemenu
            boolean customerMenuIsRunning = true;
            while (customerMenuIsRunning) {

                IO.println("Kundemenu");
                IO.println();
                IO.println("1. Se filmprogram");
                IO.println("2. Se filmprogram og bestil billetter");
                IO.println("3. Tilbage");
                IO.println();

                int customerMenuChoice = Integer.parseInt(IO.readln("Vælg et nummer fra menuen: "));
                IO.println();
                if (customerMenuChoice == 1) { //kunden vil se filmprogrammet
                    //udskriv filmprogram
                    IO.println("Filmprogram");
                    for (int i = 1; i <= movieProgram.length; i++) {
                        IO.println(i + ". " + movieProgram[i - 1]);
                    }
                    //vil brugeren tilbage?
                    String back = IO.readln("Vil du tilbage til menuen? skriv 'j' for ja, eller enter for at komme tilbage til hovedmenuen");
                    if (!back.equals("j")) {
                        customerMenuIsRunning = false;
                    }

                }
                if (customerMenuChoice == 2) { //kunden vil se filmprogram og booke billet
                    //udskriv filmprogram
                    IO.println("Filmprogram");
                    for (int i = 1; i <= movieProgram.length; i++) {
                        IO.println(i + ". " + movieProgram[i - 1]);
                    }
                    int movieChosen = Integer.parseInt(IO.readln("Hvilket nummer film vil du se: "));
                    IO.println("Book et eller flere sæder: ");

                    //udskriv sal
                    IO.println();
                    IO.println("---lærred---");
                    IO.println();
                    for (int i = 0; i < auditorium.length; i++) {
                        for (int j = 0; j < auditorium[0].length; j++) {
                            if (auditorium[i][j]) {
                                IO.print("|X|");
                            } else {
                                IO.print("|_|");
                            }
                        }
                        IO.println();
                    }
                    IO.println();
                    IO.println();

                    //kunden booker billet/billetter
                    String bookedSeat = "Du har booked følgende sæder til "+ movieProgram[movieChosen-1];
                    boolean bookingprocess = true;
                    while (bookingprocess) {
                        boolean novacantseatpicked = true;
                        while (novacantseatpicked) {

                            int rowChoice = Integer.parseInt(IO.readln("Vælg række: "));

                            int seatChoice = Integer.parseInt(IO.readln("Vælg sæde: "));
                            int rowIndex = rowChoice - 1;
                            int seatIndex = seatChoice - 1;

                            if (!(auditorium[rowIndex][seatIndex])) {
                                //sædet er frit og kan bookes
                                auditorium[rowIndex][seatIndex] = true;

                                //udskriv sal
                                IO.println();
                                IO.println("---lærred---");
                                IO.println();
                                for (int i = 0; i < auditorium.length; i++) {
                                    for (int j = 0; j < auditorium[0].length; j++) {
                                        if (auditorium[i][j]) {
                                            IO.print("|X|");
                                        } else {
                                            IO.print("|_|");
                                        }
                                    }
                                    IO.println();
                                }
                                IO.println();
                                IO.println();

                                novacantseatpicked = false;
                                bookedSeat += "\nrække " + rowChoice + ", sæde" + seatChoice;

                            } else {
                                IO.println("Sædet du forsøger at booke er allerede optaget, prøv igen.");
                            }

                        }
                        String keepBooking = IO.readln("Vil du booke et sæde mere? Skriv j for ja, n for nej: ");
                        if (keepBooking.equals("n")) {
                            bookingprocess = false;
                        }
                    }
                    IO.println(bookedSeat);


                    //vil brugeren tilbage?
                    String back = IO.readln("Vil du tilbage til menuen? skriv 'j' for ja, eller enter for at komme tilbage til hovedmenuen: ");
                    if (!back.equals("j")) {
                        customerMenuIsRunning = false;
                    }
                }
                if (customerMenuChoice == 3) {//tilbage til hovedmenu
                    customerMenuIsRunning = false;
                }
            }


        }
        if (masterMenuChoice == 3) {//programmet slutter
            masterMenuIsRunning = false;
        }
    }
}
 */
