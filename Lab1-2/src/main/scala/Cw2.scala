object Cw2 {
  def main(args: Array[String]): Unit = {
    // Zad1.
    println("Zad1")
    println(weekOrDay("sobota"))
    println(weekOrDay("cokolwiek"))

    // Zad2.
    println("Zad2")
    val kontoBankowe = new KontoBankowe()
    println(kontoBankowe.wplata(10.8))
    println(kontoBankowe.getStanKonta)
    println(kontoBankowe.wyplata(2.3))

    // Zad3.
    println("Zad3")
    val o0 = Osoba("Cezary", "Husajn")
    val o1 = Osoba("Łukasz", "Kęsik")
    val o2 = Osoba("Doma", "Stachura")
    val o3 = Osoba("Ewa", "Skrzypacz")
    println(getGreeting(o0))
    println(getGreeting(o1))
    println(getGreeting(o2))
    println(getGreeting(o3))

    // Zad4.
    println("Zad4")
    val startValue = 9
    def add2(value: Int): Int = value+2
    println(add3times(startValue, add2))

    // Zad5.
    println("Zad5")
    val o4 = new Osoba("Damian", "Litwin") with Student
    println(s"Podatek studenta: ${o4.podatek}")

    val o5 = new Osoba("Ela", "Noga") with Pracownik {
      override var pensja: Double = 10000
    }
    println(s"Podatek pracownika: ${o5.podatek}")

    val o6 = new Osoba("Mia", "Grejt") with Nauczyciel {
      override var pensja: Double = 52000
    }
    println(s"Podatek nauczyciela: ${o6.podatek}")

    val o7 = new Osoba("Ania", "Cwir") with Student with Pracownik {
      override var pensja: Double = 1000
    }
    println(s"Podatek studenta i pracownika: ${o7.podatek}")

    val o8 = new Osoba("Madzia", "Cwiklak") with Pracownik with Student {
      override var pensja: Double = 1000
    }
    println(s"Podatek pracownika i studenta: ${o8.podatek}")
  }

  def add3times(startValue: Int, function: Int => Int): Int = {
    function(function(function(startValue)))
  }

  def getGreeting(osoba: Osoba): String = {
    osoba match {
      case Osoba("Cezary", "Husajn") => "Hejka, robie stoły"
      case Osoba("Łukasz", "Kęsik") => "Zapraszam na impreze za tydzien"
      case Osoba("Doma", "Stachura") => "Kocham ludzi z liceum z Warszawy"
      case _ => "Eluwina! Jestem nikim"
    }
  }

  def weekOrDay(day: String): String = {
    day match {
      case "poniedziałek" => "Praca"
      case "wtorek" => "Praca"
      case "środa" => "Praca"
      case "czwartek" => "Praca"
      case "piątek" => "Praca"
      case "sobota" => "Weekend"
      case "niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }

}
