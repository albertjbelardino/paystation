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
public class LinearRateStrategy implements RateStrategy {
    
    public int calculateTime(int insertedSoFar) {
        return insertedSoFar;
    }
}
