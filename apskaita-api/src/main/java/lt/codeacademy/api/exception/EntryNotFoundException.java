package lt.codeacademy.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@Getter
@AllArgsConstructor
public class EntryNotFoundException extends RuntimeException{
    private final UUID id;
}
