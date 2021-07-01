class KontoBankowe(stanPocz: Double) {
  private var stanKonta: Double = stanPocz

  def this() = {
    this(0)
  }

  def wplata(ilosc: Double) = {
    this.stanKonta = Math.floor((this.stanKonta + ilosc) * 100) / 100;
    this.stanKonta
  }

  def wyplata(ilosc: Double) = {
    this.stanKonta = Math.floor((this.stanKonta - ilosc) * 100) / 100;
    this.stanKonta
  }

  def getStanKonta: Double = {
    this.stanKonta
  }
}
