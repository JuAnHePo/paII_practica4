package object concurrencia {
  def hebra(body: =>Unit): Thread = {
    val t = new Thread {
      override def run(): Unit = body
    }
    t.start()
    t
  }

  def log(msg: String): Unit =
    println(s"${Thread.currentThread().getName}: $msg")

  //ejercicio2a
  def periodico(t: Long)(b: =>Unit): Thread = hebra {
    while true do
      b
      Thread.sleep(t)
  }
}
