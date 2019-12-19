package JavaIO;

import java.util.prefs.Preferences;

public class PreferencesDemo {
    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location","0z");
        prefs.put("Footwear","Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);

        int usageCount = prefs.getInt("UsageCount",0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys())
            System.out.println(key + ": " + prefs.get(key, null));
        System.out.println("have? " + prefs.getInt("Companions", 0));
    }
}
