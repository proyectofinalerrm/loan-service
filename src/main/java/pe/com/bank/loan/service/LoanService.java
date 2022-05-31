package pe.com.bank.loan.service;

import pe.com.bank.loan.entity.LoanEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanService {

    Flux<LoanEntity> listAllLoan();

    Mono<LoanEntity> findLoanById(String id);

    public Mono<LoanEntity> createLoan(LoanEntity loanEntity);

    public Mono<Void> deleteLoanById(String id);

    public Mono<LoanEntity> updateAccount(LoanEntity loanEntity, String id);
    
    public Flux<LoanEntity> getLoanByProductId(String productId);
    
    public Flux<LoanEntity> getLoanByCustomerId(String customerId);
    
}
