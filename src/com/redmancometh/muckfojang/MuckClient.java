package com.redmancometh.muckfojang;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingPolicy;
import com.redmancometh.muckfojang.config.ConfigManager;
import com.redmancometh.muckfojang.config.Configuration;

public class MuckClient
{
    private CloudflareClient client;
    private ConfigManager configManager;

    public void start()
    {
        configManager = new ConfigManager();
        configManager.init();
        Configuration config = configManager.getConfig();
        client = new CloudflareClient(config.getCloudflareConfig().getCfEmail(), config.getCloudflareConfig().getAuthKey());
        client.initializeZones();
    }

    public CloudflareClient getClient()
    {
        return client;
    }

    public void setClient(CloudflareClient client)
    {
        this.client = client;
    }

    public ConfigManager getConfigManager()
    {
        return configManager;
    }

    public void setConfigManager(ConfigManager configManager)
    {
        this.configManager = configManager;
    }

}
