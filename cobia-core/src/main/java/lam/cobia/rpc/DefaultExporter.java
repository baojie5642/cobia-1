package lam.cobia.rpc;
/**
* <p>
* default exporter
* </p>
* @author linanmiao
* @date 2018年1月2日
* @version 1.0
*/
public class DefaultExporter<T> implements Exporter<T> {

	//private final Invoker<T> invoker;
	private final Provider<T> provider;
	
	private final String key;
	
	private volatile boolean closed = false;
	
	public DefaultExporter(Provider<T> provider, String key) {
		this.provider = provider;
		this.key = key;
	}
	
	@Override
	public String getKey() {
		return key;
	}
	
	@Override
	public Provider<T> getProvider() {
		return this.provider;
	}

	@Override
	public void close() {
		if (!closed) {
			closed = true;
			getProvider().close();
		}
	}

}
