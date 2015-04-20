package com.demo

object GroupCode {

    def groupbyCode(data: List[Tuple2[String, String]]): Map[String, List[String]] = {
        val map = Map[String, List[String]]()
        data.foldLeft(map)((m, c) => {
            if (m.contains(c._1))
                m.updated(c._1, c._2 :: m(c._1))
            else 
                m.updated(c._1, c._2 :: Nil)
        })
    }

    def groupbyCode2[K, V](data: List[Tuple2[K, V]]): Map[K, List[V]] = {
        val map = Map[K, List[V]]()
        data.foldLeft(map)((m, c) => {
            if (m.contains(c._1))
                m.updated(c._1, c._2 :: m(c._1))
            else 
                m.updated(c._1, c._2 :: Nil)
        })
    }
}

