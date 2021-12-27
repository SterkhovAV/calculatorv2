fun makeArray(expression: String): MutableList<String> {
    val result = mutableListOf<String>()
    val buffer = StringBuilder()
    for (ch in expression) {
        if (ch.isDigit()) {
            buffer.append(ch)
        } else {
            if (buffer.isNotEmpty()) {
                result.add(buffer.toString())
                buffer.clear()
            }
            result.add(ch.toString())
        }
    }

    if (buffer.isNotEmpty()) result.add(buffer.toString())
    
    return result
}

