package settings;

public class Settings {

    private static final Object lock = new Object();
    private static Settings instance;

    private boolean musicEnabled = true;

    private Settings() {
    }

    public static Settings getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Settings();
                }
            }
        }
        return instance;
    }
}
