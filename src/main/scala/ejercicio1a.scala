class Hebra1a(c: Char, t: Int) extends Thread {
  override def run(): Unit =
    for (_ <- 0 until t) print(c)
}

@main def mainEjercicio1a(): Unit =
  val hA = Hebra1a('A', 10)
  val hB = Hebra1a('B', 20)
  val hC = Hebra1a('C', 30)

  hA.start(); hB.start(); hC.start()
