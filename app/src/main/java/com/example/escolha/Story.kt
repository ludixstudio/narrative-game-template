package com.example.escolha

import com.example.escolha.data.Choice
import com.example.escolha.data.Node

object Story {

    val nodes = mapOf(

        "despertar" to Node(
            id = "despertar",
            texto = "Você acorda numa sala que não reconhece.\nNão há dor. Apenas a sensação de que chegou atrasado.",
            opcoes = listOf(
                Choice("Levantar imediatamente", "sala", mapOf("desconfiança" to 1)),
                Choice("Observar a sala", "sala", mapOf("lucidez" to 1))
            )
        ),

        "sala" to Node(
            id = "sala",
            texto = "A sala é simples demais para ser real.\nNada parece fora do lugar — e isso incomoda.",
            opcoes = listOf(
                Choice("Examinar as paredes", "corredor", mapOf("lucidez" to 1)),
                Choice("Seguir em frente sem pensar", "corredor", mapOf("desconfiança" to 1))
            )
        ),

        "corredor" to Node(
            id = "corredor",
            texto = "O corredor se estende além do que deveria.\nVocê sente que está sendo avaliado.",
            opcoes = listOf(
                Choice("Chamar por alguém", "voz", mapOf("empatia" to 1)),
                Choice("Manter silêncio", "voz", mapOf("desconfiança" to 1))
            )
        ),

        "voz" to Node(
            id = "voz",
            texto = "Uma voz responde.\n\n“Você sabe que isso não é apenas uma história, não sabe?”",
            opcoes = listOf(
                Choice("Responder à voz", "final", mapOf("empatia" to 1)),
                Choice("Ignorar completamente", "final", mapOf("desconfiança" to 1))
            )
        )
    )
}
