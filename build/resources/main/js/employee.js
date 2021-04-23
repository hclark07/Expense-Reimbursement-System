


/**
 * On window load, call for current User session object and add an eventListener to create new ticket button
 */
window.onload = function () {

    
    getUser();


    document
        .getElementById('newTicket')
        .addEventListener('click', getNewTicketPage);


    document.getElementById('logout').addEventListener('click', logoutButton);

    

}

/**
 * Grabs current user from server and also grabs user ticket list to populate table
 */
async function getUser () {
    let newHeader = document.getElementById("userHeader");

    //async await to return user object in JSON format
    const response = await fetch(`http://localhost:9227/user/info/`);

    let userJSON = await response.json();

    //AJAX to populate ticket list
    const sendResponse = await fetch(`http://localhost:9227/ticket/list/`);
    let ticketListJSON = await sendResponse.json();
    console.log(ticketListJSON);

    //Change header to users first name and last name
    headerManipulated(userJSON);
    //Populate table with user ticket information
    ourTableManipulation(ticketListJSON);

}



/**
 * Populates table with ticket amount, submission date, resolved date, resolved Manager name, status, type of ticket and description
 * Repeats if more than one ticket
 * @param {TicketListJSON} objectJSON 
 */
function ourTableManipulation (objectJSON) {

    

    let idCounter = 0;

    for(var i =0; i<objectJSON.length; i++) {
        let newTR = document.createElement("tr");
        let newTH = document.createElement("th");
        

        let newTD1 = document.createElement("td");
        let newTD2 = document.createElement("td");
        let newTD3 = document.createElement("td");
        let newTD4 = document.createElement("td");
        let newTD5 = document.createElement("td");
        let newTD6 = document.createElement("td");
        let newTD7 = document.createElement("td");

        newTR.setAttribute("id", ++idCounter)
        newTD1.setAttribute("class", "amount");
        newTD2.setAttribute("class", "submitted");
        newTD3.setAttribute("class", "resolved");
        newTD4.setAttribute("class", "resolver");
        newTD5.setAttribute("class", "status");
        newTD6.setAttribute("class", "type");
        newTD7.setAttribute("class", "description");



        newTH.setAttribute("scope", "row");
        let id = document.createTextNode(idCounter);
        let amount = document.createTextNode("$"+objectJSON[i].amount);
        let submitted = document.createTextNode(new Date(objectJSON[i].submitted).toISOString().slice(0,10));
        
        let resolved = document.createTextNode("");
        if(objectJSON[i].resolved != null) {
            resolved = document.createTextNode(new Date(objectJSON[i].resolved).toISOString().slice(0,10));
        }
        
        let resolver = document.createTextNode("");
        if(objectJSON[i].strAuthor != "null null") {
            resolver = document.createTextNode(objectJSON[i].strAuthor);
        }
        
        
        let status = document.createTextNode(objectJSON[i].status);
        let type = document.createTextNode(objectJSON[i].type);

        //Description button
    
        let newButton = document.createElement("button");
        newButton.setAttribute("type", "button");
        newButton.setAttribute("class", "btn btn-secondary btn-sm description")
        let description = document.createTextNode("View");
        newButton.addEventListener("click",  (event) => {
            let path = event.composedPath();
            let rowNum = path[2].id
            alert(objectJSON[rowNum - 1].description);
        });

        newTH.appendChild(id);
        newTD1.appendChild(amount);
        newTD2.appendChild(submitted);
        newTD3.appendChild(resolved);
        newTD4.appendChild(resolver);
        newTD5.appendChild(status);
        newTD6.appendChild(type);
        newButton.appendChild(description);
        newTD7.appendChild(newButton);

        newTR.appendChild(newTH);
        newTR.appendChild(newTD1);
        newTR.appendChild(newTD2);
        newTR.appendChild(newTD3);
        newTR.appendChild(newTD4);
        newTR.appendChild(newTD5);
        newTR.appendChild(newTD6);
        newTR.appendChild(newTD7);

        let newTableBody = document.getElementById("reimbursementList");
        newTableBody.appendChild(newTR);

        

    }

}

/**
 * Returns a alert filled with the ticket description back to user
 * @param {click} event 
 */
function descriptionPopup (event) {
    let path = event.composedPath();
    let rowNum = path[2].id
    console.log(objectJSON[rowNum].description);
}


/**
 * When new ticket button is clicked redirect users to newTicket.html
 * @param {*} event 
 */
function getNewTicketPage(event) {
    console.log(event);
    window.location.href="newTicket.html"
}

/**
 * DOM manipulates header to user first and last name
 * @param {UserObjectJSON} userJSON 
 */
function headerManipulated(userJSON) {

    console.log(userJSON.fname + " " + userJSON.lname);
   document.getElementById("userHeader").innerText = "Welcome " + userJSON.fname + " " + userJSON.lname;

}


function logoutButton(event) {
    fetch(`http://localhost:9227/newSession/`)
     .then (
        () => location.href = "index.html"
    )

}
