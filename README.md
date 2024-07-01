## Http Client Read Timeout Example

Got the errors with both Java17 and Java21

### Startup
```shell
./gradlew run
```

### CURL it!
About 17-20 or so times should trigger the read timeout exception. Only takes one time to hit the JDK client exception.
```shell
curl -X POST 'http://localhost:8080/example/sample' -H 'content-type: application/json' -d '{"id": "12345", "username":"whatever"}'
```

### Read Timeout Exception
```shell
> Task :run
 __  __ _                                  _
|  \/  (_) ___ _ __ ___  _ __   __ _ _   _| |_
| |\/| | |/ __| '__/ _ \| '_ \ / _` | | | | __|
| |  | | | (__| | | (_) | | | | (_| | |_| | |_
|_|  |_|_|\___|_|  \___/|_| |_|\__,_|\__,_|\__|
11:16:16.267 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 343ms. Server Running: http://localhost:8080
11:17:07.894 [default-nioEventLoopGroup-1-3] ERROR i.m.http.server.RouteExecutor - Unexpected error occurred: Read Timeout
io.micronaut.http.client.exceptions.ReadTimeoutException: Read Timeout
        at io.micronaut.http.client.exceptions.ReadTimeoutException.<clinit>(ReadTimeoutException.java:26)
        at io.micronaut.http.client.netty.DefaultHttpClient.lambda$exchangeImpl$28(DefaultHttpClient.java:1156)
        at reactor.core.publisher.FluxOnErrorResume$ResumeSubscriber.onError(FluxOnErrorResume.java:94)
        at reactor.core.publisher.SerializedSubscriber.onError(SerializedSubscriber.java:124)
        at reactor.core.publisher.FluxTimeout$TimeoutMainSubscriber.handleTimeout(FluxTimeout.java:296)
        at reactor.core.publisher.FluxTimeout$TimeoutMainSubscriber.doTimeout(FluxTimeout.java:281)
        at reactor.core.publisher.FluxTimeout$TimeoutTimeoutSubscriber.onNext(FluxTimeout.java:420)
        at reactor.core.publisher.FluxOnErrorReturn$ReturnSubscriber.onNext(FluxOnErrorReturn.java:162)
        at reactor.core.publisher.MonoDelay$MonoDelayRunnable.propagateDelay(MonoDelay.java:270)
        at reactor.core.publisher.MonoDelay$MonoDelayRunnable.run(MonoDelay.java:285)
        at io.micronaut.core.propagation.PropagatedContext.lambda$wrap$3(PropagatedContext.java:211)
        at reactor.core.scheduler.SchedulerTask.call(SchedulerTask.java:68)
        at reactor.core.scheduler.SchedulerTask.call(SchedulerTask.java:28)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
        at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:304)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
        at java.base/java.lang.Thread.run(Thread.java:1583)
```



### JJDK Client Exception
```shell
> Task :run
 __  __ _                                  _
|  \/  (_) ___ _ __ ___  _ __   __ _ _   _| |_
| |\/| | |/ __| '__/ _ \| '_ \ / _` | | | | __|
| |  | | | (__| | | (_) | | | | (_| | |_| | |_
|_|  |_|_|\___|_|  \___/|_| |_|\__,_|\__,_|\__|
11:17:53.174 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 372ms. Server Running: http://localhost:8080
11:17:57.627 [default-nioEventLoopGroup-1-2] ERROR i.m.http.server.RouteExecutor - Unexpected error occurred: No bean introspection available for type [interface io.micronaut.http.HttpResponse]. Ensure the class is annotated with io.micronaut.core.annotation.Introspected
io.micronaut.core.beans.exceptions.IntrospectionException: No bean introspection available for type [interface io.micronaut.http.HttpResponse]. Ensure the class is annotated with io.micronaut.core.annotation.Introspected
        at io.micronaut.core.beans.BeanIntrospector.lambda$getIntrospection$3(BeanIntrospector.java:116)
        at java.base/java.util.Optional.orElseThrow(Optional.java:403)
        at io.micronaut.core.beans.BeanIntrospector.getIntrospection(BeanIntrospector.java:116)
        at io.micronaut.serde.support.DefaultSerdeIntrospections.lambda$getDeserializableIntrospection$3(DefaultSerdeIntrospections.java:158)
        at java.base/java.util.Optional.orElseGet(Optional.java:364)
        at io.micronaut.serde.support.DefaultSerdeIntrospections.getDeserializableIntrospection(DefaultSerdeIntrospections.java:149)
        at io.micronaut.serde.support.deserializers.ObjectDeserializer.createDeserBean(ObjectDeserializer.java:166)
        at io.micronaut.serde.support.deserializers.ObjectDeserializer.lambda$getDeserializableBean$1(ObjectDeserializer.java:156)
        at io.micronaut.core.util.SupplierUtil$2.get(SupplierUtil.java:79)
        at io.micronaut.serde.support.deserializers.ObjectDeserializer.getDeserializableBean(ObjectDeserializer.java:157)
        at io.micronaut.serde.support.deserializers.ObjectDeserializer.createSpecific(ObjectDeserializer.java:86)
        at io.micronaut.serde.jackson.JacksonJsonMapper.readValue0(JacksonJsonMapper.java:201)
        at io.micronaut.serde.jackson.JacksonJsonMapper.readValue(JacksonJsonMapper.java:195)
        at io.micronaut.serde.jackson.JacksonJsonMapper.readValue(JacksonJsonMapper.java:241)
        at io.micronaut.json.codec.MapperMediaTypeCodec.decode(MapperMediaTypeCodec.java:211)
        at io.micronaut.http.client.jdk.HttpResponseAdapter.lambda$convertBytes$0(HttpResponseAdapter.java:124)
        at java.base/java.util.Optional.map(Optional.java:260)
        at io.micronaut.http.client.jdk.HttpResponseAdapter.convertBytes(HttpResponseAdapter.java:124)
        at io.micronaut.http.client.jdk.HttpResponseAdapter.getBody(HttpResponseAdapter.java:98)
        at io.micronaut.http.HttpResponse.body(HttpResponse.java:66)
        at com.example.service.ExampleService$sendToHttpbun$1.invokeSuspend(ExampleService.kt:21)
        at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
        at io.micronaut.aop.util.DelegatingContextContinuation.resumeWith(DelegatingContextContinuation.kt:46)
        at io.micronaut.aop.util.DelegatingContextContinuation.resumeWith(DelegatingContextContinuation.kt:46)
        at kotlin.coroutines.SafeContinuation.resumeWith(SafeContinuationJvm.kt:41)
        at io.micronaut.aop.util.KotlinInterceptedMethodHelper$handleResult$2$1.invoke(KotlinInterceptedMethodHelper.kt:39)
        at io.micronaut.aop.util.KotlinInterceptedMethodHelper$handleResult$2$1.invoke(KotlinInterceptedMethodHelper.kt:36)
        at io.micronaut.aop.util.KotlinInterceptedMethodHelper$sam$java_util_function_BiConsumer$0.accept(KotlinInterceptedMethodHelper.kt)
        at java.base/java.util.concurrent.CompletableFuture.uniWhenComplete(CompletableFuture.java:863)
        at java.base/java.util.concurrent.CompletableFuture$UniWhenComplete.tryFire(CompletableFuture.java:841)
        at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
        at java.base/java.util.concurrent.CompletableFuture.complete(CompletableFuture.java:2179)
        at io.micronaut.aop.util.CompletableFutureContinuation.resumeWith(CompletableFutureContinuation.kt:49)
        at io.micronaut.aop.util.DelegatingContextContinuation.resumeWith(DelegatingContextContinuation.kt:46)
        at kotlin.coroutines.SafeContinuation.resumeWith(SafeContinuationJvm.kt:41)
        at io.micronaut.aop.util.KotlinInterceptedMethodHelper$handleResult$2$1.invoke(KotlinInterceptedMethodHelper.kt:39)
        at io.micronaut.aop.util.KotlinInterceptedMethodHelper$handleResult$2$1.invoke(KotlinInterceptedMethodHelper.kt:36)
        at io.micronaut.aop.util.KotlinInterceptedMethodHelper$sam$java_util_function_BiConsumer$0.accept(KotlinInterceptedMethodHelper.kt)
        at java.base/java.util.concurrent.CompletableFuture.uniWhenComplete(CompletableFuture.java:863)
        at java.base/java.util.concurrent.CompletableFuture$UniWhenComplete.tryFire(CompletableFuture.java:841)
        at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
        at java.base/java.util.concurrent.CompletableFuture.complete(CompletableFuture.java:2179)
        at io.micronaut.http.client.interceptor.HttpClientIntroductionAdvice$1.doOnComplete(HttpClientIntroductionAdvice.java:306)
        at io.micronaut.http.client.interceptor.HttpClientIntroductionAdvice$1.doOnNext(HttpClientIntroductionAdvice.java:280)
        at io.micronaut.core.async.subscriber.CompletionAwareSubscriber.onNext(CompletionAwareSubscriber.java:56)
        at reactor.core.publisher.StrictSubscriber.onNext(StrictSubscriber.java:89)
        at reactor.core.publisher.FluxSwitchIfEmpty$SwitchIfEmptySubscriber.onNext(FluxSwitchIfEmpty.java:74)
        at reactor.core.publisher.FluxFlatMap$FlatMapMain.tryEmit(FluxFlatMap.java:547)
        at reactor.core.publisher.FluxFlatMap$FlatMapInner.onNext(FluxFlatMap.java:988)
        at reactor.core.publisher.MonoFlatMapMany$FlatMapManyInner.onNext(MonoFlatMapMany.java:251)
        at reactor.core.publisher.MonoNext$NextSubscriber.onNext(MonoNext.java:82)
        at reactor.core.publisher.FluxHandle$HandleSubscriber.onNext(FluxHandle.java:129)
        at reactor.core.publisher.FluxOnErrorResume$ResumeSubscriber.onNext(FluxOnErrorResume.java:79)
        at reactor.core.publisher.FluxOnErrorResume$ResumeSubscriber.onNext(FluxOnErrorResume.java:79)
        at reactor.core.publisher.FluxFlatMap$FlatMapMain.tryEmit(FluxFlatMap.java:547)
        at reactor.core.publisher.FluxFlatMap$FlatMapInner.onNext(FluxFlatMap.java:988)
        at reactor.core.publisher.MonoCompletionStage$MonoCompletionStageSubscription.apply(MonoCompletionStage.java:121)
        at reactor.core.publisher.MonoCompletionStage$MonoCompletionStageSubscription.apply(MonoCompletionStage.java:67)
        at java.base/java.util.concurrent.CompletableFuture.uniHandle(CompletableFuture.java:934)
        at java.base/java.util.concurrent.CompletableFuture$UniHandle.tryFire(CompletableFuture.java:911)
        at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
        at java.base/java.util.concurrent.CompletableFuture.postFire(CompletableFuture.java:614)
        at java.base/java.util.concurrent.CompletableFuture$UniWhenComplete.tryFire(CompletableFuture.java:844)
        at java.base/java.util.concurrent.CompletableFuture$Completion.exec(CompletableFuture.java:483)
        at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:387)
        at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1312)
        at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1843)
        at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1808)
        at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:188)
```