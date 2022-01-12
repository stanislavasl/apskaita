package lt.codeacademy.api.repository;

import lt.codeacademy.api.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface EntryRepository extends JpaRepository<Entry, UUID> {
    List<Entry> findEntryByDateBetween(LocalDate dateFrom, LocalDate dateTill);


//    @Query("select e from Entry e where e.date between dateFrom and dateTill")
//    List<Entry> findLike(@Param("text") String text);

}
