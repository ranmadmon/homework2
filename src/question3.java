public class question3 {
    public  static int[] withoutDuplicates(int[] arr)
    {
        double[] withoutDup=new double[arr.length];
        for (int i=0;i<withoutDup.length;i++)
        {
            withoutDup[i]=0.1;
        }
        int indexWithoutDup=0;
        for (int i=0;i<arr.length;i++){
            boolean Duplicate=false;
            for (int j=0;j< arr.length;j++){
                if (arr[i]==withoutDup[j])
                {
                    Duplicate=true;
                }
                if (withoutDup[j]==0.1)
                {
                    break;
                }
            }
            if (Duplicate==false){
                withoutDup[indexWithoutDup]=arr[i];
                indexWithoutDup++;
            }
        }
        int[] returnWithoutDup=new int[indexWithoutDup];
        for (int i=0;i<indexWithoutDup;i++)
        {
            double withoutDupI=withoutDup[i];
            returnWithoutDup[i]=(int)withoutDupI;
        }
        return returnWithoutDup;
    }
    public static void main(String[] args) {

    }

}
