package quick

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import util.InputUtilities

/**
 * Created by Alexandros Milaios on 2/6/15 at 7:48 PM.
 *
 */
@RunWith(classOf[JUnitRunner])
class QuickSuite extends  FunSuite{

  trait ImportTestCases {
    val arr = InputUtilities.parseFileInput("src/test/resources/quick/10.txt", _.toInt).toArray
    val arr2 = InputUtilities.parseFileInput("src/test/resources/quick/100.txt", _.toInt).toArray
    val arr3 = InputUtilities.parseFileInput("src/test/resources/quick/1000.txt", _.toInt).toArray
    val quick = InputUtilities.parseFileInput("src/test/resources/quick/QuickSort.txt", _.toInt).toArray
    def median(xs: Array[Int], l: Int, r:Int):Int = {
      val m = (l + r-1) / 2

      def max(a:Int, b:Int): Int = {
        if(xs(a) > xs(b)) a else b
      }

      def min(a:Int, b:Int): Int = {
        if(xs(a) < xs(b)) a else b
      }

      max(max(min(l,r-1),min(m,l)),min(m,r-1))
    }
  }


  test("test case 10 first pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(arr, (arr, x,y) => x)
      assert(result === 25)
    }
  }



  test("test case 100 first pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(arr2,(arr2,x,y) => x)
      assert(result === 615)
    }
  }

  test("test case 1000 first pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(arr3, (arr3,x,y) => x)
      assert(result === 10297)
    }
  }

  test("test case 10 last pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(arr, (arr,x,y) => y-1)
      assert(result === 29)
    }
  }

  test("test case 100 last pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(arr2,(arr2, x,y) => y-1)
      assert(result === 587)
    }
  }

  test("test case 1000 last pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(arr3, (arr3, x,y) => y-1)
      assert(result === 10184)
    }
  }

  test("test case 10 median pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(arr,median)
      assert(result === 21)
    }
  }

  test("test case 100 median pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(arr2,median)
      assert(result === 518)
    }
  }

  test("test case 1000 median pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(arr3,median)
      assert(result === 8921)
    }
  }

  test("test large input first pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(quick, (quick, x, y) => x)
      assert(result === 162085)

    }
  }

  test("test large input last pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(quick, (quick, x, y) => y-1)
      assert(result === 164123)
    }
  }

  test("test large input median pivot") {
    new ImportTestCases {
      val result = QuickSortComparisonsCount.quickSortCompCount(quick, median)
      assert(result === 138382)
    }
  }
}
