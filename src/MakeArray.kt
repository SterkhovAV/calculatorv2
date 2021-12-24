fun MakeArray(expression:String):MutableList<String> {
    var array=ArrayList<String>()
    var buffer =""
    expression.toCharArray().map {
        if (it.isDigit()) {buffer+=it.toString()}
        else {
            if(buffer.isNotEmpty())array.add(buffer)
            buffer=""
            array.add(it.toString())
        }
    }
    if(buffer.isNotEmpty()) array.add(buffer)
    return array
}



