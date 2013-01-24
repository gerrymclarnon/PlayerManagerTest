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
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import entities.Player;
import java.text.MessageFormat;
import java.util.Collection;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
public class TeamTestHelper {
    
    public enum User {

        MANAGER("alexferguson", "hairdrier"), PLAYER("harryhaddock", "fishyname");
        
        private final String username;
        private final String password;

        private User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
               return password;
        }

        @Override
        public String toString() {
            return "User{" + "username=" + username + ", password=" + password + '}';
        }

    }
    
    private WebResource teamResource;
    private WebResource playerResource;
    private Client client;
    private User user;

    private static final String BASE_URI = "http://localhost:8080/playermanager/api";
    
    public static void main(String [] args) {
        TeamTestHelper testTeam = new TeamTestHelper();
        GenericType<Collection<Player>> genericType = new GenericType<Collection<Player>>(){};
       
        System.out.println("Count : " + testTeam.count());
 
        System.out.println("Team 1 players BEFORE...");
        Collection<Player> playersBefore = testTeam.findAllPlayers(genericType, "1");
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
    
    public TeamTestHelper() {
        ClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        client = Client.create(config);
        setUsernamePassword(MANAGER_USERNAME, MANAGER_PASSWORD);
        teamResource = client.resource(BASE_URI).path("team");
        playerResource = client.resource(BASE_URI).path("team");
    }

    public <T> T findAllPlayers(GenericType<T> genericType, String id) throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/players", new Object[]{id}));
        return resource.accept(MediaType.APPLICATION_JSON).get(genericType);
    }
    
    public String count() throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path("count");
        return resource.accept(MediaType.TEXT_PLAIN).get(String.class);
    }

    public void remove(String id) throws UniformInterfaceException {
        teamResource.path(MessageFormat.format("{0}", new Object[]{id})).delete();
    }

    public <T> T findAll(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = teamResource;
        return resource.accept(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void edit(Object requestEntity) throws UniformInterfaceException {
        teamResource.type(MediaType.APPLICATION_JSON).put(requestEntity);
    }

    public ClientResponse create(Object requestEntity) throws UniformInterfaceException {
        return teamResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, requestEntity);
    }

    public ClientResponse add(String id, Object requestEntity) throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path(MessageFormat.format("{0}/players", new Object[]{id}));
        return resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, requestEntity);
    }
    
    public <T> T findRange(Class<T> responseType, String max, String first) throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path(MessageFormat.format("{0}/{1}", new Object[]{max, first}));
        return resource.accept(MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T find(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = teamResource;
        resource = resource.path(MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.destroy();
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        setUsernamePassword(user.getUsername(), user.getPassword());
    }

    public final void setUsernamePassword(String username, String password) {
        client.addFilter(new HTTPBasicAuthFilter(username, password));
    }
}
