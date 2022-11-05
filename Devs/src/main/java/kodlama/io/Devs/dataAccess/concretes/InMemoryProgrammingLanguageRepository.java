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
	public void delete(int id) throws Exception {
		ProgrammingLanguage deletedProgrammingLanguage = findProgrammingLanguageById(id);
		programmingLanguages.remove(deletedProgrammingLanguage);
	}

	@Override
	public void update(int id, ProgrammingLanguage programmingLanguage) throws Exception {
		ProgrammingLanguage updatedProgrammingLanguage = findProgrammingLanguageById(id);
		updatedProgrammingLanguage.setName(programmingLanguage.getName());
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
