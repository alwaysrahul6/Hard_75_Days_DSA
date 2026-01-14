package HARD_75_DAYS;

import java.util.Scanner;

public class Find_minimum_Sorted_Rotated_Array_ii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Element");
        String s[] = scanner.nextLine().split(" ");
        int n = s.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        while (i <= j){
            int mid = i + (j - i)/2;
            if (nums[mid] > nums[j]) i  = mid + 1;
            else if (nums[mid] < nums[j]) { j = mid;
            }
            else j--;
        }
        return nums[j];
    }
}
