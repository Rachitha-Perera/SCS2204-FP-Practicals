import scala.collection.mutable.Map

def main(args:Array[String]):Unit={
    val inventory1:Map[Int,(String,Int,Double)]=Map(
        0->("Apple",65,25.5),
        1->("Orange",15,20.0),
        2->("Milk",10,35.0)
    )
    //I - print all products
    val productNames=inventory1.values.map(_._1)
    println("Product Names :")
    for (i<-productNames) println(i)

    //II - tot product value
    val totalValue=inventory1.values.map{case (_,q,p) => q*p}.sum
    println("Total Value of Products : "+totalValue)

    //III - check if map empty
    val isMapEmpty:String= if (inventory1.isEmpty) "Empty" else "not Empty" 
    println("inventory1 is "+isMapEmpty)

    //IV - merge inv1 and inv2
    val inventory2:Map[Int,(String,Int,Double)]=Map(
        0->("Apple",50,40.0),
        1->("Orange",30,40.5),
        2->("Milk",15,45.0),
        3->("Bread",15,60.0)
    )
    // val inv1_inv2:Map[Int,(String,Int,Double)]=(inventory1++inventory2).map{
    //     case(id,(n,q,p))=>
    //         val (nexisting,qexisting,pexisting)=inventory2.getOrElse(id,(n,0,0.0))
    //         id->(n, q + qexisting , math.max(p,pexisting))
        
    // }
    //merge all to inv1 here
    val inv1_inv2=inventory1++inventory2
    //resolve errors realated to inv1
    for((id,(n,q,p))<-inv1_inv2){
        inventory1.get(id) match {
            case Some((n1,q1,p1)) =>//if exists, update inv1
                inventory1(id) = (n1,q+q1,math.max(p,p1))
            case None =>//if not, add to inv1
                inventory1(id) = (n,q,p)  
        }
    }
    for((id,(n,q,p))<-inventory1) println("|Id :"+id+" |Product name :"+n+" |Product quantity :"+q+" |Product price :"+p)
    
    //V - check id ID there
    val id=3
    inventory1.get(id) match{
        case Some(n1,q1,p1) =>
            println("Product with Id = "+id+" : ")
            println("|Id :"+id+" |Product name :"+n1+" |Product quantity :"+q1+" |Product price :"+p1)
        case None => 
            println("Product with Id = "+id+" not found!")
    }




    
} 