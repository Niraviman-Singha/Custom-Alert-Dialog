package com.example.customalertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.customalertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.setname.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Set Your Name")

            val customLayout:View = layoutInflater.inflate(R.layout.custom_layout, null)
            builder.setView(customLayout)

            builder.setPositiveButton("OK"){dialog:DialogInterface, which:Int ->

                val name = customLayout.findViewById<EditText>(R.id.nameET)
                Toast.makeText(this, "Your name is "+name.text.toString(), Toast.LENGTH_SHORT).show()
            }
            val dialog = builder.create()
            dialog.setCancelable(false)
            dialog.show()
        }
    }
}