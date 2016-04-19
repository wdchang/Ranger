package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Account;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface AccountDao {
    public void create(Account account);
    public List<Account> findByName(String name);
}

/*public interface AccountDao extends GenericDAO <Account, Long> {

}*/
