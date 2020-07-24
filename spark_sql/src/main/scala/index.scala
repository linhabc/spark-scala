import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row;
import org.apache.spark.sql.types.{StructType, StructField, StringType};

object Main {
  // Programmatically Specifying the Schema
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder()
      .appName("Spark SQL")
      .getOrCreate()

    val employee = spark.sparkContext.textFile("./employee.txt")
    val schemaString = "id name age"

    val schema = StructType(
      schemaString
        .split(" ")
        .map(fieldName => StructField(fieldName, StringType, true))
    )

    val rowRDD = employee
      .map(_.split(","))
      .map(e => Row(e(0).trim, e(1), e(2).trim))

    val employeeDF = spark.createDataFrame(rowRDD, schema)

    employeeDF.createOrReplaceTempView("employee")
    val allrecords = spark.sql("SELECT * FROM employee")
    allrecords.show()
  }
}
