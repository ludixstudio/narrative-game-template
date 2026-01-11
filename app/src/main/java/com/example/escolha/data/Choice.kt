package com.example.escolha.data

data class Choice(
    val texto: String,
    val destino: String,
    val efeitos: Map<String, Int>
)
