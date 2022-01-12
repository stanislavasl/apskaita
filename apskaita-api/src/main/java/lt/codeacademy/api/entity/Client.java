package lt.codeacademy.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Setter
@Getter
@Entity
@Table(name="clients")
public class Client {

        @Id
        @Column(columnDefinition = "VARCHAR(15)", updatable = false)
        private String id;
        @NotBlank
        @Size(max=50)
        private String name;


}
