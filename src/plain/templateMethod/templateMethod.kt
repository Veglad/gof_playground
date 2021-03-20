abstract class NotificationService {
    final fun notify(event: Event) {
        if (event.message == "") {
            handleIncorrectEvent()
            return
        }

        val messageToSend = formMessage(event)
        notifyUser(messageToSend, event)
    }

    protected fun handleIncorrectEvent() {  }

    abstract protected fun formMessage(event: Event): String

    abstract protected fun notifyUser(message: String, event: Event) 

    class Event(val message: String)
}

class ConsoleNotificationService(): NotificationService() {
    override protected fun formMessage(event: Event) = "You've just got an event message: ${event.message}"
    override protected fun notifyUser(message: String, event: Event) {
        println("-------------------\nHey!\n$message\n----------------------")
    }
}

fun main(args: Array<String>) {
    val notificationService: NotificationService = ConsoleNotificationService()
    notificationService.notify(NotificationService.Event("Happy birthday!"))
}