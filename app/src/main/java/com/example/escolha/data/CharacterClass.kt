package com.example.escolha.data

import com.example.escolha.R

enum class CharacterClass(
    val displayName: String,
    val subtitle: String,
    val imageRes: Int,
    val caracteristicasTexto: String,
    val golpeFatalTexto: String
) {
    GUERREIRO(
        "Guerreiro",
        "O Escudo de Aethryn",
        R.drawable.guerreiro,
        """
GUERREIRO — O Escudo de Aethryn

Perfil
Forte, resistente, direto
Fraco contra magia e furtividade

Atributos Base (15)
Força: 5
Vitalidade: 5
Destreza: 3
Intelecto: 1
Magia: 1

Regras de Dado
Força física: 3+
Defesa corpo a corpo: 2+
Defesa contra magia: 6+
Magia simples: impossível
Magia ofensiva: impossível
""".trimIndent(),
        """
Golpe Fatal — Frenesi do Escudo Quebrado

Desbloqueio:
• 2 sucessos consecutivos em combate

Execução:
• Rolar 4+

Efeito:
• Elimina inimigos comuns
• Ignora defesa e número
• Sub-chefes sofrem dano quase mortal

Sucesso:
• Fica Ferido
• Próximos 2 testes exigem +1
• Mobilidade reduzida

Falha:
• Dano severo
• Estado Crítico
• Próximo erro pode matar
""".trimIndent()
    ),

    ARQUEIRO(
        "Arqueiro",
        "O Olho do Vento",
        R.drawable.arqueira,
        """
ARQUEIRO — O Olho do Vento

Perfil
Preciso, ágil, estratégico
Frágil em combate direto

Atributos Base (15)
Força: 2
Vitalidade: 3
Destreza: 5
Intelecto: 3
Magia: 2

Regras de Dado
Ataque à distância: 3+
Furtividade: 2+
Magia simples: 4+
Magia ofensiva: 6+
""".trimIndent(),
        """
Golpe Fatal — Chuva do Último Fôlego

Desbloqueio:
• 2 sucessos consecutivos

Execução:
• Rolar 4+

Efeito:
• Elimina inimigos comuns
• Sub-chefes sofrem dano quase mortal

Sucesso:
• Exaustão extrema
• Próximos 2 testes +1

Falha:
• Dano severo
• Fica Ferido
• Próximos 2 testes +2
""".trimIndent()
    ),

    MAGO(
        "Mago",
        "O Tecelão do Éter",
        R.drawable.mago,
        """
MAGO — O Tecelão do Éter

Perfil
Mestre da magia arcana
Fisicamente frágil

Atributos Base (15)
Força: 1
Vitalidade: 2
Destreza: 2
Intelecto: 5
Magia: 5

Regras de Dado
Magia simples: 2+
Magia ofensiva: 4+
Força física: 5+
Defesa física: 5+
""".trimIndent(),
        """
Golpe Fatal — Ruptura do Véu

Desbloqueio:
• 2 sucessos consecutivos

Execução:
• Rolar 4+

Efeito:
• Devastação total

Sucesso:
• Esgotamento Arcano
• Próximos testes mágicos +2

Falha:
• Colapso mágico
• Estado Crítico
""".trimIndent()
    ),

    NECROMANTE(
        "Necromante",
        "O Que Ouve os Mortos",
        R.drawable.necromante,
        """
NECROMANTE — O Que Ouve os Mortos

Perfil
Controle da morte
Consequências narrativas pesadas

Atributos Base (15)
Força: 1
Vitalidade: 3
Destreza: 1
Intelecto: 4
Magia: 6

Regras de Dado
Magia necromântica: 2+
Magia de dano: 3+
Força física: 6+
""".trimIndent(),
        """
Golpe Fatal — Pacto da Última Voz

Desbloqueio:
• 2 sucessos consecutivos

Execução:
• Rolar 4+

Efeito:
• Entidades eliminam inimigos

Sucesso:
• Corrupção temporária
• Entidade passa a segui-lo

Falha:
• Maldição
• Possível final sombrio
""".trimIndent()
    )
}
