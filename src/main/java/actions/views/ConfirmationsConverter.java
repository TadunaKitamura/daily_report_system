package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Report;

/**
 * 日報データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class ConfirmationsConverter {

//	/**
//	 * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
//	 * @param cv ConfirmationsViewのインスタンス
//	 * @return Confirmationsのインスタンス
//	 */
//	public static Confirmations toModel(ConfirmationsView cv) {
//		return new Confirmations(
//				cv.getId(),
//				cv.getEmployee_id(),
//				cv.getReport_id());
//	}

	/**
	 * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
	 * @param c Confirmationsのインスタンス
	 * @return ConfirmationsViewのインスタンス
	 */
	public static ConfirmationsView toView(Report r) {

		if (r == null) {
			return null;
		}

		return new ConfirmationsView(
				r.getId(),
				EmployeeConverter.toView(r.getEmployee()),
				r.getReportDate(),
				r.getTitle());
	}

	/**
	 * DTOモデルのリストからViewモデルのリストを作成する
	 * @param list DTOモデルのリスト
	 * @return Viewモデルのリスト
	 */
	public static List<ConfirmationsView> toViewList(List<Report> list) {
		List<ConfirmationsView> evs = new ArrayList<>();

		for (Report r : list) {
			evs.add(toView(r));
		}

		return evs;
	}

//	/**
//	 * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
//	 * @param c DTOモデル(コピー先)
//	 * @param cv Viewモデル(コピー元)
//	 */
//	public static void copyViewToModel(Confirmations c, ConfirmationsView cv) {
//		c.setId(cv.getId());
//		c.setEmployee_id(cv.getEmployee_id());
//		c.setReport_id(cv.getReport_id());
//
//
//	}

}
