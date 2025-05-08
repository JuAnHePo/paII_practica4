package concurrencia

def fibonacci(n: Int): (Int, Int) = {
  require(n > 0, "El número debe ser mayor a 0. \n")
  if n == 1 then
    log(s"fib($n) = 1")
    (1, 0)
  else
    var p = (0, 0)
    val h = hebra {p = fibonacci(n - 1)}
    h.join()
    log(s"fib($n) = ${p._1 + p._2}")
    (p._1 + p._2, p._1)
}

@main def mainEjercicio4(): Unit =
  log("fib(0) = 0")
  val p = fibonacci(7)
  log("Fin del programa")



