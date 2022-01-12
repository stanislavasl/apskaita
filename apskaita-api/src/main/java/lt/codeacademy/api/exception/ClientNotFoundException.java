package lt.codeacademy.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientNotFoundException extends RuntimeException{
    private final String id;
}
