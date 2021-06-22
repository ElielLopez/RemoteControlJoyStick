# Remote Control Joystick
## Flight Gear Remote Control Application


Remote control application to control Flight Gear aircrafts.


______________
#### Settings
1. open Flight Gear simulator.
2. Enter _Settings_.
3. Insert the following: **_--telnet=socket,in,10,127.0.0.1,6400,tcp_**
4. You can change to any available port on your computer.
5. If you wish to start flying _mid-air_ insert the following: **_fgfs --altitude=5000 --heading=0 --vc=110_**


______________
#### Instructions
1. Open Flight Gear Simulator.
2. Open the project and run the application.
3. Click on **_Fly!_** button to start the simulator.  
4. If you executed step 5 on **Setting** section skip the next step.
5. AutoStart the aircraft.
6. Insert IP address (CMD-> ipconfig).
7. Insert port number.
8. Click Connect.
9. Fly!


______________
#### How to fly?
Throttle, is the means by which the pilot controls the amount of fuel provided to the engine.
Rudder is attached to the fin, which allows the pilot to control yaw about the vertical axis.
Elevator controls the aircraft's pitch, and therefore the lift of the wing.
Aileron used to control the aircraft in roll and located on the edge of each wing.

You must learn to combine the 4 components to balance your aircraft.
Using the _Throttle_ seek bar, you can gain speed by dragging the bar to the top (maximun value is 1 which is full power)
or lower it to the bottom to stop the airecraft (minimum value is 0)
_Rudder_ seek bar changing the direction by dragging the bar to the sides (-1 to +1)
The joystick will change the _Elevator_ and _Aileron_ values at the same time, therefore you need to be gentle in order to keep the aircraft balanced.
______________
#### Architecture
##### The project is built according to the MVVM architectur.
Model: FlightGearModel.
View-Model: FlightGearViewModel.
View: MainActivity, ManualActivity and JoystickView.

--------------
#### UML Diagram
