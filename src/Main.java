

public class Main {

    public static void main(String[] args) {
        Utilities util = new Utilities();
        boolean retry;
        do{
            util.generateMenu();

            int choice;
            do {
                choice = util.getChar();
                if(!(choice == '1' || choice == '2' || choice == '0')){
                    System.out.println("The choice you entered is wrong. Please try again.");
                    System.out.print("> ");
                }
            } while (!(choice == '1' || choice == '2' || choice == '0'));


            switch (choice){
                case '1':
                    Hangman.play();
                    break;
                case '2':
                    Craps.play();
                    break;

                default:
                    break;
            }

            if (choice != '0'){
                retry = util.tryAgain();
            }
            else {
                retry = false;
            }

            if(!retry){
                System.out.println("Goodbye!!");
            }
        }while(retry);
    }
}
