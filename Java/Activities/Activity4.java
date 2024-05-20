package activities;

public class Activity4 {
    public static void main(String[] args){
        int [] array1={9,5,3,7,5,2};
        sortArray(array1);

    }
    public static  void sortArray (int[] arrayToSort){
        int length= arrayToSort.length;
        for (int i=0; i<length; i++){
            int key= arrayToSort[i];
            for (int j=i+1; j<length; j++ ){
                if(arrayToSort[i]>arrayToSort[j]){
                    int temp =arrayToSort[i];
                    arrayToSort[i]=arrayToSort[j];
                    arrayToSort[j]=temp;
                }
            }
        }
        System.out.println("sorted array is ");
        for (int i: arrayToSort){
            System.out.println(i+"\n");
        }
    }
}
