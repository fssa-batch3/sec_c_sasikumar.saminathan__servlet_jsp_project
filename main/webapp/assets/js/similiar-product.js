
      const product_list = [
        {
            image: "../../../../assets/image/note-11-2201117ti-redmi-original-imagbh8dmpjfzrjw.webp",
            name: "Redmi note 11",
            price: "₹12,993",
            star: "4.5",
            rating: "27,000 Ratings"
        },
        {
            image: "../../../../assets/image/galaxy-s21-fe-5g-lavender-8gb-128gb-storage-sm-g990elviinu-original-imagbnbdaj3tygup.webp",
            name: "SAMSUNG Galaxy S21 FE 5G",
            price: "₹39,999",
            star: "4.3",
            rating: "26,443 Ratings"

        },
        {
            image: "../../../../assets/image/-original-imaghxa5hvapbfds.webp",
            name: "APPLE iPhone 14",
            price: "₹77,400",
            star: "4.6",
            rating: "786 Ratings"
        },
        {
            image: "../../../../assets/image/-original-imagg2abzhxjckxu.webp",
            name: "OnePlus Nord CE 2 Lite 5G",
            price: "₹19,979",
            star: "4.4",
            rating: "34,497 Ratings"
        },
    ]


for (let j = 3; 0 <= j; j--) //loop for creating 4 product cards
    {
        //div 1 class name: pack
        const div_2 = document.createElement("div");
        div_2.setAttribute("class", "mob-2")
        document.querySelector(".mobile-2").prepend(div_2)

        //product img
        const img = document.createElement("img");
        img.setAttribute("src", product_list[j].image)
        img.setAttribute("alt", "redmi_note_11")
        img.setAttribute("width", "150px")
        img.setAttribute("height", "200px")
        document.querySelector(".mob-2").append(img)

        //anker tag for going next pages
        const a = document.createElement("a");
        a.setAttribute("aria-label", "redmi")
        a.setAttribute("class", "mob-link")
        a.setAttribute("href", "side-flow2.html")
        document.querySelector(".mob-2").append(a)

        //product name
        const h4 = document.createElement("h4");
        h4.setAttribute("class", "detail-1-2")
        h4.innerHTML = product_list[j].name
        document.querySelector(".mob-link").append(h4)

        //div 2 class name: rate for show price
        const div_3 = document.createElement("div");
        div_3.setAttribute("class", "rate-2")
        document.querySelector(".mob-2").append(div_3)

        //product price
        const h2 = document.createElement("h2");
        h2.innerHTML = product_list[j].price
        document.querySelector(".rate-2").append(h2)

        //product price
        const p = document.createElement("p");
        p.setAttribute("class", "onward-2")
        p.innerHTML = "onwards"
        document.querySelector(".rate-2").append(p)

        //div 2 class name: rate for show rating
        const div_4 = document.createElement("div");
        div_4.setAttribute("class", "rating-2")
        document.querySelector(".mob-2").append(div_4)

        //div 2 class name: rate for show rating
        const div_5 = document.createElement("div");
        div_5.setAttribute("class", "rating-1-2")
        document.querySelector(".rating-2").append(div_5)

        //product rating
        const h5 = document.createElement("h5");
        h5.innerHTML = product_list[j].star
        document.querySelector(".rating-1-2").append(h5)

        //product rating star icon
        const i = document.createElement("i");
        i.setAttribute("class", "fa fa-star")
        i.setAttribute("aria-hidden", "true")
        document.querySelector(".rating-1-2").append(i)

        //product rating count
        const p_1 = document.createElement("p");
        p_1.innerHTML = product_list[j].rating
        document.querySelector(".rating-2").append(p_1)
    }



