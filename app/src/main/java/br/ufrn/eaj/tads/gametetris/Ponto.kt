package br.ufrn.eaj.tads.gametetris

class Ponto(var x:Int, var y:Int){

    //x são linhas, y são colunas
    fun moveDown(){
        x++
    }
    fun moveLeft(){
        y--
    }
    fun moveRight(){
        y++
    }
}