package br.ufrn.eaj.tads.gametetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_tela_jogo.*
import android.view.LayoutInflater
import br.ufrn.eaj.tads.gametetris.pecas.*
import kotlin.random.Random


class JogoActivity : AppCompatActivity() {

    val LINHA = 36
    val COLUNA = 26
    var running = true
    var speed:Long = 300
    var rotate:Boolean = true
    var pt = novaPeca()

    //val board = Array(LINHA, { IntArray(COLUNA) })
    var board = Array(LINHA) {
        Array(COLUNA){0}
    }

    var boardView = Array(LINHA){
        arrayOfNulls<ImageView>(COLUNA)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_jogo)

        gridboard.rowCount = LINHA
        gridboard.columnCount = COLUNA

        val inflater = LayoutInflater.from(this)

        for (i in 0 until LINHA) {
            for (j in 0 until COLUNA) {
                boardView[i][j] = inflater.inflate(R.layout.inflate_image_view, gridboard, false) as ImageView
                gridboard.addView( boardView[i][j])
            }
        }
        //realizam o movimento das peças do tabuleiro
        btnLeft.setOnClickListener(){
            if(colideEsquerda()){
                pt.moveLeft()
            }
        }
        btnRight.setOnClickListener() {
            if(colideDireita()) {
                pt.moveRight()
            }
        }
        btnDown.setOnClickListener(){
            if(colideBaixo()){
                pt.moveDown()

            }
        }
        btnRotate.setOnClickListener(){
            if(colideEsquerda() && colideDireita()){
                if(rotate == true) {
                    pt.rotateRight()
                    rotate = false
                }else{
                    pt.rotateAgain()
                    rotate = true
                }
            }

        }
        gameRun()
    }

    fun novaPeca():Piece{
        var pecaRandom = Random.nextInt(1,6)
        when (pecaRandom) {
            1 -> {return I(0,13)}
            2 -> {return L(0,13)}
            3 -> {return N(0,13)}
            4 -> {return O(0,13)}
            5 -> {return S(0,13)}
            else->return T(0,13)
        }
    }

    fun colideBaixo():Boolean{
        return( (pt.pontoA.x + 1 < LINHA && board[pt.pontoA.x + 1][pt.pontoA.y] < 1) &&
                (pt.pontoB.x + 1 < LINHA && board[pt.pontoB.x + 1][pt.pontoB.y] < 1) &&
                (pt.pontoC.x + 1 < LINHA && board[pt.pontoC.x + 1][pt.pontoC.y] < 1) &&
                (pt.pontoD.x + 1 < LINHA && board[pt.pontoD.x + 1][pt.pontoD.y] < 1))
        /*return((pt.pontoA.x  + 1 <  LINHA) && (pt.pontoB.x + 1 < LINHA)
                && (pt.pontoC.x + 1 < LINHA) && (pt.pontoD.x + 1 < LINHA))*/
    }

    fun colideEsquerda():Boolean{
        return( (pt.pontoA.x - 1 >= COLUNA && board[pt.pontoA.x][pt.pontoA.y - 1] < 1) &&
                (pt.pontoB.x - 1 >= COLUNA && board[pt.pontoB.x][pt.pontoB.y - 1] < 1) &&
                (pt.pontoC.x - 1 >= COLUNA && board[pt.pontoC.x][pt.pontoC.y - 1] < 1) &&
                (pt.pontoD.x - 1 >= COLUNA && board[pt.pontoD.x][pt.pontoD.y - 1] < 1))
        /*return((pt.pontoA.x - 1 >= COLUNA) && (pt.pontoB.x - 1 >= COLUNA) &&
                 (pt.pontoC.x - 1 >= COLUNA) && (pt.pontoD.x - 1 >=  COLUNA))*/
    }

    fun colideDireita():Boolean{
        return( (pt.pontoA.x + 1 < COLUNA && board[pt.pontoA.x][pt.pontoA.y + 1] > 1) &&
                (pt.pontoB.x + 1 < COLUNA && board[pt.pontoB.x][pt.pontoB.y + 1] > 1) &&
                (pt.pontoC.x + 1 < COLUNA && board[pt.pontoC.x][pt.pontoC.y + 1] > 1) &&
                (pt.pontoD.x + 1 < COLUNA && board[pt.pontoD.x][pt.pontoD.y + 1] > 1))
        /*return( (pt.pontoA.x + 1 < COLUNA) && (pt.pontoB.x + 1 > COLUNA) &&
                  (pt.pontoC.y + 1< COLUNA) && (pt.pontoD.x + 1 > COLUNA))*/
    }
    fun colidePeca(): Boolean {
        return( (board[pt.pontoA.x][pt.pontoA.y] != 1) &&
                (board[pt.pontoB.x][pt.pontoB.y] != 1) &&
                (board[pt.pontoC.x][pt.pontoC.y] != 1) &&
                (board[pt.pontoD.x][pt.pontoD.y] != 1))
    }

    fun printPeca(){
        boardView[pt.pontoA.x][pt.pontoA.y]!!.setImageResource(R.drawable.white)
        boardView[pt.pontoB.x][pt.pontoB.y]!!.setImageResource(R.drawable.white)
        boardView[pt.pontoC.x][pt.pontoC.y]!!.setImageResource(R.drawable.white)
        boardView[pt.pontoD.x][pt.pontoD.y]!!.setImageResource(R.drawable.white)
    }

    fun salvaPeca(){
        board[pt.pontoA.x][pt.pontoA.y] = 1
        board[pt.pontoB.x][pt.pontoB.y] = 1
        board[pt.pontoC.x][pt.pontoC.y] = 1
        board[pt.pontoD.x][pt.pontoD.y] = 1
    }

    fun gameRun(){
        Thread{
            while(running){
                Thread.sleep(speed)
                runOnUiThread{
                    //limpa tela
                    for (i in 0 until LINHA) {
                        for (j in 0 until COLUNA) {
                            when(board[i][j]){
                                0 -> {
                                    boardView[i][j]!!.setImageResource(R.drawable.black)
                                }
                                1 -> {
                                    boardView[i][j]!!.setImageResource(R.drawable.white)
                                }

                            }

                        }
                    }
                    //move peça atual
                    pt.moveDown()
                    //gera uma nova peça - primeira verifica se houve colisão entre peças e colisão como final do tabuleiro
                    if(colideBaixo() && colidePeca()) {
                        printPeca()
                    }else{
                        printPeca()
                        salvaPeca()
                        rotate = true
                        pt = novaPeca()
                    }

                }
            }
        }.start()
    }
}