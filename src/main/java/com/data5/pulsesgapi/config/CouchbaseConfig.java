package com.data5.pulsesgapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return "Panja@05";
    }

    @Override
    public String getBucketName() {
        return "pulsesg-sample";
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
