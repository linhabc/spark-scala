import org.apache.spark.sql.SparkSession

case class Person(id: String, name: String, age: Long)

object Main2 {
  // Inferring the Schema Using Reflection
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder()
      .appName("Spark SQL")
      .getOrCreate()

    import spark.implicits._

    val employeeDF = spark.sparkContext
      .textFile("./employee.txt")
      .map(_.split(","))
      .map(attributes =>
        Person(attributes(0), attributes(1), attributes(2).trim.toInt)
      )
      .toDF()

    employeeDF.createOrReplaceTempView("employee")

    val allrecords = spark.sql("SELECT * FROM employee")
    allrecords.show()

    employeeDF.select($"name", $"age" + 1).show

    employeeDF.select(employeeDF("name"), $"age" + 1).show

  }
}
