// go home
function changeHomeButtonColor(){
    document.getElementById("go-home").style.background = "white";
    document.getElementById("go-home").style.color = "#92a1d1";
}

function revertHomeButtonColor(){
    document.getElementById("go-home").style.color = "white";
    document.getElementById("go-home").style.background = "#92a1d1";
}

document.getElementById("go-home").addEventListener("mouseover", changeHomeButtonColor);
document.getElementById("go-home").addEventListener("mouseleave", revertHomeButtonColor);

// back
function changeBackButtonColor(){
    document.getElementById("backButton").style.background = "white";
    document.getElementById("backButton").style.color = "#92a1d1";
}

function revertBackButtonColor(){
    document.getElementById("backButton").style.color = "white";
    document.getElementById("backButton").style.background = "#92a1d1";
}

document.getElementById("backButton").addEventListener("mouseover", changeBackButtonColor);
document.getElementById("backButton").addEventListener("mouseleave", revertBackButtonColor);

// go home
function changeNextButtonColor(){
    document.getElementById("nextButton").style.background = "white";
    document.getElementById("nextButton").style.color = "#92a1d1";
}

function revertNextButtonColor(){
    document.getElementById("nextButton").style.color = "white";
    document.getElementById("nextButton").style.background = "#92a1d1";
}

document.getElementById("nextButton").addEventListener("mouseover", changeNextButtonColor);
document.getElementById("nextButton").addEventListener("mouseleave", revertNextButtonColor);

// async functions will go here

async function getAndSetUserInfo(){
    let httpResponse = await fetch(`http://localhost:8080/tabitha/user/username/${sessionStorage.getItem("sessionUsername")}`);
    console.log(httpResponse);
    let responseBody = await httpResponse.json();
    console.log(responseBody);

    if(httpResponse.status === 200){
        for(x of responseBody){
            sessionStorage.setItem("sessionUserId", x.id);
            sessionStorage.setItem("sessionUsername", x.username);
            sessionStorage.setItem("sessionZipCode", x.zip_code);
            console.log(sessionStorage.getItem("sessionUserId"));
            console.log(sessionStorage.getItem("sessionUsername"));
            console.log(sessionStorage.getItem("sessionZipCode"));
        }
    }

    getEventsByUserId()
}

document.body.addEventListener("load", getAndSetUserInfo())

// i need to have a get events by user id and populate them into the proper place
async function getEventsByUserId(){
    let httpResponse = await fetch(`http://localhost:8080/tabitha/calendar/${sessionStorage.getItem("sessionUserId")}`);
    let responseBody = await httpResponse.json();

    if(httpResponse.status === 200){
        for(x of responseBody){
            console.log(x.event_id);
            console.log(x.event_title);
            console.log(x.event_desc);
            console.log(x.event_status);
            console.log(x.event_start);
            console.log(x.event_end);
            console.log(x.day_status);
            console.log(x.task_user_id);

            let tr = document.createElement("tr");
            tr.innerHTML = 
            `
            <tr>${x.event_id}</tr>
            <tr>${x.event_title}</tr>
            <tr>${x.event_desc}</tr>
            <tr>${x.event_status}</tr>
            <tr>${x.event_start}</tr>
            <tr>${x.event_end}</tr>
            <tr>${x.day_status}</tr>
            <tr>${x.task_user_id}</tr>            
            `
            document.getElementById("calendar").appendChild(tr);
        }
    } else {
        console.log("Could not load events")
    }
}

    // basically i need to have a create event one that associates the event created in the current one with a new java object and uses the user id

// writing my javascript in here because im following a tutorial
let nav = 0;
let clicked = null;
let events = localStorage.getItem('events') ? JSON.parse(localStorage.getItem('events')) : [];

const calendar = document.getElementById('calendar');
const newEventModal = document.getElementById('newEventModal');
const deleteEventModal = document.getElementById('deleteEventModal');
const backDrop = document.getElementById('modalBackDrop');
const eventTitleInput = document.getElementById('eventTitleInput');
const weekdays = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

function openModal(date) {
  clicked = date;

  const eventForDay = events.find(e => e.date === clicked);

  if (eventForDay) {
    document.getElementById('eventText').innerText = eventForDay.title;
    deleteEventModal.style.display = 'block';
  } else {
    newEventModal.style.display = 'block';
  }

  backDrop.style.display = 'block';
}

function load() {
  const dt = new Date();

  if (nav !== 0) {
    dt.setMonth(new Date().getMonth() + nav);
  }

  const day = dt.getDate();
  const month = dt.getMonth();
  const year = dt.getFullYear();

  const firstDayOfMonth = new Date(year, month, 1);
  const daysInMonth = new Date(year, month + 1, 0).getDate();
  
  const dateString = firstDayOfMonth.toLocaleDateString('en-us', {
    weekday: 'long',
    year: 'numeric',
    month: 'numeric',
    day: 'numeric',
  });
  const paddingDays = weekdays.indexOf(dateString.split(', ')[0]);

  document.getElementById('monthDisplay').innerText = 
    `${dt.toLocaleDateString('en-us', { month: 'long' })} ${year}`;

  calendar.innerHTML = '';

  for(let i = 1; i <= paddingDays + daysInMonth; i++) {
    const daySquare = document.createElement('div');
    daySquare.classList.add('day');

    const dayString = `${month + 1}/${i - paddingDays}/${year}`;

    if (i > paddingDays) {
      daySquare.innerText = i - paddingDays;
      const eventForDay = events.find(e => e.date === dayString);

      if (i - paddingDays === day && nav === 0) {
        daySquare.id = 'currentDay';
      }

      if (eventForDay) {
        const eventDiv = document.createElement('div');
        eventDiv.classList.add('event');
        eventDiv.innerText = eventForDay.title;
        daySquare.appendChild(eventDiv);
      }

      daySquare.addEventListener('click', () => openModal(dayString));
    } else {
      daySquare.classList.add('padding');
    }

    calendar.appendChild(daySquare);    
  }
}

function closeModal() {
  eventTitleInput.classList.remove('error');
  newEventModal.style.display = 'none';
  deleteEventModal.style.display = 'none';
  backDrop.style.display = 'none';
  eventTitleInput.value = '';
  clicked = null;
  load();
}

function saveEvent() {
  if (eventTitleInput.value) {
    eventTitleInput.classList.remove('error');

    events.push({
      date: clicked,
      title: eventTitleInput.value,
    });

    // async function createNewEvent(){
    //     let eventStartDate = `${document.getElementById("date").value} ${document.getElementById("day").value}, 2023`
    //     let eventEndDate = `${document.getElementById("date").value} ${document.getElementById("day").value}, 2023`

    //     let eventInfo = {
    //         event_id: 0,
    //         event_title: eventTitleInput.value,
    //         event_desc: "Not necessary anymore" ,
    //         event_status: "N",
    //         event_start: eventStartDate,
    //         event_end: eventEndDate,
    //         day_status: "Y",
    //         task_user_id: sessionStorage.getItem("sessionUserId")
    //     };

    //     let eventInfoJSON = JSON.stringify(eventInfo);

    //     let config = {
    //         method: "POST",
    //         headers: {'Content-Type': "application/json"},
    //         body: eventInfoJSON
    //     };

    //     let httpResponse = await fetch("http://localhost:8080/tabitha/calendar/new", config);

    //     if(httpResponse.status === 201){
    //         let responseBody = await httpResponse.json();
    //         console.log(responseBody);
    //         alert("Event created!")
    //         location.reload();
    //     } else {
    //         alert("Event could not be created, please try again.");
    //     }
    // }

    localStorage.setItem('events', JSON.stringify(events));
    closeModal();
  } else {
    eventTitleInput.classList.add('error');
  }
}

function deleteEvent() {
  events = events.filter(e => e.date !== clicked);
  localStorage.setItem('events', JSON.stringify(events));
  closeModal();
}

function initButtons() {
  document.getElementById('nextButton').addEventListener('click', () => {
    nav++;
    load();
  });

  document.getElementById('backButton').addEventListener('click', () => {
    nav--;
    load();
  });

  document.getElementById('saveButton').addEventListener('click', saveEvent);
  document.getElementById('cancelButton').addEventListener('click', closeModal);
  document.getElementById('deleteButton').addEventListener('click', deleteEvent);
  document.getElementById('closeButton').addEventListener('click', closeModal);
}

initButtons();
load();