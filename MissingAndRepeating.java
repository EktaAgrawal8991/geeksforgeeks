import java.util.*;
public class Main {
    
    public static HashMap<Integer, Integer> countOccurrences(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
    
        for (int num : arr) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }
    
        return counts;
    }
    
    public static int[] removeDuplicates(int[] arr) {
        int end = arr.length;
        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = arr[end - 1];
                    end--;
                    j--;
                }
            }
        }
        
        int[] uniqueArray = Arrays.copyOf(arr, end);
        return uniqueArray;
    }
    
    public static void findMissingNumber (int[] arr) {
        int[] result = removeDuplicates(arr);
        int sum = (result.length+1)*(result.length+2)/2;
        for(int i=0; i<result.length; i++) {
            sum = sum - result[i];
        }
        System.out.println(sum);
    }
    public static void main (String[] args) {
        int[] arr = {4,5,6,8,3,2,6,5,2,1,};
        
        HashMap<Integer, Integer> counts = countOccurrences(arr);
        System.out.print("Repeating elements in the array are:");
        for (int num : counts.keySet()) {
            if (counts.get(num) > 1) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        removeDuplicates(arr);
        System.out.print("Missing element is : ");
        findMissingNumber(arr);
    }
}
