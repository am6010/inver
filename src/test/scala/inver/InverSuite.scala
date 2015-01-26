package inver

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import inver._

/**
 * Created by amilaios on 1/25/15 at 12:23 PM.
 */

@RunWith(classOf[JUnitRunner])
class InverSuite extends FunSuite {
  trait IntegerList {
    val list1 =  InversionCounter.parseFileInput("src/test/resources/tc1", _.toInt);
  }

  test("Input list tc1") {
    new IntegerList {
      assert(list1 === List(1, 3, 5, 2, 4, 6))
    }
  }

  test("Test Count Split Inv") {
    new IntegerList {
      val p = InversionCounter.countSplitInv[Int](List(1,3,5), List(2,4,6), (List(),0), _ < _)
      assert(p._1 === List(1,2,3,4,5,6))
      assert(p._2 === 3)
    }
  }

  test("test tc1") {
    new IntegerList {
      assert(InversionCounter.count[Int](list1, _ < _)===3)
    }
  }

  test("test tc2") {
    val l = InversionCounter.parseFileInput("src/test/resources/tc2", _.toInt)
    assert(InversionCounter.count[Int](l, _ < _)===4)
  }


  test("test tc3") {
    val l = InversionCounter.parseFileInput("src/test/resources/tc3", _.toInt)
    assert(InversionCounter.count[Int](l, _ < _)===10)
  }

  test("test tc4") {
    val l = InversionCounter.parseFileInput("src/test/resources/tc4", _.toInt)
    assert(InversionCounter.count[Int](l, _ < _)===56)
  }

  test("test tc 5") {

    val l = List(4, 80, 70, 23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53, 44, 8, 49, 28,
      18, 46, 21, 39, 51, 7, 87, 99, 69, 62, 84, 6, 79, 67, 14, 98, 83, 0, 96, 5, 82,
      10, 26, 48, 3, 2, 15, 92, 11, 55, 63, 97, 43, 45, 81, 42, 95, 20, 25, 74, 24, 72,
      91, 35, 86, 19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89, 32, 37,
      34, 65, 1, 73, 41, 36, 57, 77, 30, 22, 13, 29, 38, 16, 88, 61, 31, 85, 33, 54 )
    assert(InversionCounter.count[Int](l, _ < _)===2372)
  }

  test("final test") {
    val s = System.nanoTime();
    val l = InversionCounter.parseFileInput("src/test/resources/IntegerArray.txt", _.toInt)
    val t = System.nanoTime()
    println(t -s)
    assert( InversionCounter.count[Int](l, _ < _)  === 2407905288L)
    val f = System.nanoTime()
    println(f -t)
  }


}
