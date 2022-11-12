package kodlama.io.Devs.business.requests.subTechnologyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubTechnologyRequest {
	private int id;
	private String name;
	private int programmingLanguageId;
}