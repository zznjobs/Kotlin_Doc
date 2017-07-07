package U1_GettingStarted

import java.io.File

/**
习惯用法
 * Created by zz on 7/5/2017.
 */
fun main(args: Array<String>) {
    // 创建数据类，相当于Bean
    creatingBean()

    // 函数的默认参数
    setFuncDefaultValue()

    // 过滤一个List
    filterList()

    // 插入String
    interpolationString()

    // 实例检查
    checkInstance()

    // 遍历Map
    traversingMap()

    // 使用范围
    usingRange()

    // 只读的集合
    readOnlyCollections()
    // 连接Map
    accessingMap()

    // Lazy property 延迟初始化 / 懒加载？？？
    lazyProperty()

    // 扩展函数
    extensionFunction()

    // 自带语法级单例模式
    creatingASingleton()

    // 关于为空判断的缩写
    aboutNullShorthand()
    aboutOtherNullShorthand()

    // 在When语句上使用return
    returnOnWhen()

    // TryCatch语句可以当作表达式来用
    tryCatchExpression()

    // If语句可以当作表达式来用
    ifExpression()

    // 返回类型为 Unit 的方法的 Builder 风格用法
    testArrayOfMinusOnes()
}

/**
返回类型为 Unit 的方法的 Builder 风格用法
不知道啥意思
 */
fun testArrayOfMinusOnes() {
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }

    val array = arrayOfMinusOnes(10)
    println("array = $array")
    array.withIndex().forEach { (x) -> print("${array[x]}\t") }
}

/**
创建数据类，相当于Bean
Kotlin会自动提供如下方法：
- equals()
- hashCode()
- toString()
- copy() --> 见Kotlin的后续章节
- getters(如果是var类型还会提供setters)
- componentN()函数 --> 用于数据类和解构声明
 */
fun creatingBean() {
    data class Student(val number: Int, var name: String, var weight: Float)
}

/**
函数的默认参数
 */
fun setFuncDefaultValue() {
    fun foo(a: Int = 0, b: String = "Unit") {
        println("a == ${a} , b == ${b}")
    }
    foo() // 这样不指定值的时候，就会用到方法声明时的默认值
}

/**
过滤一个List
 */
fun filterList() {
    val list = listOf(0, 1, 3, 9, 20)
    val positives = list.filter { x -> x > 3 } // x是列表中的某个元素，类型要与list中元素的类型相同
    println("positives == ${positives}") // 输出 ：positives == [9, 20]

    val positives2 = list.filter { it > 1 }
    println("positives2 == ${positives2}") // 输出 ：positives == [3, 9, 20]
}

/**
插入String
 */
private fun interpolationString() {
    val name = "Hello"
    println("Name = $name")
}


/**
实例检查
 */
private fun checkInstance() {
//    when(x){
//        is Foo -> ...
//        is Bar -> ...
//        else -> ...
//    }
}


/**
遍历Map
 */
fun traversingMap() {
    // 创建Map
    val map = mapOf(
            Pair(1, "hello"),
            Pair(3, false),
            Pair(5, 6))
    for ((k, v) in map) {
        println("$k -> $v")
    }
}

/**
使用范围
 */
fun usingRange() {
    for (i in 1..100) {
    } // 闭区间，包括100
    for (i in 1 until 100) {
    } // 半开区间，不包括100
    for (x in 2..100 step 2) {
    } //  步进为2的区间
    for (x in 10 downTo 1) {
    } // x的值为从10到1的循环

    val m = 10
    if (m in 1..100) {
    } //
}

/**
只读的集合
 */
fun readOnlyCollections() {
    val list = listOf("a", "b", "c")
    val map = mapOf(1 to "a", "b" to 2)
}

/**
连接Map
 */
private fun accessingMap() {
    // 连接一个集合
    val map1 = mapOf(1 to "a", "b" to 2)
    val map2 = mapOf<Int, String>(1 to "a", 2 to "b")
    println(map1[1])
}

/**
Lazy property 延迟初始化 / 懒加载？？？
 */
fun lazyProperty() {
    val p: String by lazy {
        return@lazy "Hello World"
    }
    println("p = ${p}")
}

/**
扩展函数
 */
fun extensionFunction() {
    fun String.noCamelCase(): String {
        // 这里用全部小写来模拟一个新方法
        return this.toLowerCase()
    }
    println("Convert This To No Camel Case".noCamelCase())
}

/**
自带单例模式
 */
fun creatingASingleton() {
    val singleton = Singleton // 单例类不需要加()
    println("singleton's name = ${singleton.name}, singleton'age = ${singleton.age}")
    // singleton's name = Name, singleton'age = 16
}

// 单例类不能被定义在方法内（cannot be local），即不能是局部的
object Singleton {

    val name = "Name"

    val age = 16

}


/**
关于为空判断的缩写
?. --> 不为空
?: --> 为空
 */
fun aboutNullShorthand() {
    // if not null aboutNullShorthand
    val files = File("Test").listFiles()

    println(files?.size) // files不为空时输出files的size

    println(files?.size ?: "empty") // files不为空时输出files的size，为空时输出"empty"
}

fun aboutOtherNullShorthand() {
    // Kotlin中的集合明确分为只读集合、可变集合。
    // 默认创建的是只读集合
    // 创建可变集合使用mutableXxxOf()
    val data = mutableMapOf("email" to null, "name" to "Lily")

    // 为Null时抛出异常
    try {
        val email = data["email"] ?: throw IllegalAccessException("Email is missing")
    } catch(e: Exception) {
    }

    // 为空时执行代码块
    data?.let {
        // not null时，执行此代码块
        println("NOT NULL!!!")
    }


    fun defaultValueIfDataIsNull(): Any {
        return "defaultValueIfDataIsNull()"
    }

    fun transformData(it: Map<String, String?>): Any {
        data["email"] = "@163.com"
        return "it.keys = ${it.keys} , it.values = ${it.values}"
    }
    // 综合使用
    val mapped = data?.let { println(transformData(it)) } ?: defaultValueIfDataIsNull()
    // it.keys = [email, name] , it.values = [@163.com, Lily]


}

/**
在When语句上使用return
 */
fun returnOnWhen() {
    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalAccessException("Invalid color")
        }
    }

    val result = transform("Red")
    println("result == $result")
}

/**
TryCatch语句可以当作表达式来用
 */
fun tryCatchExpression(){
    fun count(): Int {
//        return 1 / 0
        return 1
    }

    val result = try {
        count()
    } catch (e: Exception) {
        throw IllegalStateException(e)
    }
    // 使用result
    println("result = $result")
}

/**
If语句可以当作表达式来用
 */
fun ifExpression() {
    fun foo(param: Int) {
        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
        println("result = $result")
    }
    foo(9)
}

