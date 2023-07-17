//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

// dream elements

const submitDream = document.getElementById("dream-form");
let dreamContainer = document.getElementById("dreams-container");
let dreamBody = document.getElementById("dream-body");
let updateDream = document.getElementById("update-dream-button");

const seeDreams = document.getElementById("get-dreams");
const seeHopes = document.getElementById("get-hopes")

// hope elements
const submitHope = document.getElementById("hope-form");
let hopeContainer = document.getElementById("hopes-container");
let hopeBody = document.getElementById("hope-body");
let updateHope = document.getElementById("update-hope-button");



const headers = {
    "Content-Type": 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/dreams"

const hopeBaseUrl = "http://localhost:8080/api/v1/hopes"



// dream functions

//submit

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObjDream = {
        body: document.getElementById('dream-input').value
    }

    await addDream(bodyObjDream);
    document.getElementById("dream-input").value = ""

}

//add dreams

async function addDream(obj) {
    const response = await fetch(`${baseUrl}/user/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
    .catch(err => console.error(err.message))

//    if (response.status == 200) {
//        return getDreams(userId);
//    } else {
//        console.error("Failed to add dream")
//    }
}

//get dreams

async function getDreams(userId) {


    await fetch(`${baseUrl}/user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createDreamPost(data))
        .catch(err => console.error(err))
}

// get dream by id
//COME BACK TO THIS FETCH BASEURL
async function getDreamById(dreamId) {
    await fetch(`${baseUrl}/${dreamId}`, {
        method:"GET",
        headers:headers
    })
    .then(res => res.json())
    .then(data => populateDreamPost(data))
    .catch(err => console.error(err.message))
}


// refine your dream

async function editDream(dreamId) {
    let bodyObjDream = {
        id: dreamId,
        body: dreamBody.value
    }
     await fetch(`${baseUrl}`, {
        method: "PUT",
        body: JSON.stringify(bodyObjDream),
        headers: headers
     })
        .catch(err => console.error(err))

    return getDreams(userId);
}

// delete

async function deleteDream(dreamId) {
    await fetch(`${baseUrl}/${dreamId}`, {
    method: "DELETE",
    headers: headers
    })
        .catch(err => console.error(err))
    return getDreams(userId)
}

//create dream post
const createDreamPost = (arr) => {

dreamContainer.innerHTML = ""


arr.forEach(obj => {

    console.log(obj);
    let dreamPost = document.createElement("div")
    dreamPost.innerHTML = `
          <div class="card d-flex" style="width: 18rem; height: 18rem;">
                            <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                                <h4>Dreams</h4>
                                <p class="card-text">${obj.body}</p>
                                <div class="d-flex justify-content-between">
                                    <button class="btn btn-danger" onclick="deleteDream(${obj.id})">Delete</button>
                                </div>
                            </div>
                        </div>
    `





dreamContainer.append(dreamPost);

})

}

// populateDreamPost

const populateDreamPost = (obj) => {
    dreamBody.innerText = ""
    dreamBody.innerText = obj.body
    updateDream.setAttribute('data-dream-id', obj.id)
}



/// hope functions

//submit

const handleHopeSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        body: document.getElementById('hope-input').value
    }

    await addHope(bodyObj);
    document.getElementById("hope-input").value = ""
}

//add hopes

async function addHope(obj) {
    const response = await fetch(`${hopeBaseUrl}/user/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
    .catch(err => console.error(err.message))
//    if (response.status == 200) {
//        return getHopes(userId);
//    }
}

//get hopes

async function getHopes(userId) {
    await fetch(`${hopeBaseUrl}/user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createHopePost(data))
        .catch(err => console.error(err))
}

// get hope by id
//COME BACK TO THIS FETCH BASEURL
async function getHopeById(hopeId) {
    await fetch(`${hopeBaseUrl}/${hopeId}`, {
        method:"GET",
        headers:headers
    })
    .then(res => res.json())
    .then(data => populateHopePost(data))
    .catch(err => console.error(err.message))
}


// refine your hope

async function editHope(hopeId) {
    let bodyObj = {
        id: hopeId,
        body: hopeBody.value
    }
     await fetch(`${hopeBaseUrl}`, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
     })
        .catch(err => console.error(err))

    return getHopes(userId);
}

// delete

async function deleteHope(hopeId) {
    await fetch(`${hopeBaseUrl}/${hopeId}`, {
    method: "DELETE",
    headers: headers
    })
        .catch(err => console.error(err))
    return getHopes(userId)
}

//create hope post
const createHopePost = (arr) => {

hopeContainer.innerHTML = ""

arr.forEach(obj => {
    let hopePost = document.createElement("div")
    hopePost.innerHTML = `
         <div class="card d-flex" style="width: 18rem; height: 18rem;">
                                    <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                                        <h4>Hopes</h4>
                                        <p class="card-text">${obj.body}</p>
                                        <div class="d-flex justify-content-between">
                                            <button class="btn btn-danger" onclick="deleteHope(${obj.id})">Delete</button>
                                        </div>
                                    </div>
                                </div>
    `
hopeContainer.append(hopePost);

})

}

// populateHopePost

const populateHopePost = (obj) => {
    hopeBody.innerText = ""
    hopeBody.innerText = obj.body
    updateHope.setAttribute('data-hope-id', obj.id)
}

//DREAM
getDreams(userId);

submitDream.addEventListener("submit", handleSubmit)

updateDream.addEventListener("click", (e) => {
    let dreamId = e.target.getAttribute('data-dream-id')
    editDream(dreamId);
})



//HOPE
getHopes(userId);

submitHope.addEventListener("submit", handleHopeSubmit)

updateHope.addEventListener("click", (e) => {
    let hopeId = e.target.getAttribute('data-hope-id')
    editHope(hopeId);
})

seeDreams.addEventListener("click", () => getDreams(userId));
seeHopes.addEventListener("click", () => getHopes(userId));


//logging out

function handleLogout() {
    let c = document.cookie.split(";");
    for(let i in c) {
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}