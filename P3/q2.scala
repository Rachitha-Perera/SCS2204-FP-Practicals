//filter() - used to filter strings to a condition
def str5(str:List[String]):List[String]={
    str.filter(_.length>5)
}
def main(args:Array[String]):Unit={
    var strList=str5(List("apple","orange","mango","jack","5555","666666","hi"))
    println(strList)
}