package com.korealm

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage

class Main : Application() {
    override fun start(stage: Stage) {
        val root = AnchorPane()
        val label = Label("Hello KotlinFX!")

        root.children.add(label)
        val scene = Scene(root, 800.0, 600.0)

        stage.title = "Hello KotlinFX!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(Main::class.java)
}