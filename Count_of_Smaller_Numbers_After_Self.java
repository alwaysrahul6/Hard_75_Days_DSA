package HARD_75_DAYS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Count_of_Smaller_Numbers_After_Self {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Element :");
        String[]s = scanner.nextLine().split(" ");


    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
                ans.add(count);
            }
        }
        return ans;
    }

    class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    int[] count;
    Pair[] temp;

    public List<Integer> countSmall(int[] arr) {

        int n = arr.length;
        count = new int[n];
        temp = new Pair[n];

        Pair[] pair = new Pair[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(arr[i], i);
        }

         mergeSort(pair, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }

        return result;
    }

    private void mergeSort(Pair[] arr, int left , int right){
        if (left >= right)return;;

        int mid = left + ( right - left)/2;
        mergeSort(arr , left , mid);
        mergeSort(arr , mid + 1, right);
        mergeMethod(arr , left , mid , right);
    }

    private void mergeMethod(Pair[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int rightCount  = 0;
        while (i <= mid && j <= right){
            if (arr[j].val < arr[i].val){
                rightCount++;
                temp[k++] = arr[j++];
            }else{
                count[arr[i].idx] += rightCount;
                temp[k++] = arr[i++];
            }   
        }
        /*Remaining left elements*/
        while (i <= mid){
            count[arr[i].idx] += rightCount;
            temp[k++] = arr[i++];
        }

        while (j <= right){
            temp[k++] = arr[j++];
        }

        for (int x = left; x <= right; x++){
            arr[x] = temp[x];
        }
    }
}