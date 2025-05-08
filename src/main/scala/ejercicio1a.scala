class Hebra(c: Char, t: Int) extends Thread {
  override def run(): Unit =
    for (_ <- 0 until t) print(c)
}

@main def mainEjercicio1a(): Unit =
  val hA = Hebra('A', 10)
  val hB = Hebra('B', 20)
  val hC = Hebra('C', 30)

  hA.start(); hB.start(); hC.start()
