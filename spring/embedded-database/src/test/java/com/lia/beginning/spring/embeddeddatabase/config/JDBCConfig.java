package com.lia.beginning.spring.embeddeddatabase.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import com.lia.beginning.spring.embeddeddatabase.data.BrickRepository;
import com.lia.beginning.spring.embeddeddatabase.data.jdbc.BrickRepositoryImp;

@Configuration
public class JDBCConfig {

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
      .setType(EmbeddedDatabaseType.H2)
      .addScripts("classpath:com/lia/beginning/spring/embeddeddatabase/data/jdbc/schema.sql", "classpath:com/lia/beginning/spring/embeddeddatabase/data/jdbc/test-data.sql")
      .build();
  }
  
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
  
  @Bean
  public BrickRepository brickRepository(JdbcTemplate jdbcTemplate) {
    return new BrickRepositoryImp(jdbcTemplate);
  }
  
  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

}
