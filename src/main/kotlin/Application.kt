import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import common.JsonTransformer
import spark.Spark.get
import user.UserController

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    val jsonTransformer = JsonTransformer(objectMapper)
    val userController = UserController()

    get("/users", userController.index(), jsonTransformer)
}
