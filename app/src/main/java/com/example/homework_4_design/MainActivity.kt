package com.example.homework_4_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework_4_design.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        next()
        back()
    }
    private fun next(){
        binding.btnNext.setOnClickListener {

            val fullName = binding.edFullName.text.toString()
            val username = binding.edUsername.text.toString()
            if (fullName.isNotEmpty() && username.isNotEmpty()){
                if (username.length < 10){
                    Toast.makeText(this, "username-ში სიმბოლოების რაოდენობა არ უნდა იყოს 10-ზე ნაკლები!", Toast.LENGTH_SHORT).show()
                }else{
                    startActivity()
                }
            }else{
                Toast.makeText(this, "გთხოვთ შეავსოთ ველი!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun back(){
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun startActivity(){
        val fullName = binding.edFullName.text.toString()
        val intent = Intent(this, SignUp2Activity::class.java)
        intent.putExtra("FullName", fullName)
        startActivity(intent)
        finish()
    }
    
}