package com.ddowoo.firstandroid

class Gamer: BaseSecondClass(), Archery, Singer {

    override fun shoot() {
//        super.shoot()
        println("게이머의 슛")
    }

    override fun sing(){
        super.sing()
        println("게이머의 sing")
    }


}