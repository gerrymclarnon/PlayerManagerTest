/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
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
public class TeamRESTFacadeTest {
    
    private TeamTestHelper testTeam = new TeamTestHelper();

    private GenericType<Collection<Player>> genericType = new GenericType<Collection<Player>>(){};
    
    public TeamRESTFacadeTest() {
    }
   
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Deploy App with PersistenceUnit set to PMDEV01 with schema drop and create option");
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
    public void testCreateForbidden() {
        System.out.println("create");
        Team entity = new Team();
        entity.setName("Dream Team");
        TeamTestHelper teamTestHelper = new TeamTestHelper();
        teamTestHelper.setUser(TeamTestHelper.User.PLAYER);
        ClientResponse result = teamTestHelper.create(entity);
        assertEquals(ClientResponse.Status.FORBIDDEN, result.getClientResponseStatus());
    }

    /**
     * Test of create method, of class TeamRESTFacade.
     */
    @Test
    public void testCreateAllowed() {
        System.out.println("create");
        Team team = new Team();
        team.setName("Dream Team");
        team.setUri("dreamteam");
        
        TeamTestHelper teamTestHelper = new TeamTestHelper();
        teamTestHelper.setUser(TeamTestHelper.User.MANAGER);
        ClientResponse result = teamTestHelper.create(team);
        assertEquals(ClientResponse.Status.CREATED, result.getClientResponseStatus());
    }

    /**
     * Test of edit method, of class TeamRESTFacade.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Team entity = null;
        TeamRESTFacade instance = new TeamRESTFacade();
        instance.edit(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class TeamRESTFacade.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Long id = null;
        TeamRESTFacade instance = new TeamRESTFacade();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class TeamRESTFacade.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Long id = null;
        TeamRESTFacade instance = new TeamRESTFacade();
        Team expResult = null;
        Team result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllPlayers method, of class TeamRESTFacade.
     */
    @Test
    public void testFindAllPlayers() {
        System.out.println("findAllPlayers");
        Long id = null;
        TeamRESTFacade instance = new TeamRESTFacade();
        Collection expResult = null;
        Collection result = instance.findAllPlayers(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class TeamRESTFacade.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        TeamRESTFacade instance = new TeamRESTFacade();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class TeamRESTFacade.
     */
    @Test
    public void testFindRange() {
        System.out.println("findRange");
        Integer max = null;
        Integer first = null;
        TeamRESTFacade instance = new TeamRESTFacade();
        List expResult = null;
        List result = instance.findRange(max, first);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class TeamRESTFacade.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        TeamTestHelper instance = new TeamTestHelper();
        String expResult = "2";
        String result = instance.count();
        assertEquals(expResult, result);
    }
}
