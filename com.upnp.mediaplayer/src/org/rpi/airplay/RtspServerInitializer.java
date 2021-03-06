package org.rpi.airplay;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.rtsp.RtspRequestDecoder;
import io.netty.handler.codec.rtsp.RtspResponseEncoder;

public class RtspServerInitializer extends ChannelInitializer<NioSocketChannel> {

@Override
protected void initChannel(NioSocketChannel ch) throws Exception {
	ChannelPipeline p = ch.pipeline();
	//p.addLast(new LoggingHandler(LogLevel.DEBUG));
	p.addLast(new HttpObjectAggregator(1024*1024));
	p.addLast(new RtspRequestDecoder());
	p.addLast(new RtspResponseEncoder());
	//p.addLast("codec", new HttpServerCodec());
	p.addLast(new RtspRequestHandler());
	
}
}
