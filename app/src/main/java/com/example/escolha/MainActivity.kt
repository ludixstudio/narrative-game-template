package com.example.escolha

import android.app.AlertDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.escolha.data.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var cenaAtualId = "capitulo0"
    private var indiceTexto = 0
    private var personagem: CharacterClass? = null

    // ===== SISTEMA DE TESTE =====
    private var estadoTeste = EstadoTeste.AGUARDANDO_ESCOLHA
    private var tipoTesteAtual: TipoTeste? = null
    private var minimoAtual = 0

    // Views
    private lateinit var bg: ImageView
    private lateinit var centerText: TextView
    private lateinit var bottomText: TextView
    private lateinit var bottomContainer: LinearLayout
    private lateinit var choicesContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scene_layout)
        bindViews()
        configurarCliqueTexto()
        renderCena(cenaAtualId)
    }

    private fun bindViews() {
        bg = findViewById(R.id.sceneBackground)
        centerText = findViewById(R.id.sceneTextCenter)
        bottomText = findViewById(R.id.sceneTextBottom)
        bottomContainer = findViewById(R.id.bottomContainer)
        choicesContainer = findViewById(R.id.choicesContainer)
    }

    // ===============================
    // CLIQUE FIXO DO TEXTO (CRÍTICO)
    // ===============================
    private fun configurarCliqueTexto() {
        bottomText.setOnClickListener {
            when (estadoTeste) {

                EstadoTeste.INTENCAO -> {
                    estadoTeste = EstadoTeste.REGRA
                    bottomText.text =
                        "Teste de ${tipoTesteAtual!!.label}\nSucesso com $minimoAtual+"
                }

                EstadoTeste.REGRA -> {
                    estadoTeste = EstadoTeste.SUSPENSE
                    bottomText.text = "O destino é lançado…"
                }

                EstadoTeste.SUSPENSE -> {
                    estadoTeste = EstadoTeste.RESULTADO
                    executarRolagem()
                }

                else -> {
                    avancarTextoNormal()
                }
            }
        }

        bg.setOnClickListener {
            if (estadoTeste == EstadoTeste.AGUARDANDO_ESCOLHA) {
                avancarTextoNormal()
            }
        }
    }

    // ===============================
    // CENAS
    // ===============================
    private fun renderCena(sceneId: String) {
        if (sceneId == "escolha_personagem") {
            mostrarSelecaoPersonagem()
            return
        }

        val scene = SceneRepository.getScene(sceneId) ?: return
        cenaAtualId = sceneId
        indiceTexto = 0
        estadoTeste = EstadoTeste.AGUARDANDO_ESCOLHA

        bg.setImageResource(scene.backgroundRes)
        choicesContainer.visibility = LinearLayout.GONE
        choicesContainer.removeAllViews()

        val usarCentro = sceneId == "capitulo0"
        centerText.visibility = if (usarCentro) TextView.VISIBLE else TextView.GONE
        bottomContainer.visibility = if (usarCentro) LinearLayout.GONE else LinearLayout.VISIBLE

        val textoAtivo = if (usarCentro) centerText else bottomText
        textoAtivo.text = scene.textos[indiceTexto]
    }

    private fun avancarTextoNormal() {
        val scene = SceneRepository.getScene(cenaAtualId) ?: return
        val textoAtivo = if (cenaAtualId == "capitulo0") centerText else bottomText

        if (indiceTexto < scene.textos.size - 1) {
            indiceTexto++
            textoAtivo.text = scene.textos[indiceTexto]
        } else {
            if (cenaAtualId == "capitulo1_combate") {
                mostrarAcoesCombate()
            } else {
                scene.proximaCena?.let { renderCena(it) }
            }
        }
    }

    // ===============================
    // COMBATE
    // ===============================
    private fun mostrarAcoesCombate() {
        choicesContainer.visibility = LinearLayout.VISIBLE
        choicesContainer.removeAllViews()

        fun botao(texto: String, tipo: TipoTeste) {
            val b = Button(this)
            b.text = texto
            b.setOnClickListener {
                choicesContainer.visibility = LinearLayout.GONE
                iniciarTeste(tipo)
            }
            choicesContainer.addView(b)
        }

        botao("Atacar com cautela", TipoTeste.DESTREZA)
        botao("Avançar agressivamente", TipoTeste.FORCA)
    }

    private fun iniciarTeste(tipo: TipoTeste) {
        tipoTesteAtual = tipo
        minimoAtual = RegraTeste.getMinimo(personagem!!, tipo)
        estadoTeste = EstadoTeste.INTENCAO
        bottomText.text = "Você decide agir."
    }

    private fun executarRolagem() {
        val dado = Random.nextInt(1, 7)
        val sucesso = dado >= minimoAtual

        AlertDialog.Builder(this)
            .setTitle("Resultado do Dado")
            .setMessage(
                "🎲 Dado: $dado\n\n" +
                        if (sucesso) "✅ Sucesso" else "❌ Falha"
            )
            .setCancelable(false)
            .setPositiveButton("Continuar") { _, _ ->
                if (sucesso) {
                    renderCena("capitulo1_pos_combate")
                } else {
                    estadoTeste = EstadoTeste.AGUARDANDO_ESCOLHA
                    bottomText.text =
                        "Você falha, mas ainda está de pé.\nTente outra abordagem."
                    mostrarAcoesCombate()
                }
            }
            .show()
    }

    // ===============================
    // SELEÇÃO DE PERSONAGEM
    // ===============================
    private fun mostrarSelecaoPersonagem() {
        setContentView(R.layout.character_select_layout)

        val personagens = CharacterClass.values()
        var index = 0

        val bgChar = findViewById<ImageView>(R.id.characterBackground)
        val nome = findViewById<TextView>(R.id.characterName)
        val subtitulo = findViewById<TextView>(R.id.characterSubtitle)

        fun render() {
            val p = personagens[index]
            bgChar.setImageResource(p.imageRes)
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

        findViewById<Button>(R.id.btnCharacteristics).setOnClickListener {
            mostrarPopup(personagens[index].caracteristicas)
        }

        findViewById<Button>(R.id.btnFatal).setOnClickListener {
            mostrarPopup(personagens[index].golpeFatal)
        }

        findViewById<Button>(R.id.btnConfirm).setOnClickListener {
            personagem = personagens[index]
            setContentView(R.layout.scene_layout)
            bindViews()
            configurarCliqueTexto()
            renderCena("capitulo1_estrada")
        }

        render()
    }

    private fun mostrarPopup(texto: String) {
        AlertDialog.Builder(this)
            .setMessage(texto)
            .setPositiveButton("Fechar", null)
            .show()
    }
}
