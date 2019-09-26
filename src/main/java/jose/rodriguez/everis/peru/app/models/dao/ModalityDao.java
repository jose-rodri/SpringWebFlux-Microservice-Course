package jose.rodriguez.everis.peru.app.models.dao;

import jose.rodriguez.everis.peru.app.models.document.Modality;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface ModalityDao extends ReactiveMongoRepository<Modality, String> {

}
