object Even{
    def filterEvenNumbers(nums:List[Int]):List[Int]={
        nums.filter(n => n%2==0)
    }

    def main(args:Array[String]):Unit={
        var numList = List(1,2,3,4,5,6,7,8,9,10)
        println("List : "+numList)
        var filteredNumList = filterEvenNumbers(numList)
        println("Filterd List : "+filteredNumList)
    }
}