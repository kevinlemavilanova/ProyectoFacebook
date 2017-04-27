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
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author klemavilanova
 */
public class ProyectoFacebook {

    static ConfigurationBuilder cb;
    static FacebookFactory ff;
    static Facebook fb;

    /**
     * @param args the command line arguments
     * @throws facebook4j.FacebookException
     */
    public static void main(String[] args) throws FacebookException {
        ConfigBuilder();
        Boolean contin = true;
        do {
            String option = JOptionPane.showInputDialog("Seleccione una opcion "
                    + "\n A- Actualizar estado "
                    + "\n B- Like a un post "
                    + "\n C- Subir foto "
                    + "\n D- Publicar Comentario "
                    + "\n E- Obtener Comentarios"
                    + "\n F- Buscar posts"
                    + "\n G- Extender tokem"
                    + "\n X- Salir");
            switch (option) {
                case "a":
                    //Actualizar el estado
                    UpdateState();
                    break;
                case "b":
                    //Dar Like a un post
                    LikePost();
                    break;
                case "c":
                    //Subir foto
                    UpPhoto();
                    break;
                case "d":
                    //Publicar un Comentario
                    CommentPost();
                    break;
                case "e":
                    //Obtener Comentarios
                    getComments();
                    break;
                case "f":
                    //Buscar Posts
                    FindPost();
                    break;
                case "g":
                    //Extender tokem
                    ExtendTokem();
                    break;
                case "x":
                    //Salida del menu
                    contin = false;
                    break;
            }
        } while (contin == true);

    }

    public static void ConfigBuilder() throws FacebookException {
    cb = new ConfigurationBuilder();
    cb.setDebugEnabled (true)
                .setOAuthAppId("")
                .setOAuthAppSecret("")
                .setOAuthAccessToken("")
                .setOAuthPermissions("user_likes,user_friends,public_profile,user_posts");
    ff = new FacebookFactory(cb.build());
    fb = ff.getInstance();
}
/**
 * Actualiza el estado con el metodo de postStatusMessage y le pasamos el estado que queremos postear
 * @throws FacebookException 
 */
public static void UpdateState() throws FacebookException {
        String comentario1 = JOptionPane.showInputDialog("Comentario: ");
        fb.postStatusMessage(comentario1);
    }

/**
 * Sube una foto, nos pide la ruta de la foto
 * @throws FacebookException 
 */
    public static void UpPhoto() throws FacebookException {
        Media foto = new Media(new File("URl de la foto"));
        fb.postPhoto(foto);
    }

    /**
     * Da like al post con el id que hemos obetenido de un post el cual se lo pasamos por teclado
     * @throws FacebookException 
     */
    public static void LikePost() throws FacebookException {
        String IdPost = JOptionPane.showInputDialog("Id del Post a comentar");
        fb.likePost(IdPost);
    }
/**
 * Comenta en un post con el id que le hemos pasado
 * @throws FacebookException 
 */
    public static void CommentPost() throws FacebookException {
        String IdPost1 = JOptionPane.showInputDialog("Id del Post a comentar");
        String comentario = JOptionPane.showInputDialog("Comentario: ");
        fb.commentPost(IdPost1, comentario);
    }
/**
 * Obtiene los comentarios de post con el id que le apsamos y los muestra
 * @throws FacebookException 
 */
    public static void getComments() throws FacebookException {
        String idpost = JOptionPane.showInputDialog("Id del Post para obtener comentarios");
        ResponseList coments = fb.getCommentReplies(idpost);
        String[] coment = (String[]) coments.toArray();
        for (String n : coment) {
            System.out.println(n);
        }
    }
/**
 * Busca un post con el nombre que le pasamos con searchPost de fb
 * @throws FacebookException 
 */
    public static void FindPost() throws FacebookException {
        String busqueda = JOptionPane.showInputDialog("Buscar: ");
        ResponseList<Post> results = fb.searchPosts(busqueda);
        String[] Posts = (String[]) results.toArray();
        for (String n : Posts) {
            System.out.println(n);
        }    }

    public static void ExtendTokem() throws FacebookException {
        String shortLivedToken = "your-short-lived-token";
        AccessToken extendedToken = fb.extendTokenExpiration(shortLivedToken);
    }

}
