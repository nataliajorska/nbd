case class Osoba(imie: String, nazwisko: String) extends OsobaA {
  override def podatek(): Double = 5
}
