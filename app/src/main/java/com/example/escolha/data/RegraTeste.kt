package com.example.escolha.data

object RegraTeste {

    fun valorMinimo(
        personagem: CharacterClass,
        tipoTeste: TipoTeste
    ): Int {

        return when (personagem) {

            CharacterClass.GUERREIRO -> when (tipoTeste) {
                TipoTeste.FORCA -> 3
                TipoTeste.DEFESA -> 2
                TipoTeste.DESTREZA -> 3
                TipoTeste.MAGIA -> 6
                TipoTeste.FURTIVIDADE -> 5
            }

            CharacterClass.ARQUEIRO -> when (tipoTeste) {
                TipoTeste.DESTREZA -> 2
                TipoTeste.FURTIVIDADE -> 2
                TipoTeste.FORCA -> 5
                TipoTeste.DEFESA -> 3
                TipoTeste.MAGIA -> 4
            }

            CharacterClass.MAGO -> when (tipoTeste) {
                TipoTeste.MAGIA -> 2
                TipoTeste.DEFESA -> 5
                TipoTeste.FORCA -> 5
                TipoTeste.DESTREZA -> 4
                TipoTeste.FURTIVIDADE -> 4
            }

            CharacterClass.NECROMANTE -> when (tipoTeste) {
                TipoTeste.MAGIA -> 2
                TipoTeste.DEFESA -> 5
                TipoTeste.FORCA -> 6
                TipoTeste.DESTREZA -> 5
                TipoTeste.FURTIVIDADE -> 4
            }
        }
    }
}
