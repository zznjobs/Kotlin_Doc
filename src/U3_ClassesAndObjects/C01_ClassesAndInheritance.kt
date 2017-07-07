package U3_ClassesAndObjects

/**
 * 类与继承
 */
class TestDemo1(val a: Int = 0)

class TestDemo2(val a: Int = 0, val b: Int)


open class ClassBase(p: Int) {
    constructor(p: Int, q: Int) : this(p) {

    }
}

//class ClassSub() : ClassBase(p) // 子类的主构造器参数不能比父类少
class ClassSubA(p: Int) : ClassBase(p)

class ClassSubB : ClassBase { // 没有主构造器
    constructor(p: Int) : super(p)
    constructor(p: Int, q: Int) : super(p)
    constructor(p: Int, q: Int, r: Int) : this(p, q)
}


open class Foo {
    open val x: Int get() = 0

}

class Bar1 : Foo() {
    override var x: Int = 100
    // var可复写val，反过来不行。
    // 因为val只有get，添加个set即为var。
}

fun main(args: Array<String>) {

    // 主构造器的所有参数都有默认值，则会产生一个额外的无参构造器，使用主构造器各参数的默认值来调用主构造器。
    // 如果所有主构造器的所有参数都有默认值，完全可以通过无参构造器创建该类对象。
    val testDemo1_1 = TestDemo1()
    println(testDemo1_1.a) // 0 --> 默认值
    val testDemo1_2 = TestDemo1(100)
    println(testDemo1_2.a) // 100


    // 报错，因为不是所有构造器参数都有默认值，因此没有隐式的无参构造器
//    val testDemo1_1 = TestDemo2()
//    println(testDemo1_1.a)
    // 以下写法也错
//    val testDemo1_2 = TestDemo2(, 100)
//    println(testDemo1_2.a)
    val testDemo1_3 = TestDemo2(100, -1) // 这是唯一正确的写法
    println(testDemo1_3.a) // 100


}