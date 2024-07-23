import scala.io.StdIn.readLine

object InventoryManagement {
  def getProductList(): List[String] = {
    var products = List[String]()
    var input = ""
    println("Enter product names (type 'done' to finish):")

    while (input != "done") {
      input = readLine()
      if (input != "done") {
        products = products :+ input
      }
    }
    products
  }

  def printProductList(products: List[String]): Unit = {
    println("Product List:")
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.size
  }

  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    printProductList(productList)
    val totalProducts = getTotalProducts(productList)
    println(s"Total number of products: $totalProducts")
  }
}

// Run the main method
InventoryManagement.main(Array())