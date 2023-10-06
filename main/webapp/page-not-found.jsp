<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error page</title>
    <link rel="icon" type = "image/x-icon" href="./assets/icon/shopping-bag.png">
</head>
<body>
<style>
@import url('https://fonts.googleapis.com/css2?family=Barlow+Condensed&family=Barlow:wght@300;400&family=Karla:wght@300;400&family=Michroma&family=Outfit:wght@100;500&family=Rubik:wght@300&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Acme&family=Barlow+Condensed&family=Barlow:wght@300;400&family=Karla:wght@300;400&family=Michroma&family=Outfit:wght@100;500&family=Rubik:wght@300&display=swap');
*{
    margin: 0%;
    padding: 0%;
    box-sizing: border-box;
    font-family:PlusJakartaSans,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Cantarell,Helvetica Neue,Ubuntu,sans-serif;;

}

/* variable declarations */
:root{
    --primary:#00203FFF;
    --secondary:#ADEFD1FF;
}
header{
    display: flex;
    height: 100px;
    justify-content: space-between;
    background-color:var(--primary);
    position: sticky;
    top: 0%; 
    z-index: 1; 
}
.container img{
    scale: 2.1
}
.top-list{
    display: flex;
    width: 500px;
    justify-content: space-evenly;
    margin-top: 30px;
}
.logo{
    display: flex;
    width: 250px;
    justify-content: space-around;
    margin-top: 30px;
    margin-left: 120px;
    color:var(--secondary);
}
.search{
    width: 200px;
    height: 30px;
    margin-top: 40px;
    border: 2px solid var(--secondary);
    border-radius: 10px;
    padding: 10px;
    position: relative;
    right: 200px;
}
.login{
    padding: 10px;
    width: 110px;
    border: 0px solid var(--secondary);
    background-color: var(--secondary);
    border-radius: 10px;
    color:var(--primary);
    letter-spacing: 1px;
}
.logo-name{
    margin-top: 6px;
    margin-right: 80px;
    font-size: 25px;
}
ul a{
    text-decoration: none;   
}
.seller{
    margin-top: 10px;
    color:var(--secondary);
}
.home-icon{
    padding: 10px;
    height: 35px;
    border: 0px solid var(--secondary);
    background-color: var(--secondary);
    border-radius: 5px;
    color:var(--primary);
}
.logo a{
    text-decoration: none;
    color: var(--secondary);
    margin-left: 10px;
}
main img{
    width: 38%;
    height: 38%;
    margin-left: 29%;
}
button{
    position: relative;
    top: 30px;
    right: 23%;
    padding: 10px;
    width: 100px;
    background-color: var(--secondary);
    color: var(--primary);
    cursor: pointer;
}
</style>
    <header> 
        <div class="logo">
        <img src="https://iili.io/JJAEBUv.png" alt="shopping-bag" width="40px" height="40px">
        <a href="../../index.html"><h5 class="logo-name"><b>Shopnow</b></h5></a>
    </div>
</header>
<main>
<img src="https://iili.io/JJA03mP.png" alt="404-error" srcset="">
<a href="http://localhost:8080/shopnow-web/index.html"><button>Go to home</button></a>
</main>
</body>
</html>