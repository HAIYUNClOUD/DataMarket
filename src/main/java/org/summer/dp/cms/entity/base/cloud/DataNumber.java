/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:46:42
 * @desc 数据表
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
@Table(name = "data_number")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})//序列化成json是不序列化这两个属性否则会报错
public class DataNumber implements java.io.Serializable{
	private static final long serialVersionUID = -1L;
	
	//alias
	public static final String TABLE_ALIAS = "数据表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_WATER_NUMBER = "水量(吨)";
	public static final String ALIAS_WARN_NUMBER = "暖量(立方)";
	public static final String ALIAS_ELECTRIC_NUMBER = "电量(度)";
	public static final String ALIAS_PRODUCTION_NUMBER = "产量(辆)";
	public static final String ALIAS_SALE_NUMBER = "销量(辆)";
	public static final String ALIAS_GAS_NUMBER = "气量(立方)";
	public static final String ALIAS_TEMPERATURE = "温度";
	public static final String ALIAS_DIM_TYPE_ID = "类型维度";
	public static final String ALIAS_DIM_DATETIME_ID = "时间维度";
	public static final String ALIAS_DIM_GEOG_ID = "地理位置维度";
	public static final String ALIAS_DIM_WORKSHOP_ID = "厂房维度";
	
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Long id;
	
	private java.lang.Integer waterNumber;
	
	private java.lang.Integer warnNumber;
	
	private java.lang.Integer electricNumber;
	
	private Long productionNumber;
	
	private Long saleNumber;
	
	private Long gasNumber;
	
	private java.lang.Integer temperature;
	
	private Long dimTypeId;
	
	private Long dimDatetimeId;
	
	private Long dimGeogId;
	
	private Long dimWorkshopId;
	//columns END


	public DataNumber(){
	}

	public DataNumber(
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
	
	@Column(name = "water_number", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getWaterNumber() {
		return this.waterNumber;
	}
	
	public void setWaterNumber(java.lang.Integer value) {
		this.waterNumber = value;
	}
	
	@Column(name = "warn_number", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getWarnNumber() {
		return this.warnNumber;
	}
	
	public void setWarnNumber(java.lang.Integer value) {
		this.warnNumber = value;
	}
	
	@Column(name = "electric_number", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getElectricNumber() {
		return this.electricNumber;
	}
	
	public void setElectricNumber(java.lang.Integer value) {
		this.electricNumber = value;
	}
	
	@Column(name = "production_number", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public Long getProductionNumber() {
		return this.productionNumber;
	}
	
	public void setProductionNumber(Long value) {
		this.productionNumber = value;
	}
	
	@Column(name = "sale_number", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public Long getSaleNumber() {
		return this.saleNumber;
	}
	
	public void setSaleNumber(Long value) {
		this.saleNumber = value;
	}
	
	@Column(name = "gas_number", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public Long getGasNumber() {
		return this.gasNumber;
	}
	
	public void setGasNumber(Long value) {
		this.gasNumber = value;
	}
	
	@Column(name = "temperature", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getTemperature() {
		return this.temperature;
	}
	
	public void setTemperature(java.lang.Integer value) {
		this.temperature = value;
	}
	
	@Column(name = "dim_type_id", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public Long getDimTypeId() {
		return this.dimTypeId;
	}
	
	public void setDimTypeId(Long value) {
		this.dimTypeId = value;
	}
	
	@Column(name = "dim_datetime_id", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public Long getDimDatetimeId() {
		return this.dimDatetimeId;
	}
	
	public void setDimDatetimeId(Long value) {
		this.dimDatetimeId = value;
	}
	
	@Column(name = "dim_geog_id", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public Long getDimGeogId() {
		return this.dimGeogId;
	}
	
	public void setDimGeogId(Long value) {
		this.dimGeogId = value;
	}
	
	@Column(name = "dim_workshop_id", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public Long getDimWorkshopId() {
		return this.dimWorkshopId;
	}
	
	public void setDimWorkshopId(Long value) {
		this.dimWorkshopId = value;
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
	
	private DimDatatime dimDatatime;
	
	public void setDimDatatime(DimDatatime dimDatatime){
		this.dimDatatime = dimDatatime;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "dim_datetime_id",nullable = false, insertable = false, updatable = false)
	public DimDatatime getDimDatatime() {
		return dimDatatime;
	}
	
	private DimWorkshop dimWorkshop;
	
	public void setDimWorkshop(DimWorkshop dimWorkshop){
		this.dimWorkshop = dimWorkshop;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "dim_workshop_id",nullable = false, insertable = false, updatable = false)
	public DimWorkshop getDimWorkshop() {
		return dimWorkshop;
	}
	
	private DimType dimType;
	
	public void setDimType(DimType dimType){
		this.dimType = dimType;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "dim_type_id",nullable = false, insertable = false, updatable = false)
	public DimType getDimType() {
		return dimType;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("WaterNumber",getWaterNumber())
			.append("WarnNumber",getWarnNumber())
			.append("ElectricNumber",getElectricNumber())
			.append("ProductionNumber",getProductionNumber())
			.append("SaleNumber",getSaleNumber())
			.append("GasNumber",getGasNumber())
			.append("Temperature",getTemperature())
			.append("DimTypeId",getDimTypeId())
			.append("DimDatetimeId",getDimDatetimeId())
			.append("DimGeogId",getDimGeogId())
			.append("DimWorkshopId",getDimWorkshopId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof DataNumber == false) return false;
		if(this == obj) return true;
		DataNumber other = (DataNumber)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

