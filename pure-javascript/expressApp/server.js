// server and client
    const client = require('./connection.js');  // uses my database connection file
    const express = require('express');
    const app = express();

    app.set("view engine", "ejs");

    app.use(express.static("public"));
    app.listen(3000, () => {
        console.log("Server is now listening at port 3000!");
    })

    client.connect();

// parse to json
    const bodyParser = require("body-parser");
    app.use(bodyParser.json());

// paths

    // gets index page
    app.get("/", (req, res) => {
        res.render("index")
    })

    // gets game page
    app.get("/play", (req, res) => {
        res.render("game")
    });

    // gets all highscores
    app.get("/highscore", (req, res) => {
        client.query(`Select * from highscores`, (err, result) => {
            if(!err){
                res.send(result.rows);
            }
            client.end;
        });
    });

    // creates a new highscore
    app.post("/highscore/new", (req, res) => {
        const highscore = req.body;
        let insertQuery = `insert into highscores(gamer_name, score) values ('${highscore.gamer_name}', ${highscore.score})`
        client.query(insertQuery, (err, result) => {
            if(!err){
                res.send("{}");
            } else {
                console.log(err.message)
            }
        })
        client.end;
    })

    // gets all comments
    app.get("/comment", (req, res) => {
        client.query(`Select * from gamer_comments`, (err, result) => {
            if(!err){
                res.send(result.rows);
            } 
            client.end;
        });
    });

    // creates a new comment
    app.post('/comment/new', (req, res)=> {
        const comment = req.body;
        let insertQuery = `insert into gamer_comments(gamer_name, gamer_comment) 
                        values('${comment.gamer_name}', '${comment.gamer_comment}')`

        client.query(insertQuery, (err, result)=>{
            if(!err){
                res.send("{}");
            }
            else{ console.log(err.message) }
        })
        client.end;
    })

    // questions:
        // Making sure score posts to high score board every time the game ends. Probably going to run into same issue as posting a comment