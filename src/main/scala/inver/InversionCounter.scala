package inver


import scala.io.Source

/**
 * Created by Alexandros Milaios on 1/25/15 at 12:29 PM.
 *
 * Count Inversions Algorithm
 *
 * Complexity O(nlog(n))
 *
 */
object InversionCounter {


  def parseFileInput[T](fileName : String, toT : String => T) : List[T] = {
    val textList = Source.fromFile(fileName).getLines().toList
    textList.map(toT)
  }

  /**
   * Divide Part of the Algorithm
   *
   */
  def sortAndCount[T<%Ordered[T]](input: List[T]) : (List[T], Long)  = {
    input match {
      case List() => (List(), 0)
      case List(_) => (input, 0)
      case l =>
        val n = input.size
        val left = sortAndCount(input.take(n/2))
        val right = sortAndCount(input.drop(n/2))
        val split = countSplitInv(left._1, right._1, (List(), 0))
        (split._1, left._2 + right._2 + split._2)
    }
  }


  /**
   * Combine Part of the Algorithm
   *
   */
  def countSplitInv[T<%Ordered[T]](left: List[T], right: List[T], acc : (List[T], Long)) : (List[T], Long) = {
    (left, right) match {
      case (x :: xs, y :: ys) if x < y => countSplitInv(xs, y :: ys, (x :: acc._1, acc._2))
      case (x :: xs, y :: ys) => countSplitInv(x :: xs , ys, (y :: acc._1, acc._2 + left.size))
      case _ => if(left.isEmpty) (acc._1.reverse ::: right, acc._2)
              else (acc._1.reverse ::: left, acc._2)
    }
  }


  def count[T<%Ordered[T]](input: List[T]) : Long = {
      sortAndCount(input)._2
  }

}
