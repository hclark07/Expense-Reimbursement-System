
// Fake JSON API
// {
//     "amount" : "50.50",
//     "submitted" : "2014-01-08 18:31:19.37",
//     "resolved" : "2015-01-08 18:31:19.37",
//     "resolver"  :  "Tim Vook",
//     "statusid"  :  "Pending",
//     "typeid"  :  "Travel"
//     }


/**
 *On window load, call for current User session object to change header and populate tables with ticket information
  and add an eventListener to table filter search bar and submit status button
 */
window.onload = function () {

    changeUserHeader();
    userReimbursementTickets();

    document
        .getElementById("inputSearch")
        .addEventListener("keypress", tableFilter);


    document
        .getElementById("onSubmit")
        .addEventListener("click", updateStatus);

    document.getElementById('logout').addEventListener('click', logoutButton)
        
    
    

}

//Array that holds changes manager made to status
let statusObject = [];

/**
 * On option change store the status_id and ticket_id in an array that will be sent when submit button is clicked
 * @param {onChange} event 
 */
function storeUpdateStatus (event) {
    // let path = event.composedPath();
    // console.log(path[1]);


    let reimbId = event.target.id;
    let reimb_status_id = event.target.value;

    statusObject.push(
        {
            "reimbId" : reimbId,
            "reimb_status_id" : reimb_status_id
        }
    ); 
    

    console.log(statusObject)


}

/**
 * When button submit is clicked send an HTTP request sending an array of objects in JSON format to server to update database
 * @param {onSubmit} event 
 */
function updateStatus (event) {
    fetch(`http://localhost:9227/ticket/statusUpdate/`, {
        method: "post",
        'headers': {
            'Content-Type': 'application/json',
        },
        'body': JSON.stringify(statusObject)
    }) .then (
        () => location.reload()
    )


}


/**
 * Change user heaeder upon logging in
 */
async function changeUserHeader () {
    let newHeader = document.getElementById("userHeader")

    const response = await fetch(`http://localhost:9227/user/info/`);

    let userJSON = await response.json();

    newHeader.innerText =  "Welcome " + userJSON.fname + " " + userJSON.lname;
}


/**
 * XHTTPRequest for all tickets created in system
 */
function userReimbursementTickets () {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){
        
 
        if(xhttp.readyState===4 && xhttp.status===200){
             
             let ticketList = JSON.parse(xhttp.responseText);
             console.log(ticketList);
 
             ourTableManipulation(ticketList);
        }
    }
 
  
    xhttp.open("GET", "http://localhost:9227/ticket/allTickets/");  //<--- Make sure to input full http URL
     
  
     xhttp.send();

}

/**
 * Take the list of tickets and populate table with information on:
 * ticket amount, submission date, resolved date, resolved Manager name, status, type of ticket and description
 * @param {} objectJSON 
 */
function ourTableManipulation (objectJSON) {

    

    let idCounter = 0;

    for(var i =0; i<objectJSON.length; i++) {
        let cpending = "false";
        let newTR = document.createElement("tr");
        let newTH = document.createElement("th");

        let newTD1 = document.createElement("td");
        let newTD2 = document.createElement("td");
        let newTD3 = document.createElement("td");
        let newTD4 = document.createElement("td");
        let newTD5 = document.createElement("td");
        let newTD6 = document.createElement("td");
        let newTD7 = document.createElement("td");

        let newlabel = document.createElement("label");
        
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
        let amount = document.createTextNode(objectJSON[i].amount);
        let submitted = document.createTextNode(new Date(objectJSON[i].submitted).toISOString().slice(0,10));
        
        let resolved = document.createTextNode("");
        if(objectJSON[i].resolved != null) {
            resolved = document.createTextNode(new Date(objectJSON[i].resolved).toISOString().slice(0,10));
        }
        
        
        let resolver = document.createTextNode(objectJSON[i].strAuthor);
        
        let status = document.createTextNode(objectJSON[i].status);
        let type = document.createTextNode(objectJSON[i].type);

        
        //If status is pending populate table with select tag instead
        if(objectJSON[i].status == "Pending") {
            let newSelect = document.createElement("select");
            let option1 = document.createElement("option");
            let option2 = document.createElement("option");
            let option3 = document.createElement("option");
            
            newlabel.setAttribute("for", "status");
            newSelect.setAttribute("id", objectJSON[i].reimbId);
            newSelect.setAttribute("name", "status");
            newSelect.addEventListener("change",storeUpdateStatus);

            option1.setAttribute("value", "1"); //Pending
            option2.setAttribute("value", "2"); //Approved
            option3.setAttribute("value", "3"); //Denied

            let approved = document.createTextNode("Approved");
            let denied = document.createTextNode("Denied");
            let pending = document.createTextNode("Pending")

            option1.appendChild(pending);
            option2.appendChild(approved);
            option3.appendChild(denied);

            newSelect.appendChild(option1);
            newSelect.appendChild(option2);
            newSelect.appendChild(option3);

            newlabel.appendChild(newSelect);
            cpending = "true";


        };

        //Description view button
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

        if(cpending == "true"){
            newTD5.appendChild(newlabel);
        } else{
            newTD5.appendChild(status);
        }
        
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
 * Filters table based on what is typed into search bar
 * @param {onkeypress} event 
 */
function tableFilter(event) {
    console.log(event.target.value);


    var filter, table, tr, td, i, txtValue;
  filter = event.target.value.toUpperCase();
  table = document.getElementById("ticketTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[4];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) == 0) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}



function logoutButton(event) {
    fetch(`http://localhost:9227/newSession/`)
     .then (
        () => location.href = "index.html"
    )

}