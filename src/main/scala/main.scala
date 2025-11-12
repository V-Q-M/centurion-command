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
  println("Available commands: ")
  println("ARMY - See army composition")
  println("STATS - See army stats")
  println("ACTIONS - See available actions")
  println("EXIT - Leave the game")
  println()
}

def printActions() = {
  println("Available actions: ")
  println("FORMATION <type> - Change to specified formation")
  println("MOVE - Push forward with your army (if possible)")
  println("SWAP - Swap frontline (refreshes current frontline)")
  println("RETREAT - Fall back safely")
  println()
}

def printFormations() = {
  println("Choose a formation: ")
  println("Battle - High offense, high defense, low mobility")
  println("Testudo - Low offense, immunity to range attacks, very low mobility")
  println("March - Low offense, very low defense, high mobility")
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
      case "FORMATION" => 
        printFormations()
        val formation = readLine("> ").trim.toLowerCase()
        formation match {
          case "battle" => println("Switching to *battle* formation...")
          case "testudo" => println("Switching to *testudo* formation...")
          case "march" => println("Switching to *march* formation...")
          case "exit" => 
            println("Ave, Centurion. Until next time.")
            running = false
          case _ => println("Invalid input. Type HELP for a list of commands\n")
        }
      case "MOVE" => println("Moving forward...")
      case "SWAP" => println("Swapping frontline...")
      case "RETREAT" => println("Retreating...")
      case "HELP" => printHelp()
      case "EXIT" => 
        println("Ave, Centurion. Until next time.")
        running = false
      case _ => println("Invalid input. Type HELP for a list of commands\n")
    }

}
