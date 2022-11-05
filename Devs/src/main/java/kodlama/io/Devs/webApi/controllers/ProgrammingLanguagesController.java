package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.entity.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages/")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@PostMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		this.programmingLanguageService.add(programmingLanguage);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(int id) throws Exception {
		programmingLanguageService.delete(id);
	}

	@PutMapping("/update/{id}")
	public void update(int id, ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.update(id, programmingLanguage);
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();
	}

	@GetMapping("/findProgrammingLanguageById")
	public ProgrammingLanguage findProgrammingLanguageById(int id) throws Exception {
		return programmingLanguageService.findProgrammingLanguageById(id);
	}
}