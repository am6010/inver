package quick

/**
 * Created by Alexandros Milaios on 2/6/15 at 6:54 PM.
 *
 * QuickSort Algorithm to Count the comparisons
 */
object QuickSortComparisonsCount {

  def quickSortCompCount(xs: Array[Int], pivot:(Array[Int],Int,Int)=> Int) :Int = {

    def sort(l:Int, r:Int): Int = {
      if(l == r)
        return 0
      val i = partition(l,r)
      val small = sort(l,i-1)
      val great = sort(i,r)
      val left = i-1 -l
      val right = r-i
      small + great +  left + right
    }

    def partition(l: Int, r: Int): Int = {
      val p = xs(pivot(xs,l,r))
      swap(l,pivot(xs,l,r))
      var i = l+1
      var j = l+1
      while(j < r) {
        if(xs(j) < p) {
          swap(j,i)
          i = i + 1
        }
        j= j+ 1
      }
      swap(l,i-1)
      i
    }

    def swap(i: Int, j:Int): Unit = {
      val t = xs(i)
      xs(i) = xs(j)
      xs(j) = t
    }

    sort(0,xs.size)
  }
}
