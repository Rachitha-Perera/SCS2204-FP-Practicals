object InterestCalculator {

  //lambda function
  val calculateInterest: Double => Double = deposit => deposit match {
    case d if d <= 20000 => d * 0.02
    case d if d <= 200000 => d * 0.04
    case d if d <= 2000000 => d * 0.035
    case _ => deposit * 0.065
  }

  def main(args: Array[String]): Unit = {
    
    val depositAmount = 150000
    val interest = calculateInterest(depositAmount)
    println(f"The interest earned on a deposit of Rs. $depositAmount is Rs. $interest%.2f")
  }
}