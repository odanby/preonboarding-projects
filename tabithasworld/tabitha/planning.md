I want to create a planning app for my sister utilizing Java/Javascript etc.

Here's what she (the client) wants:

"
I would like an organizational website or app I can use easily.

I would like to set my list of chores including:
- Take medicine at 10pm
- Sunscreen every morning
- Water plants every 3 days
- Mop every 7 days
- Bleach shower curtain liner every 30 days
- Schedule oil change every 6 months

Etc.

I would also include how long it takes to do them. The app would schedule it all out for me. Like the app knows I'm working 10am - 830pm on Wednesday. So it doesn't set "sweeping the floors"
as a chore that day

Also to help me remember:
- Hair wash day every 7 days
- Floss every night
- Exfoliate face every 2 days
- Etc

My whole routine because I am forgetful

And then a button to basically say "I'm not feeling well today/something came up"

And then the app clears all your chores for the day and moves them into the next few days instead

I also keep this sticky note to remind me about visiting Tahiti and how much it will cost

And I want to add into shopping lists easily

It could be a beauty/self care app

Here are some sample tasks I thought of:
- Change contacts
- Wash face
- Brush teeth
- Floss
- Brush tongue
- Mouthwash
- Shave face
- Do eyebrows
- Moisturizer
- Sunscreen
- Whiten teeth
- Clean ears
- Brush Hair
- Scalp scrub
- shampoo Hair
- condition Hair
- Hair mask
- lip mask
- undereye mask
- face mask
- take vitamins
- use deodorant
- exfoliate face
- use pore strips
- trim Hair
- lash serum
- brow serum
- Shave
- body scrub
"

Looking through all these things, let's pull out what we can start off with.

I can make this into a to-do app that focuses on beauty, selfcare, chores.

Maybe you can start off making an account
- register with username, password, and email (for this I won't do email verification right away, my goal is to make an app for learning experiences, but maybe eventually i will deploy it)
- add, edit, and remove daily, weekly, monthly tasks
- assign a due date to said tasks
- be able to mark tasks as incomplete or complete
- be able to reschedule tasks

Calendar view can be year, month, week, day, or hour

Categories?:
- Work 
- Selfcare 
- Groceries 
- Home 
- Auto 
- Goals 

You can add categories or tasks, those are just the default ones

The UI should be cute, personal, friendly, and pleasing. It will look like a little desk and then you can click on the various features to see what they are:
- To do (tasks, they are put into categories)
- Calendar (click to pull up calendar view)
- Window (reflects current weather)
- Daily quote (a daily motivational quote)
- Notebook (to write down any thoughts)

ALRIGHT TIME TO REALLY PLAN.

FEATURES:
- Login
    - User should be able to login to their account
        - If a user enters the correct username and password, they will be able to login to their account
        - If they forget their password or username, they can enter the email they registered with and they will get a username message or password reset link (this will be
        a to be done later feature)
        - If a user does not enter the correct username or password, they will receive an error and not be able to login to their account
- Register
    - New users can register for an account 
        - A new user must have a valid password and email
        - All registration fields need to be completed to register
        - Confirmation of password and password MUST match
        - Confirmation of email and email MUST match
        - Users need to select their state and city
- Check in
    - Users can tell Tabitha's World how they are feeling today and the website will respond with an appropriate response
    - The check in should generate the corresponding user's first name during this check-in 
- Weather 
    - Users can view the weather in their location
    - Users can change the location their weather is set to 
    - The background will change according to the weather and time of day 
- Calendar 
    - Users can view their events and tasks for the day
    - Users can add, edit, or delete events
    - Users can view as the calendar year, by month, or by day
    - Each view will have the events they have scheduled for the calendar day
- To Do List 
    - Users can create, rename, or delete a category of tasks
    - Users can view categories of tasks
    - Users can create, edit, or delete tasks within a category
    - Users can make an event in their calendar when they create a task
    - If the amount of slots of tasks overflows, you can flip to a new page, limited to three pages
    - There is a limited amount of categories you can make (9)
- Daily Quote 
    - A daily quote will generate every day. Something uplifting and wholesome
- Notebook 
    - Users can write their thoughts in a Notebook
    - Users can delete a note 
    - Users can edit a note
- Logout 
    - User should be able to logout of their account and be returned to the login page

DATABASE:
What tables and columns do I need and how should they be related to each other?

User table:
- ID
- First name
- Username
- Password
- Email
- US Zip Code

Calendar table:
- Foreign key of id from user table
- Year
- Month
- Day
- Day of the week
- Event id
- Event title
- Event description
- Event start time
- Event end time
- Event completion status
- Day completion status

Category table:
- Foreign key of id from user table
- Category id
- Category

List table:
- Foreign key of id from user table
- Join calendar table (if they make an event)
- Join category table
- Task id
- Task
- Task frequency
- Task completion status

Notebook: 
- Foreign key of username from user table
- Notebook id
- Title of entry
- Date of entry
- Content of entry

- Checkin doesn't need a table. No data from there will be stored
- Weather will be using an API
- Daily quote will use an API

-----

- MAKE SQL TABLES (DONE!)
    - USER (DONE)
    - NOTEBOOK (DONE)
    - CATEGORY (DONE)
    - CALENDAR (DONE)
    - LIST (DONE)
- ADD DUMMY DATA (DONE!)
- CONFIGURE WITH HIBERNATE (DONE!)
    - User (DONE)
    - TaskList (DONE)
    - Notebook (DONE)
    - Category (DONE)
    - Calendar (DONE)
- CREATE REPO INTERFACES AND IMPLEMENT THEM (DONE)
    - User (DONE)
    - Tasklist (DONE)
    - Notebook (DONE)
    - Category (DONE)
    - Calendar (DONE)
- TEST REPO METHODS (DONE)
    - User (DONE)
    - Tasklist (DONE)
    - Notebook (DONE)
    - Category (DONE)
    - Calendar (DONE)
- CREATE EXCEPTIONS
- CREATE SERVICES INTERFACES AND IMPLEMENT THEM
- TEST SERVICE METHODS
- CREATE CONTROLLERS
- CONNECT API
- CREATE HTTP RESPONSES
- INTEGRATED TESTING
- CREATE HTML WEBSITES
- WRITE JAVASCRIPT CODE TO CREATE HTTP REQUESTS/RESPONSES
- WRITE CSS
- E2E TESTING!

Then move onto the registration page
- Design it
Notate what service rules will be necessary for the user login and registration
Think through what service rules are necessary for the category, task list, notebook, calendar, and weather page