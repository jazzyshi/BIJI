package com.jz.bigdata.myinternet.mynetty.catalina.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 加载自定义配置
 * @author Tom
 */
public class CustomConfig{
	
	private final static String PLACEHOLDER_START = "${";
	
	private static Map<String, String> ctx; 
	
	public static void load(String... props){
		new CustomConfig(props);
	}
	
	private CustomConfig(String... props){
		for (String path : props) {
			Properties p = new Properties();
			try {
				p.load(CustomConfig.class.getClassLoader().getResourceAsStream(path));
				
				resolvePlaceHolders(p);
				ctx = new HashMap<String, String>();  
		        for (Object key : p.keySet()) {  
		            String keyStr = key.toString();  
		            String value = p.getProperty(keyStr);  
		            ctx.put(keyStr, value);  
		        }
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	
	/**
	 * 获取已加载的配置信息
	 * @param key
	 * @return
	 */
    public static String getValue(String key) {  
        return ctx.get(key);
    }
	
	
	/**
	 * 获取已加载的配置信息
	 * @param key
	 * @return
	 */
    public static String getString(String key) {  
        return ctx.get(key);
    }
    
    /**
     * 获取已加载的配置信息
     * @param key
     * @return
     */
    public static int getInt(String key) {  
        return Integer.valueOf(ctx.get(key));
    }
    
    /**
     * 获取已加载的配置信息
     * @param key
     * @return
     */
    public static boolean getBoolean(String key) {  
        return Boolean.valueOf(ctx.get(key));
    }
    
    /**
     * 获取已加载的配置信息
     * @param key
     * @return
     */
    public static long getLong(String key) {  
        return Long.valueOf(ctx.get(key));
    }
    
    
    /**
     * 获取已加载的配置信息
     * @param key
     * @return
     */
    public static short getShort(String key) {  
        return Short.valueOf(ctx.get(key));
    }
    
    
    /**
     * 获取已加载的配置信息
     * @param key
     * @return
     */
    public static float getFloat(String key) {  
        return Float.valueOf(ctx.get(key));
    }
    
    
    /**
     * 获取已加载的配置信息
     * @param key
     * @return
     */
    public static double getDouble(String key) {  
        return Double.valueOf(ctx.get(key));
    }
    
    /**
     * 获取所有的key值
     * @return
     */
    public static Set<String> getKeys(){
    	return ctx.keySet();
    }
    
    
    /** 
     * 解析占位符 
     * @param properties 
     */  
    private void resolvePlaceHolders(Properties properties) {  
        Iterator<?> itr = properties.entrySet().iterator();  
        while ( itr.hasNext() ) {  
            final Map.Entry entry = ( Map.Entry ) itr.next();  
            final Object value = entry.getValue();  
            if ( value != null && String.class.isInstance( value ) ) {  
                final String resolved = resolvePlaceHolder(properties, (String)value );  
                if ( !value.equals( resolved ) ) {  
                    if ( resolved == null ) {  
                        itr.remove();  
                    }  
                    else {  
                        entry.setValue( resolved );  
                    }  
                }  
            }  
        }  
    }  
      
    /** 
     * 解析占位符具体操作 
     * @param property 
     * @return 
     */  
    private String resolvePlaceHolder(Properties prots,String value) {  
        if ( value.indexOf( PLACEHOLDER_START ) < 0 ) {  
            return value;  
        }  
        StringBuffer buff = new StringBuffer();  
        char[] chars = value.toCharArray();  
        for ( int pos = 0; pos < chars.length; pos++ ) {  
            if ( chars[pos] == '$' ) {  
                if ( chars[pos+1] == '{' ) {  
                    String key = "";  
                    int x = pos + 2;  
                    for (  ; x < chars.length && chars[x] != '}'; x++ ) {  
                    	key += chars[x];  
                        if ( x == chars.length - 1 ) {  
                            throw new IllegalArgumentException( "unmatched placeholder start [" + value + "]" );  
                        }  
                    }  
                    String val = extractFromSystem(prots, key);  
                    buff.append( val == null ? "" : val );  
                    pos = x + 1;  
                    if ( pos >= chars.length ) {  
                        break;  
                    }  
                }  
            }  
            buff.append( chars[pos] );  
        }  
        String rtn = buff.toString();  
        return isEmpty( rtn ) ? null : rtn;  
    } 
      

    /** 
     * 获得系统属性 当然 你可以选择从别的地方获取值 
     * @param systemPropertyName 
     * @return 
     */  
    private String extractFromSystem(Properties prots,String key) {  
        try {  
            return prots.getProperty(key);  
        }  
        catch( Throwable t ) {  
            return null;  
        }
    }  
      
    /** 
     * 判断字符串的空(null或者.length=0) 
     * @param string 
     * @return 
     */  
    private boolean isEmpty(String string) {  
        return string == null || string.length() == 0;  
    }
}
