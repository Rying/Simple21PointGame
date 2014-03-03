<html>
<head>
<style type="text/css">
div#buttonContainer{width:50px;}
input{margin:0px;width:50px;height:30px;}
</style>
</head>

<body>

<div id="buttonContainer">

<input type="button" name="Start" value="Start" onclick="Start()">

<input type="button" name="Hit" value="Hit" onclick="Hit()">

<input type="button" name="Stay" value="Stay" onclick="Stay()">

<script type="text/javascript">
function Start() {
    window.location.href="<%=request.getContextPath() %>/mainPage?method=Start";
}

function Hit() {
    window.location.href="<%=request.getContextPath() %>/mainPage?method=Hit";
}
function Stay() {
    window.location.href="<%=request.getContextPath() %>/mainPage?method=Stay";
}
</script>

</div>
</body>
</html>
