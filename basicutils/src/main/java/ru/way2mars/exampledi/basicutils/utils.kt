package ru.way2mars.exampledi.basicutils

/**
 * Prints some information about the object and returns a reference to it.
 *
 * Example: (java.class.string) (Person.name) John Turner
 *
 * Structure: (javaClass.name) (message : optional) "a string by converter()"
 */
inline fun <T : Any> T.con(message: String? = null, converter: (T) -> String = { it.toString() }): T {
    val typeString = "(class=${this.javaClass.name})"
    val msgString = if (message != null) " ($message)" else ""
    println("$typeString$msgString ${converter(this)}")
    return this
}