package source.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import source.domain.Entrant;
@Repository
public interface EntrantRepository extends JpaRepository<Entrant, Integer>{

}
