


window.onload = function () {

    document.getElementById('goBack').addEventListener('click', goBack);

}


function goBack(event) {
    console.log(event);
    location.href = "employee.html"
}