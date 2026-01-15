package com.example.escolha.data

import com.example.escolha.R

enum class CharacterClass(
    val displayName: String,
    val subtitle: String,
    val imageRes: Int,
    val caracteristicas: String,
    val golpeFatal: String
) {

    GUERREIRO(
        displayName = "Guerreiro",
        subtitle = "O Escudo de Aethryn",
        imageRes = R.drawable.guerreiro,
        caracteristicas = """
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
Defesa contra magia: 6
Magia simples: impossível
Magia ofensiva: impossível
""".trimIndent(),
        golpeFatal = """
Golpe Fatal — Frenesi do Escudo Quebrado

Desbloqueio:
2 sucessos consecutivos em combate

Execução:
Requer rolagem 4+

Efeito:
Elimina todos os inimigos comuns da cena
Ignora defesa e número de inimigos
(Sub-chefes e vilão sofrem dano quase mortal)

Se o golpe for bem-sucedido:
• Guerreiro fica Ferido automaticamente
• Próximos 2 lançamentos exigem +1
• Mobilidade narrativa reduzida temporariamente

Se o golpe falhar:
• Dano severo imediato
• Entra em Estado Crítico
• Próximo erro pode resultar em morte
""".trimIndent()
    ),

    ARQUEIRO(
        displayName = "Arqueiro",
        subtitle = "O Olho do Vento",
        imageRes = R.drawable.arqueira,
        caracteristicas = """
ARQUEIRO — O Olho do Vento

Perfil
Preciso, estratégico, ágil
Frágil em combate direto

Atributos Base (15)
Força: 2
Vitalidade: 3
Destreza: 5
Intelecto: 3
Magia: 2

Regras de Dado
Ataque à distância: 3+
Furtividade / evasão: 2+
Magia simples: 4+
Magia ofensiva: 6+
""".trimIndent(),
        golpeFatal = """
Golpe Fatal — Chuva do Último Fôlego

Desbloqueio:
2 sucessos consecutivos em combate

Execução:
Requer rolagem 4+

Efeito:
Elimina inimigos comuns e alvos prioritários
(Sub-chefes e vilão sofrem dano quase mortal)

Se o golpe for bem-sucedido:
• Entra em Exaustão Extrema
• Próximos 2 lançamentos exigem +1
• Mobilidade e precisão reduzidas temporariamente

Se o golpe falhar:
• Dano severo imediato
• Fica Ferido
• Próximos 2 lançamentos exigem +2
• Nova falha pode resultar em morte
""".trimIndent()
    ),

    MAGO(
        displayName = "Mago",
        subtitle = "O Tecelão do Éter",
        imageRes = R.drawable.mago,
        caracteristicas = """
MAGO — O Tecelão do Éter

Perfil
Mestre da magia arcana
Frágil fisicamente

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
Resistência mágica: 2+
""".trimIndent(),
        golpeFatal = """
Golpe Fatal — Ruptura do Véu Arcano

Desbloqueio:
2 sucessos consecutivos em combate

Execução:
Requer rolagem 4+

Efeito:
Destruição total da ameaça e do ambiente imediato
(Sub-chefes e vilão sofrem dano quase mortal)

Se o golpe for bem-sucedido:
• Entra em Esgotamento Arcano
• Próximos 2 lançamentos mágicos exigem +2
• Instabilidade narrativa no ambiente

Se o golpe falhar:
• Dano severo imediato
• Perda de controle mágico
• Entra em Estado Crítico Arcano
• Nova falha mágica pode causar colapso ou morte
""".trimIndent()
    ),

    NECROMANTE(
        displayName = "Necromante",
        subtitle = "O Que Ouve os Mortos",
        imageRes = R.drawable.necromante,
        caracteristicas = """
NECROMANTE — O Que Ouve os Mortos

Perfil
Controle sobre morte, sacrifício e corrupção
Consequências narrativas mais pesadas

Atributos Base (15)
Força: 1
Vitalidade: 3
Destreza: 1
Intelecto: 4
Magia: 6

Regras de Dado
Magia necromântica simples: 2+
Magia de dano: 3+
Força física: 6+
Resistência mágica: 2+
Falhas podem gerar efeitos narrativos adicionais
""".trimIndent(),
        golpeFatal = """
Golpe Fatal — Pacto da Última Voz

Desbloqueio:
2 sucessos consecutivos em combate

Execução:
Requer rolagem 4+

Efeito:
Entidades eliminam todos os inimigos comuns
(Sub-chefes e vilão sofrem dano quase mortal)

Se o golpe for bem-sucedido (Corrupção – 5 rodadas):
• Perda temporária de atributo
• Entidade passa a segui-lo
• Alteração narrativa futura

Se o golpe falhar:
• Dano severo imediato
• Maldição ativa
• Estado Crítico
• Possível desvio para final alternativo sombrio
""".trimIndent()
    );
}
