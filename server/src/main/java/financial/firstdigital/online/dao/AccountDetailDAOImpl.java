package financial.firstdigital.online.dao;

import financial.firstdigital.online.model.AccountDetail;
import financial.firstdigital.online.model.AccountStatus;
import financial.firstdigital.online.model.Currency;
import org.springframework.stereotype.Repository;

@Repository("accountDetailDAO")
public class AccountDetailDAOImpl implements AccountDetailDAO {


    public AccountDetail getAccountDetailByAccountNumber(Long accountNumber) {

        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setStatus(AccountStatus.OPEN);
        accountDetail.setCurrency(Currency.ETHEREUM);
        accountDetail.setAddress("0xC38Df9faA80F068675096f0a6da964862E90892B");
        accountDetail.setAccountNumber(accountNumber);

        return accountDetail;

    }

}
