package user

import spark.Route

class UserController {

    fun index(): Route = Route { request, response ->
        listOf(
            User(1, "Yamada"),
            User(2, "Tanaka")
        )
    }
}
