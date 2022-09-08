# Java-Automation-WebElements

Basic web elements
Here you will find 8 tests to automate where you can learn the basics of Selenium. 
All of them can be found at http://seleniumui.moderntester.plunder the Basicmenu1. 
Alerts1.
1 Simple Alert Pop up 
Test steps:
1.Click on 'Simple Alert' button
2.Click 'OK' button on alert
3.Check that "OK button pressed" text has been shown

1.2 Prompt Alert box 
Test steps:
1.Click on 'Prompt Pop up' button
2.Type "Lord Vader" in the alert text box
3.Click 'OK' button on alert
4.Check that "Hello Lord Vader! How are you today?" text has been shown

1.3 Confirm Alert box 
Test steps:
1.Click on 'Confirm Pop up' button
2.Click 'OK' buttonon alert
3.Check that "You pressed OK!" has been shown
4.Click again on 'Confirm Pop up' button
5.Click 'Anuluj'/'Cancel' button on alert
6.Check that "You pressed Cancel!" text has been shown

1.4 Delayed alert 
Test steps:
1.Click on 'Delayedalert' button
2.Wait for an alert to appear
3.Click 'OK' button on alert
4.Check that "OK button pressed" text has been shown

3. Iframes
Test steps:
1.Switch to the first iframe and fill form
2.Switch to the second iframe and fill form
3.Switch to the main frame and click on 'Basic' button in the main menu

4. Tables
Test steps:
1.Get all rows from table to List
2.Print out 'Rank', 'Peak' and 'Mountain range' of mountains that are in "Switzerland" and are higher than 4000 


5. Windows/Tabs
Test steps:
1.Click on 'New Browser Window' button
2.Switch to a new window
3.Execute test from 4th exercise on the newly opened window
4.Close window
5.Click 'New Message Window' button
6.Switch to a new window
7.Print out the text that is written in a new window
8.Close window
9.Click on 'New Browser Tab' button
10.Switch to a new tab
11.Execute test from 4th exercise on the new opened window
12.Close tab

Widgets tests
Here you will find 9 tests to automate where you learn how to interact with different widgets. 
All of them can be found at http://seleniumui.moderntester.plunder 

Widgetsmenu
1.Accordion 
1.Open each section and print out the text inside

2. Autocomplete 
1.Type 'a' in the search input
2.Print out all available options
3.Select random option
4.Check if text in search input is the same as text of the selected option3. 

Datepicker 
Select the dates below. 
After each selection check if the correct date is shown in 'Date' input
1.Today
2.1st day from next month
3.Last day from Januaryin next year
4.Select same day again (same was selectedin step 3)
5.Random day from previousmonth6.Randomdate from last year
Comment: these dates combine all different ways of 'walking' on the date picker, do all steps in one testwithoutclosing browser windows

4. Menu 
1.Click on Music -> Jazz -> Modern

5. Modal dialog 
1.Click 'Create new user'
2.Fill form
3.Click on 'Create an account'
4.Check if a new row with correct 'Name', 'Email' and 'Password' has been added
5.Create a Data provider that will provide parameters for test*

6. Progressbar
1.Wait until the text in progress bar will be "Complete!"

7. Selectable 
1.Select random speed
2.Select option from "Select a file" by the text of the option
3.Select option from "Select a number" by the index of the option
4.Select random option from "Select a title"

8. Slider
Move the slider to such values and after each shift of the slider check if the correct value is displayed
1.50
2.80
3.80
4.20
5.0

9. Tooltip
1.Print out the message from the tooltip

Interactions tests
Here you can find 5 tests to automate where you can learn how to use Action class in different situations. 
All of them can befound at http://seleniumui.moderntester.plunder interactionsmenu

1. Draggable
Test steps:
1.drag square to upper right
2.drag square to bottom right
3.drag square to centre
4.drag square to bottom left2. 

Droppable
Test steps:
1.drag 'Drag me to my target' square and drop it in 'Drop here' area
2.check if "Dropped!" text appeared

3. Resizable
Test steps:
1.resize window to the right (10px)
2.resize window to the bottom (10px)
3.resize windwo to the right and bottom (10px,10px)

4. Selectable
Test steps:
1.select items: 1,3,4
2.check if You've selected: #1 #3 #4.text appeared

5.Sortable
Test steps:
1.create table with numbers: 1,2,3,4,5,6,7
2.shuffle it
3.move items on list to match shuffled table

Other tests
Here you will find 1 test to show you how to work with JavascriptExecutor class. 
It can be found at http://seleniumui.moderntester.plunder Othersmenu
1. High site*
Test steps:
1.Scroll page until 'Submit' button is visible
2.Take screenshottutaj zadanie do rozkminienia jak zrobic scrollowanie :)

Zadanie 2 
Uzupełnienie formluarza z zajęć :)
Test steps:
Fill First name
Fill Last name
Fill Email
Choose a random 'Sex' radiobutton
Fill age
Choose a random 'Year of experience' radiobutton
Choose 'Automation Tester' profession
Select random option from 'Continents'
Select "Switch Commands" and "Wait Commands" from 'Selenium Commands'
Upload some File
Click 'Sign in' button
Check that "Form send with success" text has been shown
