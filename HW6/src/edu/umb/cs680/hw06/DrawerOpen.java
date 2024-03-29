package edu.umb.cs680.hw06;

public class DrawerOpen implements State{
    private DrawerOpen() {};
    private static DrawerOpen instance = null;

    public static DrawerOpen getInstance() {
        if (instance == null) {
            instance = new DrawerOpen();
        }

        return instance;
    }

    public void openCloseButtonPushed() {
        DVDPlayer.close();
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
    }

    public void playButtonPushed() {
        DVDPlayer.close();
        DVDPlayer.play();
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
    }

    public void stopButtonPushed() {
        System.out.println("DVD is Stopped!");
    }
}
