## Jets Projects
### Week 2 Skill Distillery Homework

#### Description
- The Jets Projects brings together everything we learnt in our first 2 weeks. 
- The user is able to navigate through the jets and pilots with the roster updating as the user adds more.

#### Topics and Technologies Used
Polymorphism

Inheritance

Interfaces

For loops

If statements

Switches

Array manipulation

Initialiser blocks

#### How to Run
- The user is given a menu where they can view the current roster of pilots and fleets separately or see the current assignment of the fleet.
- Pilots and jets can be added. When adding the jet, you will be able to choose and assign an available pilot to the jet.
- The fastest jet and the one with the longest range can be viewed.
- Flying all jets will display all the jets' information and provide how long they can fly for based on their individual speed and range.
- Loading all cargo jets will load only cargo jets.
- Dogfight causes fighterjets to start attacking other planes. Once one fighterjet has shot down another, the next fighterjet will shoot until there is only one fighterjet left.

#### Lessons Learned
**1. Arrays:**

- Using the random function to randomly assign a pilot to each jet.
- Switching array indexes when the user added a jet and then conseuqeuntly having the choice to select which pilot to assign so that the fleet 		would update correctly. This was difficult as I had to work out at exactly what index to switch to and from in the array.
	
**2. Interfaces:**

- Loading cargo and fight methods were implemented.
	
**3. For loops:**

- For dogfight I originally had the first figtherjet iterate through the array until it was the last one standing. I changed this so that the next 	fighterjet would get a go to make it more realistic.
- When using the interface to call on the fight method, as it was in the for loop it was calling on it everytime. I used a boolean to ensure it 	only ran through once as it was looping.