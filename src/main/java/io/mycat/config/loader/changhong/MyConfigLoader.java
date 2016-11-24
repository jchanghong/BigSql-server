package io.mycat.config.loader.changhong;

import io.mycat.config.loader.ConfigLoader;
import io.mycat.config.model.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by jiang on 2016/11/24 0024.
 */
public class MyConfigLoader implements ConfigLoader {
    @Override
    public SchemaConfig getSchemaConfig(String schema) {
        TableConfig tableConfig = new TableConfig("PERSON", "id", false, false,
                TableConfig.TYPE_GLOBAL_DEFAULT, "dn1", null, null, false, null, false, null, null, null);
        Map<String, TableConfig> map = new HashMap<>();
        map.put("PERSON", tableConfig);
        SchemaConfig schemaConfig = new SchemaConfig("db", null, map, 100, false);
        return schemaConfig;
    }

    @Override
    public Map<String, SchemaConfig> getSchemaConfigs() {
        Map<String, SchemaConfig> map = new HashMap<>();
        map.put("db", getSchemaConfig("db"));
        return map;
    }

    @Override
    public Map<String, DataNodeConfig> getDataNodes() {
        Map<String, DataNodeConfig> map = new HashMap<>();
        DataNodeConfig nodeConfig = new DataNodeConfig("dn1", "changhong", "localhost1");
        map.put("dn1", nodeConfig);
        return map;
    }

    @Override
    public Map<String, DataHostConfig> getDataHosts() {
        Map<String, DataHostConfig> map = new HashMap<>();
        DBHostConfig dbHostConfig = new DBHostConfig("hostS1", "localhost", 3306, "localhost:3306", "root", "0000", "0000");
        dbHostConfig.setMinCon(10);
        dbHostConfig.setMaxCon(1000);
        DBHostConfig[] dataHostConfigs = new DBHostConfig[]{dbHostConfig};
        DataHostConfig hostConfig = new DataHostConfig("localhost1", "mysql", "native", dataHostConfigs, new HashMap<Integer,DBHostConfig[]>(), 0, 100, false);
        hostConfig.setMinCon(10);
        hostConfig.setMaxCon(1000);
        hostConfig.setHearbeatSQL("select user()");
        map.put("localhost1", hostConfig);
        return map;
    }

    @Override
    public SystemConfig getSystemConfig() {
        SystemConfig systemConfig = new SystemConfig();
        return systemConfig;
    }

    @Override
    public UserConfig getUserConfig(String user) {
        UserConfig userConfig = new UserConfig();
        userConfig.setName("root");

        userConfig.setPassword("123456");
        HashSet<String> schemas = new HashSet<String>();
        schemas.add("db");
        userConfig.setSchemas(schemas);
        UserPrivilegesConfig privilegesConfig = new UserPrivilegesConfig();
        privilegesConfig.setCheck(false);
        userConfig.setPrivilegesConfig(privilegesConfig);
        return userConfig;
    }

    @Override
    public Map<String, UserConfig> getUserConfigs() {
        Map<String, UserConfig> map = new HashMap<>();
        map.put("root", getUserConfig("root"));
        return map;
    }

    @Override
    public FirewallConfig getFirewallConfig() {
        FirewallConfig firewallConfig = new FirewallConfig();
        return firewallConfig;
    }

    @Override
    public ClusterConfig getClusterConfig() {
        ClusterConfig clusterConfig = new ClusterConfig();
        return clusterConfig;
    }

}
