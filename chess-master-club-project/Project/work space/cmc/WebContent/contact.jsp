<%@page import="java.util.ArrayList"%>
<%@page import="Dao.FQueryDao"%>
<%@page import="java.util.List"%>
<%@page import="database.DataBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Chess Masters Club</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="lib/jquery-1.9.0.min.js"></script>


<script type="text/javascript" src="lib/jquery.mousewheel-3.0.6.pack.js"></script>


<script type="text/javascript" src="source/jquery.fancybox.js?v=2.1.4"></script>
<link rel="stylesheet" type="text/css"
	href="source/jquery.fancybox.css?v=2.1.4" media="screen" />


<link rel="stylesheet" type="text/css"
	href="source/helpers/jquery.fancybox-buttons.css?v=1.0.5" />
<script type="text/javascript"
	src="../source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>


<link rel="stylesheet" type="text/css"
	href="source/helpers/jquery.fancybox-thumbs.css?v=1.0.7" />
<script type="text/javascript"
	src="source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>


<script type="text/javascript"
	src="source/helpers/jquery.fancybox-media.js?v=1.0.5"></script>

<script type="text/javascript">
	$(document).ready(function() { 

  		$('.fancybox').fancybox(); 

 	}); 
 </script> 
<style type="text/css">
 .fancybox-custom .fancybox-skin { 
box-shadow: 0 0 50px #222; 
 } 
 </style> 


<script type="text/javascript">
	$(document).ready(function() {
			$("#loginform").submit(function() {

		//remove previous class and add new "myinfo" class
        			$("#msgbox").removeClass()
								.addClass('myinfo')
								.text('Validating Your Login ')
								.fadeIn(1000);
					this.timer = setTimeout(function () {
                                            $.ajax({
                                            	url : 'TournamentPlayerLoginServlet',
												data : 'un='+ $('#login_id').val()+ '&pw='+ $('#password').val(),
												type : 'post',
												success : function(msg) {
													      var contains=msg.indexOf('ERROR');
													        if (contains == -1) // Message Sent, check and redirect
																{ // and direct to the success page
									$("#msgbox").html('Login Verified, Logging in.....')
									         .addClass('myinfo')
										.fadeTo(900,1,function() {
										//redirect to secure page
										 document.location = 'tplayerlogin.html';
																							});

																} else {
																	$("#msgbox").fadeTo(200,0.1,function() {//start fading the messagebox
																		//add message and change the class of the box and start fading
														                   $(this).html('Sorry, Wrong Combination Of Username And Password.')
																				  .removeClass()
																				  .addClass('myerror')
																				  .fadeTo(900,1);
																							});

																		}
																	}

														});
													}, 200);
											return false;
										});

					});
</script>
<style type="text/css">
.fancybox-custom .fancybox-skin {
	box-shadow: 0 0 50px #222;
}
</style>


</head>




<body>
<div id="menu">
	<ul>
			<li class="active"><a href="home.html">Home</a>
			</li>
			<li><a href="video.jsp">Videos</a></li>
			<li><a href="demo.html">Know the tips</a>
			</li>
			<li><a href="download.html">Downloads</a>
			</li>
			 <li><a class="fancybox fancybox.ajax" href="admin.html">Administrator</a></li>
			<li><a href="contact.jsp">Contact</a>
			</li>
		</ul>
</div>
<div id="logo">
	<h1> Masters

	<p><a href="#">playgame</a></p></h1>

	<div id="sidebar">
		<div id="search" class="boxed" align="left">
			<div class="content">
				<form id="searchform" method="get" action="Result.jsp">
					<fieldset>
					<input id="searchinput" type="text" name="keyword" value="" />
					<input id="searchsubmit" type="submit" value="Search" />
					</fieldset>
					
				</form>
				
			</div>
			
</div>
		</div>
	
</div>
<div id="page">
	<div id="content">
		
			
		<div>&nbsp;</div>
		<div class="twocols">
			<div class="col1">
				
				
			</div>
			<div class="col2">
			
			</div>
		</div>
	</div>
	<!-- end content -->
	<div id="sidebar">
		<div id="login" class="boxed">
			<h2 class="title">Tournament Player Login </h2>
			<div class="content">
			<form id="loginform" method="post" action="">
					
					Email id :<br/><input id="login_id" type="text" name="username" value="" /> <br/>
					Password :<br/><input id="password" type="password" name="password" value="" /> <br/>
					<input id="searchsubmit" type="submit" value="Login" />
					<div id="msgbox"></div>
			</form>
			
				<a class="fancybox fancybox.ajax" href="reg.html">Register</a>
			</div>
		</div>
		<div id="news" class="boxed">
			<h2 class="title">News &amp; Events</h2>
			<div class="content">
					<ul>
						<li class="first">
							<h3>28 March 2016</h3>
							<p>
								<a href="Quater.pdf">Quater Final</a>
							</p></li>
						<li>
							<h3>14 April 2016</h3>
							<p>
								<a href="Semi.pdf">Semi Final</a>
							</p></li>
						<li>
							<h3>22 April 2016</h3>
							<p>
								<a href="Final.pdf">Final</a>
							</p></li>
					</ul>
				</div>
		</div>
		<div id="extra" class="boxed">
			<h2 class="title">Top Rating</h2>
				<div class="content">
					<ul>


						<li class="first">
							<h3>Arun Kumar,hyderabad</h3>
							<p>
								<a href="Arun.pdf">know this player details</a>
							</p></li>
						<li>
							<h3>V.Rahul,nizamabad</h3>
							<p>
								<a href="Rahul.pdf">know this player details</a>
							</p></li>
						<li>
							<h3>K.Murali Krishna, delhi</h3>
							<p>
								<a href="Murali.pdf">know this player details</a>
							</p></li>
					</ul>


				</div>
		</div>
	</div>



<form id="myForm" action="AddFQueryServlet" method="post">
<table >
<h1 > Queries </h1>
</br>
</br>
<tr><td>Name :</td><td><input type="text" id="name"  name="name"></td></tr>

<tr><td>Email :</td><td><input type="text"  id="email" name="email"></td></tr>
<tr><td>Subject :</td><td><input type="text" id="sub" name="sub"></td></tr>
<tr><td>Query :</td><td><textarea rows="10" cols="50" name="query"></textarea></td></tr>

<tr><td></td><td><input type="submit" value="Send Query"><br></td></tr>
</table>

</form>

<hr>
<br><br><br><br>
Queries
       <table >

		<%
		    DataBase db=new DataBase();
			
			List<FQueryDao> l=new ArrayList<FQueryDao>();
			l=db.listfQuery();
			for(int i=0;i<l.size();i++)
			{
		
		%>
 <tr>
       <td><b>name : </b></td><td><%=l.get(i).getFqName() %></td>
    </tr>
    
    <tr>
       <td><b>Subject : </b></td><td><%=l.get(i).getFqSubject() %></td>
    </tr>
    <tr>
       <td><b>Question : </b></td><td><%=l.get(i).getFqQuestion() %></td>
    </tr>
    <tr>
       <td><b>Answer : </b></td><td><%=l.get(i).getFqAnswer() %></td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr><td colspan="2">------------------------------------------------------------------------------------</td></tr>

    
         			

<%
			}
%>
</table>
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->
<!-- end page -->
<div id="footer">
	<p id="legal">&copy;2016 Chess Masters Club. <br />
		</p>
	<p id="links"><a href="#">Privacy</a> |
	 <a href="#">Terms</a> | <a href="http://validator.w3.org/check/referer" title="This page validates as XHTML 1.0 Transitional"><abbr title="eXtensible HyperText Markup Language">XHTML</abbr></a> | <a href="http://jigsaw.w3.org/css-validator/check/referer" title="This page validates as CSS"><abbr title="Cascading Style Sheets">CSS</abbr></a></p>
</div>
</body>
</html>