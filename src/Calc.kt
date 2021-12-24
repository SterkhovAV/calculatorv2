import java.text.DecimalFormat

fun Calc(RevPolNotatArray:MutableList<String>) {
    val stack = mutableListOf<Double>()
    RevPolNotatArray.map {
        if(isNumeric(it)) stack.add(it.toDouble())
        when (it) {
            "+" -> {
                stack[stack.lastIndex - 1] = stack[stack.lastIndex - 1] + stack.last()
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

    val myFormatter = DecimalFormat("###.##")
    val output: String = myFormatter.format(stack.first())

    println("Ответ: $output")
}
