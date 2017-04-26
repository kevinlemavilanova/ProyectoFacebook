/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofacebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Media;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author klemavilanova
 */
public class ProyectoFacebook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FacebookException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("526754324380580")
                .setOAuthAppSecret("")
                .setOAuthAccessToken("")
                .setOAuthPermissions("");
        FacebookFactory ff = new FacebookFactory(cb.build());
        Facebook fb = ff.getInstance();

        Boolean contin = true;
        do {
            String option = JOptionPane.showInputDialog("Seleccione una opcion");
            switch (option) {
                case "a":
                    String comentario1 = JOptionPane.showInputDialog("Comentario: ");
                    fb.postStatusMessage(comentario1);
                    break;
                case "b":
                    //Dar Like a un post
                    String IdPost = JOptionPane.showInputDialog("Id del Post a comentar");
                    fb.likePost(IdPost);
                    break;
                case "c":
                    //Subir foto
                    Media foto = new Media(new File("URl de la foto"));
                    fb.postPhoto(foto);
                    break;
                case "d":
                    //Publicar un Comentario
                    String IdPost1 = JOptionPane.showInputDialog("Id del Post a comentar");
                    String comentario = JOptionPane.showInputDialog("Comentario: ");
                    fb.commentPost(IdPost1, comentario);
                    break;
                case "e":
                    //Obtener Comentarios
                    String idpost = JOptionPane.showInputDialog("Id del Post para obtener comentarios");
                    fb.getCommentReplies(idpost);
                    break;
                case "f":
                    //Buscar Posts
                    String busqueda = JOptionPane.showInputDialog("Buscar: ");
                    ResponseList<Post> results = fb.searchPosts(busqueda);
                    break;
            }
        } while (contin = true);

    }

}
