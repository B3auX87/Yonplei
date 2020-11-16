package de.b3aux.yonplei.methoden;

import com.sun.istack.internal.NotNull;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class fileBauer {

    private File file;
    private YamlConfiguration cfg;

    public fileBauer(String FilePath, String FileName) {

        this.file = new File(FilePath, FileName);
        this.cfg = YamlConfiguration.loadConfiguration(this.file);

    }

    public fileBauer setValue(String ValuePath, Object Value) {

        cfg.set(ValuePath, Value);

        return this;

    }

    public boolean exists() {

        return file.exists();

    }

    public double getDouble(String ValuePath) {

        return this.cfg.getDouble(ValuePath);

    }

    public Object getObject(String ValuePath) {

        return cfg.getInt(ValuePath);

    }

    public int getInt(String ValuePath) {

        return cfg.getInt(ValuePath);

    }

    public String getString(String ValuePath) {

        return cfg.getString(ValuePath);

    }

    public boolean getBoolean(String ValuePath) {

        return cfg.getBoolean(ValuePath);

    }

    public long getLong(String ValuePath) {

        return cfg.getLong(ValuePath);

    }

    public List<String> getStringList(String ValuePath) {

        return cfg.getStringList(ValuePath);

    }

    public @NotNull
    Set<String> getKeys(boolean deep) {

        return cfg.getKeys(deep);

    }

    public ConfigurationSection getConfigurationSection(String Section) {

        return cfg.getConfigurationSection(Section);

    }

    public fileBauer save() {

        try {

            this.cfg.save(this.file);

        } catch (IOException ex) {

        }

        return this;

    }
}
