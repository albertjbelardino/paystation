/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;
import java.util.Calendar;
/**
 *
 * @author tug83326
 */
public class AlternatingRateStrategy implements RateStrategy {
    
    public int calculateTime(int insertedSoFar) {
        if(Calendar.DAY_OF_WEEK == 1 || Calendar.DAY_OF_WEEK == 7)
            return (new ProgressiveRateStrategy()).calculateTime(insertedSoFar);
        else 
            return (new LinearRateStrategy()).calculateTime(insertedSoFar);
    }
}
