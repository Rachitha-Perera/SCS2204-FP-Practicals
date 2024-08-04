object Suare{
    def calculateSquare(nums:List[Int]):List[Int]={
        nums.map(n => n*n)
    }
    def main(args:Array[String]):Unit={
        var numList = List(1,2,3,4,5)
        println("List : "+numList)
        var squaredNumList = calculateSquare(numList)
        println("Filterd List : "+squaredNumList)
    }
}