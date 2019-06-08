package com.wenner.github.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myapplication.R
import com.wenner.github.server.Server
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnreg.setOnClickListener {
            if ("".equals(editusername.text.toString()) || "".equals(editpass.text.toString()) || "".equals(editemail.text.toString())) {
                toast("Useranem or Password is empty!")
            }
            else if (!editpass.text.toString().equals(editcpass.text.toString())){
                toast("Inconsistent passwords！")
            }
            else {
                doAsync {
                    val result = Server.register(editusername.text.toString(), editpass.text.toString())
                    uiThread{
                        when (result){
                            "0" -> {
                                toast("User name has been registered")
                            }
                            "1" -> {
                                toast("Register successful!")
                                finish()
                            }
                        }
                    }
                }
            }
        }
    }
}