package financial.firstdigital.online.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * The CustomerDetail class contains information
 * about the customer
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

@Entity
@Table(name = "fdf_customerdetail")
public class CustomerDetail {

    @Id
    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "firstName", length = 50)
    @Size(max = 50)
    private String firstName;

    @Column(name = "lastName", length = 50)
    @Size(max = 50)
    private String lastName;

    @Column(name = "otherNames", length = 250)
    @Size(max = 250)
    private String otherNames;

    @Column(name = "gender")
    private Gender gender;

}
