package com.sohan.student.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class provides the configurations required to setup a Debezium connector for the Student Table.
 *
 * @author Sohan
 */
@Configuration
public class DebeziumConnectorConfig {

    /**
     * Student Database details.
     */
    @Value("${student.datasource.host}")
    private String studentDBHost;

    @Value("${student.datasource.databasename}")
    private String studentDBName;

    @Value("${student.datasource.port}")
    private String studentDBPort;

    @Value("${student.datasource.username}")
    private String studentDBUserName;

    @Value("${student.datasource.password}")
    private String studentDBPassword;

    private String STUDENT_TABLE_NAME = "public.student";

    /**
     * Student database connector.
     *
     * @return Configuration.
     */
    @Bean
    public io.debezium.config.Configuration studentConnector() {

        return io.debezium.config.Configuration.create().
            with("name", "student-postgres-connector").
            with("connector.class", "io.debezium.connector.postgresql.PostgresConnector").
            with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore").
            with("offset.storage.file.filename", "/tmp/offsets.dat").
            with("offset.flush.interval.ms", "60000").
            /* begin connector properties */
            with("database.hostname", studentDBHost).
            with("database.port", studentDBPort).
            with("database.user", studentDBUserName).
            with("database.password", studentDBPassword).
            with("database.dbname", studentDBName).
            with("table.whitelist", STUDENT_TABLE_NAME).
            with("topic.prefix", "my-app-connector").
            with("slot.name", "my_slot_name02").
            with("schema.history.internal", "io.debezium.storage.file.history.FileSchemaHistory").
            with("schema.history.internal.file.filename", "/tmp/schemahistory.dat").build();
    }
}
