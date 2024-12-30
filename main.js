let search = document.querySelector('.search-box');
document.querySelector('#Search-icon').onclick = () => {
    search.classList.toggle('active');
    menu.classList.remove('active');

}

let menu = document.querySelector('.navbar');
document.querySelector('#menu-icon').onclick = () => {
    menu.classList.toggle('active');
    search.classList.remove('active');

}

// Hide Menu And Search Box On scroll
window.onscroll=()=>{
    menu.classList.remove('active');
    search.classList.remove('active');
}
 
// Header
let header = document.querySelector('header');
window.addEventListener('scroll',()=>{
    header.classList.toggle('shadow', window.scrollY > 0)
});


  
  // =====================all cart JS====
  
  // Ensure the document is loaded before running the script
  if (document.readyState == "loading") {
      document.addEventListener("DOMContentLoaded", ready);
  } else {
      ready();
  }
  
  // Define the ready function
  function ready() {
      // Get all remove buttons
      let removeCartButtons = document.getElementsByClassName("cart-remove");
      for (let i = 0; i < removeCartButtons.length; i++) {
          let button = removeCartButtons[i];
          button.addEventListener("click", removeCartItem);
      }
      // Quntity change 
      let quntityInputs = document.getElementsByClassName("cart-quantity");
      for (let i = 0; i < quntityInputs.length; i++) {
        let input = quntityInputs[i];
        input.addEventListener("change", quntityChanged);
    }
// add to cart
let addCart = document.getElementsByClassName("btn-part");
for (let i = 0; i < addCart.length; i++) {
  let button = addCart[i];
  button.addEventListener("click",addCartClicked);
}
  }
  

  // Function to remove the cart item
  function removeCartItem(event) {
      let buttonClicked = event.target;
      buttonClicked.parentElement.remove(); // Removes the cart box
      updatetotal()
  }

  //function quntity changed
  function quntityChanged(event){
    let input = event.target;
    if(isNaN(input.value)|| input.value<=0){
        input.value=1;
    }
    updatetotal();

  }



  //add cart function
  function addCartClicked(event){
    let button = event.target;
    let shopProducts = button.parentElement;
    let title = shopProducts.getElementsByClassName("product-title").innerText;
    let price = shopProducts.getElementsByClassName("price").innerText;
    let productImg = shopProducts.getElementsByClassName("product-img")[0].src;
    addProductToCart(title,price,productImg);
    updatetotal();

  }


  //Update total

  function updatetotal() {
    // Get the cart content container
    var cartContent = document.getElementsByClassName("cart-content")[0];

    // Get all cart boxes
    var cartBoxes = cartContent.getElementsByClassName("cart-box");

    var total = 0;

    // Loop through each cart box to calculate the total
    for (var i = 0; i < cartBoxes.length; i++) {
        var cartBox = cartBoxes[i];

        // Get the price element and quantity element
        var priceElement = cartBox.getElementsByClassName("cart-price")[0];
        var quantityElement = cartBox.getElementsByClassName("cart-quantity")[0];

        // Parse the price and quantity values
        var price = parseFloat(priceElement.innerText.replace("$", ""));
        var quantity = parseInt(quantityElement.value);

        // Add to the total
        total += price * quantity;
    }

    // Round the total to two decimal places
    total = Math.round(total * 100) / 100;

    // Update the total price in the cart
    document.getElementsByClassName("total-price")[0].innerText = "$" + total;
}




function addProductToCart(title,price,productImg){
    let cartShopBox = document.createElement("div");
    cartShopBox.classList.add("cart-box");
    let creatItems = document.getElementsByClassName("cart-content")[0];
    let creatItemsNames = creatItems.getElementsByClassName("cart-product-title");
    for (let i = 0 ; i < creatItemsNames.length; i++){
        if(creatItemsNames[i].innerText==title){
            alert("You have alreafy added this item to cart");
            return;
        }
    }

    let cartBoxContent = `
                <img src="${productImg}" alt="" class="cart-img">
                    <div class="detail-box">
                        <div class="cart-product-title">${title}</div>
                        <div class="cart-price">${price}</div>
                        <input 
                        type="number"
                        name=""
                        id=""
                        min="0"
                        max="10"
                        value="1"
                        class="cart-quantity"
                        >
                    </div>
                    <!-- Remove Item -->
                    <i class='bx bxs-trash cart-remove'   ></i>`;
        
        
    
    cartShopBox.innerHTML=cartBoxContent ;
    creatItems.append(cartShopBox);
    cartShopBox.getElementsByClassName('cart-remove')[0]
    .addEventListener('click',removeCartItem);
    cartShopBox.getElementsByClassName('cart-quantity')[0]
    .addEventListener('change',quntityChanged);
}






// =================================================== LOGIN BOX
// const signInBtnLink = document.querySelector('.signInBtn-link');
// const signUpBtnLink = document.querySelector('.signUpBtn-link');
// const wrapper = document.querySelector('.wrapper');
// signUpBtnLink.addEventListener('click', () => {
//     wrapper.classList.toggle('active');
// });
// signInBtnLink.addEventListener('click', () => {
//     wrapper.classList.toggle('active');
// });
