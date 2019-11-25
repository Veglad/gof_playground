interface Mediator {
    fun mediate(interractor: Interractor)
    fun setInteractors(Interractor1: Interractor1, Interractor2: Interractor2)
}

open class Interractor(val mediator: Mediator)

class Interractor1(mediator: Mediator) : Interractor(mediator) {
    var state: Int = 0
        set(value) {
            if (state != value) {
                this.state = value
                println("Updated state for Interractor 1: ${this.state}")
                mediator.mediate(this)
            }
        }
    fun action1(state: Int) {
        this.state = state
        println("Action 1 is called")
    }
}

class Interractor2(mediator: Mediator) : Interractor(mediator) {
    var state: Int = 0
        set(value) {
            if (state != value) {
                this.state = value
                println("Updated state for Interractor 2: ${this.state}")
                mediator.mediate(this)
            }
        }
    fun action2(state: Int) {
        this.state = state
        println("Action 2 is called")
    }
}

class Mediator1 : Mediator {
    private var interractor1: Interractor1? = null
    private var interractor2: Interractor2? = null 

    override fun setInteractors(Interractor1: Interractor1, Interractor2: Interractor2) {
        this.interractor1 = interractor1
        this.interractor2 = interractor2
    }

    override fun mediate(interractor: Interractor) {
        if (interractor == interractor1) {
            val state = interractor2?.state ?: 0
            interractor1?.state = state
            interractor2?.action2(state)
        }

        if (interractor == interractor2) {
            val state = interractor1?.state ?: 0
            interractor1?.state = state
            interractor1?.action1(state)
        }
    }
}

fun main(args: Array<String>) {
    val mediator = Mediator1()
    val interractor1 = Interractor1(mediator)
    val interractor2 = Interractor2(mediator)
    mediator.setInteractors(interractor1, interractor2)

    interractor1.state = 1
    interractor2.state = 10
}