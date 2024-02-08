public class Main {
    public static int max(int sum1, int sum2){
        return (sum1>sum2)?sum1:sum2;
    }
    public static int findMaximum(int[] arr1, int[] arr2){
        int result = 0, sum1 = 0, sum2 = 0, i=0, j=0;
        int m =arr1.length;
        int n = arr2.length;
        
        while(i<m && j<n){
            if(arr1[i]<arr2[j]){
                sum1=sum1+arr1[i];
                i++;
            }else if(arr1[i]>arr2[j]){
                sum2 = sum2+arr2[j];
                j++;
            }else{
                result = result + max(sum1, sum2) + arr1[i];
                sum1=0;
                sum2=0;
                i++;
                j++;
            }
        }
        
        while(i<m){
            sum1 = sum1+arr1[i];
            i++;
        }
        
        while(j<n){
            sum2 = sum2+arr2[j];
            j++;
        }

        result = result+max(sum1, sum2);
        return result;
    }
    public static void main (String[] args) {
        Main m = new Main();
        int[] arr1 = { 2, 3, 7, 10, 12, 15, 30, 34 };
        int[] arr2 = { 1, 5, 7, 8, 10, 15, 16, 19 };
        
        System.out.print(m.findMaximum(arr1, arr2));
    }
}
