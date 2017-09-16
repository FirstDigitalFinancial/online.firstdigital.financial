package financial.firstdigital.online.model;

/**
 * The AccountDetailJsonReponse class.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */
public class AccountDetailJsonReponse extends JsonResponse {

    private AccountDetail accountDetail;

    public AccountDetail getAccountDetail() {
        return accountDetail;
    }

    public void setAccountDetail(AccountDetail accountDetail) {
        this.accountDetail = accountDetail;
    }

    @Override
    public String toString() {
        return "AccountDetailJsonReponse{" +
                "accountDetail=" + accountDetail +
                '}';
    }
}
