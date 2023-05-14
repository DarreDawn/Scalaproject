import scala.collection.mutable
object operation {
  def Average(list: List[Double]):Double = {
    if (list.length == 0)
      0
    else {
      val ave = BigDecimal(list.sum / list.size)
      ave.toDouble
    }
  }

  def Averagemassage(list: List[Double]): Unit = {
    try {
      val a = Average(list)
      if (a == null) {
        throw new ArithmeticException("This list is empty")
      }
      else if (a == 0) {
        throw new ArithmeticException("Production volume is zero.")
      }
      else {
        println("The average of this list is " + a)
      }
    } catch {
      case ex: ArithmeticException =>
        println("Error: " + ex.getMessage)
    }
  }

  def Median(list: List[Double]): Double = {
    try {
      if (list.isEmpty) {
        throw new ArithmeticException("This list is empty")
      }
      val sortedList = list.sorted
      val len = sortedList.length
      if (len != 0 && len % 2 == 0) {
        val mid1 = len / 2
        val mid2 = mid1 - 1
        (sortedList(mid1) + sortedList(mid2)) / 2.0
      } else if (len == 0) {
        0
      } else {
        sortedList(len / 2)
      }
    } catch {
      case ex: ArithmeticException =>
        println("Error: " + ex.getMessage)
        0
    }
  }


  def Medianmassage(list: List[Double]): Unit = {
    try {
      val a = Median(list)
      if (a == null) {
        throw new ArithmeticException("This list is empty")
      }
      else if (a == 0) {
        throw new ArithmeticException("Production volume is zero.")
      } else {
        println("The median of this list is " + a)
      }
    } catch {
      case ex: ArithmeticException =>
        println("Error: " + ex.getMessage)
    }
  }


  def Mode(list: List[Double]): Unit = {
    try {
      if (list.isEmpty) {
        throw new ArithmeticException("This list is empty")
      }
      val seqop = (result: mutable.HashMap[Double, Int], number: Double) => {
        val numbercount = result.getOrElse(number, 0) + 1
        result.update(number, numbercount)
        result
      }

      val combop = (result1: mutable.HashMap[Double, Int], result2: mutable.HashMap[Double, Int]) => {
        result2.foreach { case (num, count) =>
          val totalCount = result1.getOrElse(num, 0) + count
          result1.update(num, totalCount)
        }
        result1
      }
      val modemap = list.aggregate(mutable.HashMap[Double, Int]())(seqop, combop)
      println(modemap)
      val Maxcount = modemap.values.max
      val mostFrequentNumbers = modemap.filter { case (_, count) => count == Maxcount }.keys.toList
      println(s"Most frequent numbers: $mostFrequentNumbers")
    } catch {
      case ex: ArithmeticException =>
        println("Error: " + ex.getMessage)
    }
  }

  def range (list: List[Double]): Double = {
    val sortedlist = list.sorted
    val range = sortedlist.last -sortedlist.head
    range
  }

  def rangemassage(list: List[Double]): Unit = {
    try {
      if (list.isEmpty) {
        throw new ArithmeticException("This list is empty")
      }
      val dou = range(list)
      println("The range of this list is " + dou)
    } catch {
      case ex: ArithmeticException =>
        println("Error: " + ex.getMessage)
    }
  }


  def Midrange(list: List[Double]): Double = {
    val sortedlist = list.sorted
    val range = sortedlist.last + sortedlist.head
    val result = range/2
    result
  }
  def Midrangemassage(list: List[Double]): Unit = {
    try {
      if (list.isEmpty) {
        throw new ArithmeticException("This list is empty")
      }
      val Mid = Midrange(list)
      println("The Midrange of this list is " + Mid)
    } catch {
      case ex: ArithmeticException =>
        println("Error: " + ex.getMessage)
    }
  }


}
object Main extends App{
  val a = List(1.0,2.0,3.0,4.0,5.0)
  val b = List()
  operation.Averagemassage(a)
  operation.Averagemassage(b)
  val nums = List(1.0, 3, 5, 2, 4)
  val num = List(1,8,6,4,9,3,76,4.0)
  operation.Medianmassage(nums)
  operation.Medianmassage(num)
  val testcount1  = List(1,2,3,4,1,2,3,4,1,2,3,4,5,1,2,5,6.0)
  operation.Mode(testcount1)
  val num2 = List(1,8,6,4,9,3,76,4.0)
  println(operation.range(num2))
  println(operation.Midrange(num2))
}