package com.example.kotlin_1

data class Project(
    val id: Int,
    val name: String,
    val description: String,
    val technologies: List<String>,
    val done: Boolean
)
