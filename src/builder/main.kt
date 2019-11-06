package builder

interface AbstractBuiler {
    fun buildPartA()
    fun buildPartB()
    fun build(): Complex
}

class Builder1: AbstractBuiler  {

    var partA: Product? = null
    var partB: Product? = null

    override fun buildPartA() {
        partA = Product(1,2)
    }

    override fun buildPartB() {
        partB = Product(2,1)
    }

    override fun build(): Complex {
        return Complex(partA, partB)
    }
}

class Product(private val num1: Int, private val num2: Int) {
    override fun toString(): String {
        return "$num1 $num2"
    }
}

class Complex(val product1: Product?, val product2: Product?) {
    override fun toString(): String {
        return "${product1.toString()}\n${product2.toString()}"
    }
}


fun main(args: Array<String>) {
    Client(Builder1()).makaOperation()
}

class Client(private val abstractBuilder: AbstractBuiler) {
    fun makaOperation() {
        abstractBuilder.buildPartA()
        abstractBuilder.buildPartB()
        val complex = abstractBuilder.build()
        println(complex)
    }
}