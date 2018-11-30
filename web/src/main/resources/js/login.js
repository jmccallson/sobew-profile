var signInBtn = document.getElementById("signInBtn")



/* signin button */
var txtSignInBtn = document.createTextNode("Sign In");
signInBtn.appendChild(txtSignInBtn);
signInBtn.addEventListener('click',
    function(){
        try{
            alert("signing in :)")

        } catch(ex){
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