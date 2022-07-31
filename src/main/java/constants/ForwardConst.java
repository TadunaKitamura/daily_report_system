package constants;

/**
 * リクエストパラメーターの変数名、変数値、jspファイルの名前等画面遷移に関わる値を定義するEnumクラス
 *
 */
public enum ForwardConst {

	//action
	ACT("action"),
	ACT_TOP("Top"), ACT_EMP("Employee"), ACT_REP("Report"), ACT_AUTH("Auth"), ACT_FAV("Favorites"),
	ACT_CON("Confirmations"),

	//command
	CMD("command"), CMD_NONE(""), CMD_INDEX("index"), CMD_SHOW("show"), CMD_SHOW_LOGIN("showLogin"), CMD_LOGIN(
			"login"), CMD_LOGOUT("logout"), CMD_NEW(
					"entryNew"), CMD_CREATE("create"), CMD_EDIT("edit"), CMD_UPDATE("update"), CMD_DESTROY("destroy"),
	CMD_FAV("favorites"),CMD_FAV_LIST("favList"),CMD_CON("confirmations"),

	//jsp
	FW_ERR_UNKNOWN("error/unknown"), FW_TOP_INDEX("topPage/index"), FW_LOGIN("login/login"), FW_EMP_INDEX(
			"employees/index"), FW_EMP_SHOW("employees/show"), FW_EMP_NEW("employees/new"), FW_EMP_EDIT(
					"employees/edit"), FW_REP_INDEX("reports/index"), FW_REP_SHOW(
							"reports/show"), FW_REP_NEW("reports/new"), FW_REP_EDIT("reports/edit"),
	FW_FAV_INDEX("favorites/index"),FW_FAV_SHOW("favorites/show"),FW_FAV_LIST("favorites/list"),
	FW_FAV_RANK("favorites/rank"),FW_FAV_MRANK("favorites/mrank"),FW_FAV_YRANK("favorites/yrank"),
	FW_CON_INDEX("confirmations/index"),FW_CON_SHOW("confirmations/show");

	/**
	 * 文字列
	 */
	private final String text;

	/**
	 * コンストラクタ
	 */
	private ForwardConst(final String text) {
		this.text = text;
	}

	/**
	 * 値(文字列)取得
	 */
	public String getValue() {
		return this.text;
	}

}
