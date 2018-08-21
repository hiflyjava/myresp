package cc.mrbird.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurerSupport
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor
import java.util.concurrent.ThreadPoolExecutor

@Configuration
open class TaskExecutorPoolConfig : AsyncConfigurerSupport() {
    @Bean
    open fun taskExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 5
        executor.maxPoolSize = 20
        executor.setQueueCapacity(100)
        executor.keepAliveSeconds = 30
        executor.threadNamePrefix = "asyncTaskExecutor-"
        executor.setRejectedExecutionHandler(ThreadPoolExecutor.CallerRunsPolicy())
        return executor
    }
}