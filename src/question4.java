public class question4 {
    public static int upToDown(int[] arr)
    {
        if (arr[0]>=arr[1]||arr.length==1)
        {
            return -1;
        }
        int index=0;
        for (int i=0;i<arr.length-1;i++){
            if (arr[i+1]<arr[i])
            {
                index=i;
                break;
            }
        }
        for (int i=index;i<arr.length-1;i++)
        {
            if (arr[i+1]>arr[i])
            {
                return -1;
            }
        }
        return index;

    }
    public static void main(String[] args) {

    }
}
