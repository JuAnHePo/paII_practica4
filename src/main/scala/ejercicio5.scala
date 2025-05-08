package concurrencia

import scala.util.Random

def mezclar(l1: List[Int], l2: List[Int]): List[Int] = (l1, l2) match
  case (Nil, _) => l2
  case (_, Nil) => l1
  case (h1 :: t1, h2 :: t2) =>
    if (h1 <= h2) h1 :: mezclar(t1, l2)
    else h2 :: mezclar(l1, t2)

def ordenar(l: List[Int]): List[Int] = {
  if l.length <= 1 then l
  else
    val (l1, l2) = l.splitAt(l.length / 2)
    val (l1a, l2a) = parallel[List[Int], List[Int]](ordenar(l1), ordenar(l2))
    mezclar(l1a, l2a)
}

@main def mainEjercicio5(): Unit =
  val l = List.fill(Random.nextInt(50))(Random.nextInt(100))
  log(s"${l.mkString("[", ",", "]")}")
  val listaOrd = ordenar(l)
  log(s"${listaOrd.mkString("[", ",", "]")}")