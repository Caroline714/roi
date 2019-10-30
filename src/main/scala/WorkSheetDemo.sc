object WorkSheetDemo {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  var x = 1                                       //> x  : Int = 1
  println(x)                                      //> 1
  //for
  var l = List("abc", "bc", "c")                  //> l  : List[String] = List(abc, bc, c)
  for (
    s <- l
  ) println(s)                                    //> abc
  //| bc
  //| c
  //filter
  for {
    s <- l
    if (s.length > 2)
  } println(s)                                    //> abc

  //yield
  for {
    s <- l
    s1 = s.toUpperCase()
  } yield (s1)                                    //> res0: List[String] = List(ABC, BC, C)

  //try catch finally
  var result = try { Integer.parseInt("do") } catch {
    case _ => 2
  } finally { println("finally") }                //> finally
  //| result  : Int = 2
  //match
  var caseVar = 1                                 //> caseVar  : Int = 1
  var result_case = caseVar match {
    case 1 => "first"
    case 2 => "second"
    case _ => "others"
  }                                               //> result_case  : String = first
}