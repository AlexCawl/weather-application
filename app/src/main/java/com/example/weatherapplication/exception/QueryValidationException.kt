package com.example.weatherapplication.exception

data class QueryValidationException(
    private val reason: String,
    private val query: String,
) : Exception() {
    override fun getLocalizedMessage(): String {
        return "$reason by {$query}"
    }
}