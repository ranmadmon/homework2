import java.util.Random;
import java.util.Scanner;

public class question7 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int [] secretPassward = potentialCodes();
        int passward = randomNumber(secretPassward);
        System.out.println("For easy game , press 1");
        System.out.println("For medium game , press 2");
        System.out.println("For hard game , press 3");
        System.out.println("For random tries game, press 4");
        int gameLevel = scanner.nextInt();
        int easyGame = 20;
        int mediumGame = 15;
        int hardGame = 10;
        int randomGame = random.nextInt(5,25);

        if (gameLevel == 1){
            game(passward,easyGame);
        }
        if (gameLevel == 2){
            game(passward,mediumGame);
        }
        if (gameLevel == 3){
            game(passward,hardGame);
        }
        if (gameLevel == 4){
            game(passward,randomGame);
        }




    }
    public static void game (int passward, int rounds) {
        Scanner scanner = new Scanner(System.in);
        if (rounds == 10 || rounds== 15 || rounds ==20){
            System.out.println("You have "+rounds+" tries");}
        System.out.println("Try to guess the secret passward");
        boolean userWon = false;
        for (int i = 1; i<=rounds; i++) {
            int userPassward = scanner.nextInt();
            int[] userPasswardArry = digits(userPassward);
            for (int y = 0; y<4; y++){
                if (userPasswardArry[y]>6||userPasswardArry[y]==0){
                    System.out.println("The passward is ilegal, try again");
                    break;
                }
            }
            for (int p = 0;p<4;p++){
                for (int t = p; t<4; t++){
                    if (userPasswardArry[p] == userPasswardArry[t]&& p!=t){
                        rounds = rounds-2;
                        break;
                    }
                }
            }
            int[] secretPasswardArry = digits(passward);
            if (userPasswardArry[0]==secretPasswardArry[0]&&
                    userPasswardArry[1]==secretPasswardArry[1]&&
                    userPasswardArry[2]==secretPasswardArry[2]&&
                    userPasswardArry[3]==secretPasswardArry[3]){
                userWon = true;
                System.out.println("you won");
                break;

            }
            else {wardle(userPasswardArry,secretPasswardArry);
                System.out.println("Try again");}

        }
        if (userWon==false){
            System.out.println("You lost. the passward is "+passward);
        }


    }


    public static int randomNumber (int [] secretPassward){
        int passward = new Random().nextInt(secretPassward.length);
        return secretPassward[passward];
    }
    public static void wardle (int [] userPassward, int [] secretPassward){
        int correctGuess = 0;
        int notCorrectGuess = 0;
        for (int i = 0; i<4; i++){
            for (int j = 0; j<4; j++){
                if (userPassward[i]== secretPassward[i]){
                    correctGuess = correctGuess+1;
                    break;
                } else if (userPassward[i]==secretPassward[j] && i!=j) {
                    notCorrectGuess = notCorrectGuess+1;

                }
            }
        }
        System.out.println("You have " + correctGuess + " guess in the right place and "+notCorrectGuess+ " correct guess but in the wrong place ");


    }


    public static int [] digits (int number1){
        int number = number1;
        int unitsNumber = 0;
        int tensNUmber = 0;
        int hundredsNumber = 0;
        int thousensNumber = 0;
        for (int j = number; j % 10 != 0; j--) {
            unitsNumber = unitsNumber + 1;
        }
        int newI1 = (number - unitsNumber) / 10;
        for (int j = newI1; j % 10 != 0; j--) {
            tensNUmber = tensNUmber + 1;
        }
        int newI2 = (newI1 - tensNUmber) / 10;
        for (int j = newI2; j % 10 != 0; j--) {
            hundredsNumber = hundredsNumber + 1;
        }
        int newI3 = (newI2 - hundredsNumber) / 10;
        thousensNumber = newI3;
        int [] digits = {unitsNumber,tensNUmber,hundredsNumber,thousensNumber};
        return digits;
    }
    public static int [] potentialCodes (){
        int counter = 0;
        int[] secretPassward = new int[300];
        secretPassward[0] = 1234;
        for (int i = 1235; i<6000; i++) {
            int unitsNumber = 0;
            int tensNUmber = 0;
            int hundredsNumber = 0;
            int thousensNumber = 0;
            for (int j = i; j % 10 != 0; j--) {
                unitsNumber = unitsNumber + 1;
            }
            int newI1 = (i - unitsNumber) / 10;
            for (int j = newI1; j % 10 != 0; j--) {
                tensNUmber = tensNUmber + 1;
            }
            int newI2 = (newI1 - tensNUmber) / 10;
            for (int j = newI2; j % 10 != 0; j--) {
                hundredsNumber = hundredsNumber + 1;
            }
            int newI3 = (newI2 - hundredsNumber) / 10;
            thousensNumber = newI3;
            if (unitsNumber!=tensNUmber&&unitsNumber!=hundredsNumber&&unitsNumber!=thousensNumber&&tensNUmber!=hundredsNumber&&tensNUmber!=thousensNumber&&hundredsNumber!=thousensNumber&&tensNUmber<=6&&tensNUmber>=1&&hundredsNumber<=6&&hundredsNumber>=1&&unitsNumber<=6&&unitsNumber>=1) {
                counter = counter+1;
                secretPassward[counter] = i;
            }
        }
        return secretPassward;
    }
}
