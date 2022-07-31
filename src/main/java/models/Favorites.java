package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * いいねデータのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_FAV)
@NamedQueries({
	@NamedQuery(name = JpaConst.Q_FAV_COUNT, query = JpaConst.Q_FAV_COUNT_DEF),
})

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class Favorites {

	/**
	 * id
	 */
	@Id
	@Column(name = JpaConst.FAV_COL_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * id
	 */

	@Column(name = JpaConst.FAV_COL_EMP)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employee_id;

	/**
	 * id
	 */

	@Column(name = JpaConst.FAV_COL_REP)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer report_id;

}
