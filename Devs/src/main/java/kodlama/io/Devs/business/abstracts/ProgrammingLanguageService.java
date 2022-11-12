package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.programmingLanguageResponses.GetProgrammingLanguageByIdResponce;

public interface ProgrammingLanguageService {
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception;

	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;

	List<GetAllProgrammingLanguagesResponse> getAll();

	GetProgrammingLanguageByIdResponce findProgrammingLanguageById(int id) throws Exception;
}