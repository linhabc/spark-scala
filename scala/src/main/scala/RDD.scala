import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object Main {
  val appName: String = "MyApp"
  val master: String = "local"
  val conf = new SparkConf().setAppName(appName).setMaster(master)
  new SparkContext(conf)
}
