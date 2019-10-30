import org.apache.spark.sql.{Row, SparkSession}

object SparkTest {

  def main(args: Array[String]): Unit = {

    //本地spark环境配置
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



    //释放spark资源
    spark.stop()
  }

}
