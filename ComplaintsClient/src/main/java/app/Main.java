/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author olunia
 */
public class Main {
    
    static String url = "http://localhost:8080/Complaints/resources/complaints";
    
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient(); 
        String count = client.target(url + 
              "resources/complaints/count").request(MediaType.TEXT_PLAIN).get(String.class); 
         
        System.out.println("Count: " + count); 
         
        List<Complaint> allComplaints = client.target(url)
                 .request(MediaType.APPLICATION_JSON)
                 .get(Response.class)
                 .readEntity(new GenericType<List<Complaint>>(){});
        
        System.out.println("Wszystkie skargi:");
        for(Complaint complaint : allComplaints){
            System.out.println(complaint.toString());
        }
        
        Complaint complaint=client.target(url + "/1")
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint.class);
        
        System.out.println("Pierwsza skarga: " + complaint.toString());
        
        complaint.setStatus("closed");
        
        client.target(url + "/"
                + complaint.getId().toString())
                .request()
                .put(Entity.entity(complaint, MediaType.APPLICATION_JSON));
        
        List<Complaint> opened = client.target(url + "?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<Complaint>>(){});
        
        System.out.println("Otwarte skargi:");
        for(Complaint complaintInOpened : opened){
            System.out.println(complaintInOpened.toString());
        }
        client.close();
    }
    
}
