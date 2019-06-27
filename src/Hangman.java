public class Hangman {

    public static void play() {
        boolean retry;
        //do {
        Utilities utils = new Utilities();
        char[] targetWord = utils.getWord();
        char[] displayWord = utils.hideWord(targetWord.length);
        char[] guessedCharacters = {' '};
        int numberOfTries = 0;
        do{
            boolean correctGuess = false;
            // Receiving a guess from the user
            char guess = utils.getGuess(displayWord);
            boolean validGuess = utils.guessedCharacterValidation(guess, guessedCharacters);

            if(validGuess){
                guessedCharacters = utils.addGuessToArray(guessedCharacters, guess);
                for(int i = 0; i < displayWord.length; i++){
                    if(targetWord[i] == guess){
                        displayWord[i] = guess;
                        correctGuess = true;
                    }
                }
                if(!correctGuess){
                    numberOfTries++;
                    System.out.println(guess +" is not in the word");
                    System.out.println("Wrong guess count: " +numberOfTries);
                }
            }
            else{
                if(utils.guessedCharacterValidation(guess, targetWord)){
                    System.out.println("You have already guessed '" +guess +"', which is not in the word!");
                }
                else{
                    System.out.println("You have already succeeded guessing '" +guess +"'");
                }
            }
            System.out.print("You have guessed: ");
            utils.printCharArray(guessedCharacters);
            System.out.println("");
        }while(!utils.isSolved(displayWord));
        System.out.print("It took you " +numberOfTries +" wrong guess(es) to identify the word ");
        utils.printCharArray(displayWord);
        System.out.println("");
        //} while (retry);
    }
}
