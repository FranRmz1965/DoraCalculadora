package mx.uacj.doralacalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var operacion: Int = 0
    var numero1: Double = 0.0
    lateinit var C_num1: TextView
    lateinit var C_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        C_num1 = findViewById(R.id.C_num1)
        C_num2 = findViewById(R.id.C_num2)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        val btnIgual: Button = findViewById(R.id.btnIgual)

        btnIgual.setOnClickListener{
            var  numero2: Double = C_num2.text.toString().toDouble()
            var resp: Double = 0.0

            when(operacion){
                1-> resp = numero1 + numero2
                2-> resp = numero1 - numero2
                3-> resp = numero1 * numero2
                4-> resp = numero1 / numero2
            }

            C_num2.setText(resp.toString())
            C_num1.setText("")
        }
        btnBorrar.setOnClickListener{
            C_num1.setText("")
            C_num2.setText("")
            numero1 = 0.0
            operacion = 0
        }

    }
    fun presionarDigito(view: View){
        val C_num2:  TextView = findViewById(R.id.C_num2)
        val num2: String = C_num2.text.toString()

        when(view.id){
            R.id.btn0 -> C_num2.setText(num2 + "0")
            R.id.btn1 -> C_num2.setText(num2 + "1")
            R.id.btn2 -> C_num2.setText(num2 + "2")
            R.id.btn3 -> C_num2.setText(num2 + "3")
            R.id.btn4 -> C_num2.setText(num2 + "4")
            R.id.btn5 -> C_num2.setText(num2 + "5")
            R.id.btn6 -> C_num2.setText(num2 + "6")
            R.id.btn7 -> C_num2.setText(num2 + "7")
            R.id.btn8 -> C_num2.setText(num2 + "8")
            R.id.btn9 -> C_num2.setText(num2 + "9")
            R.id.btnPunto -> C_num2.setText(num2 + ".")
        }
    }
    fun clicOperacion(view: View){
        numero1 = C_num2.text.toString().toDouble()
        var num2_text:String = C_num2.text.toString()
        C_num2.setText("")
        when(view.id){
            R.id.btnSuma ->{
                C_num1.setText(num2_text + "+")
                operacion = 1
            }
            R.id.btnResta ->{
                C_num1.setText(num2_text + "-")
                operacion = 2
            }
            R.id.btnMulti ->{
                C_num1.setText(num2_text + "*")
                operacion = 3
            }
            R.id.btnDiv ->{
                C_num1.setText(num2_text + "/")
                operacion = 4
            }


        }
    }
}