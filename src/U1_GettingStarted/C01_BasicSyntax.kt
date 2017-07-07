package U1_GettingStarted

/**
基本语法
 */
fun main(args: Array<String>) {
    // 定义方法
    defineFunctions()

    // 定义变量
    defineVariable()

    // 关于注释
    /*
     /*
        不同与Java，Kotlin中的块注释是可以嵌套的
      */
    */

    // 关于字符串模板
    usingStringTemplates()

    // 关于条件表达式
    usingConditionalExpressions()

    // 使用可空值，并做null检查
    usingNullableValues()

    // 使用类型检查、自动类型转换
    usingTypeChecksNAutomaticCasts()

    // 使用for循环、while循环
    usingLoop()

    // 使用条件分支语句
    usingWhen()

    // 使用范围 ！！！
    usingRanges()

    // 使用集合
    usingCollections()
}

/**
使用集合
 */
fun usingCollections() {
    // List的普通用法
    val items1 = listOf("apple", "banana", "kiwi")
    for (item in items1) {
        println(item)
    }
    println()

    // Set的普通用法 --> 判断集合中是否包含某对象
    val items2 = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items2 -> println("juicy")
        "apple" in items2 -> println("apple is fine too")
    }
    println("-----------")

    // 使用 lambda 表达式来过滤（filter）和映射（map）集合
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

/**
定义方法
 */
private fun defineFunctions() {
    /*
    @return 返回 Int 类型的值
     */
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /*
    省略方法体
     */
    fun sum1(a: Int, b: Int) = a + b

    /*
    方法返回没有意义的值
    Unit 相当于Java中的void --> 可以省略
     */
    fun printSum(a: Int, b: Int): Unit {
        println("$a + $b == ${a + b}")
    }

    // 定义方法
    println("Hello World")
    println("a + b == " + sum(15, 30))
    println("a + b == ${sum1(20, 50)}")
    printSum(30, 450)
}

/**
定义变量
 */
fun defineVariable() {
    // Assign-once (read-only) local variable
    // 只读变量 --> 相当于final变量
    val a: Int = 1 // immediate assignment 立即赋值
    val b = 2 // type inferred 类型推断
    val c: Int // 当没有赋初值时，需要显式给出类型
    c = 3 // deferred assignment 延迟赋值
    println("a == $a, b == $b, c == $c")

    // mutable variable
    // 可多次赋值的变量
    var x = 5 // type inferred 类型推断
    x += 1
    println("x == $x")
}

/**
关于类型检查和自动类型转换
is 关键字，相当于Java中的 instantof
如果一个本地常量/成员变量已经通过is判定为某一类型（SomeType），则可直接当此类型（SomeType）的对象来用
--> 而非像Java一样需要先强制类型转换，再使用
 */
fun usingTypeChecksNAutomaticCasts() {
    fun getStringLength(obj: Any?): Int? {
        if (obj is String && obj.length > 0) {
            return obj.length
        }
        return null
    }

    fun printStringLength(obj: Any?) {
        // 有趣的用法，直接在字符串里做逻辑判断
        // 如果getStringLength(obj)的返回值是null,则不输出该null，而是输出"?:"后的内容
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, is empty or not a string at all"} ")
    }

    printStringLength("1111")
    printStringLength("")
    printStringLength(100)
    printStringLength(null)
}

/**
关于字符串模板
 */
fun usingStringTemplates() {
    var a = 1
    val s1 = "a is $a" // 常量

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a" // 常量
    println(s2)
}

/**
关于条件表达式
 */
fun usingConditionalExpressions() {

    // 简单写法
    fun maxOf1(a: Int, b: Int) = if (a > b) a else b

    // 完整写法
    fun maxOf2(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    println("max of 0 and 42 is ${maxOf1(0, 42)}")
    println("max of 0 and 42 is ${maxOf2(0, 42)}")
}

/**
如果一个变量可能为空，那么在声明的时候就要用？标识出来
 */
fun usingNullableValues() {
    fun parseInt(arg: String): Int? { // 主要是这个返回值可能为空，要在声明时用？标识出来
        return arg.toIntOrNull()
    }

    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)
        if (x != null && y != null) {
            println("x * y == ${x * y}")
        } else {
            println("either x or y is not a number")
        }
    }

    printProduct("7", "8") // 乘法
    printProduct("7", "b")

}


/**
使用for循环、while循环
 */
fun usingLoop() {
    val items = listOf("apple", "banana", "kiwi")

    // Kotlin中的for循环只有迭代器样式的，没有传统样式的
    for (index in items.indices) {
        println("item at ${index} is ${items[index]}")
    }

    // 想使用传统样式的for循环的功能，只能用while循环来模拟
    var index = 0
    while (index < items.size) {
        println("item at ${index} is ${items[index]}")
        index++
    }
}

/**
使用条件分支语句
 */
fun usingWhen() {

    fun describe(obj: Any): String =
            when (obj) {
                1 -> "One"
                "Hello" -> ("Greeting")
                is Long -> {
                    "Long"
                }
                !is String -> "Not a String"
                else -> "Unkonwn"
            }
    // Test
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
}

/**
使用范围 ！！！
 */
fun usingRanges() {
    // 基本用法
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }

    // Range在list中的常用用法
    val list = listOf("a", "b", "c")
    if (-1 in 0..list.lastIndex) { // 判断某数在某区间
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too") // 判断某数在某数的集合中，indices就是list的脚标的集合
    }

    // Range在Iter中的用法, 相当于普通的fori循环
    for (i in 0..5) {
        print(i)
    }
    println()
    (0..5).forEach { j -> print(j) } // Kotlin编辑器的推荐写法
    println()

    // 数列迭代
    // step 是步进
    // 如果这里的变量名用x，就与上文件中的变量x重名，会报一个name shadowed：x的告警，改为不重复的字母即可
    for (m in 1..10 step 2) {
        print(m) // 13579
    }
    println()
    for (n in 9 downTo 0 step 3) {
        print(n) // 9630
    }
    println()
}


