import org.apache.spark._
import org.apache.spark.streaming._
// import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.StreamingContext._

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe

object KafkaSpark {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("Kafka Spark")
    val scc = new StreamingContext(conf, Seconds(5))

    val topics = Array("topicA", "topicB")

    // config for consumer
    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "test",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )

    // create an input Dstream from Kafka topic(s)
    val stream = KafkaUtils.createDirectStream[String, String](
      scc,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    )

    var seq = stream.map(record => (record.key, record.value))

    seq.print()

    scc.start()
    scc.awaitTermination()
  }
}
