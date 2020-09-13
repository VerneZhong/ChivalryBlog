package com.chivalry.netty.protocol.mqtt;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttQoS;

/**
 * 发布 - 订阅 - 服务器
 * tcp
 * @author Mr.zxb
 * @date 2020-09-13 20:30:35
 */
public class MqttServer {
    private final EventLoopGroup bossGroup;
    private final EventLoopGroup workGroup;

    public static final int MQTT_PORT = 8000;

    private ServerBootstrap bootstrap;

    public MqttServer() {
        bossGroup = new NioEventLoopGroup(1);
        workGroup = new NioEventLoopGroup();
        bootstrap = new ServerBootstrap();
    }

    public void start() {
        try {
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new SimpleChannelInboundHandler<MqttMessage>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext ctx, MqttMessage msg) throws Exception {
                            MqttQoS mqttQoS = msg.fixedHeader().qosLevel();
                        }
                    });
            ChannelFuture channelFuture = bootstrap.bind(MQTT_PORT).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
