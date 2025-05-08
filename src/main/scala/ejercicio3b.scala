package concurrencia

import scala.util.Random

def todosTrueIterativa(l: List[Boolean]): Boolean = l.filter(!_).isEmpty

def todosTrueRecursiva(l: List[Boolean]): Boolean = l match
  case Nil => true
  case h :: t => h && todosTrueIterativa(t)

@main def mainEjercicio3b(): Unit =
  val l = List.fill(Random.nextInt(10))(Random.nextBoolean())
  log(s"${l.mkString("[", ", ", "]")}")
  val (lA, lB) = l.splitAt(l.length / 2)
  val (hA, hB) = parallel(todosTrueIterativa(lA), todosTrueRecursiva(lB))
  log(s"¿Son todos true?: ${if hA && hB then "Sí" else "No"}")