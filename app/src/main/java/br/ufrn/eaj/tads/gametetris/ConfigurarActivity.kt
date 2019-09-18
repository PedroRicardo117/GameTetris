package br.ufrn.eaj.tads.gametetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_configurar.*

class ConfigurarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar)

        //botão retorna para o menu principal e informações não são salvas
        btnReturn.setOnClickListener(){
            var i = Intent(this, TelaInicial::class.java)
            startActivity(i)
        }
        //Botão retorna para a tela inicial persistindo o dados que foram alterados.
        btnSaveConf.setOnClickListener(){
            var i = Intent(this, TelaInicial::class.java)
            startActivity(i)
        }
    }
}
