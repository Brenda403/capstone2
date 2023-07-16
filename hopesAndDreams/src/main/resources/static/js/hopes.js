//let cookieArr = document.cookie.split("=")
//let userId = cookieArr[1];
//
//const submitHope = document.getElementById("hope-form");
//const hopeContainer = document.getElementById("hope-container");
//let hopeBody = document.getElementById("hope-body");
//let updateHope = document.getElementById("update-hope-button");
//
//const headers = {
//    "Content-Type": 'application/json'
//}
//
//const baseUrl = "http://localhost:8080/api/v1/hopes"



////submit
//
//const handleHopeSubmit = async (e) => {
//    e.preventDefault()
//
//    let bodyObj = {
//        body: document.getElementById('hope-input').value
//    }
//
//    await addHope(bodyObj);
//    document.getElementById("hope-input").value
//}
//
////add hopes
//
//async function addHope(obj) {
//    const response = await fetch(`${baseUrl}/user/${userId}`, {
//        method: "POST",
//        body: JSON.stringify(obj),
//        headers: headers
//    })
//    .catch(err => console.error(err.message))
//    if (response.status == 200) {
//        return getHopes(userId);
//    }
//}
//
////get hopes
//
//async function getHopes(userId) {
//    await fetch(`${baseUrl}/user/${userId}`, {
//        method: "GET",
//        headers: headers
//    })
//        .then(response => response.json())
//        .then(data => createHopePost(data))
//        .catch(err => console.error(err))
//}
//
//// get hope by id
////COME BACK TO THIS FETCH BASEURL
//async function getHopeById(hopeId) {
//    await fetch(baseUrl + hopeId, {
//        method:"GET",
//        headers:headers
//    })
//    .then(res => res.json())
//    .then(data => populateHopePost(data))
//    .catch(err => console.error(err.message))
//}
//
//
//// refine your hope
//
//async function editHope(hopeId) {
//    let bodyObj = {
//        id: hopeId,
//        body: hopeBody.value
//    }
//     await fetch(baseUrl, {
//        method: "PUT",
//        body: JSON.stringify(bodyObj),
//        headers: headers
//     })
//        .catch(err => console.error(err))
//
//    return getHopes(userId);
//}
//
//// delete
//
//async function deleteHope(hopeId) {
//    await fetch(baseUrl + hopeId, {
//    method: "DELETE",
//    headers: headers
//    })
//        .catch(err => console.error(err))
//    return getHopes(userId)
//}
//
////create hope post
//function createHopePost(arr) {
//
//hopeContainer.innerHTML = ""
//arr.forEach(obj => {
//    let hopePost = document.createElement("div")
//    hopePost.innerHTML = `
//        <div class="modal" tabindex="-1">
//          <div class="modal-dialog">
//            <div class="modal-content">
//              <div class="modal-header">
//                <h5 class="modal-title">Hope</h5>
//              </div>
//              <div class="modal-body">
//                <p class="card-text">${obj.body}</p>
//              </div>
//              <div class="modal-footer">
//                <button type="button" class="btn btn-danger" onclick="deleteHope(${obj.id})" data-bs-dismiss="modal">Delete</button>
//                <button type="button" class="btn btn-primary" onclick="getHopeById(${obj.id})">Edit</button>
//              </div>
//            </div>
//          </div>
//        </div>
//    `
//hopeContainer.append(hopePost);
//
//})
//
//}
//
//// populateHopePost
//
//const populateHopePost = (obj) => {
//    hopeBody.innerText = ""
//    hopeBody.innerText = obj.body
//    updateHope.setAttribute('data-hope-id', obj.id)
//}
//
//getHopes(userId);
//
//submitHope.addEventListener("submit", handleHopeSubmit)
//
//updateHope.addEventListener("click", (e) => {
//    let hopeId = e.target.getAttribute('data-hope-id')
//    editHope(hopeId);
//})
