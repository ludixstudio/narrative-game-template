package com.example.escolha.data

import kotlin.random.Random

object DiceManager {

    private var falhasConsecutivas: Int = 0

    fun rolarDado(): Int {
        return Random.nextInt(1, 7) // 1 a 6
    }

    fun registrarSucesso() {
        falhasConsecutivas = 0
    }

    fun registrarFalha(): EstadoFalha {
        falhasConsecutivas++

        return when (falhasConsecutivas) {
            1 -> EstadoFalha.FERIMENTO_LEVE
            2 -> EstadoFalha.FERIMENTO_CRITICO
            else -> EstadoFalha.MORTE
        }
    }

    fun resetarFalhas() {
        falhasConsecutivas = 0
    }

    fun getFalhasConsecutivas(): Int {
        return falhasConsecutivas
    }
}
