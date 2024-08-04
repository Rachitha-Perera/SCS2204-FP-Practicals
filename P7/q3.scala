object Prime{
    //helper function
    def isPrime(n:Int):Boolean={
        if (n<=1) false
        else if (n==2) true
        else if (n%2==0) false
        else{
            !(3 to math.sqrt(n).toInt by 2).exists(i => n%i == 0) // step is 2(2 by 2)
        }
    }

    def filterPrime(nums:List[Int]):List[Int]={
        nums.filter(n => isPrime(n))
    }
    
    def main(args:Array[String]):Unit={
        var numList = List(1,2,3,4,5,6,7,8,9,10)
        println("List : "+numList)
        var filteredPrimeList = filterPrime(numList)
        println("Filterd List : "+filteredPrimeList)
    }
}