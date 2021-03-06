package com.redmancometh.muckfojang.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Data;

@Data
public class ConfigManager
{

    private Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.PROTECTED).setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES).create();

    private Configuration config;

    public void init()
    {
        initConfig();
    }

    public void updateConfig()
    {
        try (FileWriter writer = new FileWriter(new File("config/config.json")))
        {
            gson.toJson(this, writer);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void initConfig()
    {
        try (FileReader reader = new FileReader("config" + File.separator + "config.json"))
        {
            Configuration conf = gson.fromJson(reader, Configuration.class);
            this.config = conf;
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
    }

}
