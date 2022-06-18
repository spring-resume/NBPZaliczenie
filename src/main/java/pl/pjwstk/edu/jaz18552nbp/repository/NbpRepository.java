package pl.pjwstk.edu.jaz18552nbp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjwstk.edu.jaz18552nbp.model.Result;

@Repository
public interface NbpRepository extends JpaRepository<Result, Long> {
}
