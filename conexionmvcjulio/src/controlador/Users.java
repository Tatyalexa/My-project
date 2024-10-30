/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MIller
 */
public class Users {
    
    Connection connection;
    private Integer id;
    private String fullname;
    private String username;
    private String password;
   // private String user_type;
    private String phone;
    

    public Users(){
    
    }
    //datos desde el formulario
    public Users(Integer ID, String UNAME, String PASW, String FNAME, String TEL){
    
        this.id = ID;
        this.username = UNAME;
        this.password = PASW;
        this.fullname = FNAME;
       // this.user_type = UTYP;
        this.phone = TEL;
        
    }

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

   

    public String getPassword() {
        return password;
    }

   
    
    
    // insert a new user CRUD
     public static void insertUser(Users user)
    {
        //crear el objeto de la clase  Conexion_DB
        Connection con = modelo.Conexion_DB.getConnection();
        PreparedStatement ps;
        //jTextField_fullname noooo es ??
        //INSERT INTO `users`(`full_name`, `username`, `password`, `phone`) VALUES ('pedro','pedro','1234','245789') //jTextField_fullname
        try {
            ps = con.prepareStatement("INSERT INTO `users`(`full_name`, `username`, `password`, `phone`) VALUES (?,?,?,?)");

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            //como el tipo de usuario no se puede exponer en un formulario el admin crea los diferentes a user
           // ps.setString(3, "user");// the admin will add a user
           
            ps.setString(4, user.getPhone());
          
            

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "New User Added");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    
    
    
}
