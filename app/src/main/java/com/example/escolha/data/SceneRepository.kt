package com.example.escolha.data

import com.example.escolha.R

object SceneRepository {

    private val scenes = mapOf(

        // =========================
        // CAPÍTULO 0 — TELA PRETA
        // =========================
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

        // =========================
        // INTRODUÇÃO — O REINO
        // =========================
        "introducao" to Scene(
            id = "introducao",
            backgroundRes = R.drawable.reino,
            textos = listOf(
                "A névoa cobre as torres de Aethryn.",
                "Os sinos não tocam.",
                "As estradas estão vazias.",
                "Os corvos, não.",
                "Mensageiros desapareceram.",
                "Vilas inteiras silenciaram.",
                "Relatos falam de um exército que não dorme.",
                "Corpos que marcham sem respirar.",
                "No centro do reino, apenas uma ordem resiste.",
                "O Conselho da Última Vigília.",
                "E é para eles que você é chamado."
            ),
            proximaCena = "conselho"
        ),

        // =========================
        // CONSELHO
        // =========================
        "conselho" to Scene(
            id = "conselho",
            backgroundRes = R.drawable.capitulo_1_o_chamado,
            textos = listOf(
                "Você está diante de uma mesa de pedra marcada por séculos de guerra.",
                "Velas tremulam. Não por vento.",
                "Mas por algo mais sutil.",
                "Uma voz ecoa na sala:",
                "“O nome dele é Malachar.”",
                "“Antigo arquimago.”",
                "“Agora… algo além disso.”",
                "Um mapa é estendido sobre a mesa.",
                "Marcas negras avançam do norte.",
                "“Ele levanta os mortos.”",
                "“Quebra juramentos.”",
                "“E não marcha sozinho.”",
                "O silêncio pesa.",
                "“Precisamos de alguém.”",
                "“Não um exército.”",
                "“Um sobrevivente.”"
            ),
            proximaCena = "escolha_personagem"
        ),

        // =========================
        // CAPÍTULO 1 — ESTRADA
        // =========================
        "capitulo1_estrada" to Scene(
            id = "capitulo1_estrada",
            backgroundRes = R.drawable.capitulo_2_sombras_na_estrada_norte,
            textos = listOf(
                "Você parte ao amanhecer.",
                "A estrada norte está abandonada.",
                "Casas fechadas. Portões quebrados.",
                "Marcas no chão indicam luta.",
                "Nenhuma vitória.",
                "O vento carrega um cheiro metálico.",
                "Algo aconteceu aqui.",
                "Algo recente.",
                "Ao longe, entre as árvores, há movimento.",
                "Não são animais.",
                "Eles observam.",
                "Esperam.",
                "E então avançam."
            ),
            proximaCena = "capitulo1_combate"
        ),

        // =========================
        // COMBATE TUTORIAL (IMAGEM CORRETA)
        // =========================
        "capitulo1_combate" to Scene(
            id = "capitulo1_combate",
            backgroundRes = R.drawable.orcs_estrada_abandonada,
            textos = listOf(
                "Eles avançam sem hesitação.",
                "Seus corpos são grandes demais.",
                "Seus olhos, vazios.",
                "Você tem poucos segundos para agir."
            ),
            proximaCena = null
        ),

        // =========================
        // PÓS-COMBATE
        // =========================
        "capitulo1_pos_combate" to Scene(
            id = "capitulo1_pos_combate",
            backgroundRes = R.drawable.campo_de_batalha,
            textos = listOf(
                "Os corpos caem… mas não descansam.",
                "Algo os chamou.",
                "Algo maior está próximo.",
                "Você sente isso.",
                "Se continuar tendo sucesso,",
                "poderá arriscar algo… mais extremo."
            ),
            proximaCena = null
        )
    )

    fun getScene(id: String): Scene? = scenes[id]
}
