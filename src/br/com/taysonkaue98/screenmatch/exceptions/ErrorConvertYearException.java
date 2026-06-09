package br.com.taysonkaue98.screenmatch.exceptions;

public class ErrorConvertYearException extends RuntimeException {

    private String message;

// Construtor da classe ErrorConvertYearException para inicializar a mensagem de erro
    public ErrorConvertYearException(String message) {
        this.message = message;

    }

// Sobrescreve o método getMessage para retornar a mensagem de erro personalizada quando a exceção for lançada
    @Override
    public String getMessage() {
        return this.message;
    }
    
}
