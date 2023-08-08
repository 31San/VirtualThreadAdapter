package org.eu.miraikan;



import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.ThreadFactory;

public class VirtualEventLoopGroup extends NioEventLoopGroup {

   static ThreadFactory threadFactory = Thread.ofVirtual().factory();

    public VirtualEventLoopGroup(){
        super(0,threadFactory);
    }

}
