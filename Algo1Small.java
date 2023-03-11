import java.util.*;
class Algo1Small{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int arr[][] = new int[t][3];

        //input values
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
            
        //Sort array  
        Arrays.sort(arr, new Comparator<int[]>() {
        @Override
        public int compare(final int[] val1, final int[] val2) {
            int cmp =  Integer.compare(val1[0], val2[0]); //Sort array according to first column(text) [accending order]
            if(cmp == 0){
                return Integer.compare(val2[1], val1[1]); //if column value is same then sort array according to second column(images) [decending order]
            }
            return cmp;
        }
        });

        //print array
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<3; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();

    }
}