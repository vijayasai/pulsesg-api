package com.pulsesg.platform.core.task.config;

import com.couchbase.client.java.Cluster;
import com.pulsesg.platform.core.task.model.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

/**
 * @author Vijayasai Kesanupalli
 */
@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.pulsesg.platform.core.task.repository"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("${spring.couchbase.bootstrap-hosts}")
    private String hosts;

    @Value("${spring.couchbase.bucket.name}")
    private String bucketName;

    @Value("${spring.couchbase.bucket.password}")
    private String password;

    @Value("${couchDB.login.userName}")
    private String loginUserName;

    @Override
    public String getConnectionString() {
        return hosts;
    }

    @Override
    public String getUserName() {
       return loginUserName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }

    @Bean
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

   /* @Bean
    public Transactions transactions(final Cluster couchbaseCluster) {
        return Transactions.create(couchbaseCluster,
                TransactionConfigBuilder.create().build());
    }*/
}
