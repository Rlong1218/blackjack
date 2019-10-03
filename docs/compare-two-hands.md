## Comparing two hands in Blackjack

### Given two hands with "n" cards in each.

#### Find the sum of each hand using the following:

(Hard Ace = 1, Soft Ace = 11)
(Assume all aces start Soft)

* Sum cards in each hand
  * If total > 21 and hand is hard
    * Return Soft total
  * If Soft hand > 21
      * return hand loss
  * If total <= 21
    * Return total
    
#### Next compare totals
   
* If Dealer total = 21
  * return Dealer Win
* If Dealer total > Player Total
  * return Dealer Win
* If Dealer total = Player Total
  * return Dealer Win
* If Player hand > Dealer hand
  *return Player Win
