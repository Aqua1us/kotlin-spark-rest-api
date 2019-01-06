package com.amtkxa.kotlinsparkrestapi.common

import org.sql2o.Connection
import org.sql2o.Sql2o

class DBConnectionManager {

    companion object {
        private val sql2o = Sql2o(
            "jdbc:mysql://localhost:3306/sampledb",
            "testuser",
            "testuser"
        )

        fun getConnection(): Connection = sql2o.open()
    }
}