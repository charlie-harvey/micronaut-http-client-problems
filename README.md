## Http Client Read Timeout Example

Got the errors with both Java17 and Java21

### Run httpbun locally
```shell
docker run -p 80:80 sharat87/httpbun
```

### Run the tests
```shell
./gradlew test --info
```

### Read Timeout Exception
```shell
com.example.ExampleControllerTest > testController FAILED
    io.micronaut.http.client.exceptions.ReadTimeoutException: Read Timeout
        at app//io.micronaut.http.client.exceptions.ReadTimeoutException.<clinit>(ReadTimeoutException.java:26)
        at app//io.micronaut.http.client.netty.DefaultHttpClient$BaseHttpResponseHandler.exceptionCaught(DefaultHttpClient.java:2084)
        at app//io.micronaut.http.client.netty.DefaultHttpClient$FullHttpResponseHandler.exceptionCaught(DefaultHttpClient.java:2318)
        at app//io.netty.channel.AbstractChannelHandlerContext.invokeExceptionCaught(AbstractChannelHandlerContext.java:346)
        at app//io.netty.channel.AbstractChannelHandlerContext.invokeExceptionCaught(AbstractChannelHandlerContext.java:325)
        at app//io.netty.channel.AbstractChannelHandlerContext.fireExceptionCaught(AbstractChannelHandlerContext.java:317)
        at app//io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext.fireExceptionCaught(CombinedChannelDuplexHandler.java:424)
        at app//io.netty.channel.ChannelHandlerAdapter.exceptionCaught(ChannelHandlerAdapter.java:92)
        at app//io.netty.channel.CombinedChannelDuplexHandler$1.fireExceptionCaught(CombinedChannelDuplexHandler.java:145)
        at app//io.netty.channel.ChannelInboundHandlerAdapter.exceptionCaught(ChannelInboundHandlerAdapter.java:143)
        at app//io.netty.channel.CombinedChannelDuplexHandler.exceptionCaught(CombinedChannelDuplexHandler.java:231)
        at app//io.netty.channel.AbstractChannelHandlerContext.invokeExceptionCaught(AbstractChannelHandlerContext.java:346)
        at app//io.netty.channel.AbstractChannelHandlerContext.invokeExceptionCaught(AbstractChannelHandlerContext.java:325)
        at app//io.netty.channel.AbstractChannelHandlerContext.fireExceptionCaught(AbstractChannelHandlerContext.java:317)
        at app//io.micronaut.http.client.netty.ConnectionManager$Pool$Http1ConnectionHolder.fireReadTimeout(ConnectionManager.java:1315)
        at app//io.micronaut.http.client.netty.ConnectionManager$Pool$ConnectionHolder$1.readTimedOut(ConnectionManager.java:1148)
        at app//io.netty.handler.timeout.ReadTimeoutHandler.channelIdle(ReadTimeoutHandler.java:90)
        at app//io.netty.handler.timeout.IdleStateHandler$ReaderIdleTimeoutTask.run(IdleStateHandler.java:525)
        at app//io.netty.handler.timeout.IdleStateHandler$AbstractIdleTask.run(IdleStateHandler.java:497)
        at app//io.netty.util.concurrent.PromiseTask.runTask(PromiseTask.java:98)
        at app//io.netty.util.concurrent.ScheduledFutureTask.run(ScheduledFutureTask.java:153)
        at app//io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:173)
        at app//io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:166)
        at app//io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:470)
        at app//io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:569)
        at app//io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
        at app//io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at app//io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base@21.0.3/java.lang.Thread.run(Thread.java:1583)

com.example.ExampleControllerTest STANDARD_OUT
    13:27:28.422 [io-executor-thread-13] ERROR i.m.http.server.RouteExecutor - Unexpected error occurred: Connection closed before response was received
    io.micronaut.http.client.exceptions.ResponseClosedException: Connection closed before response was received
        at io.micronaut.http.client.netty.DefaultHttpClient$BaseHttpResponseHandler.channelInactive(DefaultHttpClient.java:2094)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:303)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:281)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:274)
        at io.netty.channel.ChannelInboundHandlerAdapter.channelInactive(ChannelInboundHandlerAdapter.java:81)

Gradle Test Executor 50 STANDARD_OUT
        at io.netty.handler.codec.MessageAggregator.channelInactive(MessageAggregator.java:441)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:303)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:281)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:274)
        at io.netty.channel.ChannelInboundHandlerAdapter.channelInactive(ChannelInboundHandlerAdapter.java:81)
        at io.netty.handler.codec.http.HttpContentDecoder.channelInactive(HttpContentDecoder.java:235)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:303)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:281)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:274)
        at io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext.fireChannelInactive(CombinedChannelDuplexHandler.java:418)
        at io.netty.handler.codec.ByteToMessageDecoder.channelInputClosed(ByteToMessageDecoder.java:412)
        at io.netty.handler.codec.ByteToMessageDecoder.channelInactive(ByteToMessageDecoder.java:377)
        at io.netty.handler.codec.http.HttpClientCodec$Decoder.channelInactive(HttpClientCodec.java:410)
        at io.netty.channel.CombinedChannelDuplexHandler.channelInactive(CombinedChannelDuplexHandler.java:221)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:303)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:281)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:274)
        at io.netty.channel.ChannelInboundHandlerAdapter.channelInactive(ChannelInboundHandlerAdapter.java:81)
        at io.micronaut.http.client.netty.ConnectionManager$Pool$ConnectionHolder$3.channelInactive(ConnectionManager.java:1174)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:303)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:281)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:274)
        at io.netty.channel.ChannelInboundHandlerAdapter.channelInactive(ChannelInboundHandlerAdapter.java:81)
        at io.netty.handler.timeout.IdleStateHandler.channelInactive(IdleStateHandler.java:280)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:303)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:281)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:274)
        at io.netty.channel.DefaultChannelPipeline$HeadContext.channelInactive(DefaultChannelPipeline.java:1405)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:301)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:281)
        at io.netty.channel.DefaultChannelPipeline.fireChannelInactive(DefaultChannelPipeline.java:901)
        at io.netty.channel.AbstractChannel$AbstractUnsafe$7.run(AbstractChannel.java:813)
        at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:173)
        at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:166)
        at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:470)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:569)
        at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:1583)
```



### JDK Client Exception
```shell
com.example.ExampleControllerTest > testController FAILED
    io.micronaut.http.client.exceptions.HttpClientException: Error sending request: request timed out
        at app//io.micronaut.http.client.jdk.AbstractJdkHttpClient.lambda$responsePublisher$11(AbstractJdkHttpClient.java:403)
        at app//reactor.core.publisher.Flux.lambda$onErrorMap$28(Flux.java:7302)
        at app//reactor.core.publisher.Flux.lambda$onErrorResume$29(Flux.java:7355)
        at app//reactor.core.publisher.FluxOnErrorResume$ResumeSubscriber.onError(FluxOnErrorResume.java:94)
        at app//reactor.core.publisher.FluxFlatMap$FlatMapMain.checkTerminated(FluxFlatMap.java:846)
        at app//reactor.core.publisher.FluxFlatMap$FlatMapMain.drainLoop(FluxFlatMap.java:612)
        at app//reactor.core.publisher.FluxFlatMap$FlatMapMain.drain(FluxFlatMap.java:592)
        at app//reactor.core.publisher.FluxFlatMap$FlatMapMain.innerError(FluxFlatMap.java:867)
        at app//reactor.core.publisher.FluxFlatMap$FlatMapInner.onError(FluxFlatMap.java:994)
        at app//reactor.core.publisher.MonoCompletionStage$MonoCompletionStageSubscription.apply(MonoCompletionStage.java:115)
        at app//reactor.core.publisher.MonoCompletionStage$MonoCompletionStageSubscription.apply(MonoCompletionStage.java:67)
        at java.base@21.0.3/java.util.concurrent.CompletableFuture.uniHandle(CompletableFuture.java:934)
        at java.base@21.0.3/java.util.concurrent.CompletableFuture$UniHandle.tryFire(CompletableFuture.java:911)
        at java.base@21.0.3/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
        at java.base@21.0.3/java.util.concurrent.CompletableFuture.postFire(CompletableFuture.java:614)
        at java.base@21.0.3/java.util.concurrent.CompletableFuture$UniWhenComplete.tryFire(CompletableFuture.java:844)
        at java.base@21.0.3/java.util.concurrent.CompletableFuture$Completion.exec(CompletableFuture.java:483)
        at java.base@21.0.3/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:387)
        at java.base@21.0.3/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1312)
        at java.base@21.0.3/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1843)
        at java.base@21.0.3/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1808)
        at java.base@21.0.3/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:188)

        Caused by:
        java.net.http.HttpTimeoutException: request timed out
            at java.net.http/jdk.internal.net.http.ResponseTimerEvent.handle(ResponseTimerEvent.java:63)
            at java.net.http/jdk.internal.net.http.HttpClientImpl.purgeTimeoutsAndReturnNextDeadline(HttpClientImpl.java:1778)
            at java.net.http/jdk.internal.net.http.HttpClientImpl$SelectorManager.run(HttpClientImpl.java:1335)
```