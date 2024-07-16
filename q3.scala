import scala.io.StdIn.readInt


object fibbonachiNum {



    def fibonachi(n:Int):Int = {

        if( n <= 0) 0
        else if ( n == 1) 1

        else fibonachi(n-1) + fibonachi(n-2)


    }

    def printFibnum(n:Int):Unit = {

        for(i <- 0 until n)
        {
            println(fibonachi(i))
        }

    }

    def main(args:Array[String]): Unit = {

        println("Enter the number of the fibonachi numbers to print")

        val n = readInt()

        println(s"The first $n Fibonachi numbers are:")

        printFibnum(n)

    }
}