package ru.way2mars.exampledi.utils

inline fun <T : Any> T.con(message: String? = null, converter: (T) -> String = { it.toString() }): T {
    val typeString = "(class=${this.javaClass.name})"
    val msgString = if (message != null) " ($message)" else ""
    println("$typeString$msgString ${converter(this)}")
    return this
}