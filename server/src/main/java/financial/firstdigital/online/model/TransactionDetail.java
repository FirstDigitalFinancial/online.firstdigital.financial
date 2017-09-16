package financial.firstdigital.online.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * The TransactionDetail class contains information
 * about a transaction that has taken place on a
 * customers account
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

@Entity
@Table(name = "fdf_transactiondetail")
public class TransactionDetail {

    @Id
    @Column(name = "transactionId")
    private Long transactionId;

    @Column(name = "transactionType")
    private TransactionType transactionType;

    @Column(name = "tansactionValue")
    private BigDecimal transactionValue;

}
