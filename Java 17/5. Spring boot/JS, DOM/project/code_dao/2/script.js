const canvas = document.getElementById("draw");
console.log(canvas)
const ctx = canvas.getContext("2d");
ctx.fillStyle = "red";

function draw(x, y) {
  const circle = new Path2D();
  circle.arc(x, y, 5, 0, 2 * Math.PI);
  ctx.fill(circle);
  console.log(x,y)
}

canvas.addEventListener("mousedown", (e) => {

    const react = canvas.getBoundingClientRect()
  draw(e.clientX-100, e.clientY);
  console.log(e)
  console.log(react)
});
