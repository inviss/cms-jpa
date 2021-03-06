package kr.co.d2net.dto;

import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;




@StaticMetamodel(EpisodeTbl.class)
public abstract class EpisodeTbl_ {
	public static volatile SingularAttribute<EpisodeTbl, Integer> categoryId;		//카테고리ID
	public static volatile SingularAttribute<EpisodeTbl, Integer> episodeId;		//에피소드ID
	
	public static volatile SingularAttribute<EpisodeTbl, String> useYn;			//사용여부
	public static volatile SingularAttribute<EpisodeTbl, String> regrId;			//등록자Id
	public static volatile SingularAttribute<EpisodeTbl, Date> regDt;				//등록일시
	public static volatile SingularAttribute<EpisodeTbl, String> modrId;			//수정자아이디
	public static volatile SingularAttribute<EpisodeTbl, Date> modDt;				//수정일시
	public static volatile SingularAttribute<EpisodeTbl, String> episodeNm;		//회차명
	
	public static volatile SingularAttribute<EpisodeTbl, CategoryTbl> categoryTbl;
	public static volatile SetAttribute<EpisodeTbl, SegmentTbl> segmentTbls;
}
