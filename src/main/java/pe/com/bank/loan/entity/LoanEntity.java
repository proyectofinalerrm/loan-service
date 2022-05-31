package pe.com.bank.loan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "loan")
public class LoanEntity {

    @Id
    private String loanId;
    private Double debt;
    private Date paymentDate;
    private Date endDate;
    private int quota;
    private String debtStatus;
    private int pendingQuota;
    private String productId;
    private String customerId;

}
