package com.wenner.github.server

import com.google.gson.Gson
import com.wenner.github.bean.UserInfo
import com.wenner.github.bean.Word
import java.net.URL

object Server {
    val BASE_URL = "http://39.105.58.247:8899/"
    val TAG = "obj Server"
    fun login(user: String, pass: String) = Gson().fromJson(
        URL(BASE_URL + "login?username=${user}&password=${pass}").readText(),
        UserInfo::class.java
    )
    fun query(word: String) = Gson().fromJson(
        URL(BASE_URL + "query?val=${word}").readText(),
        Word::class.java
    )
    fun register(username: String, password: String) =
        URL(BASE_URL + "register?username=${username}&password=${password}").readText()
}
