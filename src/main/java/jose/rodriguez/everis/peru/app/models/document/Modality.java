package jose.rodriguez.everis.peru.app.models.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "modalities")
public class Modality {

  
  private String id;
  
  private String StudentModality;

  public Modality(String studentModality) {
    
    StudentModality = studentModality;
  }
  
  
  
  
}
