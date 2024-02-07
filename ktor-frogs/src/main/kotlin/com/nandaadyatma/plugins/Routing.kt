package com.nandaadyatma.plugins

import com.nandaadyatma.routes.greeting
import com.nandaadyatma.routes.randomFrog
import com.nandaadyatma.routes.userRoute
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
//        get("/") {
//            call.respondText("Hello World!")
//        }

        randomFrog();

        greeting();
        // Static plugin. Try to access `/static/index.html`
        staticResources("/", "static"){
            default("index.html")
        }

        userRoute();
    }
}
