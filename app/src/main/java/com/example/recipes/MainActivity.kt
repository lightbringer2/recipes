package com.example.recipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnClose: Button
    private lateinit var btnList: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnImport: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnClose = findViewById(R.id.btnClose)
        btnList = findViewById(R.id.btnList)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnImport = findViewById(R.id.btnImport)


        btnClose.setOnClickListener {
            finishAffinity()
        }

        btnList.setOnClickListener {
            val intent= Intent(this@MainActivity, RecipeListActivity::class.java)
            startActivity(intent)
        }

        btnUpdate.setOnClickListener {
            val intent= Intent(this@MainActivity, ModifyListActivity::class.java)
            startActivity(intent)
        }

        btnImport.setOnClickListener {
            val intent= Intent(this@MainActivity, ImportListActivity::class.java)
            startActivity(intent)
        }
    }
}