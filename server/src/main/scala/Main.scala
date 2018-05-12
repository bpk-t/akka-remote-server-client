import akka.actor.{ Actor, ActorSystem, Props }
import com.typesafe.config.ConfigFactory

object Main extends App {
  val config = ConfigFactory.load()
  val system = ActorSystem("server", config)

  val test1 = system.actorOf(Props[ServerActor], "test1")
  test1 ! "local test"
}

class ServerActor extends Actor {
  override def preStart(): Unit = {
    println("[ServerActor][preStart]")
    super.preStart()
  }

  override def postStop(): Unit = {
    println("[ServerActor][postStop]")
    super.postStop()
  }

  override def postRestart(reason: Throwable): Unit = {
    println("[ServerActor][postRestart]")
    super.postRestart(reason)
  }
  override def receive: Receive = {
    case "terminate" =>
      context.system.terminate()
    case s =>
      println(s"[ServerActor] receive message = ${s}")
  }
}
