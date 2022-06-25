package com.example.homework_4_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework_4_design.databinding.ActivitySignUp2Binding

class SignUp2Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fullName = intent.extras?.getString("FullName", "Your Name")
        binding.tvFullName.text = "$fullName"

        back()
        next()
    }

    private fun back(){
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun next(){
        binding.btnNext.setOnClickListener {
            val pass1 = binding.edPassword.text.toString()
            val pass2 = binding.edRepeatPassword.text.toString()

            if (pass1.isNotEmpty() && pass2.isNotEmpty()){
                if (pass1 == pass2){
                    Toast.makeText(this, "ვსო :D", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "პაროლი არ ემთხვევა ერთმანეთს", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "შეიყვანეთ პაროლი", Toast.LENGTH_SHORT).show()
            }
        }
    }

}