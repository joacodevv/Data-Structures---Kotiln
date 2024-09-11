package com.example.datastructurescompilation.stack

class StackImpl<T : Any> : Stack<T> {

    var storage = arrayListOf<T>()

    override fun pop(): T? {
        return storage.removeLastOrNull()
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    override fun push(element: T) {
        storage.add(element)
    }
}

fun String.validParentheses(): Boolean{
    val stack = StackImpl<Char>()

    for(char in this){
        when(char){
            '(' -> stack.push(char)
            ')' -> if(stack.isEmpty) return false else stack.pop()
        }
    }
    return stack.isEmpty
}