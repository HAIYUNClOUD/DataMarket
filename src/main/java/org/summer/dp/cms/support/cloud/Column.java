package org.summer.dp.cms.support.cloud;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Column {
	public final static String electric_quantity = "electric_quantity";
	public final static String phase_a_power = "phase_a_power";
	public final static String phase_b_power = "phase_b_power";
	public final static String phase_c_power = "phase_c_power";
	public final static String current_a = "current_a";
	public final static String current_b = "current_b";
	public final static String current_c = "current_c";
	public final static String voltage_a = "voltage_a";
	public final static String voltage_b = "voltage_b";
	public final static String voltage_c = "voltage_c";
	public final static String water_instantaneous_current = "water_instantaneous_current";
	public final static String water_accumulate_current = "water_accumulate_current";
	public final static String water_pressure = "water_pressure";
	public final static String gas_instantaneous_current = "gas_instantaneous_current";
	public final static String gas_accumulate_current = "gas_accumulate_current";
	public final static String gas_pressure = "gas_pressure";
	public final static String compressed_air_instantaneous_current = "compressed_air_instantaneous_current";
	public final static String compressed_air_accumulate_current = "compressed_air_accumulate_current";
	public final static String compressed_air_pressure = "compressed_air_pressure";
	public final static String compressed_air_dew_point = "compressed_air_dew_point";
	public final static String vapour_air_instantaneous_current = "vapour_air_instantaneous_current";
	public final static String vapour_air_accumulate_current = "vapour_air_accumulate_current";
	public final static String vapour_pressure = "vapour_pressure";
	public final static String vapour_temperature = "vapour_temperature";
	public final static String air_conditioner_water_instantaneous_current = "air_conditioner_water_instantaneous_current";
	public final static String air_conditioner_water_instantaneous_cooling = "air_conditioner_water_instantaneous_cooling";
	public final static String air_conditioner_water_accumulate_current = "air_conditioner_water_accumulate_current";
	public final static String air_conditioner_water_accumulate_cooling = "air_conditioner_water_accumulate_cooling";
	public final static String air_conditioner_water_output_pressure = "air_conditioner_water_output_pressure";
	public final static String air_conditioner_water_input_pressure = "air_conditioner_water_input_pressure";
	public final static String air_conditioner_water_output_temperature = "air_conditioner_water_output_temperature";
	public final static String air_conditioner_water_input_temperature = "air_conditioner_water_input_temperature";
	public final static String warn_water_instantaneous_current = "warn_water_instantaneous_current";
	public final static String warn_water_instantaneous_cooling = "warn_water_instantaneous_cooling";
	public final static String warn_water_accumulate_current = "warn_water_accumulate_current";
	public final static String warn_water_accumulate_cooling = "warn_water_accumulate_cooling";
	public final static String warn_water_output_pressure = "warn_water_output_pressure";
	public final static String warn_water_input_pressure = "warn_water_input_pressure";
	public final static String warn_water_output_temperature = "warn_water_output_temperature";
	public final static String warn_water_input_temperature = "warn_water_input_temperature";
	public final static String env_temperature = "env_temperature";
	public final static String env_humidity = "env_humidity";
	public static Set<String> columnSet = new HashSet<String>();

	public static void init(){
		if(columnSet.size()==0){
			Class<?> clz = new Column().getClass();  
			Field[] fields = clz.getDeclaredFields();  
			for(Field filed : fields){
				columnSet.add(filed.getName());
			}
		}
	}
	

	public static void main(String[] args) {
		Column.init();
		for(String str : columnSet){
			System.out.println(str);
		}
	}
}
