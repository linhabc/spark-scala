import org.apache.spark._
import org.apache.spark.streaming._

object StreamData {
  def main(args: Array[String]) {
    val conf =
      new SparkConf().setMaster("local[*]").setAppName("NetworkWordCount")
    val ssc = new StreamingContext(conf, Seconds(1))
    // val lines = ssc.socketTextStream("localhost", 9999)
  }
}
