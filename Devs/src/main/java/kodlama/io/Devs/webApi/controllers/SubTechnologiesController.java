package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Devs.business.requests.subTechnologyRequests.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologyRequests.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologyRequests.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.subTechnologyResponses.GetAllSubTechnologiesResponse;
import kodlama.io.Devs.business.responses.subTechnologyResponses.GetSubTechnologyByIdResponse;
import kodlama.io.Devs.entity.concretes.SubTechnology;

@RestController
@RequestMapping("/api/subTechnologies")
public class SubTechnologiesController {

	private SubTechnologyService subTechnologyService;

	@Autowired
	public SubTechnologiesController(SubTechnologyService subTechnologyService) {
		this.subTechnologyService = subTechnologyService;
	}

	@PostMapping("/add")
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		this.subTechnologyService.add(createSubTechnologyRequest);
	}

	@PutMapping("/update")
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		this.subTechnologyService.update(updateSubTechnologyRequest);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		this.subTechnologyService.delete(deleteSubTechnologyRequest);
	}

	@GetMapping("/getall")
	public List<GetAllSubTechnologiesResponse> getAll() {
		return this.subTechnologyService.getAll();
	}
	
	@GetMapping("/getSubTechnologyById/{id}")
	public GetSubTechnologyByIdResponse getSubTechnologyByIdResponse(int id) {
		return this.subTechnologyService.getSubTechnologyByIdResponse(id);
	}
}