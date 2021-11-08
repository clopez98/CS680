package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State {
    private DrawerClosedPlaying() {};
    private static DrawerClosedPlaying instance = null;

    public static DrawerClosedPlaying getInstance() {
        if (instance == null) {
            instance = new DrawerClosedPlaying();
        }

        return instance;
    }

    public void openCloseButtonPushed() {
        DVDPlayer.stop();
        DVDPlayer.open();
        DVDPlayer.changeState(DrawerOpen.getInstance());
    }

    public void playButtonPushed() {
        System.out.println("DVD is Playing!");
    }

    public void stopButtonPushed() {
        DVDPlayer.stop();
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
    }
    
}
