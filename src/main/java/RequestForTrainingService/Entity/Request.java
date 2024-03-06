package RequestForTrainingService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Request implements Serializable {

	@Id
	private UUID id;
	private UUID coachId;
	private UUID clientId;
	private LocalDateTime dateTime;

	public Request() {

	}

	public UUID getId() {
		return id;
	}

	public UUID getCoachId() {
		return coachId;
	}

	public UUID getClientId() {
		return clientId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setCoachId(UUID coachId) {
		this.coachId = coachId;
	}

	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
