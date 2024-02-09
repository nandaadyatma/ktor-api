package com.nandaadyatma

import com.nandaadyatma.models.TicTacToeGame
import com.nandaadyatma.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val game = TicTacToeGame()
    configureSockets()
    configureMonitoring()
    configureSerialization()
    configureRouting(game)
}
