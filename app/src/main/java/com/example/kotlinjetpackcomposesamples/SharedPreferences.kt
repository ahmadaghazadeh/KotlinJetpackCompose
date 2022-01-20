package com.example.kotlinjetpackcomposesamples

import android.content.SharedPreferences

inline fun SharedPreferences.edit(
    commit:Boolean=false,
    noinline action1:Int.()->Unit={},
    action:SharedPreferences.Editor.()->Unit
){
    myFunction(action1)
    val  editor=edit()
    action(editor)
    if (commit){
        editor.commit()
    }else{
        editor.apply()
    }
}

fun myFunction( action1:Int.()->Unit){
    action1(-1)
}

val add:(Int,Int)->Int= {a,b-> a+b}


fun sum(a:Int,b:Int):Int{
    return a+b
}


private  const val KEY_TOKEN="token"

class PreferencesManager(private  val preferences: SharedPreferences){
    fun saveToken(token:String){
        preferences.edit(){
            putString(KEY_TOKEN,token)
        }
    }
}