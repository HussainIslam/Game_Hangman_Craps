public class Craps {

    public static void play() {
        int sum = 0;
        int point = 0;
        boolean rollAgain = true;

        do {
            sum = rollDice();
            if (point == 0) {
                if(sum == 2 || sum == 3 || sum == 12){
                    System.out.println("You have got Craps. You have lost the game!");
                    rollAgain = false;
                }
                else if(sum == 7 || sum == 11){
                    System.out.println("You have got Natural. You have won the game!!");
                    rollAgain = false;
                }
                else{
                    point = sum;
                    System.out.println("You have established a point. The point is " +point);
                }
            }
            else {
                if(sum == 7){
                    rollAgain = false;
                    System.out.println("You have lost the game after points!");
                }
                else if( point == sum ){
                    rollAgain = false;
                    System.out.println("You have won the game. Congratulations!!");
                }
            }
        } while (rollAgain);
    }

    public static int rollDice(){
        int number1 = (int)(Math.random() * 6 + 1);
        int number2 = (int)(Math.random() * 6 + 1);
        int sum = number1 + number2;
        System.out.println("Number of your 1st dice is " +number1);
        System.out.println("Number on your 2nd dice is " +number2);
        System.out.println("The sum of the numbers is " +sum);
        return sum;
    }
}
