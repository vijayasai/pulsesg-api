package com.data5.pulsesgapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("${spring.couchbase.bootstrap-hosts}")
    private String hosts;

    @Value("${spring.couchbase.bucket.name}")
    private String bucketName;

    @Value("${spring.couchbase.bucket.password}")
    private String password;

    @Override
    public String getConnectionString() {
        return hosts;
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }

//    @Bean
//    public CouchbaseTemplate myCouchbaseTemplate(CouchbaseClientFactory myCouchbaseClientFactory,
//                                                 MappingCouchbaseConverter mappingCouchbaseConverter) {
//        return new CouchbaseTemplate(myCouchbaseClientFactory, mappingCouchbaseConverter);
//    }
//
//    @Bean
//    public CouchbaseClientFactory myCouchbaseClientFactory(Cluster couchbaseCluster) {
//
//        return new SimpleCouchbaseClientFactory(couchbaseCluster, "pulsesg-sample", getScopeName());
//    }
//
//    @Override
//    protected void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
//
//        CouchbaseTemplate userTemplate = couchbaseTemplate(
//                couchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment())),
//                new MappingCouchbaseConverter());
//
//        mapping.mapEntity(User.class,  userTemplate);
//
//    }
//
//    @Bean
//    public Transactions transactions(final Cluster couchbaseCluster) {
//        return Transactions.create(couchbaseCluster, TransactionConfigBuilder.create()
//
//                .build());
//    }
}
