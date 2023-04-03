package br.com.fiap.todotarefs.models;

public record RestValidationError(
    Integer code,
    String field,
    String message
) {}
