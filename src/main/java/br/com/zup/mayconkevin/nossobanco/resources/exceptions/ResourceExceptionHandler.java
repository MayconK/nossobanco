package br.com.zup.mayconkevin.nossobanco.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
				
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),
				"Erro de validação", System.currentTimeMillis());
		
		for (FieldError fe : e.getBindingResult().getFieldErrors()) {
			err.addError(fe.getField(), fe.getDefaultMessage()   );
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
