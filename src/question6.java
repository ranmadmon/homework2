import java.util.Scanner;

public class question6 {
    public static boolean functionCorrectOrNot(String quadraticEquation)
    {
        int startX2=0;
        if (quadraticEquation.endsWith("=0")==true) {
            if (quadraticEquation.indexOf('x',0)!=-1)
            {
                int stratX1=quadraticEquation.indexOf('x',0);
                String xSquared=quadraticEquation.substring(stratX1,stratX1+3);
                if (xSquared.equals("x^2")==false)
                {
                    return false;
                }
                if (quadraticEquation.startsWith("-")==true)
                {
                    for (int i=1;i<stratX1;i++)
                    {
                        if (quadraticEquation.charAt(i)<'1'||quadraticEquation.charAt(i)>'9'){
                            return false;
                        }
                    }
                }else {
                    for (int i=0;i<stratX1;i++)
                    {
                        if (quadraticEquation.charAt(i)<'1'||quadraticEquation.charAt(i)>'9'){
                            return false;
                        }
                    }
                }
                if (quadraticEquation.indexOf('x',stratX1+1)!=-1)
                {
                    startX2=quadraticEquation.indexOf('x',stratX1+1);
                    String plusOrMinus1= quadraticEquation.substring(stratX1+3,stratX1+4);
                    if (plusOrMinus1.equals("+")||plusOrMinus1.equals("-")){
                        for (int i=stratX1+4;i<startX2;i++){
                            if (quadraticEquation.charAt(i)>'9'||quadraticEquation.charAt(i)<'0'){
                                return false;
                            }
                        }
                    }else {
                        return false;
                    }

                }
                else {
                    return false;
                }
                String plusOrMinus2=quadraticEquation.substring(startX2+1,startX2+2);
                if (plusOrMinus2.equals("+")||plusOrMinus2.equals("-")){
                    for (int i=startX2+2;i<quadraticEquation.indexOf("=");i++)
                    {
                        if (quadraticEquation.charAt(i)<'0'||quadraticEquation.charAt(i)>'9'){
                            return false;
                        }
                    }
                }else {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true ;
    }
    public static int returnA(String quadraticEquation)
    {
        int stratX1=quadraticEquation.indexOf('x',0);
        if (quadraticEquation.startsWith("-")==true)
        {
            if (stratX1==1)
            {
                return 1;
            }else {
                String numA=quadraticEquation.substring(1,stratX1);
                return Integer.parseInt(numA)*-1;
            }
        }else {
            if (stratX1==0)
            {
                return 1;
            }else {
                String numA=quadraticEquation.substring(0,stratX1);
                return Integer.parseInt(numA);
            }
        }
    }
    public static int returnB(String quadraticEquation){
        int stratX1=quadraticEquation.indexOf('x',0);
        int startx2=quadraticEquation.indexOf('x',stratX1+1);
        String numB=quadraticEquation.substring(stratX1+3,startx2);
        if (startx2-stratX1==4){
            if (quadraticEquation.substring(startx2-1,startx2).equals("-")){
                return -1;
            }else {
                return 1;
            }
        }
        else
            return Integer.parseInt(numB);

    }
    public static int returnC(String quadraticEquation)
    {
        int stratX1=quadraticEquation.indexOf('x',0);
        int startx2=quadraticEquation.indexOf('x',stratX1+1);
        String numC=quadraticEquation.substring(startx2+1,quadraticEquation.indexOf("="));
        return Integer.parseInt(numC);
    }
    public static void resultsQuadraticEquation(int a,int b,int c)
    {
        int ac=a*c;
        double  x1 = (-b + (Math.sqrt(b * b - 4 * ac))) / (2 * a);
        double  x2 = (-b - (Math.sqrt(b * b - 4 * ac))) / (2 * a);
        if (x1==x2) {
            System.out.println("x1,x2 = "+x1);
        }else if (x1>=0||x1<=0){
            System.out.println("x1 = "+x1);
            System.out.println("x2 = "+x2);
        }else {
            System.out.println(" There is no answer");
        }
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter your quadraticEquation :");
        String quadraticEquation= scanner.nextLine();
        if (functionCorrectOrNot(quadraticEquation)==true) {
            resultsQuadraticEquation(returnA(quadraticEquation),returnB(quadraticEquation),returnC(quadraticEquation));
        }else {
            System.out.println("The function isn't correct");
        }
    }
}
