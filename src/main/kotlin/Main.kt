package org.example

import java.io.File
import java.io.FileNotFoundException

fun main() {
    println(safeDivision(10, 0))
    println(stringToNumber("123a"))
    println(ageValidation(150))

//    val newFile = createFile();
//    println(readFile(newFile))

    val directory = File("ruta")
    println(readFile(directory))

    println(nameValidation("abc"))
    println(listAverage(listOf()))
    println(multipleExceptions("10", "abc"))
}

fun safeDivision(numerator: Int, denominator: Int): Int {
    return try {
        numerator / denominator;
    } catch (e: ArithmeticException) {
        println("Excepción capturada: División por cero no permitida.")
        0
    }
}

fun stringToNumber(word: String): Int {
    return try {
        word.toInt();
    } catch (e: NumberFormatException) {
        println("Excepción capturada: El texto no es un número")
        0
    }
}

fun ageValidation(age: Int): Boolean {
    return try {
        if (age !in 0..120) {
            throw IllegalArgumentException("La edad debe estar entre 0 y 120.")
        }
        true
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
        false
    }
}

fun createFile(): File {
    val file = File("MyFile.txt")
    file.writeText("Hello world")
    return file
}

fun readFile(file: File): String {
    return try {
        file.readText();
    } catch (e: FileNotFoundException) {
        println("Excepción capturada: El archivo no fue encontrado.")
        "F"
    }
}

fun nameValidation(name: String): Boolean {
    return try {
        if (name.length < 5) {
            throw InvalidUsernameException("Excepción capturada: El nombre de usuario debe tener al menos 5 caracteres.");
        }
        true
    } catch (e: InvalidUsernameException) {
        println("${e.message}")
        false
    }
}

fun listAverage(list: List<Int>): Double {
    return try {
        if (list.isEmpty()) {
            throw IllegalArgumentException("Excepción capturada: La lista no puede estar vacía.");
        }
        list.average()
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
        0.0
    }
}

fun multipleExceptions(numerator: String, denominator: String): Int {
    return try {
        numerator.toInt() / denominator.toInt();
    } catch (e: ArithmeticException) {
        println("Excepción capturada: División por cero no permitida.")
        0
    } catch (e: NumberFormatException) {
        println("Excepción capturada: La cadena no puede convertirse a un número.")
        0
    }
}
