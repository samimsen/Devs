package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.programmingLanguageResponses.GetProgrammingLanguageByIdResponce;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entity.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();

		for (ProgrammingLanguage currentProgrammingLanguage : programmingLanguageRepository.findAll()) {
			if (currentProgrammingLanguage.getName().equals(createProgrammingLanguageRequest.getName())) {
				throw new Exception(
						createProgrammingLanguageRequest.getName() + " Programlama dili daha önce eklenmiş");
			}

			if (createProgrammingLanguageRequest.getName() == "") {
				throw new Exception("Programlama dili boş geçilemez");
			}
		}

		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {
		ProgrammingLanguage deletedProgrammingLanguage = programmingLanguageRepository.findById(deleteProgrammingLanguageRequest.getId()).get();
		
		programmingLanguageRepository.delete(deletedProgrammingLanguage);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		if (updateProgrammingLanguageRequest.getName() == "") {
			throw new Exception("Programlama dili boş geçilemez");
		}

		ProgrammingLanguage programmingLanguageToBeUpdated = programmingLanguageRepository.findById(updateProgrammingLanguageRequest.getId()).get();
		programmingLanguageToBeUpdated.setName(updateProgrammingLanguageRequest.getName());

		programmingLanguageRepository.save(programmingLanguageToBeUpdated);
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> languages = this.programmingLanguageRepository.findAll();
		
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponce = new ArrayList<>();

		for (ProgrammingLanguage programmingLanguage : languages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			responseItem.setSubTechnologies(programmingLanguage.getSubTechnologies());
			
			programmingLanguagesResponce.add(responseItem);
		}
		
		return programmingLanguagesResponce;
	}

	@Override
	public GetProgrammingLanguageByIdResponce findProgrammingLanguageById(int id) throws Exception {
		GetProgrammingLanguageByIdResponce getProgrammingLanguageByIdResponce = new GetProgrammingLanguageByIdResponce();
		
		List<ProgrammingLanguage> languages = this.programmingLanguageRepository.findAll();
		
		for (ProgrammingLanguage language : languages) {
			if (language.getId() == id) {
				getProgrammingLanguageByIdResponce.setId(language.getId());
				getProgrammingLanguageByIdResponce.setName(language.getName());
				getProgrammingLanguageByIdResponce.setSubTechnologies(language.getSubTechnologies());
			}
		}
		
		return getProgrammingLanguageByIdResponce;
	}
}