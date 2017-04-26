/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofacebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;

/**
 *
 * @author klemavilanova
 */
public class ProyectoFacebook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FacebookException{
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("526754324380580")
                .setOAuthAppSecret("078746d88c0faa75719eb477160322cf")
                .setOAuthAccessToken("EAAHfFIxje6QBAFpKRFB0XOiSKOSmIpFP4agwJMZBeRmRucWYU3BrqVNNhnyg3eN81vF40uVyim1yHIUfNl6toJsZCjQTBL3nFt3lRDuMK3Xwu5CFwJJlHtwCfCIwP32ioio0Ulj7Km6eplkm9tLnOZAU8cGjZCVzGKmRhJ3Oxfrfqqrflz8phI5oTBfYthwZD")
                .setOAuthPermissions("publish_stream");
        FacebookFactory ff = new FacebookFactory(cb.build());
        Facebook facebook = ff.getInstance();
        
        facebook.postStatusMessage("Hello World from Facebook4J.");
        
    }

}
