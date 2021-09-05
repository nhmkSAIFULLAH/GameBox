package com.domesoft.gamebox

import kotlin.random.Random

fun randomizeQuiz(quizList: List<Quiz>){

    val randomizeList = mutableListOf<Quiz>()





}

fun getRandom(){
    val random = Random.nextInt(1,4)
    println(random)
    println( addCorrectOption(random) )
}

fun addCorrectOption(option1: Int): MutableList<Int>{
    val options = mutableListOf<Int>()
    when(option1){
        1 -> {
            options.add(0,1)
            val option2 = add2ndOptions(1)
            options.add(1, option2)
            val option3 = add3rdOption(option1, option2)
            options.add(2,option3)
            val option4 = add4thOption(option1,option2,option3)
            options.add(3,option4)

        }
        2 -> {
            options.add(0,2)
            val option2 = add2ndOptions(2)
            options.add(1, option2)
            val option3 = add3rdOption(option1, option2)
            options.add(2,option3)
            val option4 = add4thOption(option1,option2,option3)
            options.add(3,option4)
        }
        3 -> {
            options.add(0,3)
            val option2 = add2ndOptions(3)
            options.add(1, option2)
            val option3 = add3rdOption(option1, option2)
            options.add(2,option3)
            val option4 = add4thOption(option1,option2,option3)
            options.add(3,option4)
        }
        4 -> {
            options.add(0,4)
            val option2 = add2ndOptions(4)
            options.add(1, option2)
            val option3 = add3rdOption(option1, option2)
            options.add(2,option3)
            val option4 = add4thOption(option1,option2,option3)
            options.add(3,option4)
        }
    }
    return options
}

fun add2ndOptions(correctOption: Int): Int {
    val option2 =  when(correctOption){
        1 -> {
            Random.nextInt(2, 4)
        }
        2 -> {
            Random.nextInt(3, 4)
        }
        3 -> {
            Random.nextInt(1, 2)
        }
        4 -> {
            Random.nextInt(1, 3)
        }
        else -> 0
    }
    return option2
}

fun add3rdOption(option1: Int, option2: Int): Int{
    val option3 = when(option1){
        1-> {
            when (option2){
                2->{
                    Random.nextInt(3,4)
                }
                3->{
                    4
                }
                4->{
                    Random.nextInt(2,3)
                }
                else-> 0
            }
        }
        2-> {
            when (option2){
                1->{
                    Random.nextInt(3,4)
                }
                3->{
                    1
                }
                4->{
                    3
                }
                else-> 0
            }
        }
        3-> {
            when (option2){
                1->{
                    2
                }
                2->{
                    4
                }
                4->{
                    Random.nextInt(1,2)
                }
                else-> 0
            }
        }
        4-> {
            when (option2){
                1->{
                    Random.nextInt(2,3)
                }
                2->{
                    1
                }
                3->{
                    Random.nextInt(1,2)
                }
                else-> 0
            }
        }
        else-> 0
    }
    return option3
}

fun add4thOption(option1: Int, option2: Int, option3: Int): Int{
    val option4 = when(option1){
        1->{
            when(option2){
                2->{
                    when(option3){
                        3->{
                            4
                        }
                        4->{
                            3
                        }
                        else-> 0
                    }
                }
                3->{
                    when(option3){
                        2->{
                            4
                        }
                        4->{
                            2
                        }
                        else-> 0
                    }
                }
                4->{
                    when(option3){
                        2->{
                            3
                        }
                        3->{
                            2
                        }
                        else-> 0
                    }
                }
                else-> 0
            }

        }
        2->{
            when(option2){
                1->{
                    when(option3){
                        3->{
                            4
                        }
                        4->{
                            3
                        }
                        else-> 0
                    }
                }
                3->{
                    when(option3){
                        1->{
                            4
                        }
                        4->{
                            1
                        }
                        else-> 0
                    }
                }
                4->{
                    when(option3){
                        1->{
                            3
                        }
                        3->{
                            1
                        }
                        else-> 0
                    }
                }
                else-> 0
            }
        }
        3->{
            when(option2){
                1->{
                    when(option3){
                        2->{
                            4
                        }
                        4->{
                            2
                        }
                        else-> 0
                    }
                }
                2->{
                    when(option3){
                        1->{
                            4
                        }
                        4->{
                            1
                        }
                        else-> 0
                    }
                }
                4->{
                    when(option3){
                        1->{
                            2
                        }
                        2->{
                            1
                        }
                        else-> 0
                    }
                }
                else-> 0
            }
        }
        4->{
            when(option2){
                1->{
                    when(option3){
                        2->{
                            3
                        }
                        3->{
                            2
                        }
                        else-> 0
                    }
                }
                2->{
                    when(option3){
                        1->{
                            3
                        }
                        3->{
                            1
                        }
                        else-> 0
                    }
                }
                3->{
                    when(option3){
                        1->{
                            2
                        }
                        2->{
                            1
                        }
                        else-> 0
                    }
                }
                else-> 0
            }
        }
        else-> 0

    }
    return option4
}


fun main(){
    getRandom()
//    val list = mutableListOf<Int>()
//    list.add(2,10)
//    list.add(1,20)
//    list.add(0,30)
//    println(list)

}