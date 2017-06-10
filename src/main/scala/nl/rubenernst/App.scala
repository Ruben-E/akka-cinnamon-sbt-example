package nl.rubenernst

import akka.actor.{Actor, ActorSystem, Props}

object Pi extends App {
  val system = ActorSystem("PiSystem")
  val main = system.actorOf(Props[Main], name = "main")
  main ! Init

  class Main extends Actor {
    def receive: Receive = {
      case Init => calculate
      case PiApproximation(pi, duration) =>
        println("\n\tPi approximation: \t\t%s\n\tCalculation time: \t%s".format(pi, duration))
        calculate
    }

    def calculate: Unit = {
      val master = context.system.actorOf(Props(new Master(6, 10000, 10000, self)))
      master ! Calculate
    }
  }

}