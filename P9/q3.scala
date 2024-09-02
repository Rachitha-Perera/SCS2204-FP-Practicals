object StringFormatter {

  // Method to convert a string to upper case
  def toUpper(str: String): String = str.toUpperCase

  // Method to convert a string to lower case
  def toLower(str: String): String = str.toLowerCase

  // Method to format a name using a given formatting function
  def formatNames(name: String)(formatter: String => String): String = {
    formatter(name)
  }

  def main(args: Array[String]): Unit = {
    // Test inputs
    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    // Applying the formatting functions
    val upperCased = names.map(name => formatNames(name)(toUpper))
    val lowerCased = names.map(name => formatNames(name)(toLower))

    // Printing the results
    println(upperCased.mkString("\n"))
    println(lowerCased.mkString("\n"))
  }
}
