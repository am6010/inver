package util

import scala.io.Source

/**
 * Created by Alexandros Milaios on 2/6/15 at 6:52 PM.
 */
object InputUtilities {

  def parseFileInput[T](fileName : String, toT : String => T) : List[T] = {
    val textList = Source.fromFile(fileName).getLines().toList
    textList.map(toT)
  }

}
