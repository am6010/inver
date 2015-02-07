package inver

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import util.InputUtilities


/**
 * Created by Alexandros Milaios on 1/25/15 at 12:23 PM.
 *
 */

@RunWith(classOf[JUnitRunner])
class InverSuite extends FunSuite {
  trait IntegerList {
    val list1 =  InputUtilities.parseFileInput("src/test/resources/inver/tc1", _.toInt)
  }

  test("Input list tc1") {
    new IntegerList {
      assert(list1 === List(1, 3, 5, 2, 4, 6))
    }
  }

  test("Test Count Split Inv") {
    new IntegerList {
      val p = InversionCounter.countSplitInv[Int](List(1,3,5), List(2,4,6), (List(),0))
      assert(p._1 === List(1,2,3,4,5,6))
      assert(p._2 === 3)
    }
  }

  test("test tc1") {
    new IntegerList {
      assert(InversionCounter.count[Int](list1)===3)
    }
  }

  test("test tc2") {
    val l = InputUtilities.parseFileInput("src/test/resources/inver/tc2", _.toInt)
    assert(InversionCounter.count[Int](l)===4)
  }


  test("test tc3") {
    val l = InputUtilities.parseFileInput("src/test/resources/inver/tc3", _.toInt)
    assert(InversionCounter.count[Int](l)===10)
  }

  test("test tc4") {
    val l = InputUtilities.parseFileInput("src/test/resources/inver/tc4", _.toInt)
    assert(InversionCounter.count[Int](l)===56)
  }

  test("test tc 5") {

    val l = List(4, 80, 70, 23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53, 44, 8, 49, 28,
      18, 46, 21, 39, 51, 7, 87, 99, 69, 62, 84, 6, 79, 67, 14, 98, 83, 0, 96, 5, 82,
      10, 26, 48, 3, 2, 15, 92, 11, 55, 63, 97, 43, 45, 81, 42, 95, 20, 25, 74, 24, 72,
      91, 35, 86, 19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89, 32, 37,
      34, 65, 1, 73, 41, 36, 57, 77, 30, 22, 13, 29, 38, 16, 88, 61, 31, 85, 33, 54 )
    assert(InversionCounter.count[Int](l)===2372)
  }

  test("final test") {
    val s = System.nanoTime()
    val l = InputUtilities.parseFileInput("src/test/resources/inver/IntegerArray.txt", _.toInt)
    val t = System.nanoTime()
    println(t -s)
    assert( InversionCounter.count[Int](l)  === 2407905288L)
    val f = System.nanoTime()
    println(f -t)
  }


}
