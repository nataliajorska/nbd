import scala.annotation.tailrec
import scala.util.control.Breaks.{break, breakable}

object Cw1 {
  def main(args: Array[String]): Unit = {
    // 1.
    val week = List("pon", "wt", "śr", "czw", "pt", "sob", "niedz")
    // a.
    println("Zad1a " + getWeekDaysString(week))
    // b.
    println("Zad1b " + getWeekDaysStringOnlyP(week))
    // c.
    println("Zad1c " + getWeekDaysWhile(week))

    // 2.
    // a.
    println("Zad2a " + getWeekDaysR(week))
    // b.
    println("Zad2b " + getWeekDaysRReverse(week))

    // 3.
    println("Zad3 " + getWeekDaysRTail(week))

    // 4.
    // a.
    println("Zad4a " + foldl(week))
    // b.
    println("Zad4b " + foldr(week))
    // c.
    println("Zad4c " + foldlOnlyP(week))

    // 5.
    println("Zad5 " + generateSales())

    // 6.
    println(printTuple())

    // 7.
    println(optionCheck())

    // 8.
    println("Zad8 " + deleteZeros())

    // 9.
    println("Zad9 " + addOne())

    // 10.
    println("Zad10 " + abs())

  }

  def getWeekDaysString(week: List[String]): String = {
    var weekDaysString = ""
    var isFirst = true
    for (day <- week) {
      if(isFirst) {
        weekDaysString = day
        isFirst = false
      }
      else weekDaysString=weekDaysString+", "+day
    }
    weekDaysString
  }

  def getWeekDaysStringOnlyP(week: List[String]): String = {
    var weekDaysString = ""
    var isFirst = true
    for (day <- week) {
      breakable {

      if (!day.startsWith("p")){
        break
      }
      if(isFirst) {
        weekDaysString = day
        isFirst = false

      }
      else weekDaysString=weekDaysString+", "+day
    }}
    weekDaysString
  }

  def getWeekDaysWhile(week: List[String]) = {
    var weekDaysString = ""
    var index = 0;
    while (index < week.length) {
      if (weekDaysString != "") weekDaysString += ", " + week(index)
      else weekDaysString += week(index)

      index = index + 1;
    }
    weekDaysString
  }

  def getWeekDaysR(week: List[String]) = {
    def appendDay(i: Int): String = {
      if (i == week.length) return ""
      val day = if (i == week.length - 1) week(i) else week(i) + ", "
      day + appendDay(i + 1)
    }
    appendDay(0);
  }

  def getWeekDaysRReverse(week: List[String]): String = {
    def appendDay(i: Int): String = {
      if (i == -1) return ""
      val currentDay = if (i == 0) week(i) else week(i) + ", "
      currentDay + appendDay(i - 1)
    }
    appendDay(week.length - 1)
  }

  def getWeekDaysRTail(week: List[String]) = {
    @tailrec
    def appendDay(i: Int, weekDaysString: String) : String = {
      if (i == week.length) return weekDaysString
      val day = if (i == week.length - 1) week(i) else week(i) + ", "
      appendDay(i + 1, weekDaysString + day)
    }
    appendDay(0, "")
  }

  def foldl(week: List[String]): String = {
    week.foldLeft("")(_ + _ + ", ").dropRight(2)
  }

  def foldr(week: List[String]): String = {
    week.foldRight("")(", " + _ + _).substring(2)
  }

  def foldlOnlyP(week: List[String]): String = {
    val week2=week.filter(_.startsWith("p"))
    week2.foldLeft("")(_ + _ + ", ").dropRight(2)
  }

  def generateSales(): Map[String, Double] = {
    val products = Map("Miód" -> 5.60, "Wino" -> 34.70).map(mapItem => {
      (mapItem._1, mapItem._2 * 0.9)
    })
   products
  }

  def printTuple(): Unit = {
    val tuple  = ("eluwina", 37.05F, 3)
    println(String.format("Zad6 %s, %f, %d", tuple._1, tuple._2, tuple._3))
  }

  def optionCheck() = {
    val sampleMap = Map("A" -> 5.60, "B" -> 34.70)
    val existing = sampleMap.get("A")
    val notExisting = sampleMap.get("D")
    println("Zad7 wartość istniejąca: " + existing.getOrElse(0D))
    println("Zad7 wartość nieistniejąca: " + notExisting.getOrElse(0D))
  }

  def deleteZeros(): List[Int] = {
    val values = List(4, 0, 8, 0)
    val listSize = values.size
    def deleteZero(index: Int, list: List[Int]): List[Int] = {
      if (index.equals(listSize)) list
      else if (values(index) == 0) deleteZero(index + 1, list)
      else deleteZero(index + 1, list ++ List(values(index)))
    }
    deleteZero(0, List())
  }

  def addOne(): List[Int] = {
    val list=List(3, 8, 37)
    list.map(i => i+1)
  }

  def abs(): List[Double] = {
    val values=List(-3.80, 8.70, 38.50)
    values.filter(value => value >= -5 && value <= 12).map(v => v.abs)
  }
}
