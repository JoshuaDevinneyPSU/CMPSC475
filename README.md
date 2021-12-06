# CMPSC 475 – Application Programming Project Proposal 
## Joshua Devinney   
### Project Title Narrative 
### Schedule Builder and Tracker 
## The Problem 
Students often have a hard time remembering their schedule when they start a new semester. Writing the schedule down on paper is good for organization but it doesn’t actively remind the student of when their classes are coming up and how they can get to their class. Students also may know the building name where their class is located but have no clue where that building exists on campus. Solutions 
The Schedule Builder and Tracker will allow users to input their Penn State Behrend classes for each day of the week. It will provide an easy way to view each day and clearly see when each class is going to take place and where the class is located. The app will allow the user to view a map using Google Maps and see where they are located and see a pin on where each class on their schedule is located. This will help the user be able to identify where their class is and how they can get there. Users 
The Schedule Builder and Tracker app’s target audience is students enrolled at Penn State Behrend college. 
## Modeling 
## Data Entities 
•	Day of the Week block 
•	Class block 
•	Class time range 
•	Professor name 
•	Location 
## Data Relationships 
There will be one Day block for each day of the week. The day block will include 0 or more class blocks. The class blocks will include the class name, the time range, the professor’s name, and the location of the class. 
User/Data Interactions 
The user will choose one of the 7 predefined day blocks. In this block they will choose to add a class block. They will enter the class name, time range, and professor name. They will then choose the location from a list of campus buildings. The class block will then be created inside of the day block. The user will be able to edit the class block to remove it from the day block. The user will be able top navigate through the day blocks to view, edit, add, or remove the class blocks within. 
Layouts 
## Fragment Layout Sketches 
  
## Fragment Navigation 
The starting fragment will be the view for Monday. Tapping the arrows will switch the fragment to the corresponding next day or previous day of the week. Tapping a class will take the user to the middle class fragment. Tapping the plus on the day of the week fragment or tapping edit on the class fragment will take the user to the third class editor fragment. 
## Component Behavior 
Tapping the arrows at the top of the Week Day fragment will proceed to the next or previous day. Tapping a class will take the user to the Class fragment which shows the info and Google Maps location of the class. Tapping edit on the Week Day fragment will allow the user to tap a class to remove it from that day. Tapping the plus button on the Week Day fragment will take the user to the Editor fragment and allow the user to enter in the info of the class and click submit which will add it to the current day of the week fragment that was navigated from. The arrows on the class and editor fragment return the user to the previous fragment. Clicking edit on the class fragment takes the user to the editor fragment. 
## Technical Requirements 
## Requirements 
1.	User will be able to move between the days of the week 
2.	User will be able to add a class to their schedule for the current day of the week being viewed 
3.	User will be able to edit a class in their schedule 
4.	User will be able to view a day of the week on Google Maps 
5.	User will be able to see the classes pinned on Google Maps 
6.	User will be able to delete a class from their schedule 
Uses 
1.	This will allow the user to view their schedule one day at a time and also the viewed day will be the one that a class gets added too if the user chooses to on that page 
2.	Allows the user to add a class and the information for that class to the day of the week they are currently looking at 
3.	Allows the user to edit the info for a class so they can change the name, professor name, time range, or location 
4.	This allows the user to view a map view of each day of the week to locate their classes 
5.	The classes will be pinned on the map view to allow the user to easily recognize where the class is taking place 
6.	The user will be allowed to delete or remove a class from their schedule. 
