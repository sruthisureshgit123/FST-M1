package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] array1 = {1, 77, 10, 54, -11, 10};
        boolean result;
        result= checkSum(array1);
         if(result) {
             System.out.println("sum is 30");
         }
         else {
             System.out.println("sum is not 30");
         }

    }
        public static boolean checkSum(int[] numArray){
            int sum =0;
            boolean result = false;
            for(int i : numArray){
                if (i==10)
                    sum=sum+i;
            }
            if(sum==30)
                 result= true;
            return result;
        }






    }

