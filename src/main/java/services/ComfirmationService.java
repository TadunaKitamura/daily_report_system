package services;

import java.util.List;

import actions.views.ConfirmationsConverter;
import actions.views.ConfirmationsView;
import constants.JpaConst;
import models.Confirmations;
import models.Report;

/**
 * 確認しますテーブルの操作に関わる処理を行うクラス
 */
public class ComfirmationService extends ServiceBase {


    public List<ConfirmationsView> getPerPage(Integer employeeId,int page) {
//        List<Report> confirmations = em.createNamedQuery(JpaConst.Q_CON_GET_ALL, Report.class)
//                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
//                .setMaxResults(JpaConst.ROW_PER_PAGE)
//                .getResultList();
    	 List<Report> confirmations = em.createNamedQuery(JpaConst.Q_CON_GET_ALL, Report.class)
    			 .setParameter(1, employeeId.intValue())
                 .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                 .setMaxResults(JpaConst.ROW_PER_PAGE)
                 .getResultList();

        return ConfirmationsConverter.toViewList(confirmations);
    }

    public long countAll() {
        long confirmations_count = (long) em.createNamedQuery(JpaConst.Q_CON_COUNT, Long.class)
                .getSingleResult();

        return confirmations_count;
    }

    public void create(Confirmations c) {
    	em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();



    }





}
