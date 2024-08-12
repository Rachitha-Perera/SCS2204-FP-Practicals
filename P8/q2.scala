import scala.io.StdIn.readLine

object Categorize{
    def mul35(n:Int)={
        val isMul3:Int => Boolean = _ % 3 == 0
        val isMul5:Int => Boolean = _ % 5 == 0
        val output = (isMul3(n), isMul5(n)) match {
            case (false, false) => "Not a Multiple of Three or Five"
            case (false, true) => "Multiple of Five"
            case (true, false) => "Multiple of Three"
            case (true, true) => "Multiple of Both Three and Five"
        }
        println(output)
    }
    def main(args:Array[String]):Unit={
        print("Enter an Integer : ")
        val n = readLine().toInt
        mul35(n)
    }
}
