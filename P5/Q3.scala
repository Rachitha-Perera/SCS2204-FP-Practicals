import scala.io.StdIn

def fib(n:Int):Int={
    if(n<=1) n
    else fib(n-1)+fib(n-2)
}

def main(args:Array[String]):Unit={
    printf("Enter a number : ")
    val n=StdIn.readInt()
    printf("\nFirst %d fibonacci numbers are : ",n)
    for(i<-0 to n){
        printf("%d ",fib(i))
    }
}
