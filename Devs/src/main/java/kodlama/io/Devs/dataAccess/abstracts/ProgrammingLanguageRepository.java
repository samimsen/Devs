package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entity.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	
	void add(ProgrammingLanguage programmingLanguage);
	void delete(int id) throws Exception;
	void update(int id, ProgrammingLanguage programmingLanguage) throws Exception;
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage findProgrammingLanguageById(int id) throws Exception;

}
