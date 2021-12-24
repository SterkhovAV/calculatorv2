fun main() {
    println("Введите выражение")
    var expression: String = readLine().toString()
    if (CheckExpression(expression)) {
        //Если есть желание посмотреть постфиксную запись то раскоментировать
        //println(ToReversePolishNotation(MakeArray(expression)))
        Calc(ToReversePolishNotation(MakeArray(expression)))
    }
    else println("Некорректный ввод")

}

//Ограничения - нельзя вводить отрициательные числа. Возможна их запись в формате (0-121212)
//Имееться проверка выражения на корректность регулярками


