// database connection
const {Client} = require("pg");

const client = new Client({
    host: "localhost",
    user: "postgres",
    port: 5432,
    password: "Hoku501046!",
    database: "cow_escape"
});

module.exports = client;