object BankApp {

  class Account(var balance: Double) {

    // Method to deposit money into the account
    def deposit(amount: Double): Unit = {
      require(amount > 0, "Deposit amount must be positive")
      balance += amount
      println(s"Deposited $$amount. New balance: $$balance")
    }

    // Method to withdraw money from the account
    def withdraw(amount: Double): Unit = {
      require(amount > 0, "Withdrawal amount must be positive")
      if (amount <= balance) {
        balance -= amount
        println(s"Withdrew $$amount. New balance: $$balance")
      } else {
        println(s"Insufficient funds. Current balance: $$balance")
      }
    }

    // Method to transfer money from this account to another account
    def transfer(amount: Double, target: Account): Unit = {
      require(amount > 0, "Transfer amount must be positive")
      if (amount <= balance) {
        this.withdraw(amount)
        target.deposit(amount)
        println(s"Transferred $$amount to target account. Your new balance: $$balance")
      } else {
        println(s"Insufficient funds for transfer. Current balance: $$balance")
      }
    }

    // Method to print the current balance
    def printBalance(): Unit = {
      println(s"Current balance: $$balance")
    }
  }

  def main(args: Array[String]): Unit = {
    // Create two accounts
    val account1 = new Account(1000)
    val account2 = new Account(500)

    // Print initial balances
    println("Initial Balances:")
    account1.printBalance() // Output: Current balance: $1000.0
    account2.printBalance() // Output: Current balance: $500.0

    // Deposit money into account1
    account1.deposit(200) // Output: Deposited $200.0. New balance: $1200.0

    // Withdraw money from account2
    account2.withdraw(100) // Output: Withdrew $100.0. New balance: $400.0

    // Transfer money from account1 to account2
    account1.transfer(300, account2) 
    // Output:
    // Withdrew $300.0. New balance: $900.0
    // Deposited $300.0. New balance: $700.0
    // Transferred $300.0 to target account. Your new balance: $900.0

    // Print final balances
    println("Final Balances:")
    account1.printBalance() // Output: Current balance: $900.0
    account2.printBalance() // Output: Current balance: $700.0
  }
}
