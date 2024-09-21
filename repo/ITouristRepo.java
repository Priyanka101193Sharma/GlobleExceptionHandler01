package in.priyankait.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.priyankait.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
