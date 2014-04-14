<html>
<head>
<style type="text/css">
div#container{width:872px;border:1px solid;border-color:gray; }
div#header{height:80px;text-align:center;border:1px solid;border-color:gray;padding:10px}
div#buttons{height:630px; width:50px; float:left;margin:10px 0px 10px 10px;}
div#players{height:630px; width:650px; float:left;margin:10px 0px 10px 0px;}
div#score {width:150px;float:left;margin:10px auto 10px 0px;border:1px solid;border-color:gray;padding:5px}

h1 {font-size:40px;}
sub{font-size:12px; color:gray}
</style>
</head>

<body>
<div id="container" >

<div id="header">
<h1>Black Jack
<sub>Go rock it</sub></h1>
</div>

<div id="buttons">
<%@ include file="buttons.jsp"%>
</div>

<div id="players" >
<%@ include file="players.jsp"%>
</div>

<div id="score">
<%@ include file="score.jsp"%>
</div>

</div>

</body>

</html>