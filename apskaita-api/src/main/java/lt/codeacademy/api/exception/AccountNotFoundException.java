package lt.codeacademy.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountNotFoundException extends RuntimeException{
    private final String id;
}
