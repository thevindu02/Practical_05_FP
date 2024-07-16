import scala.io.StdIn.readLine


object InventoryManagement {

    def getProducts(): List[String] = {

        var productList: List[String] = List()
        var input: String = ""

        println("Enter product names(Type 'done' to finish):");

            input = readLine()

        while( input != "done") {
            
            productList = productList :+ input

            input = readLine()

        }

        productList

    }

    def printProducts(productList:List[String]): Unit = {

        productList.zipWithIndex.foreach{ case (product, index) =>

            println(s"${index + 1}.$product")

        }
    }

    def totalProducts(productList:List[String]):Int = {

        productList.length
    }


    def main (args: Array[String]):Unit = {

        val products = getProducts()
        println("Product List:")
        printProducts(products)
        println(s"Total number of products: ${totalProducts(products)}")
    }
}