package strategy

interface IFly {
    fun fly(name: String)
}

interface IQuack {
    fun quack(name: String)
}

class Duck(var flyBehavior: IFly, var quackBehavior: IQuack, private val name: String) {
    fun fly() {
        println("Calling fly behavior...")
        flyBehavior.fly(name)
    }

    fun quack() {
        println("Calling quack behavior...")
        quackBehavior.quack(name)
    }
}

class FastFly: IFly {
    override fun fly(name: String) {
        println("\t$name: Flying so fast")
    }
}

class HighFly: IFly {
    override fun fly(name: String) {
        println("\t$name: Flying so high")
    }
}

class LoadQuack: IQuack {
    override fun quack(name: String) {
        println("\t$name: Quacking so load")
    }
}

class LongQuack: IQuack {
    override fun quack(name: String) {
        println("\t$name: Quacking for so long time...")
    }
}

fun main(args: Array<String>) {
    val duck = Duck(FastFly(), LoadQuack(), "Bruce")

    duck.fly()
    duck.quack()

    println("\nChange behaviour in run-time\n")

    duck.quackBehavior = LongQuack()
    duck.flyBehavior = HighFly()

    duck.fly()
    duck.quack()
}