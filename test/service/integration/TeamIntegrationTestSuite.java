/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.integration;

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
@Suite.SuiteClasses({service.integration.test.CreateTeamTest.class, 
                    service.integration.test.ReadTeamTest.class, 
                    service.integration.test.DeleteTeamTest.class})
public class TeamIntegrationTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
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
