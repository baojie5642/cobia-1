package lam.cobia.core.util;
/**
* <p>
* cobia
* </p>
* @author linanmiao
* @date 2018年6月29日
* @version 1.0
*/
public class ParameterUtil {
	
	public static String getParameter(String key) {
		//priority level:env->java command->configure
		String value = System.getenv(key);
		if (value != null) {
			return value;
		}
		value = SystemProperties.getProperty(key);
		if (value != null) {
			return value;
		}
		//@TODO get parameter from configure
		//value = value of configure..
		return value;
	}
	
	public static int getParameterInt(String key) {
		String value = getParameter(key);
		return Integer.parseInt(value);
	}
	
	public static String getParameter(String key, String defaultValue) {
		String value = getParameter(key);
		if (value != null) {
			return value;
		}
		return defaultValue;
	}
	
	public static int getParameterInt(String key, int defaultValue) {
		try {
			String value = getParameter(key);
			if (value == null) {
				return defaultValue;
			}
			return Integer.parseInt(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static boolean getParameterBoolean(String key) {
		String value = getParameter(key);
		return Boolean.parseBoolean(value);
	}
	
	public static boolean getParameterBoolean(String key, boolean defaultValue) {
		try {
			String value = getParameter(key);
			if (value == null) {
				return defaultValue;
			}
			return Boolean.parseBoolean(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

}
