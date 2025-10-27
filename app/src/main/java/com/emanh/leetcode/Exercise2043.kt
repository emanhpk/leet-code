package com.emanh.leetcode

/*
You have been tasked with writing a program for a popular bank that will automate all its incoming transactions (transfer, deposit, and withdraw).
The bank has n accounts numbered from 1 to n. The initial balance of each account is stored in a 0-indexed integer array balance, with the (i + 1)th
account having an initial balance of balance[i].

Execute all the valid transactions. A transaction is valid if:
    - The given account number(s) are between 1 and n, and
    - The amount of money withdrawn or transferred from is less than or equal to the balance of the account.

Implement the Bank class:
    - Bank(long[] balance) Initializes the object with the 0-indexed integer array balance.
    - boolean transfer(int account1, int account2, long money) Transfers money dollars from the account numbered account1 to the account numbered
    account2.Return true if the transaction was successful, false otherwise.
    - boolean deposit(int account, long money) Deposit money dollars into the account numbered account. Return true if the transaction was successful,
    false otherwise.
    - boolean withdraw(int account, long money) Withdraw money dollars from the account numbered account. Return true if the transaction was
    successful, false otherwise.

Input:
["Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"]
[[[10, 100, 20, 50, 30]], [3, 10], [5, 1, 20], [5, 20], [3, 4, 15], [10, 50]]
Output:
[null, true, true, true, false, false]
Explanation:
Bank bank = new Bank([10, 100, 20, 50, 30]);
bank.withdraw(3, 10);    // return true, account 3 has a balance of $20, so it is valid to withdraw $10.
                         // Account 3 has $20 - $10 = $10.
bank.transfer(5, 1, 20); // return true, account 5 has a balance of $30, so it is valid to transfer $20.
                         // Account 5 has $30 - $20 = $10, and account 1 has $10 + $20 = $30.
bank.deposit(5, 20);     // return true, it is valid to deposit $20 to account 5.
                         // Account 5 has $10 + $20 = $30.
bank.transfer(3, 4, 15); // return false, the current balance of account 3 is $10,
                         // so it is invalid to transfer $15 from it.
bank.withdraw(10, 50);   // return false, it is invalid because account 10 does not exist.

Your Bank object will be instantiated and called as such:
var obj = Bank(balance)
var param_1 = obj.transfer(account1,account2,money)
var param_2 = obj.deposit(account,money)
var param_3 = obj.withdraw(account,money)
 */

class Bank(var balance: LongArray) {
    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (account1 > 0 && account1 <= balance.size) {
            if (balance[account1 - 1] < money) {
                return false
            } else {
                if (account2 > 0 && account2 <= balance.size) {
                    balance[account1 - 1] = balance[account1 - 1] - money
                    balance[account2 - 1] = balance[account2 - 1] + money
                    return true
                } else {
                    return false
                }
            }
        }
        return false
    }

    fun deposit(account: Int, money: Long): Boolean {
        if (account > 0 && account <= balance.size) {
            balance[account - 1] = balance[account - 1] + money
            return true
        }
        return false
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if (account > 0 && account <= balance.size) {
            if (balance[account - 1] < money) {
                return false
            } else {
                balance[account - 1] = balance[account - 1] - money
                return true
            }
        }
        return false
    }
}

fun main() {
    //"deposit","transfer","deposit"
    val bank = Bank(balance = longArrayOf(10, 100, 20, 50, 30))
    val param1 = bank.withdraw(account = 3, money = 10)
    println("param1: $param1 - balance = ${bank.balance.toList()}")
    val param2 = bank.transfer(account1 = 5, account2 = 1, money = 20)
    println("param2: $param2 - balance = ${bank.balance.toList()}")
    val param3 = bank.deposit(account = 5, money = 20)
    println("param3: $param3 - balance = ${bank.balance.toList()}")
    val param4 = bank.transfer(account1 = 3, account2 = 4, money = 15)
    println("param4: $param4 - balance = ${bank.balance.toList()}")
    val param5 = bank.withdraw(account = 10, money = 50)
    println("param5: $param5 - balance = ${bank.balance.toList()}")
}