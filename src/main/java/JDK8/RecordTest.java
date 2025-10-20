package JDK8;

import javax.validation.constraints.NotBlank; //javax istället för jakarta

public record RecordTest (@NotBlank name, int age) {//fungerar ej då java16+ krävs för record, NotBlank annotationer fungerar inte heller
}
