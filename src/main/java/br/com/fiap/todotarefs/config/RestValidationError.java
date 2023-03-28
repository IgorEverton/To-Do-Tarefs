package br.com.fiap.todotarefs.config;

public record RestValidationError {
    Interger code,
    String field,
    String message
}
