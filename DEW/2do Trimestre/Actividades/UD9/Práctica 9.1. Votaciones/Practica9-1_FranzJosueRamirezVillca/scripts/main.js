let mainImage = document.getElementById("main_image")
let dataContainer = document.getElementById("data")
let imageId = 0
let containerStars = document.querySelector("#stars")
let wasClicked = false //control if start was clicked

loadImage(imageId)
loadEventListeners()

function goldStars(e) {
  if (e.target.id != "stars") {    
    toDefaultStar()  
    wasClicked = false
    e.target.src = "icons/gold.png"
    let element = e.target.previousElementSibling
    while (element) {
      element.src = "icons/gold.png"
      element = element.previousElementSibling
    }
  }
}

function defaultStars(e) {
  if (e.target.id != "stars") {
    if (!wasClicked) {
      e.target.src = "icons/gray.png"
      let element = e.target.previousElementSibling
      while (element) {
        element.src = "icons/gray.png"
        element = element.previousElementSibling
      }
    }
  }
}

function likePhoto(e) {
  if (e.target.id != "stars") {
    wasClicked = true
    sendVote(e.target.alt)
  }
}

function loadEventListeners() {
  containerStars.addEventListener("mouseover", goldStars)
  containerStars.addEventListener("mouseout", defaultStars)
  containerStars.addEventListener("click", likePhoto)
}

function loadImage(imageId) {
  let connectionRequest = new XMLHttpRequest()
  connectionRequest.onreadystatechange = () => {
    if (connectionRequest.readyState === 4) {
      let responseData = connectionRequest.responseText
      mainImage.src = responseData
    }
  }
  connectionRequest.open("GET", "fotos.php?foto=" + imageId)
  connectionRequest.send()
}

function sendVote(points) {
  let connectionRequest = new XMLHttpRequest()
  connectionRequest.onreadystatechange = () => {
    if (connectionRequest.readyState === 4) {
      let responseData = connectionRequest.responseText
      let arrayVotes = responseData.split(',');
      dataContainer.innerHTML = `Tenemos una media de votos de: ${averageGrade(arrayVotes)}, de un total de: ${arrayVotes.length - 1} votos`;
    }
  }
  connectionRequest.open("GET", "votar.php?foto=" + imageId + "&voto=" + points)
  connectionRequest.send()
}

function averageGrade(numbersArray) {
  let average = 0
  numbersArray.forEach(element => {
    element = parseInt(element)
    !isNaN(element) ? average += parseInt(element) : "";
  });
  average /= numbersArray.length
  return average
}

function toDefaultStar() {
  for (let star of containerStars.children) {
    star.src = "icons/gray.png"
  }
}

document.getElementById("before").addEventListener("click", () => {
  imageId--;
  imageId < 0 ? imageId = 2 : "";
  dataContainer.innerHTML = ""
  toDefaultStar()
  loadImage(imageId)
})

document.getElementById("after").addEventListener("click", () => {
  imageId++;
  imageId > 2 ? imageId = 0 : "";
  dataContainer.innerHTML = ""
  toDefaultStar()
  loadImage(imageId)
})