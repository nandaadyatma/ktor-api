package com.nandaadyatma.plugins

import com.nandaadyatma.models.TicTacToeGame
import com.nandaadyatma.socket
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(game: TicTacToeGame) {
    routing {

        // Static plugin. Try to access `/static/index.html`
        staticResources("/", "static") {
            default("index.html")
        }

        socket(game)

    }
}
