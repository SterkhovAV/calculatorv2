package calculator.logic
fun isNumeric(str:String):Boolean {
    str.toIntOrNull() ?: return false
    return true;
}