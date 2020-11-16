package de.b3aux.yonplei.listener;

import de.b3aux.yonplei.methoden.Formats;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class signListener implements Listener {

    @EventHandler
    public void onWrite(SignChangeEvent e) {

        Formats f = new Formats();

        String line1 = f.Colorformat(e.getLine(0));
        String line2 = f.Colorformat(e.getLine(1));
        String line3 = f.Colorformat(e.getLine(2));
        String line4 = f.Colorformat(e.getLine(3));

        e.setLine(0, line1);
        e.setLine(1, line2);
        e.setLine(2, line3);
        e.setLine(3, line4);

    }
}
