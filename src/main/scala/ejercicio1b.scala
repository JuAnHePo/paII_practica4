var turno = 0

class Hebra1b(c: Char, t: Int, miId: Int) extends Thread {
  override def run(): Unit = {
    var n = 0
    for (_ <- 0 until t) {
      while (miId != turno) Thread.sleep(0)
      print(c)
      n += 1
      if n == miId + 1 then
        n = 0
        turno = (turno + 1) % 3
    }
  }
}

@main def mainEjercicio1b(): Unit =
  val t = 10
  val hA = Hebra1b('A', t, 0)
  val hB = Hebra1b('B', t * 2, 1)
  val hC = Hebra1b('C', t * 3, 2)

  hA.start(); hB.start(); hC.start()
