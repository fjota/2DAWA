let mainImage = document.getElementById("main_image")
let dataContainer = document.getElementById("data")
let imageId = 0
let containerStars = document.querySelector("#stars")
let wasClicked = false //control if star was clicked

loadImage(imageId)

function loadImage(imageId) {
  let connectionRequest = new XMLHttpRequest()   
  connectionRequest.onreadystatechange = () => {
    if (connectionRequest.readyState === 4) {
      if (connectionRequest.status === 200) {
        let responseData = connectionRequest.responseText
        mainImage.src = responseData        
      }
      else {
        dataContainer.innerHTML = "Se ha producido un error inesperado"
      }
    } 
  }
  connectionRequest.open("GET", "fotos.php?foto=" + imageId, true)
  connectionRequest.send()
}

function sendVote(points) {
  let connectionRequest = new XMLHttpRequest()
  connectionRequest.onreadystatechange = () => {
    if (connectionRequest.readyState === 4) {
      if (connectionRequest.status === 200) {
        let responseData = connectionRequest.responseText
        let arrayVotes = responseData.split(',');
        dataContainer.innerHTML = `En la foto número: ${imageId}, tenemos una media de votos de: ${averageGrade(arrayVotes)}, de un total de: ${arrayVotes.length - 1} votos`;        
      }
      else {
        dataContainer.innerHTML = "Se ha producido un error inesperado"
      }
    } 
  }
  connectionRequest.open("GET", "votar.php?foto=" + imageId + "&voto=" + points, true)
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

containerStars.addEventListener("mouseover", (e) => {
  if (e.target.id != "stars") {          
    wasClicked ? toDefaultStar() : "";
    wasClicked = false
    e.target.src = "icons/gold.png"
    let element = e.target.previousElementSibling
    while (element) {
      element.src = "icons/gold.png"
      element = element.previousElementSibling
    }
  }
})

containerStars.addEventListener("mouseout", (e) => {
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
})

containerStars.addEventListener("click", (e) => {
  if (e.target.id != "stars") {
    wasClicked = true
    sendVote(e.target.alt)
  }
})

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