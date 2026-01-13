package com.example.escolha.data

import com.example.escolha.R

object SceneRepository {

    private val scenes = mapOf(

        // CAPÍTULO 0 — TELA PRETA
        "capitulo0" to Scene(
            id = "capitulo0",
            backgroundRes = android.R.color.black,
            textos = listOf(
                "As Crônicas de Aethryn",
                "ALÉM DO VÉU",
                "Um RPG narrativo de escolhas, destino e consequências.",
                "Toque para iniciar"
            ),
            proximaCena = "introducao"
        ),

        // INTRODUÇÃO
        "introducao" to Scene(
            id = "introducao",
            backgroundRes = R.drawable.reino,
            textos = listOf(
                "A névoa cobre as torres de Aethryn como um presságio antigo.",
                "Os sinos não tocam há dias.",
                "Mensageiros desapareceram. Vilas inteiras silenciaram.",
                "No centro do reino, apenas uma ordem permanece.",
                "O Conselho da Última Vigília.",
                "E é para eles que você é chamado."
            ),
            proximaCena = "conselho"
        ),

        // CONSELHO
        "conselho" to Scene(
            id = "conselho",
            backgroundRes = R.drawable.capitulo_1_o_chamado,
            textos = listOf(
                "Você está diante de uma mesa de pedra marcada por séculos de guerra.",
                "Velas tremulam. Não por vento — mas por algo mais sutil.",
                "“O nome dele é Malachar.”",
                "“Antigo arquimago. Agora… algo além disso.”",
                "“Precisamos de alguém.”",
                "“Não um exército. Um sobrevivente.”"
            ),
            proximaCena = "escolha_personagem"
        )

        // A história continua depois da escolha
    )

    fun getScene(id: String): Scene? = scenes[id]
}
