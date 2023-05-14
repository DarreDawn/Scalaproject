import scala.io.Source
import java.io._

object question12{
  def question1(): Unit = {
    //** question 1 **//
    val filename = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/tuntidata_2022.csv"
    val file = Source.fromFile(filename)
    val filename1 = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/HWS_power.csv"
    val writer = new PrintWriter(new File(filename1))
    writer.write(s"Time, HydroPower, WindPower, SolarPower\n")


    try {
      for (line <- file.getLines) {
        val fields = line.split(",")
        val year = fields(0).toInt
        val month = fields(1).toInt
        val day = fields(2).toInt
        val hour = fields(3).toInt
        val week = fields(4).toInt
        val hydroPower = try {
          fields(5).toDouble
        } catch {
          case _: Throwable => Double.NaN
        }
        val windPower = try {
          fields(6).toDouble
        } catch {
          case _: Throwable => Double.NaN
        }
        val solarPower = try {
          fields(7).toDouble
        } catch {
          case _: Throwable => Double.NaN
        }
        println(s"$year/$month/$day/$hour/$week: Hydro=$hydroPower, Wind=$windPower, Solar=$solarPower")
        writer.write(s"$year/$month/$day/$hour/$week, $hydroPower, $windPower, $solarPower\n")

      }
    } catch {
      case e: Exception => println(e.getMessage)
    } finally {
      file.close()
    }
  }
  def question2(): Unit = {
    val filename = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/tuntidata_2022.csv"
    val file = Source.fromFile(filename)
    val filename2 = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/EnergyGeneration-StorageCapacity.csv"
    val writer2 = new PrintWriter(new File(filename2))
    writer2.write(s"Time, EnergyGeneration, StorageCapacity\n")
    try {
      for (line <- file.getLines) {
        val fields1 = line.split(",")
        val year1 = fields1(0).toInt
        val month1 = fields1(1).toInt
        val day1 = fields1(2).toInt
        val hour1 = fields1(3).toInt
        val week1 = fields1(4).toInt
        val EnergyGeneration = try {
          fields1(8).toDouble
        } catch {
          case _: Throwable => Double.NaN
        }
        val StorageCapacity = try {
          fields1(9).toDouble
        } catch {
          case _: Throwable => Double.NaN
        }
        println(s"$year1/$month1/$day1/$hour1/$week1: The power plant's energy generation=$EnergyGeneration, Storage capacity=$StorageCapacity")
        writer2.write(s"$year1/$month1/$day1/$hour1/$week1, $EnergyGeneration, $StorageCapacity\n")

      }
    } catch {
      case e: Exception => println(e.getMessage)
    } finally {
      file.close()
    }
  }

}
object yunxing extends App{
  question12.question1()
  //question12.question2()
}