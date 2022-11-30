const express = require("express");
const router = express.Router();

router.get("/", (req, res) => {
    res.send("All comments")
});

router.post("/new", (req,res) => {
    res.send("Post a new comment")
});

module.exports = router;