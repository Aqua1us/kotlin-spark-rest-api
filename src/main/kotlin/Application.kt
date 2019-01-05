import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import common.JsonTransformer
import spark.Spark.get
import spark.Spark.port
import user.UserController

fun main(args: Array<String>) {

    // Start embedded server at this port
    port(8080);

    val objectMapper = ObjectMapper().registerKotlinModule()
    val jsonTransformer = JsonTransformer(objectMapper)
    val userController = UserController()

    get("/") { request, response -> "Welcome" }

    get("/users", userController.index(), jsonTransformer)
}
