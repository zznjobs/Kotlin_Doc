package U2_Basics

/**
 * 返回和跳转
 */
fun main(args: Array<String>) {
    // 测试 Label用于break/continue
    testLabel()

    // 测试Label应用于Lambda表达式
    testLabelInLambda()
}

/**
测试 Label用于break/continue
 */
fun testLabel() {
    /* 输出结果：
       i == j == 0
       即直接把指向的循环干掉了。。
    */
    loop1@ for (i in 0..10) {
        for (j in 0..10) {
            if (i == j) {
                println("i == j == $i")
                break@loop1
            }
        }
    }

    /* 输出结果
        i===========j == 0
        i===========j == 1
        i===========j == 2
        i===========j == 3
        即本次循环不再进行，直接进行下一次循环了
     */
    loop2@ for (i in 0..3) {
        for (j in 0..3) {
            if (i == j) {
                println("i===========j == $i")
                continue@loop2
            }
        }
    }

}

/**
测试Label应用于Lambda表达式
 */
fun testLabelInLambda() {
    val ints = listOf(1, 2, 3, 4)

    /* 输出结果
     啥也没输出
     */
    fun foo() {
        ints.forEach {
            if (it == 1)
                return // 直接把foo()干掉了！！！
            println(it)
        }
    }
    foo()

    /* 输出结果
       2
       3
       4
     */
    fun foo1() {
        ints.forEach lit@ {
            if (it == 1)
                return@lit // 当it=1时直接返回，但是it为其它值时仍能执行到
            println(it)
        }
    }
    foo1()

    /* 输出结果（与foo1()相同）
       2
       3
       4
     */
    fun foo2() {
        ints.forEach {
            if (it == 1)
                return@forEach // 同foo1()，Label是Lambda表达式forEach隐含的
            println(it)
        }
    }
    foo2()
}


