const express = require("express");
const router = express.Router();

router.get("/", (req, res) => {
    res.send("All high scores")
});

router.post("//new", (req, res) => {
    res.send("Post a new high score")
})

module.exports = router;