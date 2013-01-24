/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author gerrymclarnon
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({service.CreateTeamTest.class, 
                    service.ReadTeamTest.class, 
                    service.DeleteTeamTest.class})
public class TeamTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Deploy App with PersistenceUnit set to PMDEV01 with schema drop and create option");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}
