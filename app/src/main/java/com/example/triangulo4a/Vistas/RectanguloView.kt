package com.example.triangulo4a.Vistas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.triangulo4a.Contratos.ContratoRectangulo
import com.example.triangulo4a.Presentador.RectanguloPresentador
import com.example.triangulo4a.R

class RectanguloView : AppCompatActivity(), ContratoRectangulo.Vista {

    private lateinit var edtBase: EditText
    private lateinit var edtAltura: EditText
    private lateinit var btnArea: Button
    private lateinit var btnPerimetro: Button
    private lateinit var txtArea: TextView
    private lateinit var txtPerimetro: TextView
    private lateinit var presentador: ContratoRectangulo.Presentador


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rectangulo_view)

        edtBase = findViewById<EditText>(R.id.txtBase)
        edtAltura = findViewById<EditText>(R.id.txtAltura)
        btnArea = findViewById<Button>(R.id.btnShowArea)
        btnPerimetro = findViewById<Button>(R.id.btnShowPerimetro)
        txtArea = findViewById<TextView>(R.id.txvArea)
        txtPerimetro = findViewById<TextView>(R.id.txvPerimetro)


        presentador = RectanguloPresentador(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //configuramos el listener del boton para mostrar el area
        btnArea.setOnClickListener {
            val base = edtBase.text.toString().toFloat()
            val altura = edtAltura.text.toString().toFloat()
            presentador.calculaArea(base, altura)
        }
        //configuramos el listener del boton para mostrar el perimetro
        btnPerimetro.setOnClickListener {
            val base = edtBase.text.toString().toFloat()
            val altura = edtAltura.text.toString().toFloat()
            presentador.calculaPerimetro(base, altura)
        }
    }

    override fun muestraArea(area: Float) {
        txtArea.text = txtArea.text.toString() + area.toString() + " m2"
    }

    override fun muestraPerimetro(perimetro: Float) {
        txtPerimetro.text = txtPerimetro.text.toString() + perimetro.toString() + " m"
    }

    override fun muestraError(mensaje: String) {
        txtArea.text = mensaje
        txtPerimetro.text = mensaje
    }
}