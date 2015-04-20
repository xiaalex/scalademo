package com.demo

import GroupCode._

class GroupCodeSpec extends UnitSpec {

  "An groupby result " should "equal to the  map " in {
    val data = List(("ny", "lga"), ("ca", "lax"), ("ny", "jfk"), ("ks", "ict"), ("ca", "sfo"), ("ca", "san"))
    val expected = Map[String,List[String]]("ny" -> List("jfk", "lga"), "ca" -> List("san", "sfo", "lax"), "ks" -> List("ict"))

    val result = groupbyCode(data)
    assert(expected == result)
  }

  "An groupby result of int " should "equal to the  map of int " in {
    val data = List((1, 10), (1, 20), (3, 30))
    val expected = Map[Int,List[Int]](1 -> List(20, 10), 3 -> List(30))

    val result = groupbyCode2[Int, Int](data)
    assert(expected == result)
  }

}

