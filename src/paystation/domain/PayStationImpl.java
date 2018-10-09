package paystation.domain;

import java.util.HashMap;

/**
 * Implementation of the pay station.
 *
 * Responsibilities:
 *
 * 1) Accept payment; 
 * 2) Calculate parking time based on payment; 
 * 3) Know earning, parking time bought; 
 * 4) Issue receipts; 
 * 5) Handle buy and cancel events.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class PayStationImpl implements PayStation {
    
    private int insertedSoFar;
    private int timeBought;
    private int total = 0;
    private RateStrategy rateStrategy;
    public HashMap<Integer, Integer> inserted = new HashMap<Integer, Integer>();
    
    public PayStationImpl() {
        rateStrategy = new LinearRateStrategy();
    }
    
    public PayStationImpl(RateStrategy rateStrategy) {
        this.rateStrategy = rateStrategy;
    }

    @Override
    public void addPayment(int coinValue)
            throws IllegalCoinException {
        switch (coinValue) {
            case 5: break;
            case 10: break;
            case 25: break;
            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }
        if(inserted.containsKey(coinValue)) {
            int curValue = inserted.get(coinValue);
            inserted.put(coinValue, curValue+=1);
        }    
        else {
            inserted.put(coinValue, 1);
        } 
        insertedSoFar += coinValue;
        timeBought = rateStrategy.calculateTime(insertedSoFar);
    }
    
    public int getMapValue(int coinValue) {
        return inserted.get(coinValue);
    }

    @Override
    public int readDisplay() {
        return timeBought;
    }

    @Override
    public Receipt buy() {
        Receipt r = new ReceiptImpl(timeBought);
        total += insertedSoFar;
        reset();
        return r;
    }

    @Override
    public HashMap<Integer, Integer> cancel() {
        HashMap<Integer, Integer> current = inserted;
        reset();
        return current;
    }
    
    private void reset() {
        timeBought = insertedSoFar = 0;
        inserted = new HashMap<Integer, Integer>();
    }
    
    public int empty() {
        int previousTotal = total;
        total = 0;
        return previousTotal;
    }
    
    public int getInsertedSoFar() {
        return insertedSoFar;
    }
    
    public HashMap<Integer, Integer> getInserted() {
        return inserted;
    }
    
    public void setRateStrategy(RateStrategy rateStrategy) {
        this.rateStrategy = rateStrategy;
    }
}
