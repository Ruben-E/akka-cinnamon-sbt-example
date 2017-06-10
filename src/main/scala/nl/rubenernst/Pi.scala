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
      val master = context.system.actorOf(Props(new Master(random(2, 10), random(5000, 15000), random(5000, 15000), self)))
      master ! Calculate
    }

    def random(start: Int, end: Int): Int = {
      val rnd = new scala.util.Random
      start + rnd.nextInt( (end - start) + 1 )
    }
  }

}