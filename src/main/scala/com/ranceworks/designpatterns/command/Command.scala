package com.ranceworks.designpatterns.command

/**
  * role: Command
  */
trait Command {

  def execute(): Unit

}

/**
  * role: ConcreteCommand
  */
class OpenCommand(private val app: Application) extends Command {

  override def execute(): Unit = {
    askUser() match {
      case Some(str) => {
        val doc = new Document(str)
        app.add(doc)
        doc.open()
      }
      case None =>
    }
  }

  def askUser(): Option[String] = Some("foo")
}

class Application {
     def add(doc: Document) {}
}

class Document(name: String) {
  def open() {}
  def paste() {}
}

/**
  * role: ConcreteCommand
  */
class PasteCommand(private val doc: Document) extends Command {
  override def execute(): Unit = {
    doc.paste()
  }
}

class SimpleCommand(private val receiver: Receiver) extends Command {
  override def execute(): Unit = {
    receiver.action()
  }
}

class Invoker {
  def storeCommand(cmds: List[Command]): Unit = {
    cmds.foreach(f => f.execute())
  }
}

class Client {
   new Invoker().storeCommand(new OpenCommand(new Application()) :: new SimpleCommand(new Receiver) :: Nil)
}

class Receiver {
  def action(){}
}
