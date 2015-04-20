package com.demo

object StringBreak {

  def find(w: String, dict: List[String]): String = {
    var word = ""
    dict.iterator.takeWhile(_ => word == "").foreach(x => if (x == w) word = w)
    word
  }

  // Break string "ilikesamsung" into ("i", "like", "sam", "sung")
  // Only one match returned
  def break1(s: String, dict: List[String]): List[String] = {
    s.foldLeft( ("", List[String](), dict) )( (r, a) => 
        if (find((r._1 + a), dict) != "") 
          new Tuple3("", r._2 ::: ((r._1 + a) :: Nil), r._3)
        else
          new Tuple3(r._1 + a, r._2, r._3)
      )._2
  }
  
  // Break string "ilikesamsung" into (List("i", "like", "sam", "sung"), List("i", "like", "samsung"))
  // Return ALL matches
  def break2(s: String, dict: List[String]): List[List[String]] = {
    def break2Help(s: String, key: String, map: scala.collection.mutable.Map[String, Int], dict: List[String]): Unit = {
      for (wd <- dict) {
        if (wd == s.take(wd.length)) {
          val newkey = key + " " + wd
          val newstr = s.drop(wd.length)
          map(newkey) = newstr.length
          if (newstr.length > 0)
            break2Help(newstr, newkey, map, dict)
        }
      }
    }

    val map = scala.collection.mutable.Map[String, Int]()
    break2Help(s, " ", map, dict)
    val buf = new scala.collection.mutable.ListBuffer[List[String]]
    val bldr = buf.mapResult(_.toList)
    for ((k, v) <- map) {
      if (v == 0)
        bldr += k.drop(2).split(" ").toList
    }
    bldr.result
  }

}

