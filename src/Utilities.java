import java.util.Arrays;
import java.util.Scanner;

class Utilities{
    public char[] getWord (){
        String[] database = {"write", "that", "program"};
        int index = (int)(Math.random() * database.length);
        return database[index].toCharArray();
    }

    public char[] hideWord(int size){
        char[] array = new char[size];
        Arrays.fill(array,'*');
        return array;
    }

    public char getChar(){
        Scanner sc = new Scanner(System.in);
        char guess = sc.next().charAt(0);
        return guess;
    }

    public char getGuess(char[] display){
        System.out.print("Guess a letter in word ");
        printCharArray(display);
        System.out.print(": ");
        return getChar();
    }

    public char[] addGuessToArray (char[] source, char guess){
        char[] newArray = new char[source.length + 1];
        newArray = Arrays.copyOf(source, source.length + 1);
        newArray[source.length] = guess;
        return newArray;
    }

    public void printCharArray(char[] source){
        for(char a: source){
            System.out.print(a);
        }
    }

    public boolean isSolved(char[] display){
        boolean solved = true;
        for(char a: display){
            if(a == '*'){
                solved = false;
            }
        }
        return solved;
    }

    public boolean guessedCharacterValidation(char guess, char[] alreadyGuessedCharacters){
        boolean valid = true;
        for(char a: alreadyGuessedCharacters){
            if(a == guess){
                valid = false;
            }
        }
        return valid;
    }

    public boolean tryAgain(){
        boolean retry = false;
        boolean loop;
        char input;
        System.out.print("Do you want to play again (Y/N)? ");
        do{
            loop = true;
            input = getChar();
            if(input == 'y' || input == 'Y'){
                retry = true;
                loop = false;
            }
            else if(input == 'n' || input == 'N'){
                retry = false;
                loop = false;
            }
            else {
                System.out.print("You have entered a wrong choice. Please enter again: ");
                //loop = true;
            }
        }while(loop);
        return retry;
    }

    public void generateMenu(){
        System.out.println("Please choose the game you want to play: ");
        System.out.println("    1. Hangman");
        System.out.println("    2. Craps");
        System.out.println("    0. Exit");
        System.out.print("> ");
    }
}
