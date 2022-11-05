//botão top
const btn = document.getElementById("btnTop")
btn.addEventListener("click", function () {
  window.scrollTo(0, 0)
})
document.addEventListener('scroll', ocultar)

function ocultar() {
  if (window.scrollY > 10) {
    btn.style.display = "flex"
  } else {
    btn.style.display = "none"
  }
}
ocultar()

//confirmação de senha
var password = document.getElementById("password")
  , confirmPassword = document.getElementById("ConfirmarPassword");

function validatePassword(){
  if(password.value != register-confirmPassword.value) {
    confirmPassword.setCustomValidity("Senhas diferentes!");
  } else {
    confirmPassword.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirmPassword.onkeyup = validatePassword;

//dica info
var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl)
})
