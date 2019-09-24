package br.ufrn.eaj.tads.gametetris.pecas

import br.ufrn.eaj.tads.gametetris.Ponto

class Z(x:Int, y:Int):Piece(x,y) {
    init{
        pontoB = Ponto( x,y + 1)
        pontoC = Ponto(x + 1, y)
        pontoD = Ponto(x + 1, y - 1)
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
    override fun rotateRight(){
        pontoB.x += 1
        pontoB.y -= 1

        pontoC.x -= 1
        pontoC.y -= 1

        pontoD.x -= 2
    }

    override fun rotateAgain(){
        pontoB.x -= 1
        pontoB.y += 1

        pontoC.x += 1
        pontoC.y += 1

        pontoD.x += 2
    }
}