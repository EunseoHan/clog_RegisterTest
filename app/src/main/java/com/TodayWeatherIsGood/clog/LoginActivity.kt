package com.TodayWeatherIsGood.clog

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.TodayWeatherIsGood.clog.databinding.ActivityLoginBinding
import com.TodayWeatherIsGood.clog.databinding.ActivityRegisterBinding
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class LoginActivity : AppCompatActivity() {
    /*private var my_person_id: EditText? = null
    private var person_password: EditText? = null
    private var login_button: Button? = null*/
    //private var btn_register: Button? = null

    val binding by lazy { ActivityLoginBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_login)
        my_person_id = findViewById<EditText>(R.id.my_person_id)
        person_password = findViewById<EditText>(R.id.person_password)
        login_button = findViewById<Button>(R.id.login_button)*/
        //btn_register = findViewById<Button>(R.id.btn_register)

        setContentView(binding.root)
        //val userNAME = binding.myPersonId.text.toString()

        // 회원가입 버튼을 클릭 시 수행
        /*btn_register.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        })*/
        binding.buttonLogin.setOnClickListener(View.OnClickListener { // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
            val userID=binding.idre.text.toString()
            val userPASSWORD=binding.passwordre.text.toString()
            val responseListener =
                Response.Listener<String> { response ->
                    try {
                        // TODO : 인코딩 문제때문에 한글 DB인 경우 로그인 불가
                        println("hongchul$response")
                        val jsonObject = JSONObject(response)
                        val success = jsonObject.getBoolean("success")
                        if (success) { // 로그인에 성공한 경우
                            val userNAME = jsonObject.getString("userNAME")
                            val userID = jsonObject.getString("userID")
                            val userEMAIL = jsonObject.getString("userEMAIL")
                            val userPASSWORD = jsonObject.getString("userPASSWORD")
                            val userRED = jsonObject.getInt("userRED")
                            val userBLUE = jsonObject.getInt("userBLUE")
                            val userBROWN = jsonObject.getInt("userBROWN")
                            val userPURPLE = jsonObject.getInt("userPURPLE")
                            val userYELLOW = jsonObject.getInt("userYELLOW")
                            val userCHARACTER = jsonObject.getInt("userCHARACTER")
                            Toast.makeText(applicationContext, userNAME+"님 로그인에 성공하였습니다.", Toast.LENGTH_SHORT)
                            //Toast.makeText(this@LoginActivity, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                            //로그인하면서 사용자 정보 넘기기
                            intent.putExtra("userNAME", userNAME)
                            intent.putExtra("userID", userID)
                            intent.putExtra("userEMAIL", userEMAIL)
                            intent.putExtra("userPASSWORD", userPASSWORD)
                            intent.putExtra("userRED", userRED)
                            intent.putExtra("userBLUE", userBLUE)
                            intent.putExtra("userBROWN", userBROWN)
                            intent.putExtra("userPURPLE", userPURPLE)
                            intent.putExtra("userYELLOW", userYELLOW)
                            intent.putExtra("userCHARACTER", userCHARACTER)
                            startActivity(intent)
                        } else { // 로그인에 실패한 경우
                            Toast.makeText(applicationContext, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT)
                            //Toast.makeText(this@LoginActivity, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT)
                                .show()
                            return@Listener
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            val loginRequest = LoginRequest(userID, userPASSWORD, responseListener)
            val queue = Volley.newRequestQueue(this@LoginActivity)
            //queue.add<Any>(loginRequest)
            queue.add(loginRequest)
        })
    }
}




