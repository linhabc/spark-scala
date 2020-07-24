import scala.util.matching.Regex
// import java.{util => ju}
// import scala.io.StdIn.{readLine, readInt}
// import scala.math._
// import scala.collection.mutable.ArrayBuffer
// import java.io.PrintWriter
// import scala.io.Source

// object Scalatutorial {
//   def main(args: Array[String]) {
//     // guessNum()
//     // stringFunc
//     demoListOfArgs(Array("1", "2", "3"))
//   }

//   def printList() {
//     var i = 0
//     var list = List(1, 2, 3, 4)
//     for (i <- list) {
//       println(i)
//     }
//   }

//   def guessNum() {
//     var numGuess = 0
//     print("Guess a number: ")
//     numGuess = readLine.toInt
//     println(f"Your number: ${numGuess}")
//     printf("Your number: %d\n", numGuess)
//   }

//   def stringFunc() {
//     var randSent = "aloalo"

//     println("Are equal? " + "aloalo".equals(randSent))
//   }

//   def demoListOfArgs(args: Array[String]): Unit = {
//     for (arg <- args) {
//       println(arg)
//     }
//   }
// }

// *100*480885585924# ==> TK chinh cua quy khach co 101817 VND.

object GetNum {
  def main(args: Array[String]) {
    print("Input string: ")
    val string = scala.io.StdIn.readLine()

    val pattern = new Regex("[\" \"](\\d+)+")

    var result = (pattern findAllIn string)

    // println(result.length)

    // while (result.hasNext) {
    //   println(result.next())
    // }

    // println(
    //   "result: " + result.slice(0, 1).toList.length
    // )

    println(result.mkString)

  }
}
