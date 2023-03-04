package source.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import source.domain.Entrant;
@Repository
public interface EntrantRepository extends JpaRepository<Entrant, Integer>{

    @Transactional
    @Modifying
    @Query(value = "update Entrant e set e.received = :received where e.id = :id")
    void updateEntrant(boolean received, Integer id);

}
