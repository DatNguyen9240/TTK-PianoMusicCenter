
let iconCart = document.querySelector('.icon-cart');
let closeBtn = document.querySelector('.cartTab .close');
let body = document.querySelector('body');
const lists = document.querySelector(".list");
const listCard = document.querySelector(".listCard");
const quantity = document.querySelector(".quantity");
const total = document.querySelector(".total");
const count = document.querySelector(".count");
const sum = 1;
iconCart.addEventListener('click', () => {
body.classList.toggle('activeTabCart');
})
closeBtn.addEventListener('click', () => {
body.classList.toggle('activeTabCart');
})