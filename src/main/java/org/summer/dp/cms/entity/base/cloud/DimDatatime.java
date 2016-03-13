/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:46:47
 * @desc 时间维度
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
@Table(name = "dim_datatime")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})//序列化成json是不序列化这两个属性否则会报错
public class DimDatatime implements java.io.Serializable{
	private static final long serialVersionUID = -1L;
	
	//alias
	public static final String TABLE_ALIAS = "时间维度";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_YEAR = "year";
	public static final String ALIAS_MONTH = "month";
	public static final String ALIAS_DAY = "day";
	public static final String ALIAS_HOUR = "hour";
	
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Long id;
	@Max(32767)
	private Short year;
	@Max(32767)
	private Short month;
	@Max(32767)
	private Short day;
	@Max(32767)
	private Short hour;
	//columns END


	public DimDatatime(){
	}

	public DimDatatime(
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
	
	@Column(name = "year", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public Short getYear() {
		return this.year;
	}
	
	public void setYear(Short value) {
		this.year = value;
	}
	
	@Column(name = "month", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public Short getMonth() {
		return this.month;
	}
	
	public void setMonth(Short value) {
		this.month = value;
	}
	
	@Column(name = "day", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public Short getDay() {
		return this.day;
	}
	
	public void setDay(Short value) {
		this.day = value;
	}
	
	@Column(name = "hour", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public Short getHour() {
		return this.hour;
	}
	
	public void setHour(Short value) {
		this.hour = value;
	}
	
	@JsonIgnore
	private List<DataNumber> dataNumbers = new ArrayList<DataNumber>(0);
	public void setDataNumbers(List<DataNumber> dataNumber){
		this.dataNumbers = dataNumber;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "dimDatatime")
	public List<DataNumber> getDataNumbers() {
		return dataNumbers;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Year",getYear())
			.append("Month",getMonth())
			.append("Day",getDay())
			.append("Hour",getHour())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof DimDatatime == false) return false;
		if(this == obj) return true;
		DimDatatime other = (DimDatatime)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

