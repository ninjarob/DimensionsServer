package com.fdimensiontests.sync;

import com.fdimensions.DimensionServerExtension;
import com.fdimensions.game.bsn.SyncAsteroid;
import com.fdimensions.math.Vector2;
import com.fdimensions.model.Asteroid;
import com.fdimensions.model.PlayerInfo;
import com.fdimensions.model.SpaceGame;
import com.fdimensions.model.SpaceGameMap;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: rkevan
 * Date: 11/25/13
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
@PrepareForTest(Logger.class)
public class SyncAsteroidTest {

    private SyncAsteroid syncAsteroid;

    @Mock
    private SpaceGame sg;

    @Mock
    private PlayerInfo pi;

    @Mock
    DimensionServerExtension dse;

    @Mock
    SpaceGameMap spm;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testRun() throws Exception {
        PowerMockito.mockStatic(Logger.class);

        ConcurrentHashMap<Integer, SpaceGame> systems = new ConcurrentHashMap<>();
        systems.put(1, sg);
        when(dse.getSystems()).thenReturn(systems);
        ConcurrentHashMap<Integer, PlayerInfo> playerInfos = new ConcurrentHashMap<>();
        playerInfos.put(1, pi);
        when(sg.getPlayers()).thenReturn(playerInfos);
        when(sg.getSpaceGameMap()).thenReturn(spm);


        Asteroid a = new Asteroid(1, 10, new Vector2(-100, 0), new Vector2(0, 1), 1);

        List<Asteroid> asteroids = new ArrayList<>();
        asteroids.add(a);
        when(spm.getAsteroids()).thenReturn(asteroids);




        syncAsteroid = new SyncAsteroid(dse);
        syncAsteroid.run(3.0);

    }
}