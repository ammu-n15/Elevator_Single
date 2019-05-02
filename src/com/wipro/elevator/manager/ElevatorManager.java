package com.wipro.elevator.manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import com.wipro.elevator.dto.ElevatorDTO;
import com.wipro.elevator.dto.RequestDTO;
import com.wipro.elevator.entity.ElevatorImpl;
import com.wipro.elevator.exception.InvalidDirectionException;

public class ElevatorManager {
	
	public static Queue<RequestDTO> requestList =  new PriorityQueue<RequestDTO>(10,RequestDTO.comparator); 
	public static  Set<Integer> targetList = new HashSet<Integer>();
	private ElevatorImpl elevator;
	
	
	public ElevatorManager() {
					this.elevator= elevator.getInstance();
				/*	this.requestList = new PriorityQueue<RequestDTO>();*/
	}

	
	public void addPickUp(RequestDTO request){
		
		
		// add all requests to Queue
		requestList.add(request);
		
		
		
	}
	
	public void execute() {

		this.elevator.processRequest();

	}

	 /*  if passenger presses from OUTSIDE the lift , from which floor user pressed the lift and which button is pressed */
	 
	public void liftRequestedFrom(int source, String direction) {

		// add request from user to Queue

		requestList.add(new RequestDTO(source, direction));

		if (!ElevatorDTO.isLiftTravelling()) { // assumption that lift is idle
												// initially

			ElevatorDTO.setLiftTravelling(true); // now lift is moving and is
													// not idle

			if (source > ElevatorDTO.getCurrentfloor()) {

				ElevatorDTO.setLiftTravellingUp(true); // if source is greater than current floor, then move up
				// Direction = "UP";

			} else {
				ElevatorDTO.setLiftTravellingUp(false);
				// Direction = "DOWN";
			}
			ElevatorDTO.setCurrentfloor(source);
		}
	}
	 
	 /* if passenger presses from INSIDE the lift , which floor user wants to go and which button is pressed */
	 
	 public void liftRequestedToGo(int target){
		 requestList.add(new RequestDTO(target,"INSIDE"));
		 
	 }

}
