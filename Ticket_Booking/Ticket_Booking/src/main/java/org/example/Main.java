package org.example;

import java.util.*;

public class Main {

    public static void bookTicket (Passenger p) {

        TicketBooker booker = new TicketBooker ();

        if (TicketBooker.availableWaitingList == 0) {
            System.out.println ("No Tickets Available");
            return;
        }

        if ((p.berthPreference.equals ("L") && TicketBooker.availableLowerBerth > 0) ||
                (p.berthPreference.equals ("M") && TicketBooker.availableMiddleBerth > 0) ||
                (p.berthPreference.equals ("U") && TicketBooker.availableUpperBerth > 0)) {
            System.out.println ("Prefered berth available");

            if (p.berthPreference.equals ("L")) {
                System.out.println ("Lower berth given");
                booker.bookTicket (p, (TicketBooker.lowerBerthPositions.get(0)), "L");
                TicketBooker.lowerBerthPositions.remove(0);
                TicketBooker.availableLowerBerth--;
            }

            else if (p.berthPreference.equals ("M")) {
                System.out.println ("Middle berth given");
                booker.bookTicket (p, (TicketBooker.middleBerthPositions.get(0)), "L");
                TicketBooker.middleBerthPositions.remove(0);
                TicketBooker.availableMiddleBerth--;
            }

            else if (p.berthPreference.equals ("U")) {
                System.out.println ("Upper berth given");
                booker.bookTicket (p, (TicketBooker.upperBerthPositions.get (0)), "L");
                TicketBooker.upperBerthPositions.remove (0);
                TicketBooker.availableUpperBerth--;
            }

        }

        else if (TicketBooker.availableLowerBerth > 0) {
            System.out.println ("Lower berth given");
            booker.bookTicket (p, (TicketBooker.lowerBerthPositions.get (0)), "L");
            TicketBooker.lowerBerthPositions.remove (0);
            TicketBooker.availableLowerBerth--;
        }

        else if (TicketBooker.availableMiddleBerth > 0) {
            System.out.println ("Middle berth given");
            booker.bookTicket (p, (TicketBooker.middleBerthPositions.get (0)), "L");
            TicketBooker.middleBerthPositions.remove (0);
            TicketBooker.availableMiddleBerth--;
        }

        else if (TicketBooker.availableUpperBerth > 0) {
            System.out.println ("Upper berth given");
            booker.bookTicket (p, (TicketBooker.upperBerthPositions.get (0)), "L");
            TicketBooker.upperBerthPositions.remove (0);
            TicketBooker.availableUpperBerth--;
        }

        else if (TicketBooker.availableRacList > 0) {
            System.out.println ("RAC available");
            booker.addToRAC (p, (TicketBooker.racListPositions.get (0)), "RAC");
            TicketBooker.racListPositions.remove (0);
            TicketBooker.availableRacList--;
        }

        else if (TicketBooker.availableWaitingList > 0) {
            System.out.println ("You are in a Waiting list");
            booker.addToWaitingList (p, (TicketBooker.waitingListPositions.get (0)), "WL");
            TicketBooker.waitingListPositions.remove (0);
            TicketBooker.availableWaitingList--;
        }

    }

    public static void cancelTicket (int id) {

        TicketBooker booker = new TicketBooker ();

        if (!TicketBooker.passengers.containsKey(id)) {
            System.out.println ("Passenger detail Unknown");
        }

        else {
            booker.cancelTicket (id);
        }

    }

    public static void main (String[] args) {

        Scanner sc = new Scanner (System.in);
        boolean loop = true;

        while (loop) {

            System.out.println (" 1. Book Ticket: \n 2. Cancel Ticket: \n 3. Show Available Tickets: \n 4. Show Booked Tickets: \n 5. Exit");
            int choice = sc.nextInt ();

            switch (choice) {

                case 1: {
                    System.out.println ("Enter Passenger Name, Age, Berth Preference (L-Lower, M-Middle, U-Upper)");
                    String name = sc.nextLine();
                    int age = sc.nextInt();
                    String berthPreference = sc.next();
                    Passenger p = new Passenger (name, age, berthPreference);
                    bookTicket(p);
                }
                break;

                case 2: {
                    System.out.println ("Enter Passenger id to cancel");
                    int id = sc.nextInt ();
                    cancelTicket (id);
                }
                break;

                case 3, 4: {
                    System.out.println ("Enter Passenger Name, Age, Berth Preference (L-Lower, M-Middle, U-Upper)");
                }
                break;

                case 5: {
                    loop = false;
                }
                break;

                default: {
                    System.out.println("Please enter a valid choice");
                }

            }

        }

    }
}