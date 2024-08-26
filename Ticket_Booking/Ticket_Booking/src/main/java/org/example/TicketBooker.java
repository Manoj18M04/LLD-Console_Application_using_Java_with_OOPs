package org.example;

import java.util.*;

public class TicketBooker {

    static int availableLowerBerth = 21;
    static int availableMiddleBerth = 21;
    static int availableUpperBerth = 21;
    static int availableRacList = 18;
    static int availableWaitingList = 10;

    static Queue<Integer> racList = new LinkedList<>();
    static Queue<Integer> waitingList = new LinkedList<>();
    static List<Integer> bookedList = new ArrayList<>();

    static List<Integer> lowerBerthPositions = new ArrayList<>(1);
    static List<Integer> middleBerthPositions = new ArrayList<>(1);
    static List<Integer> upperBerthPositions = new ArrayList<>(1);
    static List<Integer> racListPositions = new ArrayList<>(1);
    static List<Integer> waitingListPositions = new ArrayList<>(1);

    static Map<Integer, Passenger> passengers = new HashMap<>();


    public void bookTicket (Passenger p, int berthInfo, String allottedBerth) {

        p.number = berthInfo;
        p.alloted = allottedBerth;
        passengers.put (p.passengerId, p);
        bookedList.add (p.passengerId);
        System.out.println ("---------- Booked Successfully ----------");

    }

    public void addToRAC (Passenger p, int berthInfo, String allottedBerth) {

        p.number = berthInfo;
        p.alloted = allottedBerth;
        passengers.put (p.passengerId, p);
        racList.add (p.passengerId);
        System.out.println ("---------- Added to RAC Successfully ----------");

    }

    public void addToWaitingList (Passenger p, int berthInfo, String allottedBerth) {

        p.number = berthInfo;
        p.alloted = allottedBerth;
        passengers.put (p.passengerId, p);
        waitingList.add (p.passengerId);
        System.out.println ("---------- Added to Waiting List Successfully ----------");

    }

    public void cancelTicket (int passengerId) {

        Passenger p = passengers.get (passengerId);
        passengers.remove (passengerId);
        bookedList.remove (passengerId);

        int positionBooked = p.number;

        System.out.println ("---------- Cancelled Successfully ----------");

        if (p.alloted.isEmpty()) {
            System.out.println("No Bookings for " + passengerId);
        }

    }

}