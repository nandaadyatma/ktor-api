package com.nandaadyatma.routes

import com.nandaadyatma.data.model.Fish
import com.nandaadyatma.data.model.Response
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://192.168.43.118:8080"

private val fishes = listOf(
    Fish(1, "Aldo", "THis is aldo the fish", "$BASE_URL/fishes/fish.png"),
    Fish(2, "Tono", "THis is Tono the fish", "$BASE_URL/fishes/fish-1.png"),
    Fish(3, "Agung", "THis is Agung the fish", "$BASE_URL/fishes/fish-2.png"),
    Fish(4, "Dodo", "THis is Dodo the fish", "$BASE_URL/fishes/fish-3.png"),
    Fish(5, "Abi", "THis is Abi the fish", "$BASE_URL/fishes/fish-4.png"),
    Fish(6, "Mamat", "THis is Mamat the fish", "$BASE_URL/fishes/fish-5.png"),
)

fun Route.randomFish() {
    get("/random-fish") {
        call.respond(
            HttpStatusCode.OK, Response(
                error = false,
                message = "Random fish fetched successfully",
                data = fishes.random()
            )
        )
    }

}

fun Route.fishes() {
    get("/fishes") {
        call.respond(
            HttpStatusCode.OK,
            Response(
                error = false,
                message = "list of fish fetched successfully",
                data = fishes
            )
        )
    }
}

fun Route.singlefish() {
    get("/fish/{id}") {
        val id = call.parameters["id"] ?: return@get call.respond(
            HttpStatusCode.NotFound,
            Response(
                error = true,
                message = "Missing id",
                data = null
            )
        )

        val fish = fishes.singleOrNull { it.id.toString() == id } ?: return@get call.respond (
                HttpStatusCode.NotFound,
            Response(
            error = true,
            message = "Fish not found",
            data = null
            )
        )

        call.respond(
            HttpStatusCode.OK,
            Response(
                error = false,
                message = "Fish Successfully Fetched",
                data = fish
        )
        )
    }
}