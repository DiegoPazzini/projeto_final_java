package com.pazzini.memems.exceptions.handler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pazzini.memems.exceptions.EntidadeEmUsoException;
import com.pazzini.memems.exceptions.EntidadeNaoEncontradaException;
import com.pazzini.memems.exceptions.FeignException;

/**
 * Classe que trata exceções específicas lançadas pela aplicação, fornecendo respostas personalizadas para cada cenário.
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Trata exceções do tipo EntidadeNaoEncontradaException.
     *
     * @param ex      A exceção lançada.
     * @param request A requisição web.
     * @return Uma resposta personalizada com detalhes sobre o erro.
     */
    @ExceptionHandler
    public ResponseEntity<Object> handleEntidadeNaoEncontrada(
            EntidadeNaoEncontradaException ex, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiError error = new ApiError();
        error.setStatus(status.value());
        error.setType("http://localhost/entidade-nao-encontrada");
        error.setTitle("Entidade não encontrada");
        error.setDetail(ex.getMessage());
        error.setTimestamp(LocalDateTime.now(ZoneId.of("UTC")));

        return handleExceptionInternal(ex, error,
                new HttpHeaders(), status, request);

    }

    /**
     * Trata exceções do tipo EntidadeEmUsoException.
     *
     * @param ex      A exceção lançada.
     * @param request A requisição web.
     * @return Uma resposta personalizada com detalhes sobre o erro.
     */
    @ExceptionHandler
    public ResponseEntity<Object> handleEntidadeEmUso(
            EntidadeEmUsoException ex, WebRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;

        ApiError error = new ApiError();
        error.setStatus(status.value());
        error.setType("http://localhost/entidade-em-uso");
        error.setTitle("Entidade em uso.");
        error.setDetail(ex.getMessage());
        error.setTimestamp(LocalDateTime.now(ZoneId.of("UTC")));

        return handleExceptionInternal(ex, error,
                new HttpHeaders(), status, request);
    }

    /**
     * Trata exceções do tipo FeignException.
     *
     * @param ex      A exceção lançada.
     * @param request A requisição web.
     * @return Uma resposta personalizada com detalhes sobre o erro.
     */
    @ExceptionHandler
    public ResponseEntity<Object> handleFeignException(
            FeignException ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiError error = new ApiError();
        error.setStatus(status.value());
        error.setType("http://localhost/requisicao-mal-formada");
        error.setTitle("Requisição mal formada.");
        error.setDetail(ex.getMessage());
        error.setTimestamp(LocalDateTime.now(ZoneId.of("UTC")));

        return handleExceptionInternal(ex, error,
                new HttpHeaders(), status, request);
    }

    /**
     * Sobrescreve o método padrão de tratamento de exceções para lidar com erros de validação de argumentos do método.
     *
     * @param ex      A exceção lançada.
     * @param headers Os cabeçalhos HTTP.
     * @param status  O status HTTP.
     * @param request A requisição web.
     * @return Uma resposta personalizada com detalhes sobre o erro de validação.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        status = HttpStatus.BAD_REQUEST;

        BindingResult bindingResult = ex.getBindingResult();

        List<ApiError.Field> errorFields = bindingResult.getFieldErrors().stream()
                .map(fieldError -> new ApiError.Field(
                        fieldError.getField(),
                        fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        ApiError error = new ApiError();
        error.setStatus(status.value());
        error.setType("http://localhost/dados-invalidos");
        error.setTitle("Dados inválidos");
        error.setDetail("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");
        error.setTimestamp(LocalDateTime.now(ZoneId.of("UTC")));
        error.setFields(errorFields);

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    /**
     * Sobrescreve o método padrão de tratamento de exceções internas para garantir que a resposta seja personalizada.
     *
     * @param ex      A exceção lançada.
     * @param body    O corpo da resposta.
     * @param headers Os cabeçalhos HTTP.
     * @param status  O status HTTP.
     * @param request A requisição web.
     * @return Uma resposta personalizada com detalhes sobre o erro.
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if (body == null
