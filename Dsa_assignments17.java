import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Dsa_assignments17 {

/*
 * For a stream of integers, implement a data structure that checks if the last `k` integers parsed in the
 *  stream are **equal** to `value`.
Implement the **DataStream** class:

["DataStream", "consec", "consec", "consec", "consec"]
[[4, 3], [4], [4], [4], [3]]
Output
[null, false, false, true, false]
 */

 public static  class DataStream {
        private int[] buffer;
        private int value;
        private int k;
        private int count;
    
        public DataStream(int value, int k) {
            buffer = new int[k];
            this.value = value;
            this.k = k;
            count = 0;
        }
    
        public boolean consec(int num) {
            buffer[count % k] = num;
            count++;
            
            if (count >= k) {
                for (int i = 0; i < k; i++) {
                    if (buffer[i] != value) {
                        return false;
                    }
                }
                return true;
            }
            
            return false;
        }
    }

/*You are given an integer array `deck`. There is a deck of cards where every card has a unique integer. The integer on the `ith` card is `deck[i]`.

You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.

You will do the following steps repeatedly until all cards are revealed:

1. Take the top card of the deck, reveal it, and take it out of the deck.
2. If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
3. If there are still unrevealed cards, go back to step 1. Otherwise, stop.

Return *an ordering of the deck that would reveal the cards in increasing order*.
 * 
 */
    public static int[] deckRevealed_Increasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck); // Sort the deck in increasing order
        
        Queue<Integer> indices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indices.offer(i);
        }
        
        int[] ordering = new int[n];
        for (int card : deck) {
            ordering[indices.poll()] = card;
            if (!indices.isEmpty()) {
                indices.offer(indices.poll());
            }
        }
        
        return ordering;
    }
/* 
There are `n` friends that are playing a game. The friends are sitting in a circle and are numbered from `1` 
to `n` in **clockwise order**. More formally, moving clockwise from the `ith` friend brings you to the
 `(i+1)th` friend for `1 <= i < n`, and moving clockwise from the `nth` friend brings you to the `1st` 
friend.

1. **Start** at the `1st` friend.
2. Count the next `k` friends in the clockwise direction **including** the friend you started at. The counting wraps around the circle and may count some friends more than once.
3. The last friend you counted leaves the circle and loses the game.
4. If there is still more than one friend in the circle, go back to step `2` **starting** from the friend **immediately clockwise** of the friend who just lost and repeat.
5. Else, the last friend in the circle wins the game.

Given the number of friends, `n`, and an integer `k`, return *the winner of the game*.
 */
    public static int find_Winner(int n, int k) {
        int winner = 0;

        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }

        return winner + 1;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*You have a `RecentCounter` class which counts the number of recent requests within a certain time frame.
Implement the `RecentCounter` class:
 * - `RecentCounter()` Initializes the counter with zero recent requests.
- `int ping(int t)` Adds a new request at time `t`, where `t` represents some time in milliseconds, and 
returns the number of requests that has happened in the past `3000` milliseconds (including the new request). 
Specifically, return the number of requests that have happened in the inclusive range `[t - 3000, t]`.
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]
 */
  public static class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.offer(t);
        
        
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }
        
        return requests.size();
    }
}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     *     You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the ith
     *  sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the jth 
     * student in the initial queue (j = 0 is the front of the queue). Return the number of students that are
     *  unable to eat.        

     */

     public static int count_Students(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        
        for (int student : students) {
            count[student]++;
        }
        
        for (int sandwich : sandwiches) {
            if (count[sandwich] == 0) {
                break;
            }
            
            count[sandwich]--;
        }
        
        return count[0] + count[1];
    }


  ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
/*
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray 
 * of nums.
 * A **circular array** means the end of the array connects to the beginning of the array. Formally, the next
 *  element of `nums[i]` is `nums[(i + 1) % n]` and the previous element of `nums[i]` is
 *  `nums[(i - 1 + n) % n]`.

A **subarray** may only include each element of the fixed buffer `nums` at most once. Formally, for a 
subarray `nums[i], nums[i + 1], ..., nums[j]`, there does not exist `i <= k1`, `k2 <= j` with `k1 % n == k2 % 
n`.
 */
public static int max_Subarray_Sum_Circular(int[] nums) {
    int maxSum = kadane(nums);
    
    if (maxSum < 0) {
        return maxSum;
    }
    
    int totalSum = 0;
    for (int i = 0; i < nums.length; i++) {
        totalSum += nums[i];
        nums[i] = -nums[i];
    }
    
    int circularMaxSum = totalSum + kadane(nums);
    
    return Math.max(maxSum, circularMaxSum);
}

public static int kadane(int[] nums) {
    int maxSum = nums[0];
    int currentSum = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    
    return maxSum;
}


 /*
   Given a string s, find the first non-repeating character in it and return its index. If it does not exist,
    return -1.
    */ 
    public static int first_Uniq_Char(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (frequencyMap.get(c) == 1) {
                return i;
            }
        }
        
        return -1;
    }
    

    public static void main(String[] args) {
        
          System.out.println(first_Uniq_Char("leetcode"));

          int[] arr = {1, -2, 3, -2};

            System.out.println(max_Subarray_Sum_Circular(arr)); 

            RecentCounter counter = new RecentCounter();
            System.out.println(counter.ping(1));     // Returns 1
            System.out.println(counter.ping(100));   // Returns 2
            System.out.println(counter.ping(3001));  // Returns 3
            System.out.println(counter.ping(3002));  // Returns 3

            find_Winner(5,2);

            /////////////////////////////////////////////////////////////////////
            DataStream dataStream = new DataStream(5, 3);
        System.out.println(dataStream.consec(1));  
        System.out.println(dataStream.consec(5));  
        System.out.println(dataStream.consec(5)); 
        System.out.println(dataStream.consec(5));  



    }
}

