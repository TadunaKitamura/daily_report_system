package services;

import java.util.List;

import actions.views.FavoritesConverter;
import actions.views.FavoritesView;
import constants.JpaConst;
import models.Favorites;
import models.Report;

/**
 * いいねテーブルの操作に関わる処理を行うクラス
 */
public class FavoriteService extends ServiceBase {


    public List<FavoritesView> getPerPage(Integer employeeId,int page) {
//        List<Report> confirmations = em.createNamedQuery(JpaConst.Q_CON_GET_ALL, Report.class)
//                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
//                .setMaxResults(JpaConst.ROW_PER_PAGE)
//                .getResultList();
    	 List<Report> favorites = em.createNamedQuery(JpaConst.Q_FAV_GET_ALL, Report.class)
    			 .setParameter(1, employeeId.intValue())
                 .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                 .setMaxResults(JpaConst.ROW_PER_PAGE)
                 .getResultList();

        return FavoritesConverter.toViewList(favorites);
    }


    public long countAll() {
        long favorites_count = (long) em.createNamedQuery(JpaConst.Q_FAV_COUNT, Long.class)
                .getSingleResult();

        return favorites_count;
    }

    public void create(Favorites f) {
    	em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
}
    }

