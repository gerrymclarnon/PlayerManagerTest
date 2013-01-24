/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
import static org.junit.Assert.*;

/**
 *
 * @author u530619
 */
public class DeleteTeamTest {
    
    public DeleteTeamTest() {
    }
   
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class TeamRESTFacade.
     */
    @Test
    public void testDeleteForbidden() {
        System.out.println("delete forbidden");

        TeamTestHelper teamTestHelper = new TeamTestHelper();
        teamTestHelper.setUser(TeamTestHelper.User.PLAYER);

        try {
            teamTestHelper.remove("1");
        } catch (UniformInterfaceException e) {
            ClientResponse result = e.getResponse();
            assertEquals(ClientResponse.Status.FORBIDDEN, result.getClientResponseStatus());
        }
        
        String expResult = "1";
        String result = teamTestHelper.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class TeamRESTFacade.
     */
    @Test
    public void testDeleteAllowed() {
        System.out.println("delete allowed");
        
        TeamTestHelper teamTestHelper = new TeamTestHelper();
        teamTestHelper.setUser(TeamTestHelper.User.MANAGER);
        teamTestHelper.remove("1");
        
        String expResult = "0";
        String result = teamTestHelper.count();
        assertEquals(expResult, result);
    }

}
