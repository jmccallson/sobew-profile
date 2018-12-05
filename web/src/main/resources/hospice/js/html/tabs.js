/*
This is for building tabs :)
*/


function buildTab(objId){
  var currentSelected = document.getElementById(objId);
  var clientTab = document.createElement("BUTTON");
  clientTab.setAttribute("class", "tablink");
  clientTab.setAttribute("onclick", "openPage('documentcontent" + objId + "', this, 'red')");
  var patientsName = document.createTextNode(currentSelected.innerText);
  clientTab.appendChild(patientsName);
  document.getElementById("container").appendChild(clientTab);
}

function openPage(pageName, elmnt, color) {
   alert(pageName + " - " + elmnt + " - " + color)
    // Hide all elements with class="tabcontent" by default */
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Remove the background color of all tablinks/buttons
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
    }

    // Show the specific tab content
    document.getElementById(pageName).style.display = "block";

    // Add the specific color to the button used to open the tab content
    elmnt.style.backgroundColor = color;
}

document.getElementById("document").click();