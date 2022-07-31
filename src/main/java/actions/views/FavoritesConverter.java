package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Report;

/**
 * 日報データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class FavoritesConverter {

	/**
	 * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
	 * @param fv FavoritesViewのインスタンス
	 * @return Favoritesのインスタンス
	 */
	public static FavoritesView toView(Report r) {

		if (r == null) {
			return null;
		}

		return new FavoritesView(
				r.getId(),
				EmployeeConverter.toView(r.getEmployee()),
				r.getReportDate(),
				r.getTitle());
	}

	public static List<FavoritesView> toViewList(List<Report> list) {
		List<FavoritesView> evs = new ArrayList<>();

		for (Report r : list) {
			evs.add(toView(r));
		}

		return evs;
	}

//
//
//	public static Favorites toModel(FavoritesView fv) {
//		return new Favorites(
//				fv.getId(),
//				fv.getEmployee_id(),
//				fv.getReport_id());
//	}
//
//	/**
//	 * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
//	 * @param f Favoritesのインスタンス
//	 * @return FavoritesViewのインスタンス
//	 */
//	public static FavoritesView toView(Favorites f) {
//
//		if (f == null) {
//			return null;
//		}
//
//		return new FavoritesView(
//				f.getId(),
//				f.getEmployee_id(),
//				f.getReport_id());
//	}
//
//	/**
//	 * DTOモデルのリストからViewモデルのリストを作成する
//	 * @param list DTOモデルのリスト
//	 * @return Viewモデルのリスト
//	 */
//	public static List<FavoritesView> toViewList(List<Favorites> list) {
//		List<FavoritesView> fvs = new ArrayList<>();
//
//		for (Favorites f : list) {
//			fvs.add(toView(f));
//		}
//
//		return fvs;
//	}
//
//	/**
//	 * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
//	 * @param f DTOモデル(コピー先)
//	 * @param fv Viewモデル(コピー元)
//	 */
//	public static void copyViewToModel(Favorites f, FavoritesView fv) {
//		f.setId(fv.getId());
//		f.setEmployee_id(fv.getEmployee_id());
//		f.setReport_id(fv.getReport_id());
//
//
//	}

}
