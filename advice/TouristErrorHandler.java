package in.priyankait.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.priyankait.exception.TouristNotFoundException;
import in.priyankait.model.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestControllerAdvice
public class TouristErrorHandler {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<?> handleTouristNotFound(TouristNotFoundException tnf){
		log.info("in the AdviceController");
		//System.out.println("TouristErrorHandler.handleTouristNotFound()");
		//ErrorDetails details=new ErrorDetails(LocalDateTime.now(),tnf.getMessage(),"404- Tourist Not Found");
		//return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		return new ResponseEntity<String>("its not found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e){
		System.out.println("TouristErrorHandler.handleAllProblems()");
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),e.getMessage(),"Problem in execution");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
