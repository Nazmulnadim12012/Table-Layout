package com.example.tabellayout2

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {

    lateinit var primaryTextView: TextView
    lateinit var editTextView: TextView
    lateinit var btn_1:Button
    lateinit var btn_2:Button
    lateinit var btn_3:Button
    lateinit var btn_4:Button
    lateinit var btn_5:Button
    lateinit var btn_6:Button
    lateinit var btn_7:Button
    lateinit var btn_8:Button
    lateinit var btn_9:Button
    lateinit var btn_0:Button
    lateinit var btn_back:Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        primaryTextView = findViewById(R.id.primaryTextView)
        editTextView = findViewById(R.id.editTextId)
        btn_1 = findViewById(R.id.btn_1)
        btn_2 = findViewById(R.id.btn_2)
        btn_3 = findViewById(R.id.btn_3)
        btn_4 = findViewById(R.id.btn_4)
        btn_5 = findViewById(R.id.btn_5)
        btn_6 = findViewById(R.id.btn_6)
        btn_7 = findViewById(R.id.btn_7)
        btn_8 = findViewById(R.id.btn_8)
        btn_9 = findViewById(R.id.btn_9)
        btn_0 = findViewById(R.id.btn_0)
        btn_back = findViewById(R.id.btn_back)

        val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        var clipData:ClipData


        btn_1.setOnClickListener {
            primaryTextView.text = primaryTextView.text.toString() +"1"
        }

        btn_2.setOnClickListener {
            primaryTextView.text = primaryTextView.text.toString() + "2"
        }

        btn_3.setOnClickListener {
            primaryTextView.text = primaryTextView.text.toString() + "3"
        }

        btn_4.setOnClickListener {
            primaryTextView.text = primaryTextView.text.toString() + "4"
        }

        btn_5.setOnClickListener {
            primaryTextView.text = primaryTextView.text.toString() + "5"
        }

        btn_6.setOnClickListener {
            primaryTextView.text = primaryTextView.text.toString() + "6"
        }
        btn_7.setOnClickListener {
            primaryTextView.text = primaryTextView.text.toString() + "7"
        }
        btn_8.setOnClickListener {
            primaryTextView.text = primaryTextView.text.toString() + "8"
        }
        btn_9.setOnClickListener {
            primaryTextView.text = primaryTextView.text.toString() +"9"
        }

        btn_0.setOnClickListener {
            primaryTextView.text = primaryTextView.text.toString() +"0"
        }

        btn_back.setOnClickListener {
            val currentText = primaryTextView.text.toString()
            if (currentText.isNotEmpty()){
                primaryTextView.text = currentText.substring(0,currentText.length-1)
            }
        }

        primaryTextView.setOnLongClickListener {

            val textCopy = primaryTextView.text.toString()
            clipData = ClipData.newPlainText("text",textCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this@Activity2,"Copied!",Toast.LENGTH_SHORT).show()
            true
        }

        editTextView.setOnLongClickListener {

            val pasteData = clipboardManager.primaryClip
            val item =pasteData!!.getItemAt(0)
            val txtPaste = item.text.toString()
            editTextView.text = txtPaste
            true

        }

    }
}



