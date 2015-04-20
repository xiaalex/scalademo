package com.demo

object Reverse {

  // by recursive
  def reverse1(s: String): String = { 
    def reverseHelp(s: String, r: String): String = {
      if (s == null) return null
      if (s.tail.isEmpty()) return s.head + r
      else reverseHelp(s.tail, s.head + r)
    }
    reverseHelp(s, "")
  }

  // use foldLeft
  def reverse2(s: String): String = {
    s.foldLeft("")((r, a) => a + r);
  }

  // reverse by step k
  // 1 2 3 4 5 6 -> 
  // 3 2 1 6 5 4
  def reversek1(s: String, k: Int): String = {
    def reversek1Help(s: String, r: String, k: Int): String = {
      val m = reverse2(s.take(k))
      if (s.drop(k).length() == 0) return r + m
      else reversek1Help(s.drop(k), r + m, k)
    }
    if (s == null) return null
    reversek1Help(s, "", k)
  }

}

