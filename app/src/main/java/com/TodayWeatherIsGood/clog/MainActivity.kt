package com.TodayWeatherIsGood.clog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.TodayWeatherIsGood.clog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonSignUp.setOnClickListener {
            val name = binding.namere.text.toString()
            val id = binding.idre.text.toString()
            val email = binding.emailre.text.toString()
            val password = binding.passwordre.text.toString()
            val passwordCheck = binding.passwordCheckre.text.toString()
            val phone = binding.phonere.text.toString()
            if(name=="") {
                Toast.makeText(
                    this@MainActivity,
                    "이름을 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            }else if(id==""){
                Toast.makeText(
                    this@MainActivity,
                    "아이디를 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            }else if(email==""){
                Toast.makeText(
                    this@MainActivity,
                    "이메일을 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            }else if(password==""){
                Toast.makeText(
                    this@MainActivity,
                    "비밀번호를 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            }else if(passwordCheck==""){
                Toast.makeText(
                    this@MainActivity,
                    "비밀번호를 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            }else if(password != passwordCheck){
                Toast.makeText(
                    this@MainActivity,
                    "비밀번호가 다릅니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    this@MainActivity,
                    "가입이 완료되었습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
