
package com.wipro.elevator.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.wipro.elevator.dto.ElevatorDTO;
import com.wipro.elevator.dto.RequestDTO;

import com.wipro.elevator.entity.ElevatorImpl;
import com.wipro.elevator.entity.User;
import com.wipro.elevator.manager.ElevatorManager;

/**
 * @author Amreen Nazeer
 */

public class Client {

	public static void main(String[] args) {
				
		  
		  ElevatorDTO.setCurrentfloor(0);  // assuming lift is in ground Floor initially
		  ElevatorDTO.setLiftWeight(50);
		  
		  // add the pickUp Requests 
		
		  ElevatorManager elevatorManager = new ElevatorManager();
		  elevatorManager.liftRequestedFrom(5, "UP"); //source,direction
		  elevatorManager.liftRequestedFrom(4, "DOWN");
		  elevatorManager.liftRequestedFrom(7, "UP");
		  elevatorManager.liftRequestedFrom(1, "DOWN");
		  
		  
		  
		  
		 /* elevatorManager.liftRequestedToGo(9); //how we will know if user 1 requested 9th floor
		  elevatorManager.liftRequestedToGo(2);
		  elevatorManager.liftRequestedToGo(10);*/
		  
		 		  
		  elevatorManager.execute();
		  
		  
		
		
		
		

	}

}
