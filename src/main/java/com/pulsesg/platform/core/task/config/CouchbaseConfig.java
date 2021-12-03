package com.pulsesg.platform.core.task.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

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


}
