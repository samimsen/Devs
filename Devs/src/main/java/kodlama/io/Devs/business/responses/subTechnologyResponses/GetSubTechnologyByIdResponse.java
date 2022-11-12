package kodlama.io.Devs.business.responses.subTechnologyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSubTechnologyByIdResponse {
	int id;
	String name;
}