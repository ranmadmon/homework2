import java.util.Scanner;

public class question1
{
    public static  void higherThenAverage()
    {
        int total=0;
        Scanner scanner=new Scanner(System.in);
        int[] arr= new int [10];
        for (int i=0;i< arr.length;i++)
        {
            System.out.print("Enter a number :   ");
            arr[i]= scanner.nextInt();
            total+=arr[i];
        }
        double average=(double)total/10;
        System.out.print("The numbers that higer then average is : ");
        for (int i=0;i<arr.length;i++)
        {
            if (arr[i]>average)
            {
                System.out.print(arr[i]+ " ");
            }
        }
        System.out.println(" .");
    }
    public static void main(String[] args) {

    }
}
