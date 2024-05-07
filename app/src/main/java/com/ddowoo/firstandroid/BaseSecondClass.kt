package com.ddowoo.firstandroid

open class BaseSecondClass:BaseClass() {


    //
    override fun role(){
        // super을 이용해 상속받은 BaseClass의 role을 실행시킬 수 있음
        super.role()
        println("Base Seconds Class의 rolw 함수");
    }



}