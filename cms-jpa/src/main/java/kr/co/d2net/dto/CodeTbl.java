package kr.co.d2net.dto;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Cacheable(true)
@Entity
@IdClass(value=CodePK.class)
@Table(name="CODE_TBL")
public class CodeTbl{
	
	/**
	 * 공통코드에서 사용하는 그룹코드를 사전에 정의해 놓도록 한다.
	 * 코드의 value 값은 DB에 존재하는 코드와 동일해야 하고 동기화를 확인해야 한다.
	 * @author kms
	 * 사용: CodeEnum.CCLA.getCode()
	 */
	public static enum CodeEnum {
		CCLA("CCLA"), CTYP("CTYP"), CFMT("CFMT"), DECD("DECD"), DSCD("DSCD"),
		ERCD("ERCD"), RIST("RIST"), STAT("STAT"), WOST("WOST");
		
		private String code;
		
		private CodeEnum(String code) {
			this.code = code;
		}
		
		public String getCode() {
			return code;
		}
	}
	
	/**
	 * 공통코드의 키값은 자동 생성이 아니라 외부로부터 받기 때문에
	 * 추가 및 수정 요청 모두 키값은 존재하게 된다.
	 * DAO에서 인식할 수 있도록 add() or update() 구분을 해주도록 한다.
	 * codeTbl.add() or codeTbl.update()
	 * 
	 * @author kms
	 *
	 */
	public static enum Operator {
		ADD,
		UPDATE;
	}
	private Operator operator = Operator.ADD;
	public CodeTbl withOperator(Operator operator) {
		this.operator = operator;
		return this;
	}
	public Operator getOperator() {
		return operator;
	}
	
	public CodeTbl add() {
		return withOperator(Operator.ADD);
	}

	public CodeTbl update() {
		return withOperator(Operator.UPDATE);
	}
	
	public CodeTbl() {}

	@Id
	@Column(name="CLF_CD", length=4)
	private String clfCd;	//구분코드
	@Id
	@Column(name="SCL_CD", length=5)
	private String sclCd;	//구분상세코드
	
	public String getClfCd() {
		return clfCd;
	}

	public void setClfCd(String clfCd) {
		this.clfCd = clfCd;
	}

	public String getSclCd() {
		return sclCd;
	}

	public void setSclCd(String sclCd) {
		this.sclCd = sclCd;
	}
	
	@Column(name="CLF_NM", length=150, nullable=true)
	private String clfNM;	//구분명
	
	@Column(name="SCL_NM", length=150, nullable=true)
	private String sclNm;	//구분상세코드명
	
	@Column(name="CODE_CONT", length=150, nullable=true)
	private String codeCont;	//코드설명
	
	@Column(name="RMK_1", length=150, nullable=true)
	private String rmk1;	//비고1
	
	@Column(name="RMK_2", length=16, nullable=true)
	private String rmk2;	//비고2
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REG_DT", nullable=true)
	private Date regDt;	//등록일
	
	@Column(name="REGRID", length=30, nullable=true)
	private String regrId;	//등록자
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MOD_DT", nullable=true)
	private Date modDt;	//수정일
	
	@Column(name="MODRID", length=30, nullable=true)
	private String modrId;	//수정자
	
	@Column(name="CLF_GUBUN", length=30, nullable=true)
	private String clfGubun;	//S : 시스템 사용 코드 U : 유저사용코드
	
	@Column(name="USE_YN", columnDefinition="char(1) default 'Y'", nullable=true)
	private String useYn;	//사용여부
	
	@Transient
	private String gubun;	//조회구분 코드
	@Transient
	private String keyWord;	//검색단어
	@Transient
	private String createWay;	//생성방식
	
	
	
	public String getCreateWay() {
		return createWay;
	}

	public void setCreateWay(String createWay) {
		this.createWay = createWay;
	}

	public String getClfGubun() {
		return clfGubun;
	}

	public void setClfGubun(String clfGubun) {
		this.clfGubun = clfGubun;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getClfNM() {
		return clfNM;
	}
	public void setClfNM(String clfNM) {
		this.clfNM = clfNM;
	}

	public String getRmk1() {
		return rmk1;
	}
	public void setRmk1(String rmk1) {
		this.rmk1 = rmk1;
	}
	public String getRmk2() {
		return rmk2;
	}
	public void setRmk2(String rmk2) {
		this.rmk2 = rmk2;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public String getRegrId() {
		return regrId;
	}
	public void setRegrId(String regrId) {
		this.regrId = regrId;
	}
	public Date getModDt() {
		return modDt;
	}
	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}
	public String getModrId() {
		return modrId;
	}
	public void setModrId(String modrId) {
		this.modrId = modrId;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getSclNm() {
		return sclNm;
	}
	public void setSclNm(String sclNm) {
		this.sclNm = sclNm;
	}
	public String getDesc() {
		return codeCont;
	}
	public void setDesc(String codeCont) {
		this.codeCont = codeCont;
	}
	public String getCodeCont() {
		return codeCont;
	}
	public void setCodeCont(String codeCont) {
		this.codeCont = codeCont;
	}
	
}
