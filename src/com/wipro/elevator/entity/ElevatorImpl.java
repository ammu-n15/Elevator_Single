package com.wipro.elevator.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.junit.runner.Request;

import com.wipro.elevator.constants.Constants;
import com.wipro.elevator.dto.ElevatorDTO;
import com.wipro.elevator.dto.RequestDTO;
import com.wipro.elevator.exception.InvalidDirectionException;
import com.wipro.elevator.manager.ElevatorManager;
import com.wipro.elevator.manager.InputValidator;

public class ElevatorImpl implements Elevator {
	
	public int currentSource=0;
	int count =0;
	int count2 = 0;
	public int destination=0;
	public int currentchangesource=0;
	public int requestsum=0;
	public int maxdestination=0;
	List<Integer> list=new ArrayList<Integer>();
	//private int source=getCurrentFloor();
	
	private static ElevatorImpl elevator;
	
	
	
	
	public static  ElevatorImpl   getInstance(){
		if(elevator == null){
			elevator = new ElevatorImpl();			
		}
		return elevator;
		
	}

	
	
	@Override
	public void processRequest()    { // (5,UP)
		
		
		String Direction  = null;
		int nextFloor = 0; 
		
		InputValidator validator = new InputValidator();
		//ElevatorDTO elevatorDTO = new ElevatorDTO();
		
		while((ElevatorManager.requestList.size()!=0)){
			   RequestDTO firstRequest = ElevatorManager.requestList.peek();		
		
		
		      int currentFloor =  ElevatorDTO.getCurrentfloor();
		
		
		
		System.out.println("Checking weight");
				
		if(validator.isFullyLoaded(ElevatorDTO.getLiftWeight()))
			{
				System.out.println("Warning: Maximun weight of 100KG attained please unload");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		
	     //validate if lift is idle or not
		
		
		
		/*if(ElevatorDTO.isLiftTravellingUp()){
			  nextFloor = currentFloor +1 ;
			  
			  
		}else{
			  nextFloor = currentFloor-1;
		}
		*/
	/*	boolean isAvailableInRequestList =false;
		boolean isRequestNotProcessed = false;
		String srcDest = null;
		*/
	
				
				




		
		RequestDTO request = ElevatorManager.requestList.poll();
		if(request == null) break;
		System.out.println("Processing Request with Source Floor ="+request.getSourceFloor());
		ElevatorDTO.setCurrentfloor(request.getSourceFloor());
		openDoor(ElevatorDTO.getCurrentfloor(),request.getDirection());
		
		
		/*for(RequestDTO requestSet : ElevatorManager.requestList){
			     System.out.println(requestSet);
			     if((requestSet.getSourceFloor()== nextFloor) && (requestSet.getDirection().equals(Direction))){	
			    	 isAvailableInRequestList = true;			    	
			    	 requestSet.setRequestProcessed( true);
			    	 ElevatorDTO.setCurrentfloor(requestSet.getSourceFloor());
			    	 //remove the element from request list
			    	 // if the particular floor also available in destination list,remove it 
			    	 
			    	 //if  0 --> 4 -->4
			    	 openDoor(ElevatorDTO.getCurrentfloor(),"SOURCE");
			    	 isRequestNotProcessed =  true;
			    	 break;
			    	 
			     }
		}*/
		
		
		
		/*if(!isAvailableInRequestList){  // y this variable
			if(ElevatorManager.targetList.size() > 0){
				for(Integer target : ElevatorManager.targetList){
					    if(target==nextFloor){
					    	ElevatorDTO.setCurrentfloor(target);
					    	 //remove the element from target list
					    	 openDoor(ElevatorDTO.getCurrentfloor(),"DESTINATION");
					    	 isRequestNotProcessed = true;
					    	 break;
					    	
					    	
					    }
					
				}
			}
			
		}*/
		// if request is not served , added not operator, need to check
		
		/*if(!isRequestNotProcessed){
			ElevatorDTO.setCurrentfloor(nextFloor);		
			 
		}*/
		
		}
		
		
		
			
			
		
		
		
		
		// TODO Auto-generated method stub
		/*System.out.println("current floor :" + getCurrentFloor());
		System.out.println(request);*/
		/*int a=directionCheck(request.getSourceFloor(),request.getDestinationFloor());
		
			if (a == 1) {

				moveUp(request);

			} else if (a == -1) {
				moveDown(request);
			} else {
				System.out.println("source and destination cant be same");
			}*/
		
	}
	
	/* method to check if Lift need to go towards upwards or downwards*/
	
	public int directionCheck (int source ,int destination)
	{
		
		if((destination-source)>0)
		{
			return 1;
		}
		else if((destination-source)<0)
		{
			return -1;
		}
		return 0;
	}

	
	private void openDoor(int floor  , String src) {
		
		System.out.println("================>   Doors are opening in floor," + floor);
		ElevatorManager elevatorManager = new ElevatorManager();
			
		if((!Constants.ADD_DESTINATION_FLAG) && (!src.equals("INSIDE"))){
			  elevatorManager.liftRequestedToGo(7); //how we will know if user 1 requested 9th floor
		      elevatorManager.liftRequestedToGo(10);
		      
			  
			
		}
		Constants.ADD_DESTINATION_FLAG = true;
		System.out.println("Waiting for five seconds ,Closing the door now");
		
		
		
	}
	
 

	
	
	

}
