package pe.com.bank.loan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.bank.loan.entity.LoanEntity;
import pe.com.bank.loan.repository.LoanRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {

    LoanRepository loanRepository;

    public Flux<LoanEntity> listAllLoan(){
        return loanRepository.findAll();
    }

    public Mono<LoanEntity> findLoanById(String id){
        return loanRepository.findById(id);
    }

    public Mono<LoanEntity> createLoan(LoanEntity loanEntity){
        return loanRepository.save(loanEntity);
    }

    public Mono<Void> deleteLoanById(String id) {
        return loanRepository.deleteById(id);
    }

    public Mono<LoanEntity> updateAccount(LoanEntity loanEntity, String id) {
        return loanRepository.findById(id)
                .flatMap(loan -> {
                    loan.setDebt(loanEntity.getDebt() != null ? loanEntity.getDebt() : loan.getDebt());
                    loan.setQuota(loanEntity.getQuota() != 0 ? loanEntity.getQuota() : loan.getQuota());
                    loan.setDebtStatus(loanEntity.getDebtStatus() != null ? loanEntity.getDebtStatus() : loan.getDebtStatus());
                    loan.setProductId(loanEntity.getProductId() != null ? loanEntity.getProductId() : loan.getProductId());
                    loan.setCustomerId(loanEntity.getCustomerId() != null ? loanEntity.getCustomerId() : loan.getCustomerId());
                    return loanRepository.save(loan);
                });
    }
    
    public Flux<LoanEntity> getLoanByProductId(String productId) {
        return loanRepository.findByProductId(productId);
    }
    
    public Flux<LoanEntity> getLoanByCustomerId(String customerId) {
        return loanRepository.findByCustomerId(customerId);
    }


}



