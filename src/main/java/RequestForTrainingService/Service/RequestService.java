package RequestForTrainingService.Service;

import RequestForTrainingService.Entity.Request;
import RequestForTrainingService.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RequestService {

	private final RequestRepository requestRepository;

	public RequestService(@Autowired RequestRepository requestRepository) {
		this.requestRepository = requestRepository;
	}

	public List<Request> getRequests() {
		return requestRepository.findAll();
	}

	public void add(Request request) {
		requestRepository.save(request);
	}

	public Request getById(UUID id) {
		Optional<Request> optionalRequest = requestRepository.findById(id);
		if (optionalRequest.isEmpty()) {
			throw new RuntimeException(String.format("По заданному id: '%s' заявка на тренировку не найдена.", id));
		} else {
			return optionalRequest.get();
		}
	}

	public List<Request> getCoachRequests(UUID coachId) {
		return requestRepository.findByCoachId(coachId);
	}

	public List<Request> getClientRequests(UUID clientId) {
		return requestRepository.findByClientId(clientId);
	}
}
