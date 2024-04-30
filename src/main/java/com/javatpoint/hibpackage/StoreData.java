package com.javatpoint.hibpackage;  
  

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
  
public class StoreData {  
  
    public static void main( String[] args )  
    {  
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
      
    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    Session session = factory.openSession();  
    Transaction t = session.beginTransaction();   
                
        Employee e1=new Employee();    
        //e1.setId(109);    
        e1.setFirstName("Gaurav");    
        e1.setLastName("Chawla");    
            
      
        
        Address adr=new Address();
        adr.setCity("HYDERABAD");
        adr.setStreet("KONDAPUR");
        adr.setPinCode("500084");
        adr.setState("TELANGANA");
        
        Address adr1=new Address();
        adr1.setCity("HYDERABAD");
        adr1.setStreet("KONDAPUR");
        adr1.setPinCode("500084");
        adr1.setState("TELANGANA");
        
        e1.getListOfAddresses().add(adr);
        e1.getListOfAddresses().add(adr1);
        
        session.persist(e1);  
        t.commit();
        
        Employee employee = (Employee) session.get(Employee.class, 6);
        System.out.println("successfully saved");    
        //factory.close();  
        //session.close();
        //System.out.println("Chan:"+ employee.getListOfAddresses().size());
        //<mapping resource="employee.hbm.xml"/>
        //<mapping class="com.javatpoint.hibpackage.Employee"/>
        System.out.println("Chan:");
        //load
        @SuppressWarnings("deprecation")
		Employee zzz = session.load(Employee.class,1); 
        zzz.getFirstName();// on demand
        
       // System.out.println("Sat:"+ zzz.getFirstName() );
        factory.close();
        session.close();                
    }  
}  