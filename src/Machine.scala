import EnvironmentType.Environment


// Abstract Machine to Single Step reduce expression
class Machine(statement: Statement, environment: Environment) {

  var currStatement = statement
  var currEnvironment = environment

  def step() = {
    val pre = this.currStatement

    val (nextStatement, nextEnvironment) = this.currStatement.reduce(this.environment)

    currStatement = nextStatement
    currEnvironment = nextEnvironment

    println("Reduce: " + pre + " -> " + this.currStatement)
  }

  def run() : Unit = {

    while (currStatement.isReducible ) {
      println("Statement: " + this.currStatement + ", Environment: " + this.environment)

      this.step()
    }

    println("Final Statement: " + this.currStatement + ", Environment: " + this.environment)


  }

}

object EnvironmentType {
  type Environment = Map[Symbol, Primitive]
}