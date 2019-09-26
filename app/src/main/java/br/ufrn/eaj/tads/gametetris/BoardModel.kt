package br.ufrn.eaj.tads.gametetris

import androidx.lifecycle.ViewModel

class BoardModel: ViewModel() {
    val LINHA = 36
    val COLUNA = 26

    var board = Array(LINHA){
        Array(COLUNA){0}
    }
}