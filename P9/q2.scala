object PatternMatchingExample {

  def main(args: Array[String]): Unit = {
    // Check if the command line argument is provided
    if (args.length != 1) {
      println("Please provide exactly one integer as an argument.")
      sys.exit(1)
    }

    // Try to parse the input argument as an integer
    try {
      val number = args(0).toInt

      // Define the lambda function to classify the number
      val classifyNumber: Int => Unit = num => num match {
        case n if n <= 0 => println("Negative/Zero is input")
        case n if n % 2 == 0 => println("Even number is given")
        case _ => println("Odd number is given")
      }

      // Call the lambda function with the provided number
      classifyNumber(number)
    } catch {
      case e: NumberFormatException => 
        println("Invalid input. Please provide a valid integer.")
        sys.exit(1)
    }
  }
}