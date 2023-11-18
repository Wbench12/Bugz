"use strict";
const sub = document.getElementById("submit");
sub.addEventListener("submit", function (event) {
  event.preventDefault();
  console.log("sfdfd");
  window.location.href = "profile-company.html";
});
const dot = document.getElementById("sub");
for (let i = 0; i < dot.length; i++) {
  dot.addEventListener("click", function () {
    window.location.href = "profile-company.html";
  });
}
