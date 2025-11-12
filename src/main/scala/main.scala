import scala.io.StdIn.readLine

enum Status {
  case MOVING
  case RETREATING
  case FIGHTING
  case ROUTING
}

enum Formation {
  case Battle
  case Testudo
  case Marching
}

val armyComposition = List("Centurion","Optio","Cornicen","Signifer", "Legionary")

// Troop stats
var troopCount: Int = 80
var troopSpeed: Int = 1
var troopStatus: Status = Status.MOVING
var troopFormation: Formation = Formation.Battle
var frontlineStamina: Double = 100.0
var frontlineStrength: Double = 100.0


def initialize() = {
  println("Welcome to this game!")
  println()
  printHelp()
}


def printArmyComposition() = {
  println("Your army consists of: ")
  armyComposition.zipWithIndex.map {
    case (element, index) => println(s"${index + 1}: $element")
  }
  println()
}

def printArmyStats() = {
  println("Your troop stats: ")
  println(s"Troop count: $troopCount men")
  println(s"Status: $troopStatus")
  println(s"Formation: $troopFormation formation")
  println(s"Movement speed: ${troopSpeed}x")
  println()
}

def printFrontlineStats() = {
  println("Frontline stats: ")
  println(s"Stamina: $frontlineStamina%")
  println(s"Strength: $frontlineStrength%")
  println()
}


def printHelp() = {
  println("Help: ")
  println("Type ARMY to see army composition")
  println("Type STATS to see army stats")
  println("Type ACTIONS to see available actions")
  println("Type EXIT to leave the game")
  println()
}

def printActions() = {
  println("Actions: ")
  println("Type FORMATION to change formation")
  println("Type MOVE to push forward (if possible)")
  println("Type SWAP to swap frontline (refreshes current frontline)")
  println("Type RETREAT to fall back safely")
  println()
}


@main
def main () = {
  initialize()

  var running: Boolean = true
  while running do
    val command = readLine("> ").trim.toUpperCase()
    command match {
      case "ARMY" => printArmyComposition()
      case "STATS" => 
        printArmyStats()
        printFrontlineStats()
      case "ACTIONS" => printActions()
      case "HELP" => printHelp()
      case "EXIT" => 
        println("Ave, Centurion. Until next time.")
        running = false
      case _ => println("Invalid input. Type HELP for a list of commands\n")
    }

}
