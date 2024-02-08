/* geeksforgeeks - Top 50 Array Coding Problems for Interviews
 * Hard - Chocolate Distribution Problem
 * Given an array of N integers where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 
 *    Each student gets one packet.
 *    The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates given to the students is minimum.
 * Ekta Agrawal
 */

public class Main {
    
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i=low-1;
        
        for (int  j=low; j<high; j++) {
            if (arr[j] <= pivot) {
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    
    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }
    
    public static int chocolateDistribution (int[] arr, int m) {
        if (arr.length ==0 || m==0){
            return 0;
        }
        
        quickSort(arr, 0, arr.length-1);
        
        if (arr.length<m) {
            return -1;
        }
        
        int min_diff = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i++) {
            int next = i+m-1;
            if(next >= arr.length){
                break;
            }
            
            int diff = arr[next] - arr[i];
            min_diff = Math.min(min_diff,diff);
        }
        return min_diff;
    }
    public static void main (String[] args) {
        int[] arr = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;
        
        int result = chocolateDistribution(arr, m);
        if(result != -1){
            System.out.print(result);
        }else{
            System.out.print("invalid input");
        }
    }
}
