package com.example.escolha.data

data class Scene(
    val id: String,
    val backgroundRes: Int,
    val textos: List<String>,
    val proximaCena: String? = null
)
