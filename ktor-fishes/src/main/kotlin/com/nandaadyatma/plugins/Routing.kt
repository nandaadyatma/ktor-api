package com.nandaadyatma.plugins

import com.nandaadyatma.routes.fishes
import com.nandaadyatma.routes.randomFish
import com.nandaadyatma.routes.singlefish
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
//        get("/") {
//            call.respondText("Hello World!")
//        }


        // Static plugin. Try to access `/static/index.html`
        staticResources("/", "static") {
            default("index.html")
        }

        randomFish();
        fishes()
        singlefish()


    }
}
