package com.example.java_and_kotlin_g11

class person {
    private var name: String
    private var age: Int



    constructor(strname: String, newage: Int){
        this.name = strname;
        this.age = newage;
    }



    fun getinfo(): String {
        return "${name} ${age}"
    }

    fun getName (): String{
        return name
    }


}

