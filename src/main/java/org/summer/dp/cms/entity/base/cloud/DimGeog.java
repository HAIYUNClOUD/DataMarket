/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 13:12:03
 * @desc 地理位置维度
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
@Table(name = "dim_geog")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})//序列化成json是不序列化这两个属性否则会报错
public class DimGeog implements java.io.Serializable{
	private static final long serialVersionUID = -1L;
	
	//alias
	public static final String TABLE_ALIAS = "地理位置维度";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_TYPE = "1 国家 2省份 3城市 4具体区街道";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_PARENT_ID = "parentId";
	
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Long id;
	@Max(32767)
	private Short type;
	@Length(max=64)
	private java.lang.String name;
	
	private java.lang.Integer parentId;
	//columns END


	public DimGeog(){
	}

	public DimGeog(
		Long id
	){
		this.id = id;
	}

	

	public void setId(Long value) {
		this.id = value;
	}
	
	
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 19)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table")
	@GenericGenerator(name = "table", strategy = "org.hibernate.id.MultipleHiLoPerTableGenerator", parameters = {
			@Parameter(name = "max_lo", value = "5") })//增长级别为5，可根据并发级别适当调整
	public Long getId() {
		return this.id;
	}
	
	@Column(name = "type", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public Short getType() {
		return this.type;
	}
	
	public void setType(Short value) {
		this.type = value;
	}
	
	@Column(name = "name", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	@Column(name = "parent_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
	
	@JsonIgnore
	private List<DataNumber> dataNumbers = new ArrayList<DataNumber>(0);
	public void setDataNumbers(List<DataNumber> dataNumber){
		this.dataNumbers = dataNumber;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "dimGeog")
	public List<DataNumber> getDataNumbers() {
		return dataNumbers;
	}
	@JsonIgnore
	private List<DimWorkshop> dimWorkshops = new ArrayList<DimWorkshop>(0);
	public void setDimWorkshops(List<DimWorkshop> dimWorkshop){
		this.dimWorkshops = dimWorkshop;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "dimGeog")
	public List<DimWorkshop> getDimWorkshops() {
		return dimWorkshops;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Type",getType())
			.append("Name",getName())
			.append("ParentId",getParentId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof DimGeog == false) return false;
		if(this == obj) return true;
		DimGeog other = (DimGeog)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

