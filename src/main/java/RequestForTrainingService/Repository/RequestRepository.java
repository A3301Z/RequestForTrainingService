package RequestForTrainingService.Repository;

import RequestForTrainingService.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RequestRepository extends JpaRepository<Request, UUID> {

	@Query("SELECT r FROM Request r WHERE r.coachId = :coachId")
	List<Request> findByCoachId(@Param("coachId") UUID coachId);

	@Query("SELECT r FROM Request r WHERE r.clientId = :clientId")
	List<Request> findByClientId(@Param("clientId") UUID clientId);

}
