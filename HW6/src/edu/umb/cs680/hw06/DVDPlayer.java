package edu.umb.cs680.hw06;

public class DVDPlayer {
    private static DVDPlayer instance = null;
    private static State state;

    public DVDPlayer(State state) {
        DVDPlayer.state = state;
    }

    public static DVDPlayer getInstance() {
        if (instance == null) {
            State state = DrawerClosedNotPlaying.getInstance();
            instance = new DVDPlayer(state);
        }

        return instance;
    }

    public static void changeState(State state) {
        DVDPlayer.state = state;
    }

    public State getCurrentState() {
        return DVDPlayer.state;
    }

    public void openCloseButtonPushed() {
        state.openCloseButtonPushed();
    }

    public void playButtonPushed() {
        DVDPlayer.state.playButtonPushed();
    }

    public void stopButtonPushed() {
        DVDPlayer.state.stopButtonPushed();
    }

    public static void open() {
        System.out.println("Drawer Opened!");
    }

    public static void close() {
        System.out.println("Drawer Closed!");
    }

    public static void play() {
        System.out.println("DVD is Playing!");
    }

    public static void stop() {
        System.out.println("DVD has Stopped!");
    }

    public State getPresentState() {
        return DVDPlayer.state;
    }
}
