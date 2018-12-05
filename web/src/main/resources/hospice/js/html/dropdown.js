

var expanded = false;

function showCheckboxes() {
  var checkboxes = document.getElementById("checkboxes");
  if (!expanded) {
    checkboxes.style.display = "block";
    expanded = true;
  } else {
    checkboxes.style.display = "none";
    expanded = false;
  }
}

function filterFunction() {
    try{
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("checkboxes");
    a = div.getElementsByTagName("span");
    img = div.getElementsByTagName("img");
    //inpt = div.getElementsByTagName("input");
    lbl = div.getElementsByTagName("label");
    for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
            img[i].style.display = "";
            //inpt[i].style.display = "";
            lbl[i].style.display = "";
        } else {
            a[i].style.display = "none";
            img[i].style.display = "none";
            //inpt[i].style.display = "none";
            lbl[i].style.display = "none";
        }
    }
    } catch(ex){
        alert(ex.message)
    }
}