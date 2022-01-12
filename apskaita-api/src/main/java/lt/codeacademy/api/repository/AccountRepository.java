package lt.codeacademy.api.repository;

import lt.codeacademy.api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
