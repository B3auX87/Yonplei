package de.b3aux.yonplei.methoden;

import java.util.UUID;

public class playerData {

    private fileBauer fb;
    private UUID uuid;

    public playerData(UUID uuid) {

        fb = new fileBauer("plugins//Yonplei//Playerdata//", uuid.toString() + ".yml");
        fb.save();
        this.uuid = uuid;

    }

    public boolean exist() {

        return fb.exists();

    }

    public void setMuted(boolean muted) {

        fb.setValue("muted", muted);
        fb.save();

    }

    public boolean isMuted() {

        return fb.getBoolean("muted");

    }
}
