package HARD_75_DAYS;
/* Find Median from Data Stream
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
*   For example, for arr = [2,3,4], the median is 3.
*   For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
*   Implement the MedianFinder class:
*   MedianFinder() initializes the MedianFinder object.
*   void addNum(int num) adds the integer num from the data stream to the data structure.
*   double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
*   Example 1:
*   Input
*   ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
*   [[], [1], [2], [], [3], []]
*   Output
*   [null, null, null, 1.5, null, 2.0]
*/
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianFinder {
    private final PriorityQueue<Integer> minheap;
    private final PriorityQueue<Integer> maxheap;


    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        Scanner scanner = new Scanner(System.in);
        String s[] = scanner.nextLine().split(" ");
        int n = s.length;
        int[] stream = new int[n];
        for (int i = 0; i < n; i++){
            stream[i] = Integer.parseInt(s[i]);
        }

        for (int num : stream) {
            mf.addNum(num);
            System.out.println(STR."Inserted: \{num} | Current Median: \{mf.findMedian()}");
        }
    }


        public  MedianFinder() {
            this.maxheap = new PriorityQueue<>(Comparator.reverseOrder());
            this.minheap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (minheap.isEmpty() || num >= minheap.peek()){
                minheap.offer(num);
            }else maxheap.offer(num);
            if (minheap.size() > maxheap.size() + 1) {
                maxheap.offer(minheap.poll());
            } else if (maxheap.size() > minheap.size()) {
                minheap.offer(maxheap.poll());
            }
        }

        public double findMedian() {
            if (maxheap.size() == minheap.size()){
                return (minheap.peek() + maxheap.peek())/2.0;
            }else return minheap.peek();
        }
    }
