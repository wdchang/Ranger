package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.OrderFormTouristDao;
import cn.edu.tongji.ranger.model.OrderformTourist;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 马二爷 on 2016/5/2.
 */
@Repository("OrderFormTouristDao")
public class OrderFormTouristDaoImpl implements OrderFormTouristDao {
    @Autowired
    private SessionFactory sessionFactory;
    public List<OrderformTourist> getOrderFormTouristByOrderId(long orderId)
    {
        Session session=sessionFactory.getCurrentSession();
        String hql="FROM OrderformTourist ot WHERE ot.orderformId=:orderId";
        Query query=session.createQuery(hql);
        query.setParameter("orderId",orderId);
        return (List<OrderformTourist>)query.list();
    }
}
