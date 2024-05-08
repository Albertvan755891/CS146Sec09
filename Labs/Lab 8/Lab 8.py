from collections import deque
from typing import List

class CoinChange:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        coins.sort(reverse = True)
        seen = set()
        queue = deque()
        queue.append((0,0))
        while queue:
            c, t = queue.popleft()
            if t == amount:
                return c
            for coin in coins:
                if t + coin <= amount and t + coin not in seen:
                    queue.append((c + 1, t + coin))
                    seen.add(t + coin)

        return -1

def main():
    coin_changer = CoinChange()

    coins1 = [1, 2, 5]
    amount1 = 11
    print("Test Case 1:")
    print(f"Input: coins = {coins1}, amount = {amount1}")
    print("Output:", coin_changer.coinChange(coins1, amount1)) 

    coins2 = [2]
    amount2 = 3
    print("\nTest Case 2:")
    print(f"Input: coins = {coins2}, amount = {amount2}")
    print("Output:", coin_changer.coinChange(coins2, amount2))  

    coins3 = [1]
    amount3 = 0
    print("\nTest Case 3:")
    print(f"Input: coins = {coins3}, amount = {amount3}")
    print("Output:", coin_changer.coinChange(coins3, amount3))

if __name__ == "__main__":
    main()
