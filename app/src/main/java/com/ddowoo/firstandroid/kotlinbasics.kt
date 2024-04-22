package com.ddowoo.firstandroid

fun main(){
    println("Hello World!")

    // val은 재할당 불가능
    val number = 1
    // number = 2 불가

    // 재할당 가능
    var number2 = 2
    number2 = 22

    println(number2
    )

    // 기본으로 숫자는 Int로 추정 , 길어지면 Long로 추정
    // 코틀린은 타입을 지정하지만 선언시 직접 지정할수도 있음
    var longNumber : Long = 3123123123123123123;
    // 나중에 숫자가 길어질 수 있으면 Long으로 설정

    // Float suffix f
    val nFloat = 2.1231232f
}