package com.example.triangulo4a.Contratos

interface ContratoRectangulo {
    interface Vista{
        fun muestraArea(area:Float)
        fun muestraPerimetro(perimetro:Float)
        fun muestraError(mensaje:String)
    }
    interface Modelo {
        fun calculaArea(base: Float, altura: Float): Float
        fun calculaPerimetro(base: Float, altura: Float): Float
        fun verificaRectangulo(base: Float, altura: Float): Boolean
    }
    interface Presentador {
        fun calculaArea(base: Float, altura: Float)
        fun calculaPerimetro(base: Float, altura: Float)
    }
}