Let's work on the webpage design first and see what I need as I go along

Login:
SERVICE:
- validate login credentials. the username and password must be a match in the database

E2E:
- if you enter incorrect username or password, an error will appear. system will not let you into homepage you will stay on login page
- if you enter correct username AND password, you will be taken to your home page
- if you want to register for a new account, you can click on the registration page link and it'll take you to the registration page

---

Registration:
SERVICE:
- limit first name to 50 characters
- limit username to 50 characters
- limit password to 50 characters
- email must be in email format
- zip code must be 5 characters and all numbers
- cannot make a new account if one with the same username or email already exists

these are all needed to make a proper user object

E2E:
- all fields must be validly filled out to register
- if user hovers over each field, a text will appear explaining why that information is needed 
- check each field if it were not filled out if they can register
- check each field if it were not filled out validly if they can register
- if not valid, make sure an error pops up letting them know why they can't register

---

Calendar:

SERVICE:
- make sure calendar date is no earlier than 2023 and no further than 2023
- event title is a 50 character limit
- event desc is a 300 character limit
- event status can only be either "Y" or "N"
- day status can only be either "Y" or "N"

E2E:
- ensure can view calendar by year, month, or day
- ensure can create an event
- ensure can delete an event
- ensure can update an event

---

Check-in:

SERVICE:
None, no back end methods related to it

E2E:
- ensure that if user clicks on each option, it'll generate a phrase
- ensure that it says user's name
- ensure that after clicking on phrase button it'll take them to their homepage

---

Home:

SERVICE:
I don't think the home will have any service rules because it's just essentially a list of links that will redirect you to the html that has the actual entity

E2E:
- ensure that user can click on notebook feature and be redirected
- ensure that user can click on calendar feature and be redirected
- "" for weather
- "" for to-do list
- "" for logout
- ensure when user clicks on daily quote it'll load one from the daily quote API

---

Notebook:

SERVICE:
- notebook title can only be 50 characters
- notebook entry can only be 500 characters

E2E:
- ensure user can create a new note
- ensure user can view notes and click to view others
- ensure user can delete a note
- ensure user can update a note

---

To-Do:

SERVICE:
- task desc can only be 300 characters
- task status can only be "Y" or "N"

E2E:
- ensure users can create a task
- ensure users can delete a task
- ensure users can update a task

---

Category:

SERVICE:
- category title can only be 50 characters
- cannot make a new category if one already exists with the same name

E2E:
- ensure users can create a category
- ensure users can update a category
- ensure users can delete a category
- ensure users can click on the category and be taken to the category's to-do list

---

Weather:
SERVICE:
none, taken care of in user

E2E:
- have the weather api pull up the corresponding us zip code's weather
- make sure system will validate someone's response if they want to change their zip code for weather
- if not valid zip code change, have an error populate