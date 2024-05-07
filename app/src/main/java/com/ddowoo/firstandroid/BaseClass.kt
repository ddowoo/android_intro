package com.ddowoo.firstandroid

// open => 상속 가능
open class BaseClass {

    // open => 오버라이딩 가능
    open fun role(){
        println("BaseClass 의 role 함수")
    }

    fun coreValues(){
        println("BaseClass 의 coreValues 함수")
    }

}