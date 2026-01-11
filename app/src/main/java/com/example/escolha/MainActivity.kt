package com.example.escolha

import com.example.escolha.R
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var storyText: TextView
    private lateinit var choicesContainer: LinearLayout

    private var currentNodeId = "despertar"

    private val state = mutableMapOf(
        "lucidez" to 0,
        "empatia" to 0,
        "desconfiança" to 0
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        storyText = findViewById(R.id.storyText)
        choicesContainer = findViewById(R.id.choicesContainer)

        renderNode()
    }

    private fun renderNode() {
        val node = Story.nodes[currentNodeId]

        if (node == null) {
            renderFinal()
            return
        }

        storyText.text = node.texto
        choicesContainer.removeAllViews()

        node.opcoes.forEach { choice ->
            val button = Button(this).apply {
                text = choice.texto
                setOnClickListener {
                    applyEffects(choice.efeitos)
                    currentNodeId = choice.destino
                    renderNode()
                }
            }
            choicesContainer.addView(button)
        }
    }

    private fun applyEffects(effects: Map<String, Int>) {
        effects.forEach { (key, value) ->
            state[key] = (state[key] ?: 0) + value
        }
    }

    private fun renderFinal() {
        choicesContainer.removeAllViews()

        val finalText = when {
            state["lucidez"]!! >= 2 ->
                "Você percebeu cedo demais.\nAlguns leitores nunca percebem."

            state["empatia"]!! >= 2 ->
                "O sistema não foi feito para ser amado.\nMas você tentou."

            state["desconfiança"]!! >= 2 ->
                "Você nunca acreditou.\nE por isso nunca entendeu."

            else ->
                "Você não escolheu bem.\nVocê escolheu humano."
        }

        storyText.text = finalText
    }
}
