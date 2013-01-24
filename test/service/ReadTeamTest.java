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
    }
    
    @After
    public void tearDown() {
    }

      /**
     * Test of count method, of class TeamRESTFacade.
     */
    @Test
    public void testCount() {
        System.out.println("count allowed");
        TeamTestHelper teamTestHelper = new TeamTestHelper();
        String expResult = "1";
        String result = teamTestHelper.count();
        assertEquals(expResult, result);
    }
}
