object InvManagement{

    var items:Array[String] = Array("Apple", "Milk", "Onion")
    var quantity:Array[Int] = Array(5,6,7)
    def displayInventory(): Unit = {
        println("Inventory : ")
        for((name, quant) <- items.zip(quantity)){ // zip - pairs adjacent elements of different collection
            //println(s"Item Name : $name, Item Quantity : $quant")
            printf("Name : %s, Quantity : %d\n",name,quant)
        }
    }

    def restockItem(itemName: String, quant: Int): Unit = {
        val index = items.indexOf(itemName)
        if (index != -1) {
            quantity(index) += quant // qty array += new qty
            printf("Item %s restocked.\n",itemName)
        } else {
            printf("Item %s not in inventory!\n",itemName);
        }
    }

    def sellItem(itemName: String, quant: Int): Unit = {
    val index = items.indexOf(itemName)
    if (index != -1) {
      if (quantity(index) >= quant) {
        quantity(index) -= quant
        printf("Quantity %d of item %s Sold\n",quant,itemName)
      } else {
        printf("Not enough quantity of %s to sell\n",itemName)
      }
    } else {
        printf("Item %s does not exists!\n",itemName)
        
    }
  }

    def main(args : Array[String]):Unit={
        displayInventory()
        restockItem("Apple",2)
        displayInventory()
        sellItem("Apple",2)
        displayInventory();


    }

}