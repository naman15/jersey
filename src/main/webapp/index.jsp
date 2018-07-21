<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Service</title>
</head>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<body>
<script type="text/javascript">
  
/* $(function(){
        $("#input-id").change(function(event) {
            var file = event.target.files[0];
            if(!file.type.match('application/pdf')) {
                alert("Only Pdf Files Supported");
                $("#form-id").get(0).reset();
                toggleButton(this,'submit-button');
                return;
            }
            if(file.size > 2*1024*1024) {
                alert("File Limit Exceeded maximum 2MB");
                $("#form-id").get(0).reset();
                toggleButton(this,'submit-button');
                return;
            }
            toggleButton(this,'submit-button');
        });
    });
    $("#submit-button").
    function toggleButton(ref,buttonId){
        document.getElementById(buttonId).disabled= ((ref.value !== ref.defaultValue) ? false : true);
    }
   */
    function setCookie(name, value){
        document.cookie=name + "=" + value;
    }
    //this should set the UserName cookie to the proper value;
    function storeValues(form){
        setCookie("X-API-KEY", "apikey123");
        var a=10;
        return true;
    }
    
</script> 
    <h1>File Upload Service</h1>
    <form action="rest/test/upload" id="form-id" method="post" enctype="multipart/form-data" onsubmit="storeApiKey(this)">
        <p>File : <input id="input-id" type="file" name="file"/></p>
        <input type="submit" value="Upload File" id="submit-button" />
    </form>
</body>
</html>
