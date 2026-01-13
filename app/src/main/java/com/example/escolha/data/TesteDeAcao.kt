package com.example.escolha.data

import kotlin.random.Random

object TesteDeAcao {

    fun executarTeste(
        personagem: CharacterClass,
        tipoTeste: TipoTeste,
        vantagem: Int = 0,
        capitulo: Int = 1,
        dicaEspecifica: String? = null
    ): ResultadoTeste {

        val dado = Random.nextInt(1, 7)
        val minimo = getMinimoParaTeste(personagem, tipoTeste)

        val sucesso = dado + vantagem >= minimo

        val texto = if (sucesso) {
            dicaEspecifica ?: "Você age com precisão. A ação dá certo."
        } else {
            "Algo sai errado. O destino não esteve ao seu favor."
        }

        return ResultadoTeste(
            sucesso = sucesso,
            valorDado = dado,
            textoNarrativo = texto
        )
    }

    fun getMinimoParaTeste(
        personagem: CharacterClass,
        tipoTeste: TipoTeste
    ): Int {
        return when (personagem) {

            CharacterClass.GUERREIRO -> when (tipoTeste) {
                TipoTeste.FORCA -> 3
                TipoTeste.DEFESA -> 2
                TipoTeste.MAGIA -> 6
                TipoTeste.DESTREZA -> 4
                TipoTeste.FURTIVIDADE -> 5
            }

            CharacterClass.ARQUEIRO -> when (tipoTeste) {
                TipoTeste.DESTREZA -> 3
                TipoTeste.FURTIVIDADE -> 2
                TipoTeste.MAGIA -> 4
                TipoTeste.FORCA -> 5
                TipoTeste.DEFESA -> 4
            }

            CharacterClass.MAGO -> when (tipoTeste) {
                TipoTeste.MAGIA -> 2
                TipoTeste.FORCA -> 5
                TipoTeste.DEFESA -> 5
                TipoTeste.DESTREZA -> 4
                TipoTeste.FURTIVIDADE -> 4
            }

            CharacterClass.NECROMANTE -> when (tipoTeste) {
                TipoTeste.MAGIA -> 2
                TipoTeste.FORCA -> 6
                TipoTeste.DEFESA -> 4
                TipoTeste.DESTREZA -> 5
                TipoTeste.FURTIVIDADE -> 5
            }
        }
    }
}
