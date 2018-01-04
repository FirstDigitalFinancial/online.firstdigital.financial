package financial.firstdigital.online.filter;

import financial.firstdigital.online.exceptions.FdfException;
import financial.firstdigital.online.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionFilter {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionFilter.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exception(Exception ex, WebRequest req) {
        logger.debug(ex.getMessage());

        if (ex instanceof FdfException) {
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(((FdfException) ex).getSafeMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ErrorResponse>(new ErrorResponse("Unknown Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
