/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.json.JSONConfiguration;
import entities.Player;
import entities.Team;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Jersey REST client generated for REST resource:TeamRESTFacade [team]<br>
 *  USAGE:
 * <pre>
 *        TestTeam client = new TestTeam();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author U530619
 */
public class TestTeam {
    private WebResource teamResource;
    private WebResource playerResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/playermanager/api";
    
    public static final String MANAGER_USERNAME = "alexferguson";
    public static final String MANAGER_PASSWORD = "hairdrier";
    public static final String PLAYER_USERNAME = "harryhaddock";
    public static final String PLAYER_PASSWORD = "fishyname";

    public static void main(String [] args) {
        TestTeam testTeam = new TestTeam();
        GenericType<Collection<Player>> genericType = new GenericType<Collection<Player>>(){};
       
        System.out.println("Count : " + testTeam.count());
 
        System.out.println("Team 1 players BEFORE...");
        Collection<Player> playersBefore = testTeam.findAllPlayers_JSON(genericType, "1");
        for (Player playerBefore : playersBefore) {
            System.out.println(playerBefore.toString());
        }
        
//        Team team1 = testTeam.find_JSON(Team.class, "1");
//        Player player = new Player();
//        player.setName("george");
//        player.setTeam(team1);
//        ClientResponse response = testTeam.add_JSON("1", player);
//
//        System.out.println("Team 1 players AFTER...");
//        Collection<Player> playersAfter = testTeam.findAllPlayers_JSON(genericType, "1");
//        for (Player playerAfter : playersAfter) {
//            System.out.println(playerAfter.toString());
//        }
    }
    
    public TestTeam() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        client = Client.create(config);
        setUsernamePassword(MANAGER_USERNAME, MANAGER_PASSWORD);
        teamResource = client.resource(BASE_URI).path("team");
        playerResource = client.resource(BASE_URI).path("team");
    }

    public <T> T findAllPlayers_JSON(GenericType<T> genericType, String id) throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/players", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(genericType);
    }
    
    public String count() throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path("count");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void remove(String id) throws UniformInterfaceException {
        teamResource.path(java.text.MessageFormat.format("{0}", new Object[]{id})).delete();
    }

    public <T> Collection<T> findAllPlayers_XML(Class<T> responseType, String id) throws UniformInterfaceException {
        GenericType<Collection<T>> genericType = new GenericType<Collection<T>>(){};
        WebResource resource = teamResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/players", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(genericType);
    }


    public <T> T findAll_XML(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = teamResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findAll_JSON(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = teamResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void edit_XML(Object requestEntity) throws UniformInterfaceException {
        teamResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }

    public void edit_JSON(Object requestEntity) throws UniformInterfaceException {
        teamResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(requestEntity);
    }

    public ClientResponse create_XML(Object requestEntity) throws UniformInterfaceException {
        return teamResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).post(ClientResponse.class, requestEntity);
    }

    public ClientResponse create_JSON(Object requestEntity) throws UniformInterfaceException {
        return teamResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(ClientResponse.class, requestEntity);
    }

    public ClientResponse add_JSON(String id, Object requestEntity) throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/players", new Object[]{id}));
        return resource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(ClientResponse.class, requestEntity);
    }
    
    public <T> T findRange_XML(Class<T> responseType, String max, String first) throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{max, first}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findRange_JSON(Class<T> responseType, String max, String first) throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{max, first}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T find_XML(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T find_JSON(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.destroy();
    }
    
    public final void setUsernamePassword(String username, String password) {
        client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(username, password));
    }
    
    public final void setUserAsManager() {
        client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(MANAGER_USERNAME, MANAGER_PASSWORD));
    }
    
    public final void setUserAsPlayer() {
        client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(PLAYER_USERNAME, PLAYER_PASSWORD));
    }
    
}
