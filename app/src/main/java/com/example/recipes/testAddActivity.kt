package com.example.recipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class testAddActivity : AppCompatActivity() {


    private lateinit var db: RecipesDatabaseHelper
    private lateinit var btnAdd: Button
    private lateinit var title: EditText
    private lateinit var content: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_add)

        db = RecipesDatabaseHelper(this)
        btnAdd=findViewById(R.id.btnAdd)
        title=findViewById(R.id.title)
        content=findViewById(R.id.content)

        this.btnAdd.setOnClickListener {

            val recipe = Recipe(0, title.toString(), content.toString())
            db.insertRecipe(recipe)
            finish()
            Toast.makeText(this, "Recept uložen", Toast.LENGTH_SHORT).show()
           }


    }
}