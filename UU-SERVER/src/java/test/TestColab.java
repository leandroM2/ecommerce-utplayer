
package test;
import dao.DaoUsuarios;
import dao.impl.DaoUsuariosImpl;
import dto.Usuarios;
import java.sql.Connection;
import util.ConectaBD;
public class TestColab {

    public static void main(String[] args) {
        DaoUsuarios DC=new DaoUsuariosImpl();
        ConectaBD conect=new ConectaBD();
        Connection c=null;
        try{
            c=conect.getConnection();
            System.out.println("Conexión exitosa");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        } 
        try {
            Usuarios cc=DC.ColabLogin("arturo@utp.com","2021");
            System.out.println("Usuario: "+cc.getCorreo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
