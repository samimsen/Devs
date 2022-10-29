package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entity.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;

	@Autowired
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) throws Exception {
		ProgrammingLanguage searchingLanguange = findProgrammingLanguageById(programmingLanguage.getId());
		programmingLanguages.remove(searchingLanguange);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage currentLanguage : programmingLanguages) {
			if (currentLanguage.getId() == programmingLanguage.getId()) {
				currentLanguage.setName(programmingLanguage.getName());
			}
		}
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage findProgrammingLanguageById(int id) throws Exception {
		for (ProgrammingLanguage currentProgrammingLanguage : programmingLanguages) {
			if (currentProgrammingLanguage.getId() == id) {
				return currentProgrammingLanguage;
			}
		}
		throw new Exception("Programlama dili mevcut değil");
	}

}
