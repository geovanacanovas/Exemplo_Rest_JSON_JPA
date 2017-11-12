package com.mysystem.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
   

  @Entity
  public class Client implements Serializable {
         
         private static final long serialVersionUID = -3842844978617110554L;
         
         @Id
         @GeneratedValue(strategy=GenerationType.AUTO)
         private int id;
         private String userName;
         private String password;
         private String address;
         private String email;
         
         public int getId() {
               return id;
         }
         
         public void setId(int id) {
               this.id = id;
         }
         
         public String getUserName() {
               return userName;
         }
         
         public void setUserName(String userName) {
               this.userName = userName;
         }
         
         public String getPassword() {
               return password;
         }
         
         public void setPassword(String password) {
               this.password = password;
         }
         
         public String getAddress() {
               return address;
         }
         
         public void setAddress(String address) {
               this.address = address;
         }
         
         public String getEmail() {
               return email;
         }
         
         public void setEmail(String email) {
               this.email = email;
         }

         
         
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Client other = (Client) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", userName=" + userName + ", password=" + password + ", address=" + address
					+ ", email=" + email + "]";
		}
   
  }