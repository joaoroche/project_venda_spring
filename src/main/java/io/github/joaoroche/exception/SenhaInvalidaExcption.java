package io.github.joaoroche.exception;

public class SenhaInvalidaExcption extends RuntimeException {
    public SenhaInvalidaExcption(){
        super("Senha inválida");
    }
}
