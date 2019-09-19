package br.ufrn.eaj.tads.gametetris.pecas

import br.ufrn.eaj.tads.gametetris.Ponto

class T (x:Int, y:Int): Piece(x, y){
    override fun girar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        pontoB = Ponto(x, y-1)
        pontoC = Ponto(x, y+1)
        pontoD = Ponto(x, y+1)

    }
    override fun moveDown(){
        pontoA.moveDown()
        pontoB.moveDown()
        pontoC.moveDown()
        pontoD.moveDown()
    }

    override fun moveLeft(){
        pontoA.moveLeft()
        pontoB.moveLeft()
        pontoC.moveLeft()
        pontoD.moveLeft()
    }

    override fun moveRight(){
        pontoA.moveRight()
        pontoB.moveRight()
        pontoC.moveRight()
        pontoD.moveRight()
    }

    override fun rotate(){
        pontoB.x += 1
        pontoB.y += 1

        pontoC.x += 2
        pontoC.y += 2

        pontoD.x += 1
        pontoD.y -= 1
    }
}