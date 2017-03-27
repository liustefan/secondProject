package  com.bithealth.sdk.common.cache.oscache;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 

import com.bithealth.sdk.common.cache.Cache;
//import com.opensymphony.oscache.base.NeedsRefreshException;
//import com.opensymphony.oscache.general.GeneralCacheAdministrator;
//extends GeneralCacheAdministrator
@SuppressWarnings("serial")
public class OsCache  implements Cache {

	private final static Log log = LogFactory.getLog(OsCache.class);
	
	@Override
	public Object get(String key) {
//
//		try {
//
//			return this.getFromCache(key,1000 * 60);
//
//		} catch (NeedsRefreshException e) {
//			log.error(e);
//			this.cancelUpdate(key);
//			
//		}
//		
		return null;

	}

	@Override
	public boolean isExist(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void put(String key, Object value, int expire) {
//		this.putInCache(key, value);

	}

	@Override
	public void put(String key, Object value) {
//		this.putInCache(key, value);
	}

	@Override
	public Object remove(String key) {

		return this.remove(key);

	}

	@Override
	public boolean replace(String key, Object value, Date expire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replace(String key, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

}
