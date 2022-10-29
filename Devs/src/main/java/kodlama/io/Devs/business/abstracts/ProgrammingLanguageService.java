package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entity.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void delete(ProgrammingLanguage programmingLanguage) throws Exception;
	void update(ProgrammingLanguage programmingLanguage) throws Exception;
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage findProgrammingLanguageById(int id) throws Exception;

}
