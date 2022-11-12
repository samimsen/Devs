package kodlama.io.Devs.business.responses.programmingLanguageResponses;

import java.util.List;

import kodlama.io.Devs.entity.concretes.SubTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProgrammingLanguageByIdResponce {
	private int id;
	private String name;
	private List<SubTechnology> subTechnologies;
}