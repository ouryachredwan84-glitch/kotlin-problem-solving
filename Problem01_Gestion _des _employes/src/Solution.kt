fun main(){
    val emp1 = Developpeur("radouan",23000.0)
    val emp2 = Designer("rayan",50000.0)
    val emp3 = Manager("khalid",300000.0)
    ajouterEmploye(emp1)
    ajouterEmploye(emp2)
    ajouterEmploye(emp3)
    afficherEmployes()
}
enum class TypeEmploye{
    DEVELOPPEUR,
    DESIGNER,
    MANAGER
}

sealed class Employee(open var nom: String,
                      open var salaire: Double,
                      open var type:TypeEmploye)

data class Developpeur(override var nom: String,
                       override var salaire: Double,
                       override var type:TypeEmploye=TypeEmploye.DEVELOPPEUR):Employee(nom, salaire, type),Travailleur{
    override fun travailler() {
        println("travailler")
    }
}

data class Designer(override var nom: String,
                    override var salaire: Double,
                    override var type:TypeEmploye=TypeEmploye.DESIGNER):Employee(nom, salaire, type),Travailleur{
    override fun travailler() {
        println("travailler")
    }
}

data class Manager(override var nom: String,
                   override var salaire: Double,
                   override var type:TypeEmploye=TypeEmploye.MANAGER):Employee(nom, salaire, type)

interface Travailleur{
    fun travailler()
}

val employees = mutableListOf<Employee>()

fun ajouterEmploye(obj: Employee) {
    employees.add(obj)
}

fun afficherEmployes(){
    for(employee in employees){
        println("${employee.nom} ${employee.salaire} ${employee.type}")
        if(employee is Travailleur){
            employee.travailler()
        }
    }
}