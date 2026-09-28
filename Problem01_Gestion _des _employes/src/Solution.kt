fun main(){

}
enum class TypEmployee{
    DEVELOPEUR,DESIGNER,MANAGER
}
sealed class Employee(open var nom : String,
                      open var salaire: Double,
                      open var projet: List<String>,
                      open var departement: String,
                      open val type: TypEmployee)

data class Developer(override var nom: String,
                     override var salaire: Double,
                     override var projet: List<String>,
                     override var departement: String,
                    override val type:TypEmployee =TypEmployee.DEVELOPEUR ): Employee(nom, salaire, projet,departement,type)

data class Designer(override var nom: String,
                     override var salaire: Double,
                    override var projet: List<String>,
                     override var departement: String,
                    override val type:TypEmployee =TypEmployee.DESIGNER ): Employee(nom, salaire,projet, departement,type)

data class Manager(override var nom: String,
                     override var salaire: Double,
                   override var projet: List<String>,
                     override var departement: String,
                   override val type:TypEmployee =TypEmployee.MANAGER ): Employee(nom, salaire, projet,departement,type)

val employees = mutableListOf<Employee>()

fun enregistrer(obj: Employee) {
    employees.add(obj)
    println("employer ${obj.nom} Enregistrer avec succee")
}

fun employeesinfos(){
    var i:Int = 0
    for(employee in employees){
        println("${i++}employee ${employee.nom} - ${employee.salaire} - ${employee.type} ")
        println("travailler sur ${employee.projet}")
        println("department ${employee.departement}")
        println("###################################")
    }
}

fun chercher(str:String){
    for(i in employees){
        if (str == i.nom){
            println("${i.nom} oui cest un employee dans notre societer")
            break
        }else{
            println(" ne trauve aucune employee avec ce nom:${i.nom}")
        }
    }
}
fun suprimer(str:String){
    for(i in employees){
        if (str == i.nom){
            employees.remove(i)
            println("employee ${str} suprimmer avec succee")
        }
    }
}
fun DEpartementemployees(str:String){
    for(i in employees){
        if (str == i.departement){
            println("${i.nom} travaille dans departement ${i.departement}")
        }
    }
}
fun MoyenSalairEntr():Double{
    var sommesalaire: Double = 0.0
    var compteur:Int=0
    for (i in employees){
       if (i.salaire>0){
           sommesalaire += i.salaire
           compteur++
       }
    }
    var moyenneSalaire: Double = sommesalaire/compteur
    return moyenneSalaire
}

fun projetEmp(str:String){
    for(i in employees){
        if (i.projet.contains(str)){
            println("voila la list des employee qui travaille dans le projet ${str}")
            println("${i.nom} ")
        }
    }
}
fun employeeproject(obj:Employee){
    println(obj.projet)
}
