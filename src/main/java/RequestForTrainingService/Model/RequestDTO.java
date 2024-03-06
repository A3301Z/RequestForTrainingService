package RequestForTrainingService.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonPropertyOrder({"id", "coachId", "clientId"})
public class RequestDTO {
	@JsonProperty("id")
	public UUID id;

	@JsonProperty("coachId")
	public UUID coachId;

	@JsonProperty("clientId")
	public UUID clientId;

	@JsonProperty("dateTime")
	@JsonFormat(pattern = "dd.MM.yyyy: HH:mm")
	public LocalDateTime dateTime;
}
