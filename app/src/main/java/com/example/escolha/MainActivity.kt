package com.example.escolha

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.escolha.data.*

class MainActivity : AppCompatActivity() {

    private var cenaAtualId = "capitulo0"
    private var indiceTexto = 0
    private var personagemSelecionado: CharacterClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scene_layout)
        renderCena(cenaAtualId)
    }

    private fun renderCena(sceneId: String) {
        if (sceneId == "escolha_personagem") {
            mostrarSelecaoPersonagem()
            return
        }

        val scene = SceneRepository.getScene(sceneId) ?: return

        val background = findViewById<ImageView>(R.id.sceneBackground)
        val textCenter = findViewById<TextView>(R.id.sceneTextCenter)
        val textBottom = findViewById<TextView>(R.id.sceneTextBottom)

        val usarCentro = sceneId == "capitulo0"

        textCenter.visibility = if (usarCentro) TextView.VISIBLE else TextView.GONE
        textBottom.visibility = if (usarCentro) TextView.GONE else TextView.VISIBLE

        val textoAtivo = if (usarCentro) textCenter else textBottom

        background.setImageResource(scene.backgroundRes)
        indiceTexto = 0
        textoAtivo.text = scene.textos[indiceTexto]

        fun avancar() {
            if (indiceTexto < scene.textos.size - 1) {
                indiceTexto++
                textoAtivo.text = scene.textos[indiceTexto]
            } else {
                scene.proximaCena?.let { renderCena(it) }
            }
        }

        background.setOnClickListener { avancar() }
        textoAtivo.setOnClickListener { avancar() }
    }

    // ================= SELEÇÃO DE PERSONAGEM =================

    private fun mostrarSelecaoPersonagem() {
        setContentView(R.layout.character_select_layout)

        val personagens = CharacterClass.values()
        var index = 0

        val bg = findViewById<ImageView>(R.id.characterBackground)
        val nome = findViewById<TextView>(R.id.characterName)
        val subtitulo = findViewById<TextView>(R.id.characterSubtitle)

        fun render() {
            val p = personagens[index]
            bg.setImageResource(p.imageRes)
            nome.text = p.displayName
            subtitulo.text = p.subtitle
        }

        findViewById<Button>(R.id.btnPrev).setOnClickListener {
            index = if (index == 0) personagens.size - 1 else index - 1
            render()
        }

        findViewById<Button>(R.id.btnNext).setOnClickListener {
            index = (index + 1) % personagens.size
            render()
        }

        findViewById<Button>(R.id.btnAttributes).setOnClickListener {
            mostrarDialogo("Características", personagens[index].caracteristicasTexto)
        }

        findViewById<Button>(R.id.btnFatal).setOnClickListener {
            mostrarDialogo("Golpe Fatal", personagens[index].golpeFatalTexto)
        }

        findViewById<Button>(R.id.btnConfirm).setOnClickListener {
            personagemSelecionado = personagens[index]
            setContentView(R.layout.scene_layout)
            renderCena("capitulo1_estrada")
        }

        render()
    }

    private fun mostrarDialogo(titulo: String, texto: String) {
        val scroll = ScrollView(this)
        val tv = TextView(this)
        tv.text = texto
        tv.setPadding(32, 32, 32, 32)
        scroll.addView(tv)

        AlertDialog.Builder(this)
            .setTitle(titulo)
            .setView(scroll)
            .setPositiveButton("Fechar", null)
            .show()
    }
}
