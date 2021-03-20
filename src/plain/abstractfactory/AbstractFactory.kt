package abstractfactory

interface AbstractFactory {
    fun createObjectA(): Test
    fun createObjectB(): Test
}

class Test(val num: Int)

object Factory: AbstractFactory {
    override fun createObjectA() = Test(1)
    override fun createObjectB() = Test(2)
}

object Factory2: AbstractFactory {
    override fun createObjectA() = Test(3)
    override fun createObjectB() = Test(4)
}


fun main(args: Array<String>) {
    useObjects(Factory)
    useObjects(Factory2)
}
fun useObjects(abstractFactory: AbstractFactory) {
    val obj1 = abstractFactory.createObjectA()
    val obj2 = abstractFactory.createObjectB()
    println("obj1:${obj1.num} ; obj2: ${obj2.num}")
}