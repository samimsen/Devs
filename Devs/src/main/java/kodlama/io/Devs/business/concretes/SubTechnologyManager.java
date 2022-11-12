package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Devs.business.requests.subTechnologyRequests.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologyRequests.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologyRequests.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.subTechnologyResponses.GetAllSubTechnologiesResponse;
import kodlama.io.Devs.business.responses.subTechnologyResponses.GetSubTechnologyByIdResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.Devs.entity.concretes.ProgrammingLanguage;
import kodlama.io.Devs.entity.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {

	private SubTechnologyRepository subTechnologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository,
			ProgrammingLanguageRepository programmingLanguageRepository) {
		this.subTechnologyRepository = subTechnologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository
				.findById(createSubTechnologyRequest.getProgrammingLanguageId()).get();

		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setId(createSubTechnologyRequest.getId());
		subTechnology.setName(createSubTechnologyRequest.getName());
		subTechnology.setProgrammingLanguage(programmingLanguage);

		this.subTechnologyRepository.save(subTechnology);
	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		SubTechnology subTechnologyToBeUpdated = subTechnologyRepository.findById(updateSubTechnologyRequest.getId())
				.get();
		subTechnologyToBeUpdated.setName(updateSubTechnologyRequest.getName());

		subTechnologyRepository.save(subTechnologyToBeUpdated);
	}

	@Override
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		SubTechnology subTechnologyToBeDeleted = subTechnologyRepository.findById(deleteSubTechnologyRequest.getId())
				.get();

		subTechnologyRepository.delete(subTechnologyToBeDeleted);
	}

	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {
		List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();

		List<GetAllSubTechnologiesResponse> getAllSubTechnologiesResponses = new ArrayList<>();

		for (SubTechnology subTechnology : subTechnologies) {
			GetAllSubTechnologiesResponse responseItem = new GetAllSubTechnologiesResponse();
			responseItem.setId(subTechnology.getId());
			responseItem.setName(subTechnology.getName());
			
			getAllSubTechnologiesResponses.add(responseItem);
		}

		return getAllSubTechnologiesResponses;
	}

	@Override
	public GetSubTechnologyByIdResponse getSubTechnologyByIdResponse(int id) {
		SubTechnology subTechnology = subTechnologyRepository.findById(id).get();
		
		GetSubTechnologyByIdResponse getSubTechnologyByIdResponse = new GetSubTechnologyByIdResponse();
		getSubTechnologyByIdResponse.setId(subTechnology.getId());
		getSubTechnologyByIdResponse.setName(subTechnology.getName());

		return getSubTechnologyByIdResponse;
	}
}