# Remote Control Joystick
## Flight Gear Remote Control Application


Remote control application to control Flight Gear aircrafts. <br/>
![ex3 home screen](https://user-images.githubusercontent.com/58383829/122922810-b023d880-d36c-11eb-94c5-d5e446eab80d.jpg)
![ex3 manual screen](https://user-images.githubusercontent.com/58383829/122922848-b914aa00-d36c-11eb-9b77-4988f0ac8fb6.jpg)


______________
#### Settings
1. open Flight Gear simulator.
2. Enter _Settings_.
3. Insert the following: 
* **_--telnet=socket,in,10,127.0.0.1,6400,tcp_**
* **_--timeofday=morning_**
5. You can change to any available port on your computer.
6. If you wish to start flying _mid-air_ insert the following: **_fgfs --altitude=5000 --heading=0 --vc=110_**

![ex3 flight gear settings mid air and day time](https://user-images.githubusercontent.com/58383829/122949694-8a0a3280-d384-11eb-9228-b9469e025abb.jpg)

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

If you want to change IP address and port number go back by pressing *_Back_* button, click on *_SETTINGS_* button
and you will see the IP and port that you already inserted. change them if you wish. <br/>
________________________
Note: if the connection was succesfull you will get the following message <br/> ![ex3 connected message 2](https://user-images.githubusercontent.com/58383829/122923106-fc6f1880-d36c-11eb-8400-eaff18bb6d67.jpg)


______________
#### How to fly?
**Throttle** is the means by which the pilot controls the amount of fuel provided to the engine. <br/>
**Rudder** is attached to the fin, which allows the pilot to control yaw about the vertical axis. <br/>
**Elevator** controls the aircraft's pitch, and therefore the lift of the wing. <br/>
**Aileron** used to control the aircraft in roll and located on the edge of each wing. <br/>

You must learn to combine the 4 components to balance your aircraft. <br/>
Using the _Throttle_ seek bar, you can gain speed by dragging the bar to the top (maximun value is 1 which is full power) 
or lower it to the bottom to stop the airecraft (minimum value is 0).
_Rudder_ seek bar changing the direction by dragging the bar to the sides (-1 to +1). <br/>
The joystick will change the _Elevator_ and _Aileron_ values at the same time, therefore you need to be gentle in order to keep the aircraft balanced. <br/>
______________
#### Architecture
##### The project is built according to the MVVM architectur. 
Model: FlightGearModel. <br/>
View-Model: FlightGearViewModel. <br/>
View: MainActivity, ManualActivity and JoystickView. <br/>

![MVVM2 0White](https://user-images.githubusercontent.com/58383829/123124988-cefb9b00-d450-11eb-8e35-8d96ad8c398b.jpg)


--------------
#### UML Diagram
![umlExp2](https://user-images.githubusercontent.com/58383829/123119456-3bc06680-d44c-11eb-904e-ab9f10f13a1d.jpg)

