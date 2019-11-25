abstract class Handler() {
    private var successor: Handler? = null

    constructor(successor: Handler) : this() {
        this.successor = successor
    }

    open fun handle(message: String) {
        this.successor?.handle(message)
    }

    fun canHandleRequest() = false
}

class Reciever1(private val successor: Handler): Handler(successor) {
    override fun handle(message: String) {
        if (canHandleRequest()) {
            println("Handling request from the Reciever1")
        } else {
            println("Can't handle request from the Reciever1")
            super.handle(message)
        }
    }
}

class Reciever2(): Handler() {
    override fun handle(message: String) {
        print("Handling request from the Reciever2")
    }
}

fun main(args: Array<String>) {
    val handler = Reciever1(Reciever2())
    handler.handle("Handle message")
}