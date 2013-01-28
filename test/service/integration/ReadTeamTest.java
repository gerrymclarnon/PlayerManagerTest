/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.integration;

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
import service.TeamTestHelper;
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
    public void testCountUnauthorized() {
        System.out.println("count allowed");
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
    public void testCountAllowed() {
        System.out.println("count allowed");
        TeamTestHelper teamTestHelper = new TeamTestHelper();
        teamTestHelper.setUser(TeamTestHelper.User.MANAGER);
        String expResult = "1";
        String result = teamTestHelper.count();
        assertEquals(expResult, result);
    }
}
