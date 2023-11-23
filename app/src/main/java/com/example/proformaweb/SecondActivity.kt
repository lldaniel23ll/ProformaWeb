package com.example.proformaweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import java.util.Calendar

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val businessName = intent.getStringExtra("businessName")
        var selectedItem = intent.getStringExtra("selectedItem")
        val estimatedBudget = intent.getStringExtra("estimatedBudget")
        val projectObjectives = intent.getStringExtra("projectObjectives")
        val projectFunctionalities = intent.getStringExtra("projectFunctionalities")

        findViewById<TextView>(R.id.textViewName).text = name
        findViewById<TextView>(R.id.textViewEmail).text = email
        findViewById<TextView>(R.id.textViewPhone).text = phone
        findViewById<TextView>(R.id.textViewBusinessName).text = businessName
        findViewById<TextView>(R.id.textViewSelectedItem).text = selectedItem
        findViewById<TextView>(R.id.textViewEstimatedBudget).text = estimatedBudget
        findViewById<TextView>(R.id.textViewProjectObjectives).text = projectObjectives
        findViewById<TextView>(R.id.textViewProjectFunctionalities).text = projectFunctionalities

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dateString = "$day/$month/$year"
        findViewById<TextView>(R.id.editTextDate).setText(dateString)

        val textViewText = findViewById<TextView>(R.id.textViewText)

        selectedItem = intent.getStringExtra("selectedItem")

        when (selectedItem) {
            "Página dinámica" -> {
                textViewText.text = "La página web dinámica puede llevar un tiempo de 6 a 12 semanas o más, dependiendo de la complejidad.\n" +
                        "Este plazo es aproximado y nuestro equipo lo estara contactando a más tardar en 3 dias aviles para que los desarrolladores evaluen cuanto tiempo se llevaran en crear el proyecto."
            }
            "Página estática" -> {
                textViewText.text = "Para una página web estática relativamente, el tiempo de elaboración podría ser de aproximadamente 2 a 4 semanas.\n" +
                        "Este plazo es aproximado y nuestro equipo lo estara contactando a más tardar en 3 dias aviles para que los desarrolladores evaluen cuanto tiempo se llevaran en crear el proyecto."
            }
            else -> {
                textViewText.text = "No se ha seleccionado ninguna opción, porfavor regrese para darle el tiempo estimado que llevara el proyecto"
            }
        }

    }
}