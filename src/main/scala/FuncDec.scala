import FuncDec.varPara

object FuncDec {
/*
1. scala worksheet

2. scala object

3. scala class

4. scala script

 */

  def main(args: Array[String]) {

    println( "指定部分参数取值：" + addVar(b=5,a=7))
    print("函数嵌套调用：" + delayed(printMe,"Hello World!")+"\n");
    println("可变参数函数：" + varPara("a","b","c"))
    println("内嵌函数：" + factorial(0))
    println("addVar函数转换为匿名函数：" + sumFuc(7,5,0.4))

    val varParaResult = varPara(_:String, _:String,"c")
    println("函数赋值给变量：" + varParaResult("a","b"))

    println("scala闭包：" + multiplier(4))

  }


  //==================== PART1: 变量声明 ====================
  //
  //
  //
  //==================== PART1: 变量声明 ====================
  var para1: Int = 3
  var para2 = 4
  val para3 = 5.0
  val para4 = "String"






  //==================== PART2: 函数声明 ====================
  //
  // def 函数名 ([参数列表]) : [返回值类型]={}
  // 返回值类型：Unit/Int/Double/String/Float...
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
  //************************* 场景1 *************************



  //************************* 场景2 *************************
  //                     支持自身递归调用
  //===================>>> 函数嵌套调用 <<<====================
  def printMe(s: String) : Unit = {
      print(s)
  }
  def delayed( f: String => Unit,s: String) = {
    f(s)
  }
  //************************* 场景2 *************************




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
  //************************* 场景3 *************************




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
  //************************* 场景4 *************************




  //************************* 场景5 *************************
  //
  //====================>>> 匿名函数 <<<======================
  var sumFuc = (a:Int,b:Int,c:Double) => a+b+c
  //************************* 场景5 *************************




  //************************* 场景6 *************************
  //
  //====================>>> scala闭包 <<<====================
  def multiplier(i:Int): Int = {
    var j = i * para1
    return j
  }
  //************************* 场景6 *************************

}
