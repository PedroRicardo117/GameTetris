package br.ufrn.eaj.tads.gametetris.pecas

import br.ufrn.eaj.tads.gametetris.Ponto

class I (x:Int, y:Int): Piece(x, y){
    override fun rotate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        pontoB = Ponto(x+1,y)
        pontoC = Ponto(x+2,y)
        pontoD = Ponto(x+3,y)
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

    override fun girar() {
        pontoB.x += 1
        pontoB.y += 1

        pontoC.x += 2
        pontoC.y += 2

        pontoD.x += 1
        pontoD.y -= 1
    }
}