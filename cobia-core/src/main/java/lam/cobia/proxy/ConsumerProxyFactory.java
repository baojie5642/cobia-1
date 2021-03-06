package lam.cobia.proxy;

import lam.cobia.rpc.Consumer;
import lam.cobia.spi.Spiable;

@Spiable("jdk")
public interface ConsumerProxyFactory {

    public <T> T getConsumerProxy(Consumer<T> t);

}
