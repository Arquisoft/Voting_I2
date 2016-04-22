package es.uniovi.asw.results.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Roberto on 17/4/16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND ,reason = "The partie doesn't exist ")
public class PartieNotFoundException extends RuntimeException {
}
