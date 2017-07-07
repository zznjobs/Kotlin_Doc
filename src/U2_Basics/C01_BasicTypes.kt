package U2_Basics

/**
 * 基本类型
 */
fun main(args: Array<String>) {
    // 测试位运算符
    testOperation()

    // 测试 Array
    testArray()

    // 测试String
    testString()
}

/**
测试位运算符
xor --> 异或（普通或再取反）
 */
fun testOperation() {
    val x = (1 shl 2) or 0x0F23F
    val y = 2.inv()
    println("x = $x") // x = 62015
    println("y = $y") // y = -3
}

/**
测试 Array
 */
fun testArray() {
    // 创建一个Array
    val arr = arrayOf(1, 2, 3)
    (0..arr.size - 1).forEach { i -> print("${arr[i]} ") }
    println()
    // 创建一个指定长度，元素为null的Array
    val arrNulls = arrayOfNulls<Int>(5)
    (0..arrNulls.size - 1).forEach { j -> print("${arrNulls[j]} ") }
    println()

    // 创建一个Array<String>，内容为["0","1","4","9","16"]
    val arrString = Array(5, { i -> (i * i).toString() })
    (0..arrString.size - 1).forEach { j -> print("${arrString[j]}\t") }
    println()
}

/**
测试String
 */
fun testString() {
    val str = "Hello Kotlin"
    // 普通遍历
    for (c in str) {
        println(c)
    }
    // 文艺遍历 哈哈哈
    (0..str.length - 1).forEach { c -> print("${str[c]}  ") }

    // 新功能：原始字符串，类似Markdown中的段引用
    // 不加前导字符'|'，带前面的一大堆空格原样输出
    val rawString1 =
            """
            public static void main(String[] args){
                println("Hello World");
            }
        """
    println("\nrawString = \n$rawString1")

    // 行前加"|"可消除打印时前面的空白区域
    val text = """
        |Tell me and I forget.
        |Teach me and I remember.
        |Involve me and I learn.
        |(Benjamin Franklin)
        """.trimMargin()
    println(text)

    // 在RawString中表示$符号
    val price = """
${'$'}9.99
$99.99
                """
    println(price)
}

