package observer

interface Subject<T> {
    fun attach(observer: Observer<T>)
    fun detach(observer: Observer<T>)
    fun getData(): T
}

abstract class Observer<T>(protected val subject: Subject<T>) {
    init {
        subject.attach(this)
    }

    abstract fun onStateChanged()
}

class TextField: Subject<String> {
    private var observers: MutableList<Observer<String>> = mutableListOf()
    private var data: String = ""

    override fun attach(observer: Observer<String>) {
        observers.add(observer)
    }

    override fun detach(observer: Observer<String>) {
        observers.remove(observer)
    }

    override fun getData() = data

    fun updateData(data: String) {
        this.data = data
        notifyObservers()
    }

    private fun notifyObservers() {
        println("Notifying observers...")
        observers.forEach { it.onStateChanged() }
    }
}

class Reader(subject: Subject<String>, private val id: String): Observer<String>(subject) {
    override fun onStateChanged() {
        val data = subject.getData()
        println("*** $id ***\nGet changed data: $data")
    }

    fun attach() { subject.attach(this) }
    fun detach() { subject.detach(this) }
}

fun main(args: Array<String>) {
    val textField = TextField()
    val reader1 = Reader(textField, "Reader 1")
    val reader2 = Reader(textField, "Reader 2")

    println("Set subject data to New data 1")
    textField.updateData("New data 1")
    println("Detach reader 2")
    reader2.detach()
    println("Set subject data to New data 2")
    textField.updateData("New data 2")

}