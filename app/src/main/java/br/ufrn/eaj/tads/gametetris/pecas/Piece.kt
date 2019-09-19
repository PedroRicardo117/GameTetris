package br.ufrn.eaj.tads.gametetris.pecas

import br.ufrn.eaj.tads.gametetris.Ponto

abstract class Piece(var x:Int, var y:Int){

    var pontoA:Ponto = Ponto(x, y)
    lateinit var pontoB:Ponto
    lateinit var pontoC:Ponto
    lateinit var pontoD:Ponto

    abstract fun moveDown()
    abstract fun moveLeft()
    abstract fun moveRight()
    abstract fun rotate()
    abstract fun girar()
}