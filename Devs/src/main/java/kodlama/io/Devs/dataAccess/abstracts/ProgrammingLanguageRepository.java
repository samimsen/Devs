package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entity.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	
	void add(ProgrammingLanguage programmingLanguage);
	void delete(ProgrammingLanguage programmingLanguage) throws Exception;
	void update(ProgrammingLanguage programmingLanguage);
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage findProgrammingLanguageById(int id) throws Exception;

}
