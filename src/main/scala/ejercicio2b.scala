package concurrencia

@main def mainEjercicio2b(): Unit =
  val h1 = periodico(1000)(log("Activa"))
  val h2 = periodico(3000)(log("Activa"))
