const { response } = require('express');
const express = require('express');
const app = express();

app.set("view engine", "ejs");

app.use(express.static("public"));

app.get("/", (req, res) => {
    res.render("index")
})

app.get("/play", (req, res) => {
    res.render("game")
});

const highscoreRouter = require("./routes/highscores");
const commentRouter = require("./routes/comments");

app.use("/highscore", highscoreRouter);
app.use("/comments", commentRouter);



app.listen(3000);

/*
    1. Get all game scores
    2. Post new score and user
    3. Post a comment on the game
    4. Get all comments
*/
