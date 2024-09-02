object BankApp2 {

  // Account class representing a bank account
  class Account(var balance: Double) {
    
    // Deposit money into the account
    def deposit(amount: Double): Unit = {
      require(amount > 0, "Deposit amount must be positive")
      balance += amount
    }

    // Withdraw money from the account
    def withdraw(amount: Double): Unit = {
      require(amount > 0, "Withdrawal amount must be positive")
      if (amount <= balance) {
        balance -= amount
      } else {
        println(s"Insufficient funds. Current balance: $$balance")
      }
    }

    // Transfer money from this account to another account
    def transfer(amount: Double, target: Account): Unit = {
      require(amount > 0, "Transfer amount must be positive")
      if (amount <= balance) {
        this.withdraw(amount)
        target.deposit(amount)
      } else {
        println(s"Insufficient funds for transfer. Current balance: $$balance")
      }
    }

    // Apply interest: 5% for positive balance, 10% penalty for negative balance
    def applyInterest(): Unit = {
      if (balance > 0) {
        balance += balance * 0.05
      } else if (balance < 0) {
        balance += balance * 0.1
      }
    }

    override def toString: String = s"Account(balance: $$balance)"
  }

  // Bank class representing a collection of accounts
  class Bank(accounts: List[Account]) {

    // 4.1 List of Accounts with negative balances
    def accountsWithNegativeBalance: List[Account] = {
      accounts.filter(_.balance < 0)
    }

    // 4.2 Calculate the sum of all account balances
    def totalBalance: Double = {
      accounts.map(_.balance).sum
    }

    // 4.3 Apply interest to all accounts and return final balances
    def applyInterestToAllAccounts(): List[Double] = {
      accounts.foreach(_.applyInterest())
      accounts.map(_.balance)
    }
  }

  def main(args: Array[String]): Unit = {
    // Create some accounts
    val account1 = new Account(1000)
    val account2 = new Account(-500)
    val account3 = new Account(200)
    val account4 = new Account(-300)
    
    // Create a bank with the list of accounts
    val bank = new Bank(List(account1, account2, account3, account4))

    // 4.1 Get list of accounts with negative balances
    println("Accounts with negative balance:")
    bank.accountsWithNegativeBalance.foreach(println)

    // 4.2 Calculate the sum of all account balances
    println(s"Total balance of all accounts: $$${bank.totalBalance}")

    // 4.3 Apply interest to all accounts and show final balances
    bank.applyInterestToAllAccounts()
    println("Final balances after applying interest:")
    bank.applyInterestToAllAccounts().foreach(balance => println(s"$$${balance}"))
  }
}
