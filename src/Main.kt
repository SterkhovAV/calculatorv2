fun main() {
    println("Введите выражение")
    var expression: String = readLine().toString()
    if (checkExpression(expression)) {

        //println(NotationConverter().toReversePolishNotation(makeArray(expression)))
        Calc(NotationConverter().toReversePolishNotation(makeArray(expression)))
    }

    else println("Некорректный ввод")

}

//Ограничения - нельзя вводить отрициательные числа. Возможна их запись в формате (0-121212)
//Имееться проверка выражения на корректность регулярками


