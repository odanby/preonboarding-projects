// {"coord":{"lon":-120.7516,"lat":37.1666},
// "weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],
// "base":"stations",
// "main":{"temp":283.74,"feels_like":282.84,"temp_min":283.31,"temp_max":284.27,"pressure":1017,
// "humidity":76,"sea_level":1017,"grnd_level":1014},"visibility":10000,"wind":{"speed":3.55,"deg":144,
// "gust":5.76},"clouds":{"all":90},"dt":1672768545,"sys":{"type":2,"id":2006438,"country":"US",
// "sunrise":1672759016,"sunset":1672793858},"timezone":-28800,"id":5372259,"name":"Merced","cod":200}

const weatherTable = "weather-table"

async function getWeather(){
    let apiKey = "c8fa3d2bc754c90dcf6d027e163f4f17";
    let cityName = document.getElementById("city-search").value;
    let countryCode = document.getElementById("country-search").value;
    let httpResponse = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${cityName},${countryCode}&units=imperial&appid=${apiKey}`);
    let responseBody = await httpResponse.json();
    console.log(httpResponse)
    console.log(responseBody)
    if(httpResponse.status === 200){
        for(x of responseBody){
            let tr = document.createElement("tr");
            tr.innerHTML =
            `
                <td class = "weather-data">${cityName}, ${countryName}</td>
                <td class = "weather-data">${Math.round(x.temp)}°F</td>
                <td class = "weather-data">${x.main}</td>
                <td class = "weather-data">${x.description}</td>
                <td class = "weather-data">${x.humidity}%</td>
                <td class = "weather-data">${Math.round(x.wind.speed)} mph</td>
            `;
            weatherTable.appendChild(tr);
        }
    } else {
        alert("Could not find weather for this city, please try again!")
    }
}