import akka.actor.{ Actor, ActorSystem, PoisonPill, Props }
import com.typesafe.config.ConfigFactory

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App {
  val config = ConfigFactory.load()
  val system = ActorSystem("client", config)

  val server = system.actorSelection("akka.tcp://server@127.0.0.1:2553/user/test1")
  server ! "message 1"
  Thread.sleep(1000)

  server ! "message 2"
  Thread.sleep(1000)

  server ! "message 3"
  Thread.sleep(1000)

  server ! "terminate"
  Thread.sleep(1000)

  Await.ready(system.terminate(), Duration.Inf)
}
