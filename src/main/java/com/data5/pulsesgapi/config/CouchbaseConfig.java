package com.data5.pulsesgapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.data5.pulsesgapi.repository"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    //@Value("${spring.couchbase.bootstrap-hosts}")
    private String hosts ="52.91.169.220";

    //@Value("${spring.couchbase.bucket.name}")
    private String bucketName ="generatedata";

    //@Value("${spring.couchbase.bucket.password}")
    private String password ="Generated123!";

    @Override
    public String getConnectionString() {
        return hosts;
    }

    @Override
    public String getUserName() {
        return "generated";// "Administrator";
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }

  /*  @Bean
    public CouchbaseClientFactory taskCouchbaseClientFactory(Cluster couchbaseCluster) {
        return new SimpleCouchbaseClientFactory(couchbaseCluster, getBucketName(), getScopeName());
    }

    @Bean
    public CouchbaseTemplate taskCouchbaseTemplate(CouchbaseClientFactory taskCouchbaseClientFactory,
                                                   MappingCouchbaseConverter mappingCouchbaseConverter) {
        return new CouchbaseTemplate(taskCouchbaseClientFactory, mappingCouchbaseConverter);
    }


    @Override
    protected void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
        CouchbaseTemplate taskTemplate = couchbaseTemplate(
                couchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment())),
                new MappingCouchbaseConverter());
        mapping.mapEntity(Task.class, taskTemplate);

    }

    @Bean
    public Transactions transactions(final Cluster couchbaseCluster) {
        return Transactions.create(couchbaseCluster,
                TransactionConfigBuilder.create().build());
    }*/
}
