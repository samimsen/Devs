package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
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
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		for (ProgrammingLanguage currentProgrammingLanguage : programmingLanguageRepository.findAll()) {
			if (currentProgrammingLanguage.getName().equals(programmingLanguage.getName())) {
				throw new Exception(programmingLanguage.getName() + " Programlama dili daha önce eklenmiş");
			}
			
			if(currentProgrammingLanguage.getId() == programmingLanguage.getId()) {
				throw new Exception("Id zaten mevcut");
			}

			if (programmingLanguage.getName() == "") {
				throw new Exception("Programlama dili boş geçilemez");
			}
		}

		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(int id) throws Exception {
		ProgrammingLanguage programmingLanguageToBeDeleted = programmingLanguageRepository.findById(id).get();
		programmingLanguageRepository.delete(programmingLanguageToBeDeleted);
	}

	@Override
	public void update(int id, ProgrammingLanguage programmingLanguage) throws Exception {
		if (programmingLanguage.getName() == "") {
			throw new Exception("Programlama dili boş geçilemez");
		}
		
		ProgrammingLanguage programmingLanguageToBeUpdated = programmingLanguageRepository.findById(id).get();
		programmingLanguageToBeUpdated.setName(programmingLanguage.getName());;
		
		programmingLanguageRepository.save(programmingLanguageToBeUpdated);
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.findAll();
	}

	@Override
	public ProgrammingLanguage findProgrammingLanguageById(int id) throws Exception {
		return programmingLanguageRepository.findById(id).get();
	}

}
