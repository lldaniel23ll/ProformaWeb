package com.example.proformaweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val spinnerweb = arrayOf("Tipo de pagina web", "Página dinámica", "Página estática")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.idbtnnext)
        btn.setOnClickListener{
            saveData()
        }
        val spinner = findViewById<Spinner>(R.id.spinner)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerweb)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //Toast.makeText(applicationContext, "Escogio: "+spinnerweb[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
    private fun saveData() {
        val name = findViewById<EditText>(R.id.editTextText).text.toString()
        val email = findViewById<EditText>(R.id.editTextText1).text.toString()
        val phone = findViewById<EditText>(R.id.editTextText2).text.toString()
        val businessName = findViewById<EditText>(R.id.editTextText3).text.toString()

        val spinner = findViewById<Spinner>(R.id.spinner)
        val selectedItem = spinner.selectedItem.toString()

        val editTextProjectObjectives = findViewById<EditText>(R.id.editTextText5)
        val projectObjectives = editTextProjectObjectives.text.toString()

        val estimatedBudget = findViewById<EditText>(R.id.editTextText4).text.toString()
        val projectFunctionalities = findViewById<EditText>(R.id.editTextText6).text.toString()

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || businessName.isEmpty() || projectObjectives.isEmpty()) {
            Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(this, SecondActivity::class.java)

        intent.putExtra("name", name)
        intent.putExtra("email", email)
        intent.putExtra("phone", phone)
        intent.putExtra("businessName", businessName)
        intent.putExtra("selectedItem", selectedItem)
        intent.putExtra("projectObjectives", projectObjectives)
        intent.putExtra("estimatedBudget", estimatedBudget)
        intent.putExtra("projectFunctionalities", projectFunctionalities)

        startActivity(intent)
    }


}