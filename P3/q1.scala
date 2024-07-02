def sReverse(s:String):String={
    if(s.isEmpty()) ""
    else sReverse(s.tail)+ s.head
}

def main(args:Array[String]):Unit={
    println(sReverse("Bye!"))
}
