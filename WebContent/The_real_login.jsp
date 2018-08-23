<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href='http://fonts.font.im/css?family=Poiret+One' rel='stylesheet' type='text/css'>
<link href='http://fonts.font.im/css?family=Orbitron' rel='stylesheet' type='text/css'>
<title>Login</title>
<style>

.gradient {
    background-color: #c88b4e;
    /* IE9, iOS 3.2+ */
    background-image: url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMDAlIiBoZWlnaHQ9IjEwMCUiIHZpZXdCb3g9IjAgMCAxIDEiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxsaW5lYXJHcmFkaWVudCBpZD0idnNnZyIgZ3JhZGllbnRVbml0cz0idXNlclNwYWNlT25Vc2UiIHgxPSIwJSIgeTE9IjEwMCUiIHgyPSIwJSIgeTI9IjAlIj48c3RvcCBzdG9wLWNvbG9yPSIjOTUxNzAwIiBzdG9wLW9wYWNpdHk9IjEiIG9mZnNldD0iMCIvPjxzdG9wIHN0b3AtY29sb3I9IiNmYWZmOWMiIHN0b3Atb3BhY2l0eT0iMSIgb2Zmc2V0PSIxIi8+PC9saW5lYXJHcmFkaWVudD48cmVjdCB4PSIwIiB5PSIwIiB3aWR0aD0iMSIgaGVpZ2h0PSIxIiBmaWxsPSJ1cmwoI3ZzZ2cpIiAvPjwvc3ZnPg==);
    background-image: -webkit-gradient(linear, 0% 100%, 0% 0%,color-stop(0, rgb(149, 23, 0)),color-stop(1, rgb(250, 255, 156)));
    /* Android 2.3 */
    background-image: -webkit-linear-gradient(bottom,rgb(149, 23, 0) 0%,rgb(250, 255, 156) 100%);
    /* IE10+ */
    background-image: linear-gradient(to top,rgb(149, 23, 0) 0%,rgb(250, 255, 156) 100%);
    background-image: -ms-linear-gradient(bottom,rgb(149, 23, 0) 0%,rgb(250, 255, 156) 100%);
    background-size:100% 100%; 
	background-attachment: fixed;
}
 
/* IE8- CSS hack */
@media \0screen\,screen\9 {
    .gradient {
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#fffaff9c",endColorstr="#ff951700",GradientType=0);
    }
}





	.tit{
		font-size:50px;
		text-align:center;
		font-family: 'Orbitron', sans-serif;
		padding-bottom:20px;
		/*background: #FFC500;*/
	}
	.bdy{
		font-size:20px;
		text-align:center;
		font-family: 'Poiret One', cursive;
		padding-top:20px;
	}
	.button {
    border-radius:10px;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s;
    transition-duration: 0.4s;
    cursor: pointer;
    border:none;
	}
	.button1 {
    background-color: white; 
    color: black; 
	}
	.button1:hover {
    background-color: #9B2D0D;
    color: white;
	}
	.ipt{
		font-size:20px;
		height:1em;
		border-radius:10px;
		border:1px solid #c8cccf;
		color:#986655;
		display:block;
		text-align:center;
	}

</style>
</head>
<body class = "gradient">

<div class="tit"> Log In </div>

<form action="MyServlet" method="GET" id = "login_page">
<div class= "bdy">
	Username:
	</div> 
	<br>
	<div align="center"><input id = "usname_login" class = "ipt" type = "text" name = "username_login"></div>
	<br>
	<div class= "bdy">
	Password:
	</div>
	<br>
	<div align="center"><input id = "paswrd_login" class = "ipt" type="text" name="password_login" onclick="fun(this)"></div>
	<br>
	<br><br>
	<div align="center">
	<button id = "lgi_btm_login" class="button button1" type="submit" value="real_Login">
	Login
	</button>
	</div>
</form>
</body>
</html>

	<script type="text/javascript">
	function fun(obj){
	    obj.value = "";
	    obj.type = "password";
	}
	</script>