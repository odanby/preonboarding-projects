// Write a function that can take in any number of arguments, and returns the sum of all of the arguments.

function sum() {
    var s = 0;
    for (var i=0; i < arguments.length; i++) {
        s += arguments[i];
    }
    return s;
}

console.log(sum(1, 10, 3));
console.log(sum(-100000, 23, 2, 8));


// Write a function called `addOnlyNums` that can take in any number of arguments (including numbers or strings), and returns the sum of only the numbers.

function addOnlyNums(...arguments){
    let sum = 0;
    for(let i = 0; i <= arguments.length-1;i++){
        if( typeof arguments[i] === 'number'){
            sum = sum+arguments[i];
        }
    }
    return sum;
}

console.log(addOnlyNums(4, 2));
console.log(addOnlyNums(24, 2332, "Hi"));
console.log(addOnlyNums("Hello", "Hey"));

// Write a function called `countTheArgs` that can take any number of arguments, and returns the number of arguments that are passed in.

function countTheArgs(...arguments){
    var count = 0;
    for(let i = 0;i <= arguments.length-1;i++){
        count++;
    }
    return count;    
}

console.log(countTheArgs(3, 2, 3));
console.log(countTheArgs(120, "chicken", 434, 23, 5, 2));

// Write a function called `combineTwoArrays` that takes in two arrays as arguments, and returns a single array that combines both (using the spread operator).

function combineTwoArrays(a1, a2){
    return [...a1,...a2];
}

console.log(combineTwoArrays([1, 3, 5, 7, 9],[2, 4, 6, 8, 10]))

// Write a function called `sumEveryOther` that takes in any amount of arguments, and returns the sum of every other argument.

function sumEveryOther(...arguments){  
    let sum = 0;
    for (let i = 0; i <= arguments.length-1; i++) {
        if (i % 2 === 0){
            sum += arguments[i];
        }
    }
    return sum;
}

console.log(sumEveryOther(1, 2, 3, 10, 11, 2))

// Write a function called `onlyUniques` that can take in any number of arguments, and returns an array of only the unique arguments.

// Write a function called `combineAllArrays` that takes in any number of arrays as arguments and combines all of them into one array.

// Write a function called `squareAndSum` that takes in any number of arguments, squares them, then sums all of the squares.