package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.ConfirmationsView;
import actions.views.EmployeeView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import models.Confirmations;
import services.ComfirmationService;

/**
 * いいねに関わる処理を行うActionクラス
 *
 */
public class ConfirmationsAction extends ActionBase {

		private ComfirmationService service;

		/**
		 * メソッドを実行する
		 */
		@Override
		public void process() throws ServletException, IOException {

			service = new ComfirmationService();

			//メソッドを実行
			invoke();
			service.close();
		}

		/**
		 * 一覧画面を表示する
		 * @throws ServletException
		 * @throws IOException
		 */
		public void index() throws ServletException, IOException {

			//セッションからログイン中の従業員情報を取得
			EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

			//指定されたページ数の一覧画面に表示する日報データを取得
			int page = getPage();
			List<ConfirmationsView> confirmations = service.getPerPage(ev.getId(),page);

			//全日報データの件数を取得
			long confirmationsCount = service.countAll();

			putRequestScope(AttributeConst.CONFIRMATIONS, confirmations); //取得した日報データ
			putRequestScope(AttributeConst.CON_COUNT, confirmationsCount); //全ての日報データの件数
			putRequestScope(AttributeConst.PAGE, page); //ページ数
			putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

			//セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
			String flush = getSessionScope(AttributeConst.FLUSH);
			if (flush != null) {
				putRequestScope(AttributeConst.FLUSH, flush);
				removeSessionScope(AttributeConst.FLUSH);
			}

			//一覧画面を表示
			forward(ForwardConst.FW_CON_INDEX);
		}

		public void create() throws ServletException, IOException {
			//CSRF対策 tokenのチェック
			if (checkToken()) {

				//セッションからログイン中の従業員情報を取得
				EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

				//TODO　管理者以外登録できない制御を入れる
				if (ev.getAdminFlag() != AttributeConst.ROLE_ADMIN.getIntegerValue()) {

					forward(ForwardConst.FW_ERR_UNKNOWN);

				}

				//パラメータの値をもとに日報情報のインスタンスを作成する
				Confirmations c = new Confirmations(
						null,
						ev.getId(),
						toNumber(getRequestParam(AttributeConst.REP_ID))

						);

				//日報情報登録
				 service.create(c);

				//セッションに登録完了のフラッシュメッセージを設定
				putSessionScope(AttributeConst.FLUSH, MessageConst.I_CONFIRMATIONS.getMessage());

				//一覧画面にリダイレクト
				redirect(ForwardConst.ACT_CON, ForwardConst.CMD_INDEX);
			}
			}
		}


///**
//* 詳細画面を表示する
//* @throws ServletException
//* @throws IOException
//*/
//public void show() throws ServletException, IOException {
//
////idを条件に日報データを取得する
//ReportView rv = service.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));
//
//if (rv == null) {
//	//該当の日報データが存在しない場合はエラー画面を表示
//	forward(ForwardConst.FW_ERR_UNKNOWN);
//
//} else {
//
//	putRequestScope(AttributeConst.REPORT, rv); //取得した日報データ
//
//	//詳細画面を表示
//	forward(ForwardConst.FW_REP_SHOW);
//
//}
//}


