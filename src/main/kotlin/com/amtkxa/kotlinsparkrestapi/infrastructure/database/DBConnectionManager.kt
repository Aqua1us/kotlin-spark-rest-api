package com.amtkxa.kotlinsparkrestapi.infrastructure.database

import org.sql2o.Sql2o

class DBConnectionManager {

    companion object {
        /**
         * Set the properties necessary to create a connection to database.
         */
        private val sql2o = Sql2o(
            "jdbc:mysql://localhost:3306/sampledb",
            "testuser",
            "testuser"
        )

        /**
         * Get Sql2o instance.
         * <p>
         * An {@link Sql2o} instance represents a way of connecting to one specific database.
         */
        fun getSql2o(): Sql2o = sql2o
    }
}
