var usernameInput = document.getElementById("usernameInput");
var passwordInput = document.getElementById("passwordInput");
var loginBtn = document.getElementById("loginBtn");

/* user name */
var usrnameStr = new String();
usernameInput.setAttribute("placeholder", "Enter Username");
usernameInput.addEventListener('keyup',
    function(){
        try{
            usrnameStr = usernameInput.value;
        } catch(ex){
            alert(ex.message)
        }
    }
);

/* password */
var pswStr = new String();
passwordInput.setAttribute("placeholder", "Enter Password");
passwordInput.addEventListener('keyup',
    function(){
        try{
            pswStr = passwordInput.value;
        } catch(ex){
            alert(ex.message)
        }
    }
);

/* login button */
var txtLoginBtn = document.createTextNode("Login");
loginBtn.appendChild(txtLoginBtn);
loginBtn.addEventListener('click',
    function(){
        try{
            if(pswStr.length > 0 && usrnameStr.length > 0){

               form = document.getElementById("load");
               form.action = "patientprofile"
            }
        }catch(ex){
            alert(ex.message)
        }
    }
);



function myFunction() {
    var x = document.getElementById("psw");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
} 