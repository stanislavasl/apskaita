package lt.codeacademy.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;


@Setter
@Getter
@Entity
@Table(name="Accounts")
public class Account {

    @Id
    @Column(columnDefinition = "VARCHAR(10)", updatable = false)
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    @NotBlank
    private String purpose;

}
