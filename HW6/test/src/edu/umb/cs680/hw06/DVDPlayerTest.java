package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DVDPlayerTest {
    
    @Test 
    public void testDVDPlayerCanBeCreated() {
        DVDPlayer dvdPlayer = DVDPlayer.getInstance();
        assertNotNull(dvdPlayer);
    }

    @Test
    public void testIsDVDPlayerSingleton() {
        DVDPlayer dvdPlayer1 = DVDPlayer.getInstance();
        DVDPlayer dvdPlayer2 = DVDPlayer.getInstance();

        assertSame(dvdPlayer1, dvdPlayer2);
    }

    @Test
    public void testDrawerClosedNotPlayingCanBeCreated() {
        DrawerClosedNotPlaying state = DrawerClosedNotPlaying.getInstance();
        assertNotNull(state);
    }

    @Test
    public void testDrawerClosedPlayingCanBeCreated() {
        DrawerClosedPlaying state = DrawerClosedPlaying.getInstance();
        assertNotNull(state);
    }

    @Test
    public void testDrawerOpenCanBeCreated() {
        DrawerOpen state = DrawerOpen.getInstance();
        assertNotNull(state);
    }

    @Test
    public void testCanOpenDrawerFromDrawerClosedNotPlaying() {
        DVDPlayer dvdPlayer = DVDPlayer.getInstance();
        dvdPlayer.openCloseButtonPushed();
        assertEquals(DrawerOpen.getInstance(), dvdPlayer.getCurrentState());
    }

    @Test
    public void testCanPlayDVDFromDrawerClosedNotPlaying() {
        DVDPlayer dvdPlayer = DVDPlayer.getInstance();
        dvdPlayer.playButtonPushed();
        assertEquals(DrawerClosedPlaying.getInstance(), dvdPlayer.getCurrentState());
    }

    @Test
    public void testCanCloseDrawerWhenDrawerOpen() {
        DVDPlayer dvdPlayer = DVDPlayer.getInstance();
        dvdPlayer.openCloseButtonPushed();
        dvdPlayer.openCloseButtonPushed();
        assertEquals(DrawerClosedNotPlaying.getInstance(), dvdPlayer.getCurrentState());
    }

    @Test
    public void testCanPlayWhenDrawerOpen() {
        DVDPlayer dvdPlayer = DVDPlayer.getInstance();
        dvdPlayer.openCloseButtonPushed();
        dvdPlayer.playButtonPushed();
        assertEquals(DrawerClosedPlaying.getInstance(), dvdPlayer.getCurrentState());
    }

    @Test
    public void testCanStopDVDAfterPlaying() {
        DVDPlayer dvdPlayer = DVDPlayer.getInstance();
        dvdPlayer.playButtonPushed();
        dvdPlayer.stopButtonPushed();
        assertEquals(DrawerClosedNotPlaying.getInstance(), dvdPlayer.getCurrentState());
    }

    @Test
    public void testCanOpenDrawerAfterPlaying() {
        DVDPlayer dvdPlayer = DVDPlayer.getInstance();
        dvdPlayer.playButtonPushed();
        dvdPlayer.openCloseButtonPushed();
        assertEquals(DrawerOpen.getInstance(), dvdPlayer.getCurrentState());
    }
}
