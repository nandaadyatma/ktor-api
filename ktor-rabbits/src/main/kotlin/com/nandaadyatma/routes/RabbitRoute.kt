package com.nandaadyatma.routes

import com.nandaadyatma.data.model.Rabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://192.168.43.118:8100"
private val rabbits = listOf(
    Rabbit("Carl", "deskripsi 1", "$BASE_URL/rabbits/rabbit1.png"),
    Rabbit("Emma", "deskripsi 2", "$BASE_URL/rabbits/rabbit2.png"),
    Rabbit("Florian", "deskripsi 3", "$BASE_URL/rabbits/rabbit3.png"),
    Rabbit("Federico", "deskripsi 4", "$BASE_URL/rabbits/rabbit4.png"),
    Rabbit("Gina", "deskripsi 5", "$BASE_URL/rabbits/rabbit5.png"),
    Rabbit("Anton", "deskripsi 6", "$BASE_URL/rabbits/rabbit6.png"),
)

fun Route.randomRabbit() {
    get("/randomrabbit") {
        call.respond(
            HttpStatusCode.OK,
            rabbits.random()
        )
    }
}

