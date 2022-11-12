package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.subTechnologyRequests.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologyRequests.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologyRequests.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.subTechnologyResponses.GetAllSubTechnologiesResponse;
import kodlama.io.Devs.business.responses.subTechnologyResponses.GetSubTechnologyByIdResponse;

public interface SubTechnologyService {
	void add(CreateSubTechnologyRequest createSubTechnologyRequest);

	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest);

	void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest);

	List<GetAllSubTechnologiesResponse> getAll();

	GetSubTechnologyByIdResponse getSubTechnologyByIdResponse(int id);
}