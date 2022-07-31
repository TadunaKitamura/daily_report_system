package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.FavoritesView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import models.Favorites;
import services.FavoriteService;

/**
 * いいねに関わる処理を行うActionクラス
 *
 */
public class FavoritesAction extends ActionBase {

    private FavoriteService service;

    /**
     * メソッドを実行する
     */
    @Override
    public void process() throws ServletException, IOException {

        service = new FavoriteService();

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
			List<FavoritesView> favorites = service.getPerPage(ev.getId(),page);

			//全日報データの件数を取得
			long favoritesCount = service.countAll();

			putRequestScope(AttributeConst.FAVORITES, favorites); //取得した日報データ
			putRequestScope(AttributeConst.FAV_COUNT, favoritesCount); //全ての日報データの件数
			putRequestScope(AttributeConst.PAGE, page); //ページ数
			putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

			//セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
			String flush = getSessionScope(AttributeConst.FLUSH);
			if (flush != null) {
				putRequestScope(AttributeConst.FLUSH, flush);
				removeSessionScope(AttributeConst.FLUSH);
			}

			//一覧画面を表示
			forward(ForwardConst.FW_FAV_INDEX);
		}

		public void create() throws ServletException, IOException {
			//CSRF対策 tokenのチェック
			if (checkToken()) {

				//セッションからログイン中の従業員情報を取得
				EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

				//パラメータの値をもとに日報情報のインスタンスを作成する
				Favorites f = new Favorites(
						null,
						ev.getId(),
						toNumber(getRequestParam(AttributeConst.REP_ID))

						);

				//日報情報登録
				 service.create(f);

				//セッションに登録完了のフラッシュメッセージを設定
				putSessionScope(AttributeConst.FLUSH, MessageConst.I_FAVORITES.getMessage());

				//一覧画面にリダイレクト
				redirect(ForwardConst.ACT_FAV, ForwardConst.CMD_INDEX);
			}
		}
		}
