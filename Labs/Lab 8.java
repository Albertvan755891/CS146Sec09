import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class CoinChange{
    public int coinChange(int[] coins, int amount){
    if(coins == null || coins.length == 0 || amount < 1) return 0;

    Deque<Integer> queue = new ArrayDeque<Integer>();
    Set<Integer> visited = new HashSet<Integer>();
    queue.addFirst(amount);
    visited.add(amount);
    int level = 0;

    while(!queue.isEmpty()){
      int size = queue.size();

      while(size-- > 0){
        int curr = queue.removeLast();
        if(curr == 0) return level;

        if(curr < 0) continue;

        for(int coin : coins){
          int next = curr - coin;
          if(next >= 0 && !visited.contains(next)){
            queue.addFirst(next);
            visited.add(next);
          }
        }
      }

      level++;
    }

    return -1;
  }
public static void main(String[] args) {

    CoinChange coinChange = new CoinChange();
    // Test Case 1
    int[] coins1 = {1, 2, 5};
    int amount1 = 11;
    System.out.println("Test Case 1:");
    System.out.println("Input: coins = [1,2,5], amount = 11");
    System.out.println("Output: " + coinChange.coinChange(coins1, amount1)); 

    // Test Case 2
    int[] coins2 = {2};
    int amount2 = 3;
    System.out.println("\nTest Case 2:");
    System.out.println("Input: coins = [2], amount = 3");
    System.out.println("Output: " + coinChange.coinChange(coins2, amount2)); 

    // Test Case 3
    int[] coins3 = {1};
    int amount3 = 0;
    System.out.println("\nTest Case 3:");
    System.out.println("Input: coins = [1], amount = 0");
    System.out.println("Output: " + coinChange.coinChange(coins3, amount3)); 
}
}
