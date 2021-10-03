package com.impacta.microservices.investimento.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ContaIdExistenteBadRequestException extends RuntimeException {

    public ContaIdExistenteBadRequestException(String msg) { super(msg); }
}
