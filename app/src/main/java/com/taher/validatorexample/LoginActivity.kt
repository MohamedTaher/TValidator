package com.taher.validatorexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taher.validator.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val name = "Mohamed Taher"
        val (isValid, _) = name.isValidParam(AppValidator.Type.UserName)
    }
}