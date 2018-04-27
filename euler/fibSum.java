public class fibSum{
    public static int sumEven(){
        int result = 0;
        int prev = 1;
        for(int i =1; i< 4000000;){
            if(i%2 == 0){
                result+=i;
            }
            int temp = i;
            i+=prev;
            prev = temp;
        }
        return result;
    }
    public static void main(String[] args) {
    System.out.println(sumEven());    
    }
}