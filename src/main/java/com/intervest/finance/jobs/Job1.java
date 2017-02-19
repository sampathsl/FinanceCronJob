package com.intervest.finance.jobs;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericApplicationContext;

import com.intervest.finance.config.SpringContext;
import com.intervest.finance.model.model.Horse;
import com.intervest.finance.model.model.dao.inter.IHorseDAO;

/**
 * Hello world!
 *
 */
public class Job1 
{
	
	static Log log = LogFactory.getLog(Job1.class.getName());
	
    public static void main( String[] args )
    {
        System.out.println( "Job1 !" );
        
        GenericApplicationContext ctx = SpringContext.getContext();
	    BeanFactory factory = ctx;
	    IHorseDAO horseDAO = (IHorseDAO) factory.getBean("horseDAOImpl"); 
	    
	    log.info("Create a Horse table...");
	    horseDAO.createTable();
	    
	    log.info("Adding Horse data object...");
	    horseDAO.createHorse("Shirus", "9", "Quarab", "Grigio", 
	    		RandomStringUtils.random(15, false, true));
	    horseDAO.createHorse("Eclisse", "13", "Appalousa", "Pezzato con coperta", 
	    		RandomStringUtils.random(15, false, true));
	    horseDAO.createHorse("Morgana", "6", "Maremmana", "Baia", 
	    		RandomStringUtils.random(15, false, true));
	    horseDAO.createHorse("Macchia", "12", "Appalousa", "Morello", 
	    		RandomStringUtils.random(15, false, true));
	    
	    log.info("Retrieving data..");
		for(Horse currentHorse : horseDAO.selectAll()){
			log.info("From DB: " + currentHorse.toString());
		}

		log.info("Deleting record macchia and viewing...");
		horseDAO.deleteHorse("macchia");
		for(Horse currentHorse : horseDAO.selectAll()){
			log.info("From DB: " + currentHorse.toString());
		}

		log.info("Adding a new record and viewing...");
		horseDAO.createHorse("Furia", "10", "Appalousa", "Morello",
				RandomStringUtils.random(15, false, true));
		for(Horse currentHorse : horseDAO.selectAll()){
			log.info("From DB: " + currentHorse.toString());
		}

		log.info("Deleting everything and viewing...");
		horseDAO.deleteAll();
		for(Horse currentHorse : horseDAO.selectAll()){
			log.info("From DB: " + currentHorse.toString());
		}
		
	    log.info("Drop a Horse table...");
	    horseDAO.dropTable();
        
        
    }
}
