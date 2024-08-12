import scala.io.StdIn.readLine
object CaesarCipher{

    def Encrypt(t:String,shift:Int):String={
        t.map{
            case c if c.isLetter =>
                val base = if(c.isUpper) 'A' else 'a'
                val cNew = ((c-base+shift)%26+26)%26 + base
                cNew.toChar
            case c => c // non-alphabetic chars wont change
        }
    }

    def Decrypt(t:String,shift:Int):String={
        Encrypt(t:String,-(shift):Int) // Decrypt = reverse of Encrypt(-shift)
    }

    def Cipher(encryptFunc:(String, Int) => String, decryptFunc:(String, Int) => String, t:String, shift:Int): (String,String)={
        val encrypted = encryptFunc(t,shift)
        val decrypted = decryptFunc(encrypted,shift)
        (encrypted,decrypted)
    }

    def main(args:Array[String]):Unit={
        print("Enter text : ")
        val t = readLine()
        print("Enter shift : ")
        val shift = readLine().toInt
        if(!shift.isValidInt){
            println("Invalid shift value!")
            System.exit(1)
        }
        val (encrypted,decrypted) = Cipher(Encrypt,Decrypt,t,shift)

        println(s"Original text is $t")
        println(s"Encrypted text is $encrypted")
        println(s"Decrypted text is $decrypted")

    }

    

}