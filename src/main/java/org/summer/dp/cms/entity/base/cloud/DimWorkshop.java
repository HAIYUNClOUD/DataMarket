/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:46:49
 * @desc 厂房
 */

package org.summer.dp.cms.entity.base.cloud;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "dim_workshop")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})//序列化成json是不序列化这两个属性否则会报错
public class DimWorkshop implements java.io.Serializable{
	private static final long serialVersionUID = -1L;
	
	//alias
	public static final String TABLE_ALIAS = "厂房";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_DIM_GEOG_ID = "dimGeogId";
	
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Long id;
	@Length(max=128)
	private java.lang.String name;
	
	private Long dimGeogId;
	//columns END


	public DimWorkshop(){
	}

	public DimWorkshop(
		Long id
	){
		this.id = id;
	}

	

	public void setId(Long value) {
		this.id = value;
	}
	
	
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 19)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table")
	@GenericGenerator(name = "table", strategy = "org.hibernate.id.MultipleHiLoPerTableGenerator", parameters = {
			@Parameter(name = "max_lo", value = "5") })//增长级别为5，可根据并发级别适当调整
	public Long getId() {
		return this.id;
	}
	
	@Column(name = "name", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	@Column(name = "dim_geog_id", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public Long getDimGeogId() {
		return this.dimGeogId;
	}
	
	public void setDimGeogId(Long value) {
		this.dimGeogId = value;
	}
	
	@JsonIgnore
	private List<DataNumber> dataNumbers = new ArrayList<DataNumber>(0);
	public void setDataNumbers(List<DataNumber> dataNumber){
		this.dataNumbers = dataNumber;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "dimWorkshop")
	public List<DataNumber> getDataNumbers() {
		return dataNumbers;
	}
	
	private DimGeog dimGeog;
	
	public void setDimGeog(DimGeog dimGeog){
		this.dimGeog = dimGeog;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "dim_geog_id",nullable = false, insertable = false, updatable = false)
	public DimGeog getDimGeog() {
		return dimGeog;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("DimGeogId",getDimGeogId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof DimWorkshop == false) return false;
		if(this == obj) return true;
		DimWorkshop other = (DimWorkshop)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

