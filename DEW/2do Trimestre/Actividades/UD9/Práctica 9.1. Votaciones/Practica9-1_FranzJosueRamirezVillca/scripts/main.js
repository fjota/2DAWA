let mainImage = document.getElementById("main_image")
let imageId = 0
let buttonBefore = document.getElementById("before")
let buttonsAfter = document.getElementById("after")

window.onload = () => {
  loadImage(imageId)
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


buttonBefore.addEventListener("click", () => {
  imageId--;
  imageId < 0 ? imageId = 2 : "";
  loadImage(imageId)
})

buttonsAfter.addEventListener("click", () => {
  imageId++;
  imageId > 2 ? imageId = 0 : "";
  loadImage(imageId)
})