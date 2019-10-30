object MyTest {
/*
1. scala worksheet

2. scala object

3. scala class

4. scala script


 */

  def main(args: Array[String]) {

    //方法调用：[instance.]functionName( 参数列表 )
    println( "方法调用: " + addInt(5,7) );
  }


  //方法声明：def functionName ([参数列表]) : [return type]={}
  //有返回值
  def addInt(a:Int, b:Int) : Int = {
      var sum:Int = 0
      sum = a + b
      return sum
    }

  //没有返回值  Unit
  def printMe( ) : Unit = {
      println("Hello, Scala!")
  }

    //函数示例

}
