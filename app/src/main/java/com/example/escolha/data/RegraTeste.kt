package com.example.escolha.data

object RegraTeste {

    fun getMinimo(personagem: CharacterClass, tipo: TipoTeste): Int {
        return when (personagem) {

            CharacterClass.GUERREIRO -> when (tipo) {
                TipoTeste.FORCA -> 3
                TipoTeste.DESTREZA -> 4
                TipoTeste.MAGIA -> 6
                TipoTeste.DEFESA -> 2
                else -> 6
            }

            CharacterClass.ARQUEIRO -> when (tipo) {
                TipoTeste.DESTREZA -> 3
                TipoTeste.FURTIVIDADE -> 2
                TipoTeste.MAGIA -> 4
                TipoTeste.FORCA -> 5
                else -> 5
            }

            CharacterClass.MAGO -> when (tipo) {
                TipoTeste.MAGIA -> 2
                TipoTeste.FORCA -> 5
                TipoTeste.DEFESA -> 5
                else -> 4
            }

            CharacterClass.NECROMANTE -> when (tipo) {
                TipoTeste.MAGIA -> 2
                TipoTeste.FORCA -> 6
                else -> 4
            }
        }
    }
}
