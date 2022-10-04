/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import dao.DaoComics;
import dao.impl.DaoComicsImpl;
import model.Comics;

/**
 *
 * @author LEANDRO
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                DaoComics dao = new DaoComicsImpl();
        
        System.out.println("INSERTANDO");
        Comics comics = new Comics();
        comics.setNombre("PRUEBAJAVA");
        comics.setCategoria("PRUEBAJAVA");
        comics.setEditorial("PRUEBAJAVA");
        comics.setStock(100);
        comics.setPrecio(20d);
        comics.setImagen("imagen.jpg");
        try {
            String msg = dao.comicsIns(comics);
            System.out.println("Respuesta:" + msg);
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }
    }
    
}
