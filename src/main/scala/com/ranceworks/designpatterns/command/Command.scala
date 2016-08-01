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
class PasteCommand(private val doc: Document) extends Command {
  override def execute(): Unit = {
    doc.paste()
  }
}
/**
  * role: ConcreteCommand
  */
class SimpleCommand(private val receiver: Receiver) extends Command {
  override def execute(): Unit = {
    receiver.action()
  }
}

class Document() {
  def paste() {}
}

class Invoker {
  def storeCommand(cmds: List[Command]): Unit = {
    cmds.foreach(f => f.execute())
  }
}

class Client {
   new Invoker().storeCommand(new PasteCommand(new Document) :: new SimpleCommand(new Receiver) :: Nil)
}

class Receiver {
  def action(){}
}
