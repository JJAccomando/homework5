package com.solvd.laba;

import com.solvd.laba.customexceptions.*;
import com.solvd.laba.myinterfaces.PassengerInterface;
import com.solvd.laba.myinterfaces.UniqueIdInterface;

public class Passenger implements UniqueIdInterface, PassengerInterface {

    private final int ID;
    private static int numPassengers = 0;
    private String firstName, lastName;
    private int countBags = 0;
    private CustomLinkedList<Luggage> myList = new CustomLinkedList<>();
    private Seat seat;

    //Passenger Object constructor 
    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ++numPassengers;
    }

    //returns current number of Passenger Objects instantiated
    public static final int getNumPassengers() {
        return numPassengers;
    }



    ////////////// PassengerInterface Overrides //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //returns Passenger Object's first name
    @Override
    public final String getFirstName() {
        return firstName;
    }

    //returns Passenger Object's last name
    @Override
    public final String getLastName() {
        return lastName;
    }

    //adds Luggage Object to Passenger Object's array of Luggage and returns true
    //does not add Luggage Object if Luggage weight is over 50lbs or Passenger Luggage array is full
    @Override
    public final boolean addBags(Luggage bag) throws OversizeBagException, OverLimitException {
        if (countBags >= MAX_LUGGAGE) 
            throw new OverLimitException("Passenger has maximum number of luggage!");
        if (bag.isOverweight())
            throw new OversizeBagException("luggage cannot exceed maximum weight of 50lbs!");
        myList.add(bag);
        countBags++;
        return true;
    }

    //returns total number of Luggage Object's Passenger has
    @Override
    public final int getNumBags() {
        return countBags;
    }

    //assigns Passenger Object with a Seat unless Passenger's current Seat is the same as the new Seat
    @Override
    public final void setSeatNum(Seat seat) throws DoubleBookException {
        if (this.seat != null && this.seat.equals(seat)) {
            throw new DoubleBookException("Passenger has already been assigned this seat!");
        }
        this.seat = seat;
    }

    //returns Passenger Object's assigned Seat if Passenger has assigned Seat
    @Override
    public final Seat getSeat() throws NullSeatException {
        if (seat == null)
            throw new NullSeatException("Passenger does not have assigned seat!");
        return seat;
    }

    //returns array containing Passenger Object's Luggage Objects if Passenger has at least 1 Luggage
    @Override
    public final CustomLinkedList<Luggage> getLuggage() throws NullBagException {
        if (countBags == 0)
            throw new NullBagException("Passenger does not have any luggage!");
        return myList;
    }



    ////////////// UniqueIdInterface Overrides ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //returns Passenger Object's ID#
    @Override
    public final int getId() {
        return ID;
    }



    ////////////// Object Class Overrides ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //returns a String of a Passenger Object as that Object's "firstName", "lastName",  and ID#
    @Override
    public final String toString() {
        String myString = String.format("Passenger %1$s %2$s\nPassenger#: %3$d", firstName, lastName, ID);
        return myString;
    }

    //compares 2 Passenger Objects by comparing their Object's hashcodes
    @Override
    public final boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof Passenger) {
            Passenger cast = (Passenger)obj;
            return this.hashCode() == cast.hashCode();
        }
        return false;
    }

    //Passenger Object's hashcode is set to its unique ID#
    @Override
    public final int hashCode() {
        return this.getId();
    }
    
}
