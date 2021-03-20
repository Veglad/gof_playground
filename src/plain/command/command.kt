interface Command {
    fun execute()
}

class MailSender() {
    fun sendEmail(email: String) {
        println("Send email to $email")
    }
}

class Button(private val onClickCommand: Command) {
    fun click() {
        onClickCommand.execute()
    }
}

class MailSendCommand(private val mailSender: MailSender, private val mail: String): Command {
    override fun execute() {
        mailSender.sendEmail(mail)
    }
}

fun main(args: Array<String>) { 
    val sendMail: Command = MailSendCommand(MailSender(), "admin@gmail.com")
    Button(sendMail).click()
}