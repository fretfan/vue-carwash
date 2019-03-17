package carwash.config

import org.dozer.DozerBeanMapperBuilder
import org.dozer.Mapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class DozerConfig {

    @Bean
    open fun dozerMapper(): Mapper {
        return DozerBeanMapperBuilder.buildDefault()
    }

}
