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
