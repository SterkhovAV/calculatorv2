package calculator.logic
fun Calculation(expression: String): String {
        if (checkExpression(expression)) {
            return Calc(NotationConverter().toReversePolishNotation(makeArray(expression)))
        } else return "Incorrect expression"

    }

//Ограничения - нельзя вводить отрициательные числа. Возможна их запись в формате (0-121212)
//Имееться проверка выражения на корректность регулярками


