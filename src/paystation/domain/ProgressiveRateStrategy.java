/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

/**
 *
 * @author tug83326
 */
public class ProgressiveRateStrategy implements RateStrategy {
    
    public int calculateTime(int insertedSoFar) {
        int timeInMinutes = 0;
        
        if(insertedSoFar < 150) {
            return insertedSoFar / 5 * 2;
        }
        else if(insertedSoFar < 350) {
            timeInMinutes += 60;
            timeInMinutes += (insertedSoFar - 150) / 5 * 1.5;
            return timeInMinutes;
        }
        else {
            timeInMinutes += 120;
            timeInMinutes += (insertedSoFar - 350) / 5;
            return timeInMinutes;
        }    
    }
}
