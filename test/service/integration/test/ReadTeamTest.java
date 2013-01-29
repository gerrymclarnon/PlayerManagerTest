/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.integration.test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import entities.Player;
import entities.Team;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.util.TeamTestHelper;
import static org.junit.Assert.*;

/**
 *
 * @author u530619
 */
public class ReadTeamTest {
    
    public ReadTeamTest() {
    }
   
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        TeamTestHelper.createAllTestTeams();
    }
    
    @After
    public void tearDown() {
        TeamTestHelper.removeAllTestTeams();
    }

      /**
     * Test of count method, of class TeamRESTFacade.
     */
    @Test
    public void testTeamCountUnauthorized() {
        System.out.println("team count allowed");
        TeamTestHelper teamTestHelper = new TeamTestHelper();
        teamTestHelper.setUser(TeamTestHelper.User.UNKNOWN);
        String expResult = "1";
        try {
            assertEquals(expResult, teamTestHelper.count());
        } catch (UniformInterfaceException e) {
            ClientResponse result = e.getResponse();
            assertEquals(ClientResponse.Status.UNAUTHORIZED, result.getClientResponseStatus());
        }
    }

    /**
     * Test of count method, of class TeamRESTFacade.
     */
    @Test
    public void testTeamCountAllowed() {
        System.out.println("team count allowed");
        TeamTestHelper teamTestHelper = new TeamTestHelper();
        teamTestHelper.setUser(TeamTestHelper.User.MANAGER);
        String expResult = "1";
        String result = teamTestHelper.count();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testTeamPlayersCount() {
        System.out.println("team players count allowed");
        TeamTestHelper teamTestHelper = new TeamTestHelper();

        GenericType<Collection<Team>> teamCollectionType = new GenericType<Collection<Team>>(){};
        Collection<Team> teams = teamTestHelper.findAll(teamCollectionType);
        
        for (Team team : teams) {
            if (team.getUri().equalsIgnoreCase("dreamteam")) {
                GenericType<Collection<Player>> playerCollectionType = new GenericType<Collection<Player>>(){};
                Collection<Player> players = teamTestHelper.findAllPlayers(playerCollectionType, team.getId().toString());

                String expResult = "1";
                String result = String.valueOf(players.size());
                assertEquals(expResult, result);
            }
        }
    }
    
    @Test
    public void testTeamPlayersDetails() {
        System.out.println("team player details allowed");
        TeamTestHelper teamTestHelper = new TeamTestHelper();

        GenericType<Collection<Team>> teamCollectionType = new GenericType<Collection<Team>>(){};
        Collection<Team> teams = teamTestHelper.findAll(teamCollectionType);
        
        for (Team team : teams) {
            if (team.getUri().equalsIgnoreCase(TeamTestHelper.DREAMTEAM_URI)) {
                GenericType<Collection<Player>> playerCollectionType = new GenericType<Collection<Player>>(){};
                Collection<Player> players = teamTestHelper.findAllPlayers(playerCollectionType, team.getId().toString());

                for (Player player : players) {
                    if (player.getUri().equalsIgnoreCase(TeamTestHelper.HARRY_HADDOCK_URI)) {
                        String expResult = TeamTestHelper.HARRY_HADDOCK_NAME;
                        String result = String.valueOf(player.getName());
                        assertEquals(expResult, result);
                    }
                }
                
                break;
            }
        }
    }
}
