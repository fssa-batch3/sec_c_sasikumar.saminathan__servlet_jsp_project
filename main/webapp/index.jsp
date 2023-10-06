	<%@ page import="com.fssa.shopnow.model.Product" %>
	<%@ page import="java.util.*" %>
	<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shopnow</title>
<link rel="icon" type="image/x-icon"
	href="../../assets/icon/shopping-bag.png">
<link rel="stylesheet" href="./assets/css/style.css">
<script src="./assets/js/script.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
	<header>
		<!-- div:logo  contain:logo img and name -->
		<div class="logo">
			<img src="./assets/icon/shopping-bag.png" alt="shopping-bag"
				width="30px" height="30px">
			<h5 class="logo-name">
				<b>Shopnow</b>
			</h5>
		</div>

		<!-- search bar -->

		<!-- header nav links -->
		<ul class="top-list">
			<!-- <a href="pages/buyer/main flow/mobile_list.html"><li><button class="login" id="mobiles"><b>Mobiles</b></button></li></a> -->
			<li><button class="login" id="login">
					<b>My account</b>
				</button></li>
			<li id="seller"><a aria-label="seller"
				href="pages/Seller/Seller.html">
					<p class="seller">Seller</p>
			</a></li>
			<li><a id="cart" aria-label="cart"><i id="cart_icon"
					class="home-icon fa fa-shopping-cart" aria-hidden="true"></i></a></li>
			<li><a aria-label="pincode"
				href="./pages/buyer/side flow/pincode.html"><i id="order_icon"
					class="home-icon fa-solid fa-location-dot"></i></a></li>
			<li id="order_hide"><a id="order"><i
					class="home-icon fa-solid fa-bag-shopping"></i></a></li>

		</ul>
		<i id="bar" class="fa-solid fa-bars"></i>
	</header>

	<main>
		<div id="lines">
			<div id="line"></div>
			<p id="head">Add products to your shop</p>
			<div id="line" class="line2"></div>
		</div>
		<div class="model">
			<button class="button-25" id="add_address">
				<i class="fa-solid fa-plus"></i>
				<p>Add product</p>
			</button>
		</div>
		
		<div class="product_list">
		<%List<Product> productList = (List<Product>) request.getAttribute("getProducts");
		if(productList != null){
			for(Product product : productList) {
				List<String> images = product.getImageURL();
		%>
			<div class="mob">
				<img src=<%images.get(0);%> alt="redmi_note_11"
					width="150px" height="200px">
				<h4 class="detail-1"><%product.getName();%></h4>
				<div class="rate">
					<button class="edit_btn button-38" data-keyword="19">Edit</button>
					<button class="delete_btn button-38">Disable</button>
				</div>
			</div>
			<%}
			}%>
		</div>
		<!-- <p>Model name :</p><input id="search" type="search"> -->

	</main>
	<form id="forms">
		<div class="main_container">
			<i class="fa-solid fa-xmark"></i>
			<div>
				<div id="pr_name_div">
					<p>Product Name</p>
					<input type="text" class="inputs" id="pr_name" required>
				</div>
				<div class="product-img">
					<div>
						<p>Upload image urls</p>
						<input type="url" class="inputs" id="pr_img_1" required>
					</div>
					<div>
						<input type="url" class="inputs" id="pr_img_2" required>
					</div>
					<div>
						<input type="url" class="inputs" id="pr_img_3" required>
					</div>
					<div>
						<input type="url" class="inputs" id="pr_img_4" required>
					</div>
				</div>
			</div>
			<div class="type_1">
				<div>
					<p>Product price</p>
					<input type="text" class="inputs" id="pr_price" required>
				</div>
				<div>
					<p>Ram</p>
					<input type="number" class="inputs" id="pr_ram">
				</div>
				<div>
					<p>Storage</p>
					<input type="number" class="inputs" id="pr_rom" required>
				</div>
			</div>
			<div class="type_2">
			</div>
			<div>
				<p>Highlights</p>
				<input type="text" id="high" required>
			</div>
			<button type="submit" class="pr_btn button-28" id="sub">SUBMIT</button>
			<button type="submit" class="pr_btn button-28" id="edit">Update</button>
		</div>

	</form>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script type="text/javascript">
	//get the search input element
    const search = document.getElementById("search")
    const btn = document.querySelector(".button-25")
    const form = document.getElementById("forms")
    const pro_array = JSON.parse(localStorage.getItem("products"))
    let list_div = document.querySelector(".product_list")
    let inputs = document.querySelectorAll("input")
    //get element from submit btn
    const submit_btn = document.getElementById("sub")
    const edit_btn = document.getElementById("edit")
    
    
    	//Adding Load state when it's getting products
    	list_div.innerHTML = `<h3>Loading..</h3>`
    		getProducts();
    

    //event for search the product
    btn.addEventListener("click",function(){
         
        
        //after updating product if click this add product btn it will erase updated mobile values
        for (let i = 0; i < inputs.length; i++) {
            inputs[i].value = ""
        }

        
        const main_container = document.getElementById("forms")
        main_container.style.display = "block"

        submit_btn.style.display = "block"
        edit_btn.style.display = "none"


                })

        //getting values for push
        const pr_name = document.getElementById("pr_name")
        const ram = document.getElementById("pr_ram")
        const rom = document.getElementById("pr_rom")
        const price = document.getElementById("pr_price")
        const img_1 = document.getElementById("pr_img_1")
        const img_2 = document.getElementById("pr_img_2")
        const img_3 = document.getElementById("pr_img_3")
        const img_4 = document.getElementById("pr_img_4")
        const highlights = document.getElementById("high")
        const main_container = document.getElementById("forms")


	function  postData(type,params,msg){
	    	list_div.innerHTML = "";
	    	list_div.innerHTML = `<h3>${msg}</h3>`
    		const url = "http://localhost:8080/shopnow-web/"+ type + params;
    		console.log(url);
    		axios.post(url, null)
    		  .then(function (response) {
    		    // handle success
    		    console.log(response.data);
    	    	getProducts();
    		  })
    		  .catch(function (error) {
    		    // handle error
    		    console.log(error);
    		  })
        }
			
	submit_btn.addEventListener("click",function(e){
	    form.addEventListener("submit",function(e){
	    	
	    	 e.preventDefault();
	           
	    	
	    	 const params =
	    		  "?name=" +
	    		  pr_name.value +
	    		  "&price=" +
	    		  price.value +
	    		  "&ram=" +    
	    		  ram.value +
	    		  "&storage=" +
	    		  rom.value +
	    		  "&img1=" +
	    		  img_1.value +
	    		  "&img2=" +
	    		  img_2.value +
	    		  "&img3=" +
	    		  img_3.value +
	    		  "&img4=" +
	    		  img_4.value +
	    		  "&desc=" +
	    		  highlights.value;
	    	 
	    	 postData("PostProducts",params,"Adding product...");
			
	                   
	    //close the container after submit
	    main_container.style.display = "none"

	})
	})	

const x_mark = document.querySelector(".fa-xmark")
x_mark.addEventListener("click",function () {
    main_container.style.display = "none"    
}) 

	function getProducts(){
			const url = "http://localhost:8080/shopnow-web/GetProducts";
			axios.get(url)
			  .then(function (response) {
			    // handle success
			    list_div.innerHTML = "";
			    console.log(response.data);
			    const array = response.data;
			    mobData(array);
			  })
			  .catch(function (error) {
			    // handle error
			    console.log(error);
			  })
function mobData(arr) {
const pr_array = arr;

for (let j=0; j< pr_array.length; j++) //loop for creating 12 product cards
{
    //div 1 class name: pack
    const div_2 = document.createElement("div");
    div_2.setAttribute("class", "mob")


    //product img
    const img = document.createElement("img");
    img.setAttribute("src", pr_array[j].imageURL[0])
    img.setAttribute("alt", "redmi_note_11")
    img.setAttribute("width", "150px")
    img.setAttribute("height", "200px")
    div_2.append(img)


    //product name
    const h4 = document.createElement("h4");
    h4.setAttribute("class", "detail-1")
    h4.innerHTML = pr_array[j]["name"]
    div_2.append(h4)

    
    const div_3 = document.createElement("div");
    div_3.setAttribute("class", "rate")
    div_2.append(div_3)

    const edit = document.createElement("button")
    edit.setAttribute("class","edit_btn button-38")
    edit.setAttribute("data-keyword",pr_array[j]["id"])
    edit.innerText = "Edit"
    div_3.append(edit)

    const delete_btn = document.createElement("button")
    delete_btn.setAttribute("class","delete_btn button-38")
    delete_btn.innerText = "Delete"
    div_3.append(delete_btn)


    list_div.append(div_2)

    edit.addEventListener("click",function(){
    	
        	let product_id = edit.dataset.keyword
         
            main_container.style.display = "block"

            //set the value in existing inputs
            const p_name = pr_name.value = pr_array[j]["name"]
            ram.value = pr_array[j]["ram"]
            rom.value = pr_array[j]["storage"]
            price.value = pr_array[j]["price"]
            img_1.value = pr_array[j].imageURL[0]
            img_2.value = pr_array[j].imageURL[1]
            img_3.value = pr_array[j].imageURL[2]
            img_4.value = pr_array[j].imageURL[3]
            highlights.value = pr_array[j]["description"]

            pr_name.setAttribute("data-keyword",pr_array[j]["id"])
            
        submit_btn.style.display = "none"
        edit_btn.style.display = "block"
            
                edit_btn.addEventListener("click",function(){
            
            	    form.addEventListener("submit",function(e){
            	    	
            	    	 e.preventDefault();
            //get the id from element
           let product_id = pr_name.dataset.keyword
           
           const editParams = 
               "?name=" +
     		  pr_name.value +
     		  "&price=" +
     		  price.value +
     		  "&ram=" +   
     		  ram.value +
     		  "&storage=" +    
     		  rom.value +
     		  "&img1=" +
     		  img_1.value +
     		  "&img2=" +
     		  img_2.value +
     		  "&img3=" +
     		  img_3.value +
     		  "&img4=" +
     		  img_4.value +
     		  "&desc=" +
     		  highlights.value +
     		  "&id=" + 
     		  product_id;

            postData("UpdateProducts",editParams,"Updating product...");
            main_container.style.display = "none"
            //this condition for removing containers for showing updated containers
            
            	    })    
        })
       })

       
       //for update mobile

        //for disable the mobile
        delete_btn.addEventListener("click",function(){
           
           const params3 = "?name="+pr_array[j]["name"];
			
   		const url = "http://localhost:8080/shopnow-web/DeleteProduct"+params3;
		console.log(url);
		axios.post(url, null)
		  .then(function (response) {
		    // handle success
		    console.log(response.data);  
		  })
		  .catch(function (error) {
		    // handle error
		    console.log(error);
		  })
	
		div_2.remove();
    })


       }
    }
			}

        const seller_nav = document.getElementById("seller")
        const cart_nav = document.getElementById("order_hide")
        const cart_icon = document.getElementById("cart_icon")
        const location_icon = document.getElementById("order_icon")
        const home_nav = document.querySelector(".logo")
    
        
        seller_nav.style.display = "none"
        cart_nav.style.display = "none"
        // cart_icon.removeAttribute("class")
	</script>
</body>
</html>
