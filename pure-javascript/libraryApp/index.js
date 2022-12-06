const express = require('express')
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express()
const port = 3002

let books = [{
    "isbn": "9780140430721",
    "title": "Pride and Prejudice",
    "author": "Jane Austen",
    "publish_date": "1813-01-28",
    "publisher": "T. Egerton, Whitehall",
    "numOfPages": 432,
},
{
    "isbn": "9780786838653",
    "title": "The Lightning Thief",
    "author": "Rick Riordan",
    "publish_date": "2005-06-28",
    "publisher": "Activision",
    "numOfPages": 375,
},
{
    "isbn": "9780747542155",
    "title": "The Prisoner of Azkaban",
    "author": "J.K. Rowling",
    "publish_date": "1999-07-08",
    "publisher": "O'Reill",
    "numOfPages": 464,
}];

app.use(cors());

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.post('/book', (req, res) => {
    const book = req.body;

    console.log(book);
    books.push(book);

    res.json({success: true});
});

app.get('/book', (req, res) => {
    res.json(books);
});

app.get('/book/:isbn', (req, res) => {

    const isbn = req.params.isbn;

    for (let book of books) {
        if (book.isbn === isbn) {
            res.json(book);
            return;
        }
    }

    res.status(404).send('Book not found');
});

app.delete('/book/:isbn', (req, res) => {

    const isbn = req.params.isbn;

    books = books.filter(i => {
        if (i.isbn !== isbn) {
            return true;
        }

        return false;
    });

    res.send('Book is deleted');
});

app.post('/book/:isbn', (req, res) => {

    const isbn = req.params.isbn;
    const newBook = req.body;

    for (let i = 0; i < books.length; i++) {
        let book = books[i]

        if (book.isbn === isbn) {
            books[i] = newBook;
        }
    }

    res.send('Book is edited');
});

app.listen(port, () => console.log(`Hello world app listening on port ${port}!`));