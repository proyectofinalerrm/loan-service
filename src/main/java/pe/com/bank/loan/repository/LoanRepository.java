package pe.com.bank.loan.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bank.loan.entity.LoanEntity;
import reactor.core.publisher.Flux;

@Repository
public interface LoanRepository extends ReactiveMongoRepository<LoanEntity,String> {
	
	Flux<LoanEntity> findByProductId(String productId);
	Flux<LoanEntity> findByCustomerId(String customerId);

}
