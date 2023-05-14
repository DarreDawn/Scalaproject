import scala.io.{Source, StdIn}


object function{

  def filetolist(int: Int):List[Double] = {
    val FLfilePath = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/tuntidata_2022.csv"
    val FLcolumn = int
    val FLlines = Source.fromFile(FLfilePath).getLines()
    val columnData = FLlines.map(_.split(",").lift(FLcolumn).getOrElse("0").toDouble).toList
    return columnData
  }

  def filetolistmonth(int: Int): List[Double] = {
    time.monthly()
    val MonthfilePath = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/monthly.csv"
    val Monthcolumn = int
    val Monthlines = Source.fromFile(MonthfilePath).getLines()
    val MonthcolumnData = Monthlines.map(_.split(",").lift(Monthcolumn).getOrElse("0").toDouble).toList
    return MonthcolumnData
  }

  def filetolistDay(int: Int): List[Double] = {
    time.monthly()
    time.Daily()
    val DayfilePath = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/Daily.csv"
    val Daycolumn = int
    val Daylines = Source.fromFile(DayfilePath).getLines()
    val DaycolumnData = Daylines.map(_.split(",").lift(Daycolumn).getOrElse("0").toDouble).toList
    return DaycolumnData
  }

  def filetolistHour(int: Int): List[Double] = {
    time.monthly()
    time.Daily()
    time.Hourly()
    val HourfilePath = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/Hourly.csv"
    val Hourcolumn = int
    val Hourlines = Source.fromFile(HourfilePath).getLines()
    val HourcolumnData = Hourlines.map(_.split(",").lift(Hourcolumn).getOrElse("0").toDouble).toList
    return HourcolumnData
  }

  def filetolistweek(int: Int): List[Double] = {
    time.weekly()
    val WeekfilePath = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/weekly.csv"
    val Weekcolumn = int
    val Weeklines = Source.fromFile(WeekfilePath).getLines()
    val weekcolumnData = Weeklines.map(_.split(",").lift(Weekcolumn).getOrElse("0").toDouble).toList
    return weekcolumnData
  }

  def FTLChoicefunction(int: Int): List[Double] = {
    println("Do you want to filter data by time?(Y:Yes, N:No)")
    println("You answer:")
    val strchoice = StdIn.readLine()
    if (strchoice == "N") {
      val datalist = function.filetolist(int)
      datalist
    }
    else {
      println("How do you want to filter?\n1.monthly\n2.Daily\n3.Hourly\n4.weekly:")
      print("Your Choice: ")
      val datalistchioce = StdIn.readInt()
      datalistchioce match {
        case 1=>
          val datalist = function.filetolistmonth(int)
          datalist
        case 2=>
          val datalist = function.filetolistDay(int)
          datalist
        case 3=>
          val datalist = function.filetolistHour(int)
          datalist
        case 4=>
          val datalist = function.filetolistweek(int)
          datalist
      }

    }
  }

}
object Optionspage extends App {
  wholepage()
  def wholepage(): Unit = {
    print("Please enter the data you want to view\n1. Hourly power generation data for HydroPower, WindPower and SolarPower respectively&collect and store the data in the file\n2. Hourly data for EnergyGeneration and StorageCapacity respectively\n3. Data Analysis.\n4. Quit system\nYour choice:")
    val choice = StdIn.readInt()
    try {
      if(choice>4){
        throw new ArithmeticException("Please enter the number 1-4!")
      }
      choice match {
        case 1 =>
          question12.question1()
          wholepage()
        case 2 =>
          question12.question2()
          wholepage()
        case 3 =>
          dataanalysis()
          def dataanalysis(): Unit = {
            println("Which data do you want to analysis?")
            print("1.HydroPower\n2.WindPower\n3.SolarPower\n4.EnergyGeneration\n5.StorageCapacity\n6.Back to  previous level.\n")
            print("Your choice:")
            val powerchioce = StdIn.readInt()
            try {
              if (powerchioce > 6) {
                throw new ArithmeticException("Please enter the number 1-6!")
              }
              val powerlistnumber = powerchioce + 4
              if (powerchioce == 5) {
                println("StorageCapacity always is 15000.")
                dataanalysis()
              }
              else if (powerchioce == 6) {
                wholepage()
              }
              else {
                val datalist = function.FTLChoicefunction(powerlistnumber)
                choosemethod()

                def choosemethod(): Unit = {
                  println("How do you want to analyze the data?")
                  print("1.Get Average\n2.Get Median\n3.Get Mode\n4.Get range\n5.Get Midrange\n6.Back to previous level.\n")
                  print("Your choice:")
                  val methodchioce = StdIn.readInt()
                  try {
                    if (methodchioce > 6) {
                      throw new ArithmeticException("Please enter the number 1-6!")
                    }
                    methodchioce match {
                      case 1 =>
                        operation.Averagemassage(datalist)
                        choosemethod()
                      case 2 =>
                        operation.Medianmassage(datalist)
                        choosemethod()
                      case 3 =>
                        operation.Mode(datalist)
                        choosemethod()
                      case 4 =>
                        operation.rangemassage(datalist)
                        choosemethod()
                      case 5 =>
                        operation.Midrangemassage(datalist)
                        choosemethod()
                      case 6 =>
                        dataanalysis()
                    }
                  } catch {
                    case ex: ArithmeticException =>
                      println("Error: " + ex.getMessage)
                      choosemethod()
                  }
                }
              }
            } catch {
              case ex: ArithmeticException =>
                println("Error: " + ex.getMessage)
                dataanalysis()
            }
          }
        case 4 =>
          println("Welcome to your next visit!")
      }
    } catch {
      case ex: ArithmeticException =>
        println("Error: " + ex.getMessage)
        wholepage()
    }
  }

}

