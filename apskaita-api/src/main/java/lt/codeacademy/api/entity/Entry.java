package lt.codeacademy.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name="Entries")
@NoArgsConstructor
public class Entry {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String number;
    private LocalDate date;
    @NotBlank
    @Size(min = 10, max = 100)
    private String content;
    @Positive
    @NotNull
    private BigDecimal amount;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private Account debit;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private Account credit;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private Client client;

    public Entry (UUID id, String number, LocalDate date, String content, BigDecimal amount, Account debit, Account credit, Client client) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.content = content;
        this.amount = amount;
//        this.debit = debit;
//        this.credit = credit;
//        this.client = client;
    }

}
