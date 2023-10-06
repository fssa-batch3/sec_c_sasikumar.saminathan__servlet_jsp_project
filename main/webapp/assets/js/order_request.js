
//get elements for changing those dynamicaly
const mobile_image = document.getElementById("mobile_img")
const mobile_name = document.getElementById("mob_name")
const mobile_qty = document.getElementById("qty")
const mobile_price = document.getElementById("price")
const mobile_request_time = document.getElementById("requested_time")
const mobile_request_date = document.getElementById("requested_date")
const main_container = document.querySelector(".requested_mobile")
const head = document.querySelector("h1")
//nav bars
const requesst_bar = document.getElementById("request_orders")
const delivered_history_bar = document.getElementById("delivered_history")

// let shop_orders

//get the shop id from params
let url = window.location.search
const params = new URLSearchParams(url)
const shop_id = params.get("id")





productsCreate();
function productsCreate() {
    //filltering specific shop orders

    //get the order array from localstorage
const order_array = JSON.parse(localStorage.getItem("orders"))



let order_object =  order_array.filter(function (obj) {
    console.log(obj);
    if (obj["order_staus"] === "delivered") {
        return false
   }
   else{
    return true
   }        
})


delivered_history_bar.addEventListener("click",function () {
window.location.href = "order_delivered.html?id="+shop_id
})

  let shop_orders = order_object.filter(function (obj) {
    if (shop_id === obj["shop_id"]) {
        return true
    }
    else{
        return false
    }
 })


 //get the mobile details from order shop_orders array
 const product_arr = JSON.parse(localStorage.getItem("products"))
 const pr_array = []
 for(j = 0; j < shop_orders.length;j++ ){       
 for(i = 0; i < product_arr.length;i++){
     if(shop_orders[j]["product_id"] ===  product_arr[i]["user_id"]+""){
         pr_array.push(product_arr[i])
     }
 }
}

let reuest_mobile = ""
for (let i = 0; i < pr_array.length; i++) {

    let type = shop_orders[i]["type"]

    reuest_mobile += `<div class="request_container">
    <div class="mobile_name">
        <div class="mobile_img">
            <img src="${pr_array[i]["product_img_1"]}">
        </div>
        <div class="mob_name">
            <p id="mob_name">${pr_array[i]["product_name"]}</p>
        </div>
    </div>
    <div class="qty">
        <p id="qty">${shop_orders[i]["quantity"]}</p>
    </div>
    <div class="price">
        <p id="price">${"₹"+parseFloat(pr_array[i]["types"][type]["price"].slice(1)) * parseFloat(shop_orders[i]["quantity"])}</p>
    </div>
    <div class="requested_date">
        <p id="requested_time"><span id="requested_date">${shop_orders[i]["date"]}</span> at ${shop_orders[i]["time"]}</p>
    </div>
    <button class="button-45" role="button" data-keyword="${shop_orders[i]["order_id"]}">More info</button>
</div>`
    
}
main_container.innerHTML = reuest_mobile

let btn = document.querySelectorAll(".button-45")
const order_btn = document.getElementById("delivered_btn")
console.log(shop_orders);
for(let i = 0; i < shop_orders.length; i++){
      if (shop_orders[i]["order"] === false){
        
        btn[i].innerHTML = "Canceled"
        btn[i].style.backgroundColor = "#FF6969"
        order_btn.style.display = "none"

      }  
}
// }


//toggle option scripts are there
let more_info_btn = document.querySelectorAll(".button-45")
let menu = document.querySelector(".menu")
let close_arrow = document.querySelector(".fa-circle-chevron-right")
const user_name = document.getElementById("name")
const number = document.getElementById("number")
const area = document.getElementById("area")
const house_number = document.getElementById("house_num")
const landmark = document.getElementById("landmark")
const pincode = document.getElementById("pincode")
const payment = document.getElementById("payment")
const delivered_btn = document.getElementById("delivered_btn")
const main_div = document.querySelectorAll(".request_container")



let address_arr = JSON.parse(localStorage.getItem("address"))
let order_obj
let request_div;
for (let i = 0; i < more_info_btn.length; i++) {
    
    more_info_btn[i].addEventListener('click',function(){
       
        order_btn.style.display = "block"

        
        if (more_info_btn[i].innerHTML !== "Canceled") {
            menu.classList.toggle('showmenu');
        }

        let order_id = more_info_btn[i].dataset.keyword

         order_obj = shop_orders.find(function (obj) {

            if (order_id === obj["order_id"]+"") {
                return true
            }
            else{
                return false
            }
        })


            address_arr.find(function (obj) {
                if (order_obj["address_id"] === obj["id"]) {
                    user_name.innerText = obj["name"]
                    number.innerText  = obj["phone_number"]
                    area.innerText = obj["area"]
                    house_number.innerText = obj["house_number"]
                    landmark.innerText = obj["landmark"]
                    pincode.innerText = obj["pincode"]
                    payment.innerText = order_obj["payment_method"]
                }
            })


        
        
        });

        request_div = main_div[i]



}




        //while click the deliverd btn
        delivered_btn.addEventListener("click",function deliveredHistory() {

            request_div.remove();

            order_array.find(function(obj){
                if (order_obj["order_id"] === obj["order_id"]) {
                    obj["order_staus"] = "delivered"
                     
                }
            })
            localStorage.setItem("orders",JSON.stringify(order_array))
            // menu.classList.toggle('showmenu')
            main_container.innerHTML = "" 
            productsCreate();
        })
    }


        const seller_nav = document.getElementById("seller")
        const cart_nav = document.getElementById("order_hide")
        const cart_icon = document.getElementById("cart_icon")
        const location_icon = document.getElementById("order_icon")
        const home_nav = document.querySelector(".logo")
    
        
        seller_nav.style.display = "none"
        cart_nav.style.display = "none"
        // cart_icon.removeAttribute("class")
        cart_icon.setAttribute("class","home-icon fa-solid fa-calendar-plus")
        location_icon.setAttribute("class","home-icon fa-solid fa-clipboard-list")
    
        cart_icon.addEventListener("click",function () {
            window.location.href = "/pages/Seller/mobile_create.html?id="+profile["shop_id"]
        })
        location_icon.addEventListener("click",function () {
            window.location.href = "/pages/Seller/order_request.html?id="+profile["shop_id"]
        })

        home_nav.addEventListener("click",function () {
            window.location.href = "../../index.html"
        })

let menu = document.querySelector(".menu")
let close_arrow = document.querySelector(".fa-circle-chevron-right")
const delivered_btn = document.getElementById("delivered_btn")
        close_arrow.addEventListener("click",function () {
            menu.classList.toggle('showmenu')    
        })
       

        delivered_btn.addEventListener("click",function () {
            menu.classList.toggle('showmenu')
        })