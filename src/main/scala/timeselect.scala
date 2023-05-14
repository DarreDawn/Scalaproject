import java.io.{File, PrintWriter}
import scala.io.{Source, StdIn}
object time{
  def monthly(): Unit = {
    val filePath = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/tuntidata_2022.csv"
    val columnIndex = 1
    println("which mounth :")
    val chi = StdIn.readInt()
    val searchValue = chi
    val lines = Source.fromFile(filePath).getLines()
    val matchingRows = lines.filter(_.split(",")(columnIndex).trim.toInt == searchValue)
    val outputFile = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/monthly.csv"
    val writer = new PrintWriter(outputFile)
    matchingRows.foreach(row => writer.println(row))
    writer.close()
  }
  def Daily(): Unit = {
    val filePathmonth = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/monthly.csv"
    val columnIndex2 = 2
    println("which Day :")
    val chio = StdIn.readInt()
    val searchValue1 = chio
    val lines1 = Source.fromFile(filePathmonth).getLines()
    val matchingRows1 = lines1.filter(_.split(",")(columnIndex2).trim.toInt == searchValue1)
    val outputFileday = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/Daily.csv"
    val writer1 = new PrintWriter(outputFileday)
    matchingRows1.foreach(row => writer1.println(row))
    writer1.close()
  }
  def Hourly(): Unit = {
    val filePathDay = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/Daily.csv"
    val columnIndex3 = 3
    println("which Hour :")
    val choic = StdIn.readInt()
    val searchValue2 = choic
    val lines2 = Source.fromFile(filePathDay).getLines()
    val matchingRows2 = lines2.filter(_.split(",")(columnIndex3).trim.toInt == searchValue2)
    val outputFilehour = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/Hourly.csv"
    val writer2 = new PrintWriter(outputFilehour)
    matchingRows2.foreach(row => writer2.println(row))
    writer2.close()
  }
  def weekly(): Unit = {
    val filePathweek = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/tuntidata_2022.csv"
    val columnIndex4 = 4
    println("which week :")
    val c = StdIn.readInt()
    val searchValue4 = c
    val lines4 = Source.fromFile(filePathweek).getLines()
    val matchingRows4 = lines4.filter(_.split(",")(columnIndex4).trim.toInt == searchValue4)
    val outputFileweek = "/Users/darredawn/Desktop/scala 作业和其他/Scalaproject/src/main/scala/weekly.csv"
    val writer4 = new PrintWriter(outputFileweek)
    matchingRows4.foreach(row => writer4.println(row))
    writer4.close()
  }
}
