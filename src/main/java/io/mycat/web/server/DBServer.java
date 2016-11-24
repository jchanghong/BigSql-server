package io.mycat.web.server;

import io.mycat.config.model.SchemaConfig;

/**
 * Created by jiang on 2016/11/24 0024.
 */
public interface DBServer {
    void addDB(SchemaConfig schemaConfig);
}
