package com.demo

import StringBreak._

class StringBreakSpec extends UnitSpec {

  val dict = List( "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango" )
  val input = "ilikesamsung"

  "A break result " should "equal to list " in { 
    val expected = List("i", "like", "sam", "sung")
    val result = break1(input, dict)
    assert(expected == result)
  }

  "A break ALL result " should "equal to list of list " in { 
    val expected = List(List("i", "like", "sam", "sung"), List("i", "like", "samsung"))
    val result = break2(input, dict)
    assert(expected == result)
  }

}

