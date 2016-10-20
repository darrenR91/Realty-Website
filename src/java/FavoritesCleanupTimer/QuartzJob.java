/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FavoritesCleanupTimer;

/**
 *
 * @author Darrens
 */
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import src.db.FavouritesDB;

public class QuartzJob implements Job {
        @Override
        public void execute(JobExecutionContext context)
              throws JobExecutionException 
        {
            java.sql.Date date = new Date(Calendar.getInstance().getTime().getTime());
                
                FavouritesDB.cleanDB();
                System.out.println("Clean Database on the : "+ date);
        }
}