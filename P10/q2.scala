object RationalOperations {

  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator cannot be zero")

    // Compute the greatest common divisor to simplify the fraction
    private val g = gcd(n.abs, d.abs)
    
    // Ensure the denominator is positive and normalize the numerator accordingly
    val numerator: Int = (if (d < 0) -n else n) / g
    val denominator: Int = d.abs / g

    // Method to negate the rational number
    def neg: Rational = new Rational(-numerator, denominator)

    // Method to subtract two rational numbers
    def sub(that: Rational): Rational = {
      new Rational(
        this.numerator * that.denominator - that.numerator * this.denominator,
        this.denominator * that.denominator
      )
    }

    // Method to calculate the greatest common divisor (GCD)
    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }

    // Override toString to display the rational number
    override def toString: String = s"$numerator/$denominator"
  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result = y.sub(z)
    println(s"y - z = $result") // Expected output: y - z = 19/56
  }
}
