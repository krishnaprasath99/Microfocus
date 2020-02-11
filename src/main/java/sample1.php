<html>
<head>
    <title>Display form the database</title>
    <style type = "text/css">
        table{
            border: 2px solid red;
            background-color: #FFC;
        }
        th{
            border-bottom: 5px solid #000;

        }
        td{
            border-bottom: 2px solid #666;

        }



    </style>
</head>

<body>
<?php
include('phpfile1.php');
$sqlget="SELECT * FROM TABLE2";
$sqldata = mysqli_query($dbcon,$sqlget) or die('error getting');
echo "<table>";
echo "<tr><th>Fieldname</th><th>Link</th></tr>";
?>


</body>
</html>
