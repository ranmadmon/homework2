public class question2 {
    public static String checkPhone(String phone)
    {
        if (phone.startsWith("97250")||phone.startsWith("97251")||phone.startsWith("97252")||phone.startsWith("97253")||phone.startsWith("97254")||phone.startsWith("97255")||phone.startsWith("97258")   )
        {
            for (int i=5;i<12;i++){
                if (phone.charAt(i)>'9'||phone.charAt(i)<'0'){
                    return "";
                }
            }
            if (phone.length()==12){
                return "0"+phone.substring(3,5)+"-"+phone.substring(5,12);
            }

        }
        if (phone.startsWith("050-")||phone.startsWith("051-")||phone.startsWith("052-")||phone.startsWith("053-")||phone.startsWith("054-")||phone.startsWith("055-")||phone.startsWith("058-"))
        {
            for (int i=4;i<11;i++){
                if (phone.charAt(i)>'9'||phone.charAt(i)<'0'){
                    return "";
                }
            }
            if (phone.length()==11){
                return phone;
            }
        }
        if (phone.startsWith("050")||phone.startsWith("051")||phone.startsWith("052")||phone.startsWith("053")||phone.startsWith("054")||phone.startsWith("055")||phone.startsWith("058"))
        {
            for (int i=3;i<10;i++){
                if (phone.charAt(i)>'9'||phone.charAt(i)<'0'){
                    return "";
                }
            }
            if (phone.length()==10)
            {
                return phone.substring(0,3)+"-"+phone.substring(3,10);
            }
        }
        return "";

    }
    public static void main(String[] args) {

    }
}
