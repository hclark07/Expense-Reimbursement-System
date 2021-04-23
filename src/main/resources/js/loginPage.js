




/**
 * On window load send an HTTP request resetting session and adding a addeventListener to create new User button
 */
window.onload = function () {

    newSession ();
    checkWrongInfo();

    document
        .getElementById('createNewUser')
        .addEventListener('click', newUserForm);


}

/**
 * HTTP request resetting User session
 */
async function newSession () {
    const response = await fetch(`http://localhost:9227/newSession/`);
}

/**
 * Checks the server for a wrong Login token
 * If true display that the user incorrectly inputted their username/password
 */
async function checkWrongInfo () {
    const response = await fetch(`http://localhost:9227/login/wrongLoginInfo`);

    let booleanCheck = await response.json();
    if (booleanCheck == "true")
        wrongLoginInfo();
}


/**
 * DOM manipulation for creating a new User  
 * @param {click} event 
 */
function newUserForm(event) {
    console.log("In the new User function")

    //Replacing Login header with Create new user
    let newHeader = document.getElementById("divBodyHeader");
    newHeader.innerText = "Create New User"
    console.log (newHeader);
    


    //Form tag
    let newForm = document.createElement("form");

    newForm.setAttribute("class", "white");
    newForm.setAttribute("method", "post");
    newForm.setAttribute("action", "/login/newUser/");


     //First name input box
    let newDiv = document.createElement("div");
    let newLabel = document.createElement("label");
    let newDiv2 = document.createElement("div");
    let newInput = document.createElement("input");
    let fname = document.createTextNode("First name");

    
    newDiv.setAttribute("class", "row mb-3");
    newLabel.setAttribute("for", "inputFName");
    newLabel.setAttribute("class", "col-sm-2 col-form-label");
    newDiv2.setAttribute("class", "col-sm-10");
    newInput.setAttribute("type", "fname");
    newInput.setAttribute("class", "form-control");
    newInput.setAttribute("id", "inputFname");
    newInput.setAttribute("name","fname");

    newLabel.appendChild(fname);
    newDiv2.appendChild(newInput);
    newDiv.appendChild(newLabel);
    newDiv.appendChild(newDiv2);
    newForm.appendChild(newDiv);

    //Last name input box
    let newDiv3 = document.createElement("div");
    let newLabel2 = document.createElement("label");
    let newDiv4 = document.createElement("div");
    let newInput2 = document.createElement("input");
    let lname = document.createTextNode("Last name");

    
    newDiv3.setAttribute("class", "row mb-3");
    newLabel2.setAttribute("for", "inputLName");
    newLabel2.setAttribute("class", "col-sm-2 col-form-label");
    newDiv4.setAttribute("class", "col-sm-10");
    newInput2.setAttribute("type", "lname");
    newInput2.setAttribute("class", "form-control");
    newInput2.setAttribute("id", "inputLName");
    newInput2.setAttribute("name","lname");

    newLabel2.appendChild(lname);
    newDiv4.appendChild(newInput2);
    newDiv3.appendChild(newLabel2);
    newDiv3.appendChild(newDiv4);
    newForm.appendChild(newDiv3);

    //Email input box
    let newDiv5 = document.createElement("div");
    let newLabel3 = document.createElement("label");
    let newDiv6 = document.createElement("div");
    let newInput3 = document.createElement("input");
    let email = document.createTextNode("Email");

    
    newDiv5.setAttribute("class", "row mb-3");
    newLabel3.setAttribute("for", "inputEmail");
    newLabel3.setAttribute("class", "col-sm-2 col-form-label");
    newDiv6.setAttribute("class", "col-sm-10");
    newInput3.setAttribute("type", "email");
    newInput3.setAttribute("class", "form-control");
    newInput3.setAttribute("id", "inputEmail");
    newInput3.setAttribute("name","email");

    newLabel3.appendChild(email);
    newDiv6.appendChild(newInput3);
    newDiv5.appendChild(newLabel3);
    newDiv5.appendChild(newDiv6);
    newForm.appendChild(newDiv5);

    //Password input box
    let newDiv7 = document.createElement("div");
    let newLabel4 = document.createElement("label");
    let newDiv8 = document.createElement("div");
    let newInput4 = document.createElement("input");
    let password = document.createTextNode("Password");

    
    newDiv7.setAttribute("class", "row mb-3");
    newLabel4.setAttribute("for", "inputPassword");
    newLabel4.setAttribute("class", "col-sm-2 col-form-label");
    newDiv8.setAttribute("class", "col-sm-10");
    newInput4.setAttribute("type", "password");
    newInput4.setAttribute("class", "form-control");
    newInput4.setAttribute("id", "inputPassword");
    newInput4.setAttribute("name","password");

    newLabel4.appendChild(password);
    newDiv8.appendChild(newInput4);
    newDiv7.appendChild(newLabel4);
    newDiv7.appendChild(newDiv8);
    newForm.appendChild(newDiv7);



    //Radio button Employee
    let newFieldSet = document.createElement("fieldset");
    let newLegend = document.createElement("legend");
    let newDiv9 = document.createElement("div");
    let newDiv10 = document.createElement("div");
    let newInput5 = document.createElement("input");
    let newLabel5 = document.createElement("label");
    let type = document.createTextNode("Are you?");
    let employee = document.createTextNode("Employee");

    newFieldSet.setAttribute("class", "row mb-3");
    newLegend.setAttribute("class", "col-form-label col-sm-2 pt-0");
    newDiv9.setAttribute("class", "col-sm-10");
    newDiv10.setAttribute("class", "form-check");
    newInput5.setAttribute("class", "form-check-input");
    newInput5.setAttribute("type", "radio");
    newInput5.setAttribute("value", 1);
    newInput5.setAttribute("id", "radioEmployee");
    newInput5.setAttribute("name","type");
    newInput5.setAttribute("checked", "true");
    newLabel5.setAttribute("for", "radioEmployee");
    newLabel5.setAttribute("class", "form-check-label");

    newLabel5.appendChild(employee);
    newDiv10.appendChild(newInput5);
    newDiv10.appendChild(newLabel5);
    newDiv9.appendChild(newDiv10);


    //Radio button Manager
    let newDiv11 = document.createElement("div");
    let newInput6 = document.createElement("input");
    let newLabel6 = document.createElement("label");
    let manager = document.createTextNode("Manager");

    newDiv11.setAttribute("class", "form-check");
    newInput6.setAttribute("class", "form-check-input");
    newInput6.setAttribute("type", "radio");
    newInput6.setAttribute("value", 2);
    newInput6.setAttribute("id", "radioManager");
    newInput6.setAttribute("name","type");
    newLabel6.setAttribute("for", "radioManager");
    newLabel6.setAttribute("class", "form-check-label");

    newLabel6.appendChild(manager);
    newDiv11.appendChild(newInput6);
    newDiv11.appendChild(newLabel6);
    newDiv9.appendChild(newDiv11);

    newLegend.appendChild(type)
    newFieldSet.appendChild(newLegend);
    newFieldSet.appendChild(newDiv9)
    newForm.appendChild(newFieldSet);




    //Sign me in button
    let newDiv12 = document.createElement("div");
    let newButton = document.createElement("button");
    let createUser = document.createTextNode("Sign me up");

    newDiv12.setAttribute("class", "d-grid gap-2");
    newButton.setAttribute("id","createNewUser");
    newButton.setAttribute("class","btn btn-success");
    newButton.setAttribute("type", "submit");

    newButton.appendChild(createUser);
    newDiv12.appendChild(newButton);
    newForm.appendChild(newDiv12);
    

    

    //Main Div that everything will be appended to 
    let newDivBody = document.createElement("div");
    newDivBody.appendChild(newHeader);
    newDivBody.appendChild(newForm);
    let oldChildNode = document.getElementById("divBody")


    oldChildNode.parentElement.replaceChild(newDivBody, oldChildNode);

}




/**
 * If HTTP request in checkWrongInfo method returns true display incorrect username/password to user
 */
function wrongLoginInfo () {
    let newP = document.createElement("p");
    newP.setAttribute("class", "wrong");

    let message = document.createTextNode("Incorrect username or password");

    let div = document.getElementById("tryAgain");

    newP.appendChild(message);
    div.appendChild(newP);

}