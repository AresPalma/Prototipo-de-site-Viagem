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

//modal
function iniciarModal(modalID) {
  const modal = document.getElementById(modalID);
  if (modal) {
    modal.classList.add('mostrar')
    modal.addEventListener('click', (e) => {
      if (e.target.className == "close") {
        modal.classList.remove('mostrar');
      }
    });
  }
}
const login = document.querySelector('#btn-login');
login.addEventListener('click', () => iniciarModal('modal'));

//mensagem de erro no cadastro


//confirmação de senha
var password = document.getElementById("password")
  , confirm_password = document.getElementById("register-Confirmar_password");

function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Senhas diferentes!");
  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
