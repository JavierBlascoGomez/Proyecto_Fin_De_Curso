import java.util.*
import kotlin.math.pow

fun main() {
    val scanner = Scanner(System.`in`)

    print("Ingrese la edad: ")
    val edad = scanner.nextInt()

    print("Ingrese el sexo (hombre/mujer): ")
    val sexo = scanner.next().lowercase(Locale.getDefault())

    print("Ingrese el valor de creatinina en suero: ")
    val creatininaSuero = scanner.nextDouble()

    print("Ingrese la etnia (Blanco | Negro))")
    val grupoEtnico = scanner.next().lowercase(Locale.getDefault())

    val resultadoTFG = calcularCKDEPI(edad, sexo, creatininaSuero, grupoEtnico)
    println("El Filtrado Glomerular Estimado (CKD-EPI) es: $resultadoTFG mL/min/1.73m²")
}

fun calcularCKDEPI(edad: Int, sexo: String, creatininaSuero: Double, grupoEtnico: String): Double {
    // Fórmula CKD-EPI para calcular el filtrado glomerular estimado
    val factorSexo = if (sexo == "hombre") 1.0 else 0.742
    val factorEdad = Math.pow(0.993, edad.toDouble())
    val factorEtnia = if (grupoEtnico == "blanco") 1.0 else 1.159

    val tfg = 141 * factorEdad * factorSexo * Math.min(creatininaSuero / 0.9, 1.0).pow(-0.411) * Math.max(creatininaSuero / 0.9, 1.0).pow(-1.209) * factorEtnia

    return tfg
}
