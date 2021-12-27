import java.text.DecimalFormat

fun Calc(RevPolNotatArray: MutableList<String>) {
    val stack = mutableListOf<Double>() // Почему не использовать стандартный java.util.Stack<E>? Если он чем-то не устраивает, можно сделать свой класс Stack. Также можно определить extension-функции для класса List.
    RevPolNotatArray.forEach { // map возвращает преобразованную коллекцию (предварительно создав ее). Если вам не нужна эта коллекция, лучше использовать forEach.
        if(isNumeric(it)) stack.add(it.toDouble())
        when (it) {
            "+" -> {
                stack[stack.lastIndex - 1] = stack[stack.lastIndex - 1] + stack.last() // stack.push(stack.pop() + stack.pop())
                stack.removeAt(stack.lastIndex)
            }
            "*" -> {
                stack[stack.lastIndex - 1] = stack[stack.lastIndex - 1] * stack.last()
                stack.removeAt(stack.lastIndex)
            }
            "/" -> {
                stack[stack.lastIndex - 1] = stack[stack.lastIndex - 1] / stack.last()
                stack.removeAt(stack.lastIndex)
            }
            "-" -> {
                stack[stack.lastIndex - 1] = stack[stack.lastIndex - 1] - stack.last()
                stack.removeAt(stack.lastIndex)
            }
            else -> 1
        }

    }
    
    // Самый простой, но далеко не самый хороший способ округления
    // с округлением пятерки странности - учитывается предыдущее число.
    // Если оно чётное, округление производится. Если нечётное — не производится.
    
    /* Это один из широко используемых способов округления - округление к ближайшему четному. Чем этот способ лучше того, которому нас всех учили в школе,
       см., например, в документации для перечисления java.math.RoundingMode, значение HALF_EVEN. */

    val myFormatter = DecimalFormat("###.##")
    val output: String = myFormatter.format(stack.first())

    println("Ответ: $output")
}

fun <T> MutableList<T>.push(elt: T) = this.add(elt)

fun <T> MutableList<T>.pop() = this.removeLast()

