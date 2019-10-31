import org.apache.spark.sql.{Row, SparkSession}

object SparkTest {

  def main(args: Array[String]): Unit = {

    //spark环境配置
    val spark = SparkSession
          .builder().master("local")
          .appName("test")
          .config("spark.some.config.option", "some-value")
          //.enableHiveSupport()
          .getOrCreate()

    //读取csv文件
    val csv1="/Users/zhangxu35/Desktop/scala_test_data.csv"
    val data_df=spark.read.format("csv").option("header","true").load(csv1)

    //存入df
    data_df.createOrReplaceTempView("scala_test_data_df")


    saveToFile(spark,"app_ai_trade_scala_test_result")


    //释放spark资源
//    spark.stop()
  }

  def saveToFile(spark: SparkSession, resultTable: String):Unit={
    import spark.sql

    val sql_str =
    """
      |select * from $resultTable
    """.stripMargin
    print(sql_str)

    val sql_df = sql(sql_str)
  }

}
