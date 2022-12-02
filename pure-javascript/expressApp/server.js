const { response } = require('express');
const express = require('express');
const app = express();

app.set("view engine", "ejs");

app.use(express.static("public"));

// let's see if i can move database here
const {Client} = require("pg");

const client = new Client({
    host: "localhost",
    user: "postgres",
    port: 5432,
    password: "Hoku501046!",
    database: "cow_escape"
});

client.connect();

client.query(`Select * from highscores`, (err, res) => {
    if(!err){
        console.log(res.rows);
    } else {
        console.log(err.message);
    }
    client.end;
});

client.query(`Select * from gamer_comments`, (err, res) => {
    if(!err){
        console.log(res.rows);
    } else {
        console.log(err.message);
    }
    client.end;
});
// end of new database

app.get("/", (req, res) => {
    res.render("index")
})

app.get("/play", (req, res) => {
    res.render("game")
});

app.get("/highscore", (req, res) => {
    res.send("All high scores")
});

app.post("/highscore/new", (req, res) => {
    res.send("Post a new high score")
})

app.get("/comment", (req, res) => {
    res.send("All comments")
});

app.post("/comment/new", (req,res) => {
    res.send("Post a new comment")
});


app.listen(3000);

/*
    1. Get all game scores
    2. Post new score and user
    3. Post a comment on the game
    4. Get all comments
*/
