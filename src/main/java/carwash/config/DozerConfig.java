package carwash.config;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig {

  @Bean
  public Mapper dozerMapper() {
    Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    return mapper;
  }

}
