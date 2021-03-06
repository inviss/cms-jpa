package kr.co.d2net.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name="BUSI_PARTNER_TBL")
public class BusiPartnerTbl extends BaseObject {
	
	@Id
	@TableGenerator(name = "BUSIPARTNER_ID_SEQ", table = "ID_GEN_TBL", 
	pkColumnName = "ENTITY_NAME", pkColumnValue = "BUSIPARTNER_ID_SEQ", valueColumnName = "VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "BUSIPARTNER_ID_SEQ")
	@BusinessKey
	@Column(name="BUSI_PARTNERID", length=30)
	private Long busiPartnerId;	//사업자ID

	@Column(name="REGRID", length=30, nullable=true)
	private String regrId;	//수정자ID

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REG_DT", nullable=true)
	private Date regDt;	//수정일시

	@Column(name="MODRID", length=30, nullable=true)
	private String modrId;	//등록자ID
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MOD_DT", nullable=true)
	private Date modDt;	//등록일시

	@Column(name="PASSWORD", length=40, nullable=true)
	private String password;	//패스워드

	@Column(name="COMPANY", length=30, nullable=true)
	private String company;	//업체명

	@Column(name="SERVYN", columnDefinition="char(1) default 'Y'", nullable=true)
	private String servYn;	//사용여부

	@Column(name="FTP_SERV_YN", columnDefinition="char(1) default 'Y'", nullable=true)
	private String ftpServYn;	//	FTP 서비스 여부

	@Column(name="IP", length=255, nullable=true)
	private String ip;	//아이피

	@Column(name="PORT", length=255, nullable=true)
	private String port;	//포트

	@Column(name="TRANS_METHOD", length=20, nullable=true)
	private String transMethod;	//전송방식

	@Column(name="REMOTE_DIR", length=30, nullable=true)
	private String remoteDir;	//전송 타겟 디렉토리

	@Column(name="FTPID", length=50, nullable=true)
	private String ftpId;	//FTP ID

	@Column(name="SRV_URL", columnDefinition="char(1) default 'Y'", nullable=true)
	private String srvUrl;	//프로그램코드
	
	@Transient
	private String tmpProflId;
	
	@Transient
	private String tmpBusiPartnerId;


	public String getTmpBusiPartnerId() {
		return tmpBusiPartnerId;
	}

	public void setTmpBusiPartnerId(String tmpBusiPartnerId) {
		this.tmpBusiPartnerId = tmpBusiPartnerId;
	}

	public String getTmpProflId() {
		return tmpProflId;
	}

	public void setTmpProflId(String tmpProflId) {
		this.tmpProflId = tmpProflId;
	}

	public String getRegrId() {
		return regrId;
	}

	public void setRegrId(String regrId) {
		this.regrId = regrId;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public String getModrId() {
		return modrId;
	}

	public void setModrId(String modrId) {
		this.modrId = modrId;
	}

	public Date getModDt() {
		return modDt;
	}

	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getServYn() {
		return servYn;
	}

	public void setServYn(String servYn) {
		this.servYn = servYn;
	}

	public String getFtpServYn() {
		return ftpServYn;
	}

	public void setFtpServYn(String ftpServYn) {
		this.ftpServYn = ftpServYn;
	}
	
	
	public Long getBusiPartnerId() {
		return busiPartnerId;
	}

	public void setBusiPartnerId(Long busiPartnerId) {
		this.busiPartnerId = busiPartnerId;
	}



	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getTransMethod() {
		return transMethod;
	}

	public void setTransMethod(String transMethod) {
		this.transMethod = transMethod;
	}

	public String getRemoteDir() {
		return remoteDir;
	}

	public void setRemoteDir(String remoteDir) {
		this.remoteDir = remoteDir;
	}

	public String getFtpId() {
		return ftpId;
	}

	public void setFtpId(String ftpId) {
		this.ftpId = ftpId;
	}

	public String getSrvUrl() {
		return srvUrl;
	}

	public void setSrvUrl(String srvUrl) {
		this.srvUrl = srvUrl;
	}

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(targetEntity=BusiPartnerCategoryTbl.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="busiPartnerTbl")
	private Set<BusiPartnerCategoryTbl> busiPartner;


	public Set<BusiPartnerCategoryTbl> getBusiPartner() {
		return busiPartner;
	}

	public void setBusiPartner(Set<BusiPartnerCategoryTbl> busiPartner) {
		this.busiPartner = busiPartner;
	}

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(targetEntity=ProBusiTbl.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="busiPartnerTbl")
	private Set<ProBusiTbl> proBusi;


	public Set<ProBusiTbl> getProBusi() {
		return proBusi;
	}

	public void setProBusi(Set<ProBusiTbl> proBusi) {
		this.proBusi = proBusi;
	}
	
	
}
