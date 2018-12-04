let settingsBtn = document.getElementById("difficulty");
let modal = document.getElementById("settings-modal");
let closeModalBtn = document.getElementsByClassName("close").item(0);



function showModal() {
  modal.style.display = "block";
}

function closeModal() {
  modal.style.display = "none";
}

settingsBtn.addEventListener("click", showModal);
closeModalBtn.addEventListener("click", closeModal);

window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

 

