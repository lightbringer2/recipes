package com.example.recipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipes.databinding.ActivityRecipeAddBinding
import com.example.recipes.RecipesDatabaseHelper
class RecipeAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeAddBinding
    private lateinit var db: RecipesDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_add)

        db = RecipesDatabaseHelper(this)

        binding.btnAdd.setOnClickListener {
            val title = binding.title.text.toString()
            val content = binding.content.text.toString()
            val recipe = Recipe(0, title, content)
            db.insertRecipe(recipe)
            finish()
            Toast.makeText(this, "Recept uložen", Toast.LENGTH_SHORT).show()

        }

    }
}