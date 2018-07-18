<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload File Example</title>
</head>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<body>
<script type="text/javascript">
    $(function(){
        $("#input-id").change(function(event) {
            var file = event.target.files[0];
            if(file.size > 2*1024*1024) {
                alert("File Limit Exceeded maximum 2MB");
                $("#form-id").get(0).reset(); //the tricky part is to "empty" the input file here I reset the form.
                return;
            }

            if(!file.type.match('application/pdf')) {
                alert("Only PDF file Supported");
                $("#form-id").get(0).reset(); //the tricky part is to "empty" the input file here I reset the form.
                return;
        });
    });
</script>
    <h1>Upload File</h1>
    <form action="rest/test/upload" id="form-id" method="post" enctype="multipart/form-data">
        <p>Select a file : <input id="input-id" type="file" name="file" size="45"/></p>
        <input type="submit" value="Upload File" />
    </form>
</body>
</html>