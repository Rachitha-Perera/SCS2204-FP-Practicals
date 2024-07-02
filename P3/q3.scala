def arMean(num1:Int,num2:Int):Double={
    var mean=(num1+num2)/2.00
    mean
}
def main(args:Array[String]):Unit={
    var num1=78;
    var num2=69;
    printf("Mean is %.2f",arMean(num1,num2));
}