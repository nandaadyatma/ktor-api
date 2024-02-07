package com.nandaadyatma.routes

import com.nandaadyatma.data.model.Frog
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://192.168.43.118:8080"

private val frogs = listOf(
    Frog(1, "Carl", "This is Carl the frog", "$BASE_URL/frogs/frog1.png"),
    Frog(2, "Mate", "This is Mate the frog", "$BASE_URL/frogs/frog2.png"),
    Frog(3, "Boy", "This is Boy the frog", "$BASE_URL/frogs/frog3.png"),
    Frog(4, "Gino", "This is Gino the frog", "$BASE_URL/frogs/frog4.png"),
    Frog(5, "Andi", "This is Andi the frog", "$BASE_URL/frogs/frog5.png"),
    Frog(6, "Anji", "This is Anji the frog", "$BASE_URL/frogs/frog6.png"),
)

fun Route.randomFrog() {
    get("/random-frog"){
        call.respond(
            HttpStatusCode.OK,
            frogs.random()
        )
    }
}

fun Route.greeting(){
    get("/hello"){
        call.respondText("Helloooooo")
    }
}

fun Route.userRoute(){
    route("users") {
        get {
            if (frogs.isNotEmpty()) {
                call.respond(frogs)
            } else {
                call.respondText("No frogs found", status = HttpStatusCode.OK)
            }
        }

        get("{id?}"){
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )

            val frog =
                frogs.find { it.id.toString() == id } ?: return@get call.respondText(
                    "No frog with id $id found",
                    status = HttpStatusCode.NotFound
                )

            call.respond(frog)
        }
    }
}