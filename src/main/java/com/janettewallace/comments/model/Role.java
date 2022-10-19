package com.janettewallace.comments.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity //generate table in MariaDB based on annotation specifications
public class Role {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;

   public Role() {
   }

   public Role(String name) {
       this.name = name;
   }
   
   
   //getter, setter, and toString methods
   public int getId() {
       return id;
   }
   
   public void setId(int id) {
       this.id = id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   @Override
   public String toString() {
       return "Role{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
   }
}

