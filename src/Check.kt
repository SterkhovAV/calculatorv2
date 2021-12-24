import java.util.regex.Pattern

fun CheckExpression(expression:String):Boolean { //проверка на наличие недопустимых символов и корректного количества скобок
    var result = true
    var brace=0
    for (c in expression.toCharArray()) {
        when (c) {
            '('-> brace+=1
            ')'-> brace-=1
            else -> if(Pattern.matches("[^\\d\\+\\-/\\*\\(\\)]{1}", c.toString())) {   // Плодит стринги в стринг пул, корректно ли?
                result = false
            }
        }
    }
    if (brace!=0) result=false


    // Задвоенные знаки
    if(Pattern.matches("[\\d\\+\\-/\\*\\(\\)]*[\\+\\-/\\*]{2,}[\\d\\+\\-/\\*\\(\\)]*", expression)) {
        result = false}
    // Знак в конце выражения без числа
    if(Pattern.matches("[\\d\\+\\-/\\*\\(\\)]*[\\+\\-/\\*]+", expression)) {
        result = false}
    // Знак ДО выражения
    if(Pattern.matches("[\\+\\-/\\*]+[\\d\\+\\-/\\*\\(\\)]*", expression)) {
        result = false}
    // Знак после открывающейся скобки. пример - 4333-(*4545)
    if(Pattern.matches(".*[\\(]+[\\+\\-/\\*]+.*", expression)) {
        result = false}
    // Нет знака перед открывающейся скобкой - 232323(333+3454)
    if(Pattern.matches(".*\\d+[\\(]+.*", expression)) {
        result = false}
    // Знак перед закрывающейся скобкой. пример - 4333-(4545-)+2525
    if(Pattern.matches(".*[\\+\\-/\\*]+[\\)]+.*", expression)) {
        result = false}
    // Нет знака после закрывающейся скобки. пример - 4333-(4545+251)2525
    if(Pattern.matches(".*[\\)]+\\d+.*", expression)) {
        result = false}


    return result
}