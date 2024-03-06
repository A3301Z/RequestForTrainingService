package RequestForTrainingService.Controller;

import RequestForTrainingService.Entity.Request;
import RequestForTrainingService.Model.RequestDTO;
import RequestForTrainingService.Service.RequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class RequestController {

	private final RequestService requestService;

	public RequestController(@Autowired RequestService requestService) {
		this.requestService = requestService;
	}

	@Tag(name = "ЗАПРОС НА ТРЕНИРОВКУ: Отправить.")
	@PostMapping("/request")
	public void add(@RequestBody RequestDTO dto) {
		Request request = new Request();
		request.setId(UUID.randomUUID());
		request.setClientId(dto.clientId);
		request.setCoachId(dto.coachId);
		request.setDateTime(dto.dateTime);
		requestService.add(request);
	}

	@Tag(name = "ЗАПРОС НА ТРЕНИРОВКУ: Список запросов")
	@GetMapping("/requests")
	public List<RequestDTO> getRequests() {
		List<RequestDTO> list = new ArrayList<>();
		for (Request request : requestService.getRequests()) {
			RequestDTO dto = new RequestDTO();
			dto.id = request.getId();
			dto.clientId = request.getClientId();
			dto.coachId = request.getCoachId();
			dto.dateTime = request.getDateTime();
			list.add(dto);
		}
		return list;
	}

	@Tag(name = "ЗАПРОС НА ТРЕНИРОВКУ: Найти по ID.")
	@GetMapping("/request/{id}")
	public RequestDTO getById(@PathVariable UUID id) {
		RequestDTO dto = new RequestDTO();
		Request request = requestService.getById(id);
		dto.id = request.getId();
		dto.coachId = request.getCoachId();
		dto.clientId = request.getClientId();
		return dto;
	}

	@Tag(name = "ЗАПРОС НА ТРЕНИРОВКУ: Все запросы К ТРЕНЕРУ.")
	@GetMapping("/client/requests/{coachId}")
	public List<Request> getCoachRequests(@PathVariable UUID coachId) {
		return requestService.getCoachRequests(coachId);
	}

	@Tag(name = "ЗАПРОС НА ТРЕНИРОВКУ: Все запросы ОТ КЛИЕНТА.")
	@GetMapping("/coach/requests/{clientId}")
	public List<Request> getClientRequests(@PathVariable UUID clientId) {
		return requestService.getClientRequests(clientId);
	}
}

//{
//	"id": "12d92e3e-b69e-4cd4-8db0-08683411aba1",
//	"coachId": "2389734a-ddb1-4331-af62-a22c8034d978",
//	"clientId": "a2d93dcf-5621-4197-8385-280312e53596"
//}