package com.solvd.laba;

import java.util.Scanner;
import com.solvd.laba.myenums.*;
import com.solvd.laba.customexceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Executor {

    public static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("Program start successful.");
        Boeing737 plane = new Boeing737();
        Flight flight = new Flight(plane, "LAX", "JFK");
        Passenger person1 = new Passenger("John", "Smith");
        Passenger person2 = new Passenger("George", "Washington");
        SeatType seat = SeatType.ECONOMY_CLASS;

        String firstName = "";
        String lastName = "";
        try (Scanner input = new Scanner(System.in)) { //Creates scanner within try-catch with resources block which will close scanner when finished
            logger.warn("Receiving user input.");
            System.out.print("Enter first name: ");
            firstName = input.nextLine();
            System.out.print("Enter last name: ");
            lastName = input.nextLine();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            logger.error("User input unsuccessful. Error");
        }
        logger.info("User input successful.");

        Passenger person3 = new Passenger(firstName, lastName);
        Luggage overweightBag = new Luggage(55);
        logger.warn("Over weight luggage created.");
        Luggage[] bags = new Luggage[15];
        int weight = 45;
        for (int i = 0; i < bags.length; i++) {
            Luggage bag = new Luggage(weight);
            bags[i] = bag;
        }

        try {
            person3.addBags(overweightBag); //Trys to add overweight Luggage to Passenger and throws OversizeBagException
        } catch (OversizeBagException obe) {
            System.out.println(obe.getMessage()); 
            logger.error("Failed to add passenger luggage. Error: {OversizeBagException}");
        } catch (OverLimitException ole) {
            System.out.println(ole.getMessage());
            logger.error("Failed to add passenger luggage. Error: {OverLimitException}");
        }

        System.out.println(person3.getNumBags()); //Displays 0 since no Luggage was added

        try {
            for (int i = 0; i < bags.length; i++) { //Trys to add more than maximum allowed Luggage to Passenger and throws OverLimitException
                person3.addBags(bags[i]);
            }
        } catch (OversizeBagException obe) {
            System.out.println(obe.getMessage());
            logger.error("Failed to add passenger luggage. Error: {OversizeBagException}");
        } catch (OverLimitException ole) {
            System.out.println(ole.getMessage());
            logger.error("Failed to add passenger luggage. Error: {OverLimitException}");
        }

        System.out.println(person3.getNumBags()); //Displays 10 because Passenger has maximum number of Luggage
        try {
            System.out.println(person3.getLuggage().toString());
        } catch (NullBagException nbe) {
            System.out.println(nbe.getMessage());
            logger.error("Failed to retrieve passenger luggage information. Error: {NullBagException}");
        }

        try {
            Passenger[] passengers = flight.getPassengers(); //Trys to return Passenger array and throws NullPassengerException because no Passengers were added to Flight yet
            for (Passenger passenger : passengers) { 
                System.out.println(passenger); //Trys to print each Passenger but will not execute because exception was thrown
            }
        } catch (NullPassengerException npe) {
            System.out.println(npe.getMessage()); 
            logger.error("Failed to retrieve passengers information. Error: {NullPassengerException}");
        }

        try {
            flight.bookSeat(person1, seat); //Books Passenger on Flight
            flight.bookSeat(person1, seat); //Trys to book same Passenger on same Flight and throws DoubleBookException
        } catch (DoubleBookException dbe) {
            System.out.println(dbe.getMessage()); 
            logger.error("Failed to add passenger to flight. Error: {DoubleBookException}");
        }

        System.out.println(flight.getNumPassengers()); //Prints out 1 because only one Passenger was added since second Passenger was a duplicate

        try {
            System.out.println(person1.getSeat()); //Prints person1's seat number
            System.out.println(person2.getSeat()); //Trys to print person2's seat number and throws NullSeatException because person2 was never assigned a Seat
        } catch (NullSeatException nse) {
            System.out.println(nse.getMessage()); 
            logger.error("Failed to retrieve seat information. Error: {NullSeatException}");
        }

        logger.info("Program success. Shutting down...");
    }  
    
}
