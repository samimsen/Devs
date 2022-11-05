package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entity.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void delete(int id) throws Exception;
	void update(int id, ProgrammingLanguage programmingLanguage) throws Exception;
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage findProgrammingLanguageById(int id) throws Exception;

}
