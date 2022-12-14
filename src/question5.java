import java.util.Scanner;

public class question5 {
    public static void printBoard(char[] arr)
    {
        System.out.println("{"+arr[0]+"}"+"{"+arr[1]+"}"+"{"+arr[2]+"}");
        System.out.println("{"+arr[3]+"}"+"{"+arr[4]+"}"+"{"+arr[5]+"}");
        System.out.println("{"+arr[6]+"}"+"{"+arr[7]+"}"+"{"+arr[8]+"}");
    }
    public static boolean isAvailable(char[] arr,int num)
    {
        if (arr[num-1]=='X'||arr[num-1]=='O')
        {
            return false;
        }
        return true;
    }
    public static int getPositionFromUser(char[] arr){
        Scanner scanner=new Scanner(System.in);
        int position;
        System.out.println(" enter your position : ");
        position=scanner.nextInt();
        while (position<1||position>9||isAvailable(arr,position)==false)
        {
            System.out.print( "Enter another position your positin isn't right : ");
            position=scanner.nextInt();
        }
        return position;

    }
    public static boolean checkWinner(char[] arr)
    {
        if (arr[0]==arr[4]&&arr[0]==arr[8])
        {
            return true;
        }
        if (arr[6]==arr[4]&&arr[6]==arr[2])
        {
            return true;
        }
        for (int i=0;i<7;i+=3)
        {
            if (arr[i]==arr[i+1]&&arr[i]==arr[i+2])
            {
                return true;
            }
        }
        for (int i=0;i<3;i++)
        {
            if (arr[i]==arr[i+3]&&arr[i]==arr[i+6])
            {
                return true;
            }
        }
        return  false;
    }
    public static boolean placeSymbolOnBoard(char[] arr,int index,char a)
    {
        arr[index]=a;
        printBoard(arr);
        return checkWinner(arr);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arr = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        printBoard(arr);
        while (checkWinner(arr) == false) {
            System.out.print("Player X ");
            int position1 = getPositionFromUser(arr);
            placeSymbolOnBoard(arr, position1 - 1, 'X');
            if (checkWinner(arr) == true) {
                System.out.println();
                System.out.println("Player X win\uD83D\uDC4F");
                break;
            }
            System.out.print("Player O ");
            int position2 = getPositionFromUser(arr);
            placeSymbolOnBoard(arr, position2 - 1, 'O');
            if (checkWinner(arr) == true) {
                System.out.println(" Player O win\uD83D\uDC4F");
            }
        }
    }
}
