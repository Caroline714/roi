import FuncDec.varPara

import scala.util.matching.Regex

object FuncDec {
/*
1. scala worksheet

2. scala object

3. scala class

4. scala script

 */

  def main(args: Array[String]) {

    println( "1.指定部分参数取值：" + addVar(b=5,a=7))
    print("2.函数嵌套调用：" + delayed(printMe,"Hello World!")+"\n");
    println("3.可变参数函数：" + varPara("a","b","c"))
    println("4.内嵌函数：" + factorial(0))
    println("5.addVar函数转换为匿名函数：" + sumFuc(7,5,0.4))

    val varParaResult = varPara(_:String, _:String,"c")
    println("6.函数赋值给变量：" + varParaResult("a","b"))

    println("7.scala闭包：" + multiplier(4))

    //实例化类
    val classTest = new ClassTest(5,10)
    println("8.调用类的方法："+classTest.move(1,2))
    println("9.模式匹配：" + matchTest("two"))


  }


  //==================== PART1: 变量声明 ====================
  //
  //  1. 格式：修饰符 变量名 [: 变量类型] = 数值
  //  2. 使用关键词 "var" 声明变量，使用关键词 "val" 声明常量
  //  3. 使用 val 是安全和增强代码可读性的
  //
  //==================== PART1: 变量声明 ====================
  var para1: Int = 3
  var para2 = 4
  val para3 = 5.0


  //************************* 字符串 *************************
  //
  //  1. 在 Scala 中，字符串的类型实际上是 Java String，它本身没有 String 类
  //  2. String是一个不可变的对象,如果修改字符串就会产生一个新的字符串对象
  //  3. 如果需要创建一个可以修改的字符串，可以使用 String Builder 类
  //
  //************************* 字符串 *************************
  var para4: String = "String"
  //变长字符串
  val buf = new StringBuilder
  buf += 'a'
  buf ++= "bcdef"
  println(("10.buf is : " ).concat(buf.toString ))

  //字符串长度
  var len = buf.length()
  //格式化字符串
  var fs = printf("11.浮点型变量为 " + "%f, 整型变量为 %d, 字符串为 " + " %s", 3.4, 10, "aaa")
  println(fs)


  //*************************** 数组 ***************************
  //
  //*************************** 数组 ***************************
  var z:Array[String] = new Array[String](3)
  z(0) = "a"
  var myList = Array("Runoob", "Baidu", "Google")
  //输出数组元素
  for ( x <- myList ) {
    print( "12.数组："+x +" ")
  }

  import Array._
  //多维数组  ofDim
  var myMatrix = ofDim[Int](3,3)
  for (i <- 0 to 2) {
    for ( j <- 0 to 2) {
      myMatrix(i)(j) = j
    }
  }
  var myList1 = range(10, 20, 2)

  //*************************** 集合 ***************************
  //  1. 类型：List / Set / Map / tuple / Option / Iterator
  //*************************** 集合 ***************************
  // 定义整型 List
  val x1 = List(1,2,3,4)
  // 定义 Set
  val x2 = Set(1,3,5,7)
  // 定义 Map
  val x3 = Map("one" -> 1, "two" -> 2, "three" -> 3)
  println("13.Map：" + x3)
  // 创建两个不同类型元素的元组
  val x4 = (10, "Runoob")
  // 定义 Option 表示有可能包含值的容器，也可能不包含值
  val x5 : Option[Int] = Some(5)
  // 定义 Iterator：集合器
  val it = Iterator("Baidu", "Google", "Runoob", "Taobao")
  while (it.hasNext){
    print("14."+it.next())
  }



  //==================== PART2: 函数声明 ====================
  //
  // def 函数名 ([参数列表]) : [返回值类型]={}
  // 返回值类型：Byte,short,Int,Long,Float,Double,Char,String,Boolean,Unit,Null,Nothing,Any,AnyRef
  //
  //====================函数声明====================

  //************************* 场景1 *************************
  //
  //=================>>> 指定部分参数取值 <<<==================
  def addVar(a:Int, b:Int, c:Double = 0.4) : Double = {
      var sum : Double = 0.0    //可变变量声明用var
      sum = a + b + c
      return sum  // 'return' 可以省略
    }




  //************************* 场景2 *************************
  //                     支持自身递归调用
  //===================>>> 函数嵌套调用 <<<====================
  def printMe(s: String) : Unit = {
      print(s)
  }
  def delayed( f: String => Unit,s: String) = {
    f(s)
  }




  //************************* 场景3 *************************
  //
  //===================>>> 可变参数函数 <<<====================
  def varPara(strings: String*):Int = {
    var s =0
    for(string <- strings){
      s = s+1
    }
    s
  }




  //************************* 场景4 *************************
  //
  //====================>>> 内嵌函数 <<<======================
  def factorial(i: Int): Int = {
    def fact(i: Int, accumulator: Int): Int = {
      if (i <= 1)
        accumulator
      else
        fact(i - 1, i * accumulator)
    }
    fact(i, 1)
  }




  //************************* 场景5 *************************
  //
  //====================>>> 匿名函数 <<<======================
  var sumFuc = (a:Int,b:Int,c:Double) => a+b+c




  //************************* 场景6 *************************
  //
  //====================>>> scala闭包 <<<====================
  def multiplier(i:Int): Int = {
    var j = i * para1
    return j
  }




  //************************* 场景7 *************************
  //
  //=====================>>> 类的继承 <<<=====================
//  class Location(override val xc: Int, override val yc: Int,
//                 val zc :Int) extends ClassTest(xc, yc){
//    var z: Int = zc
//    def move(dx: Int, dy: Int, dz: Int) {
//      x = x + dx
//      y = y + dy
//      z = z + dz
//      println ("x 的坐标点 : " + x);
//      println ("y 的坐标点 : " + y);
//      println ("z 的坐标点 : " + z);
//    }
//  }



  //************************* 场景8 *************************
  //
  //=====================>>> 伴生对象 <<<=====================
  // 私有构造方法
  class Marker private(val color:String) {
    println("15.创建伴生对象：" + this)
    override def toString(): String = "颜色标记："+ color

  }
  // 伴生对象，与类名字相同，可以访问类的私有属性和方法
  object Marker{

    private val markers: Map[String, Marker] = Map(
      "red" -> new Marker("red"),
      "blue" -> new Marker("blue"),
      "green" -> new Marker("green")
    )

    def apply(color:String) = {
      if(markers.contains(color)) markers(color) else null
    }

    def getMarker(color:String) = {
      if(markers.contains(color)) markers(color) else null
    }
    def main(args: Array[String]) {
      println("16."+Marker("red"))
      // 单例函数调用，省略了.(点)符号
      println(Marker getMarker "blue")
    }
  }



  //************************* 场景9 *************************
  //
  //=====================>>> 模式匹配 <<<=====================
  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
    case _ => "many"
  }



  //************************* 场景10 *************************
  //
  //======================>>> 样例类 <<<=======================
  case class Person(name: String, age: Int)

  val alice = new Person("Alice", 25)
  val bob = new Person("Bob", 32)
  val charlie = new Person("Charlie", 32)

  for (person <- List(alice, bob, charlie)) {
    person match {
      case Person("Alice", 25) => println("Hi Alice!")
      case Person("Bob", 32) => println("Hi Bob!")
      case Person(name, age) =>
        println("17.Age: " + age + " year, name: " + name + "?")
    }
  }



  //************************* 场景11 *************************
  //
  //=====================>>> 正则表达式 <<<=====================
  val pattern = new Regex("(S|s)cala")  // 首字母可以是大写 S 或小写 s
  val str = "Scala is scalable and cool"

  println((pattern findAllIn str).mkString(","))   // 使用逗号 , 连接返回结果
}
