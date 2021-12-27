class NotationConverter {
    
    private val result = ArrayList<String>() // var -> val
    private val buffer = ArrayList<String>() // var -> val

    fun toReversePolishNotation(array:MutableList<String>):MutableList<String>  {
        array.add("e") //обозначение конца массива
        array.map{
            if(isNumeric(it)) result.add(it)
            else {
                when (it) {
                "+","-" -> {
                    if (buffer.isEmpty() || buffer.last().equals("(")) push(it)
                    else if (buffer.last().equals("*")||buffer.last().equals("/")) {
                        popALL()
                        push(it)
                    } else popLastpushIt(it)
                }
                "*","/" -> {
                    if (buffer.isNotEmpty()&&(buffer.last().equals("*")||buffer.last().equals("/")) )
                        popLastpushIt(it)
                    else push(it)
                }
                "(" -> push(it)
                ")" -> popAll()
                else -> popAll()
                }
            }}
            return result

        }

    private fun push(it:String) {buffer.add(it)}

    private fun popLastpushIt(it:String) {
        result.add(buffer.last())
        buffer[buffer.lastIndex]=it
    }

    private fun popAll() {
        for (i in buffer.lastIndex downTo 0){
            if (buffer[i].equals("(")) {
                buffer.removeAt(i)
                break
            }
            result.add(buffer[i])
            buffer.removeAt(i)
        }
    }
}
