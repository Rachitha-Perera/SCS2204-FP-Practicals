object StringFormatter {
  def toUpper(name: String): String = {//string to uppercase
    name.toUpperCase()
  }
  def toLower(name: String): String = {//string to lowercase
    name.toLowerCase()
  }
  def formatNames(name: String, format: String => String): String = {//format to a string
    format(name)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    println(formatNames(names(0), toUpper)) // Output: BENNY
    println(formatNames(names(1), (name: String) => {
      val splitName = name.splitAt(2)
      splitName._1.toUpperCase() + splitName._2.toLowerCase()
    })) // Output: NIroshan
    println(formatNames(names(2), toLower)) // Output: saman
    println(formatNames(names(3), (name: String) => {
      val splitName = name.splitAt(name.length - 1)
      splitName._1.toLowerCase() + splitName._2.toUpperCase()
    })) // Output: KumarA
  }
}