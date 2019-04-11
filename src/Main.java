public class Main {

    static int SecondLarge(int[] array) {
        int max1 = array[0];
        for(int i=0;i<array.length;i++) {
            if(array[i]>max1){
                max1 = array[i];
            }
        }
        //System.out.println(max1);
        int max2 = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++) {
            if(array[i]>max2 && array[i]!= max1){
                max2 = array[i];
            }
        }
        return max2;
    }

    static int SecondMostFrequent(int[]arr){
        int count = 0;
        int size= 0;
        int pos = 0;
        // loop for counting repeated numbers
        for(int i=0;i<arr.length;i++){
            count = 0;
            for (int j=0;j<arr.length;j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    pos = j;
                }
            }
            if(count>1) {
                i = pos;
                size++;
                //System.out.println(count+" "+arr[i]);
            }
        }
        // end of loop
        // loop for feeling repeated numbers and counts of each one of them in new arrays
        int ArrayForCounts[] = new int[size];
        int ArrayForIntegers[] = new int[size];
        int x = 0;
        for(int i=0;i<arr.length;i++){
            count = 0;
            for (int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                    pos = j;
                }
            }
            if(count>1) {
                i = pos;
                ArrayForIntegers[x] = arr[i];
                ArrayForCounts[x]= count;
                x++;
            }
        }
        // end of loop
        //loop and conditions for counting max and min repeated numbers count
        int Fist_Max = Integer.MIN_VALUE;
        for (int i=0;i<ArrayForCounts.length;i++){
            if(ArrayForCounts[i]>Fist_Max){
                Fist_Max = ArrayForCounts[i];
            }
        }
        int Second_Max = SecondLarge(ArrayForCounts);
        int First_MaxCount = 0;
        int Second_MaxCount =0;
        //System.out.println("max = "+Fist_Max+ " "+Second_Max);
        for(int i=0;i<ArrayForCounts.length;i++) {
            if (ArrayForCounts[i] == Fist_Max) {
                First_MaxCount++;
            }
            if (ArrayForCounts[i] == Second_Max) {
                Second_MaxCount++;
            }
        }
        // end of loop
        // System.out.println(First_MaxCount+" "+Second_MaxCount);
        // conditions to check and print second most repeated number
        int SecondMostRepeatedNumber = Integer.MIN_VALUE;
        int FirstMostRepeatedNumber = Integer.MIN_VALUE;
        if(First_MaxCount<Second_MaxCount && First_MaxCount >1 ||  Second_MaxCount==0 || Second_MaxCount<First_MaxCount){
            for (int i=0;i<ArrayForCounts.length;i++){
                if(ArrayForCounts[i]== Fist_Max){
                    FirstMostRepeatedNumber = ArrayForIntegers[i];
                }
            }
            for (int i=0;i<ArrayForCounts.length-1;i++){
                if(ArrayForCounts[i]== Fist_Max && ArrayForIntegers[i]<=FirstMostRepeatedNumber){
                    SecondMostRepeatedNumber = ArrayForIntegers[i];
                }
            }
        }
        if(First_MaxCount<Second_MaxCount && First_MaxCount<2){
            for (int i=0;i<ArrayForCounts.length;i++){
                if(ArrayForCounts[i]== Second_Max){
                    SecondMostRepeatedNumber = ArrayForIntegers[i];
                }
            }
        }
        // end of conditions
        return SecondMostRepeatedNumber;
    }

    static void PrintArray(int[]arr){
        for (int i=0 ;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[]args) {

        int [] Array1 = {-4,-4,-4,1,1,2,3,3,3,5,5,5};
        int [] Array2 = {1,1,1,2,2,3,3,4,4,5,5,5};
        int [] Array3 = {1,1,2,2,3,3,4,4,5,5,6,6};
        PrintArray(Array1);
        System.out.println("Second mos Frequant Number is = "+SecondMostFrequent(Array1));
        PrintArray(Array2);
        System.out.println("Second mos Frequant Number is = "+SecondMostFrequent(Array2));
        PrintArray(Array3);
        System.out.println("Second mos Frequant Number is = "+SecondMostFrequent(Array3));


    }
}
