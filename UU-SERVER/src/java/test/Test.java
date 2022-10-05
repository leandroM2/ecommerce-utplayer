package test;
import java.sql.*;
import util.ConectaBD;
public class Test {
    public static void main(String[] args) {
        ConectaBD conect=new ConectaBD();
        Connection c=null;
        try{
            c=conect.getConnection();
            System.out.println("Conexión exitosa");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }       
    }   
}