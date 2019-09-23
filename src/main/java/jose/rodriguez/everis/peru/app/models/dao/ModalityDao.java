package jose.rodriguez.everis.peru.app.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import jose.rodriguez.everis.peru.app.models.document.Modality;

public interface ModalityDao extends ReactiveMongoRepository<Modality, String> {

}
