package U2_Basics

fun main(args: Array<String>) {
    // If 表达式
    testIfExpression()

    // For 表达式
    testForExpression()
}

/**
For 表达式
 */
fun testForExpression() {
    // 以下是BasicTypes一节中的一段遍历Array的代码，但是最值实践不是这样的
    // 创建一个Array
//    val arr = arrayOf(1, 2, 3)
//    (0..arr.size - 1).forEach { i -> print("${arr[i]} ") }
//    println()
//    // 创建一个指定长度，元素为null的Array
//    val arrNulls = arrayOfNulls<Int>(5)
//    (0..arrNulls.size - 1).forEach { j -> print("${arrNulls[j]} ") }
//    println()
//
//    // 创建一个Array<String>，内容为["0","1","4","9","16"]
    val arrString = Array(5, { i -> (i * i).toString() })
//    (0..arrString.size - 1).forEach { j -> print("${arrString[j]}\t") }
//    println()

    // 最佳实践 使用Array.indices
    for (i in arrString.indices) {
        print("${arrString[i]}\t")
    }
    println()

    // 最佳实践2
    for ((index, value) in arrString.withIndex()) {
        println("the elment at $index is $value")
    }
    // 最佳实践3
    arrString.withIndex().forEach {
        (index, value) -> println("the elment at $index is $value")
    }
}

/**
If 表达式
 */
fun testIfExpression() {
    // Kotlin中没有三元运算符
    // 但是If表达式可以起到类似的作用
    val a = 3
    val b = 2
    val max = if (a > b) a else b
    println("max == $max")

    // 扩展上述If表达式
    val max2 = if (a > b) {
        println("Choose a")
        a // 返回a，a要放在最后
    } else {
        println("Choose b")
        b
    }
    println("max2 == $max2")

    // 如果将If用于If表达式，则必须有else分支！！！
}
