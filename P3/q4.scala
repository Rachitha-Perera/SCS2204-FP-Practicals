import scala.io.StdIn

def SOE():Int=
    printf("enter a list of integers(seperated by spaces) : ")
    val inp=StdIn.readLine()
    val nums=inp.split(" ").map(_.toInt).toList
    nums.filter(_%2==0).sum

def main(args:Array[String]):Unit={
    val res=SOE()
    printf("sum of even numbers in list is %d",res)
}