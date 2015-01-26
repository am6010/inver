package inver


import scala.io.Source

/**
 * Created by amilaios on 1/25/15 at 12:29 PM.
 */
object InversionCounter {


  def parseFileInput[T](fileName : String, toT : String => T) : List[T] = {
    val textList = Source.fromFile(fileName).getLines().toList
    textList.map(toT(_))
  }

  def sortAndCount[T](input: List[T], comp : (T,T) => Boolean) : (List[T], Long)  = {
    input match {
      case List() => (List(), 0)
      case List(_) => (input, 0)
      case l => {
        val n = input.size
        val left = sortAndCount(input.take(n/2), comp)
        val right = sortAndCount(input.drop(n/2), comp)
        val split = countSplitInv(left._1, right._1, (List(), 0), comp)
          (split._1, left._2 + right._2 + split._2)
      }
    }
  }

  def countSplitInv[T](left: List[T], right: List[T], acc : (List[T], Long), comp : (T,T) => Boolean) : (List[T], Long) = {
    (left, right) match {
      case (x :: xs, y :: ys) if comp(x,y) => countSplitInv(xs, y :: ys, (x :: acc._1, acc._2), comp)
      case (x :: xs, y :: ys) => countSplitInv(x :: xs , ys, (y :: acc._1, acc._2 + left.size), comp)
      case _ => if(left.isEmpty) (acc._1.reverse ::: right, acc._2)
              else (acc._1.reverse ::: left, acc._2)
    }
  }


  def count[T](input: List[T],  comp : (T,T) => Boolean) : Long = {
      sortAndCount(input, comp)._2
  }

}
